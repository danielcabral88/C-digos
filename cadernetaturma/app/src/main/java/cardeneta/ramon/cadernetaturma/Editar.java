package cardeneta.ramon.cadernetaturma;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Editar extends ActionBarActivity implements View.OnClickListener{
    private ArrayAdapter adpEscolas;
    private EditText descricao;
    private EditText turno;
    private EditText ano;
    private Spinner spEscola;
    private int position = -1;
    private Button btnSalvar;
    List<Integer> listaId;
    List<Escola> escola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        DB bd = new DB(this);
        List<Turma> list = bd.buscarTurma();
        escola = bd.buscarEscola();
        listaId = new ArrayList<Integer>();
        descricao = (EditText) findViewById(R.id.etxDescricaoEdit);
        turno = (EditText) findViewById(R.id.etxTurnoEdit);
        ano = (EditText) findViewById(R.id.etxAnoEdit);
        spEscola = (Spinner) findViewById(R.id.spEdit);

        try {
            List<String> listaEscola = new ArrayList<String>();
            for (int i = 0; i < escola.size(); i++) {

                listaEscola.add(escola.get(i).getNome());
                //list.add(escola.get(i).getNome());
                listaId.add(escola.get(i).getIdEscola());
            }


            adpEscolas = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listaEscola);
            spEscola.setAdapter(adpEscolas);

            btnSalvar = (Button) findViewById(R.id.btnSalvarEdit);
            btnSalvar.setOnClickListener(this);

            Intent intent = getIntent();

            Bundle params = intent.getExtras();

            if (params != null) {
                position = params.getInt("Id");

                descricao.setText(list.get(position).getDescricao());
                turno.setText(list.get(position).getTurno());
                ano.setText(String.valueOf(list.get(position).getAno()));

                for (int i = 0; i < listaId.size(); i++) {
                    if(list.get(position).getEscola() == listaId.get(i))
                        spEscola.setSelection(i);
                }

                position = list.get(position).getId();


            }
        }catch (Exception e)
        {
            Log.e("ERROR", e.toString());
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_editar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        Turma turma = new Turma();
        if(position > -1) {
            turma.setId(position);
            turma.setDescricao(descricao.getText().toString());
            turma.setTurno(turno.getText().toString());
            turma.setAno(Integer.valueOf(ano.getText().toString()));
            turma.setEscola(listaId.get(spEscola.getSelectedItemPosition()));

            DB db = new DB(this);
            db.atualizar(turma);

            Toast toast = Toast.makeText(this, "Turma editada", Toast.LENGTH_SHORT);
            toast.show();
            finish();


        }else{
            Toast toast = Toast.makeText(this, "Turma não encontrada", Toast.LENGTH_SHORT);
            toast.show();

        }


}
}
