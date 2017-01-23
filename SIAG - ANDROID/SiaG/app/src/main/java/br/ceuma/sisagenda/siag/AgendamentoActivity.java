package br.ceuma.sisagenda.siag;

import android.Manifest;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import static android.provider.CalendarContract.Events;

public class AgendamentoActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    // json array response url
    private String urlJsonArray = "http://www.baoba.eco.br/rest/agenda.php?uid=";
    private ListView listadeagendamentos;
    private List<Agendamento> lista = new ArrayList<Agendamento>();

    private ProgressDialog progressDialog;

    private final int MY_PERMISSIONS_REQUEST_READ_CALENDAR = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendamento);

        Intent intent = getIntent();

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            //Toast.makeText(AgendamentoActivity.this, query.toString(), Toast.LENGTH_SHORT).show();
            listadeagendamentos = (ListView) findViewById(R.id.listView);
            listadeagendamentos.setOnItemClickListener(this);

            /*List<Agendamento> lista = new ArrayList<Agendamento>();

            Agendamento c1 = new Agendamento();

            c1.setId(1);
            c1.setNome("Daniel Cabral");
            c1.setDataAgendamento("25/05/206");
            c1.setIdCategoria(1);
            c1.setCategoria("Categoria");
            c1.setIdServico(1);
            c1.setServico("Serviço");

            Agendamento c2 = new Agendamento();

            c2.setId(1);
            c2.setNome("Daniel Cabral");
            c2.setDataAgendamento("25/05/206");
            c2.setIdCategoria(1);
            c2.setCategoria("Categoria");
            c2.setIdServico(1);
            c2.setServico("Serviço");

            Agendamento c3 = new Agendamento();

            c3.setId(1);
            c3.setNome("Daniel Cabral");
            c3.setDataAgendamento("25/05/206");
            c3.setIdCategoria(1);
            c3.setCategoria("Categoria");
            c3.setIdServico(1);
            c3.setServico("Serviço");

            //Adiciona a Lista
            lista.add(c1);
            lista.add(c2);
            lista.add(c3);

            AgendamentoAdapter meuadapter = new AgendamentoAdapter(this, lista);
            listadeagendamentos.setAdapter(meuadapter);*/

            //solicitarWebService(query);

            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Aguarde...");
            progressDialog.setCancelable(false);

            consultaWebService(query);
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) { // Retorna para tela home
            case android.R.id.home:
                Toast.makeText(getApplicationContext(), "Home",
                        Toast.LENGTH_LONG).show();

                // go to previous activity
                onBackPressed();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void consultaWebService(String query) { // Consulta por meio da api Volley

        showpDialog();
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, urlJsonArray + query,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {

                            JSONArray jsonArray = response.getJSONArray("agendamentos");

                            if (jsonArray.length() > 0) {
                                for (int i = 0; i < jsonArray.length(); i++) {

                                    JSONObject agendamento = jsonArray.getJSONObject(i);

                                    Agendamento ag = new Agendamento();

                                    ag.setNome(agendamento.getString("nome_aluno"));
                                    ag.setDataAgendamento(agendamento.getString("dia"));
                                    ag.setHora(agendamento.getString("hora"));
                                    ag.setCategoria(agendamento.getString("nome_cat"));
                                    ag.setServico(agendamento.getString("nome_servico"));

                                    lista.add(ag);
                                }
                                AgendamentoAdapter meuadapter = new AgendamentoAdapter(getBaseContext(), lista);
                                listadeagendamentos.setAdapter(meuadapter);
                            } else {
                                hidepDialog();
                                Toast.makeText(AgendamentoActivity.this, "Não localizado!", Toast.LENGTH_SHORT).show();
                                Intent home = new Intent(getBaseContext(), MainActivity.class);
                                startActivity(home);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getBaseContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                        hidepDialog();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Volley", "Error: " + error.getMessage());
                Toast.makeText(getBaseContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                hidepDialog();
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(req);
    }

    private void showpDialog() {
        if (!progressDialog.isShowing())
            progressDialog.show();
    }

    private void hidepDialog() {
        if (progressDialog.isShowing())
            progressDialog.dismiss();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        final int pos = position;

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Aguarde...");
        progressDialog.setCancelable(false);

        alertDialog // Abaixo chama o provedor de agenda
                .setTitle("Sincronização!")
                .setMessage("Deseja sincronizar com Google Agenda?")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which){

                        showpDialog();

                        long calID = 3;
                        long startMillis = 0;
                        long endMillis = 0;

                        TimeZone tz = TimeZone.getDefault();

                        Agendamento agendamento = (Agendamento) listadeagendamentos.getItemAtPosition(pos);

                        String parts[] = agendamento.getDataAgendamento().split("-");
                        int ano = Integer.valueOf(parts[0]);
                        int mes = Integer.valueOf(parts[1]);
                        int dia = Integer.valueOf(parts[2]);

                        String parts2[] = agendamento.getHora().split(":");
                        int hora = Integer.valueOf(parts2[0]);
                        int minutos = Integer.valueOf(parts2[1]);

                        Calendar beginTime = Calendar.getInstance();

                        beginTime.set(ano, mes-1, dia, hora, minutos, 0);

                        startMillis = beginTime.getTimeInMillis();
                        Calendar endTime = Calendar.getInstance();
                        endTime.set(ano, mes-1, dia, hora+1, minutos, 0);
                        endMillis = endTime.getTimeInMillis();



                        ContentResolver cr = getContentResolver();
                        ContentValues values = new ContentValues();
                        ContentValues reminder = new ContentValues();

                        //adicionando evento
                        values.put(Events.DTSTART, startMillis);
                        values.put(Events.DTEND, endMillis);
                        //values.put(Events.DURATION, "PT1H");
                        values.put(Events.TITLE, agendamento.getCategoria());
                        values.put(Events.DESCRIPTION, agendamento.getCategoria());
                        values.put(Events.CALENDAR_ID, calID);
                        values.put(Events.EVENT_TIMEZONE, tz.getID());

                        //adicionando lembrete
                        reminder.put(CalendarContract.Reminders.EVENT_ID, calID);
                        reminder.put(CalendarContract.Reminders.METHOD, CalendarContract.Reminders.METHOD_ALERT);
                        reminder.put(CalendarContract.Reminders.MINUTES, 30);

                        // Here, thisActivity is the current activity
                        if (ContextCompat.checkSelfPermission(getApplicationContext(), // A partir da API 23 é necessário a verificação de permissão
                                Manifest.permission.WRITE_CALENDAR)
                                != PackageManager.PERMISSION_GRANTED) {

                            // Should we show an explanation?
                            if (ActivityCompat.shouldShowRequestPermissionRationale(AgendamentoActivity.this,
                                    Manifest.permission.WRITE_CALENDAR)) {

                                // Show an expanation to the user *asynchronously* -- don't block
                                // this thread waiting for the user's response! After the user
                                // sees the explanation, try again to request the permission.

                            } else {

                                // No explanation needed, we can request the permission.

                                ActivityCompat.requestPermissions(AgendamentoActivity.this,
                                        new String[]{Manifest.permission.WRITE_CALENDAR},
                                        MY_PERMISSIONS_REQUEST_READ_CALENDAR);

                                // MY_PERMISSIONS_REQUEST_READ_CALENDAR is an
                                // app-defined int constant. The callback method gets the
                                // result of the request.
                            }
                        }else{

                            Uri uri = cr.insert(Events.CONTENT_URI,values);
                            Uri uri2 = cr.insert(CalendarContract.Reminders.CONTENT_URI,reminder);

                        }
                        hidepDialog();
                        Toast.makeText(AgendamentoActivity.this, "Compromisso sincronizado!", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Não", null)
                .show();
    }
}
