package cardeneta.ramon.cadernetaturma;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;


public class Principal extends ActionBarActivity implements View.OnClickListener{
    private Button btnNovo;
    DB bd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btnNovo = (Button) findViewById(R.id.btnNovo);
        btnNovo.setOnClickListener(this);
     bd = new DB(this);
//        bd.inserirEscolar();
//        bd.inserirTurma();

        listTurmas();
/*
        final ArrayList<String> listPedidos = new ArrayList<String>();
        for (int i = 0; i < list.size(); ++i) {
            listPedidos.add(list.get(i).getDescricao());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, listPedidos);

        lv.setAdapter(adapter);
*/

    }


    private void listTurmas(){

        List<Turma> list = bd.buscarTurma();
        List<Escola> escola = bd.buscarEscola();
        ListView lv = (ListView) findViewById(R.id.lvTurma);


        lv.setAdapter(new TurmaAdapter(this, list,escola));


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

    protected void onResume()
    {
        super.onResume();

        listTurmas();
    }
    @Override
    public void onClick(View v) {


            Intent it = new Intent(v.getContext(),Novo.class);


            // it.putExtras(params);
            startActivity(it);


    }
}
