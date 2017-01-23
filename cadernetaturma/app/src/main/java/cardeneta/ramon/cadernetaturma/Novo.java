package cardeneta.ramon.cadernetaturma;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
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


public class Novo extends ActionBarActivity implements  View.OnClickListener{

    ArrayAdapter<String> adpEscolas;
    List<Integer> listaId = new ArrayList<Integer>();
    List<Escola> escola;
    Spinner spnEscola;
    Button btnSalva;
    EditText ano;
    EditText descricao;
    EditText turno;
    DB db;
    private int anInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo);

        btnSalva = (Button) findViewById(R.id.btnSalvar);
        btnSalva.setOnClickListener(this);
        db = new DB(this);
        //db.inserirEscolar();
        //List<Usuario> us = new ArrayList<>();
        //us = db.buscar();
        escola = db.buscarEscola();
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < escola.size(); i++) {

            list.add(escola.get(i).getNome());
            //list.add(escola.get(i).getNome());
            listaId.add(escola.get(i).getIdEscola());
        }


        adpEscolas = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);
        spnEscola = (Spinner) findViewById(R.id.spinner);
        spnEscola.setAdapter(adpEscolas);

        descricao = (EditText) findViewById(R.id.etxDescricao);
        turno = (EditText) findViewById(R.id.etxTurno);
        ano = (EditText) findViewById(R.id.etxAno);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
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

    public void limpar() {

        descricao.setText("");
        ano.setText("");
        turno.setText("");
        spnEscola.setSelection(0);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnSalvar:

                Turma turma = new Turma();
                turma.setDescricao(descricao.getText().toString());
                turma.setTurno(turno.getText().toString());
                turma.setAno(Integer.valueOf(ano.getText().toString()));
                turma.setEscola(listaId.get(spnEscola.getSelectedItemPosition()));

                DB db = new DB(this);
                db.inserirTurma(turma);

                Toast toast = Toast.makeText(this,"Turma salva",Toast.LENGTH_SHORT);


                toast.show();
                limpar();
                break;
        }
    }
}
