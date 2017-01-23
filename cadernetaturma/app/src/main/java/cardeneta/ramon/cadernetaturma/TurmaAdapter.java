package cardeneta.ramon.cadernetaturma;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ramon on 29/05/2015.
 */
public class TurmaAdapter  extends BaseAdapter implements ListAdapter {

    private Context contexto;
    private List<Turma> turmas;
    private List<Escola> escolas;

    public TurmaAdapter(Context contexto, List<Turma> turmas, List<Escola> escolas) {
        this.contexto = contexto;
        this.turmas = turmas;
        this.escolas = escolas;
    }

    public int getCount() {
        return turmas.size();

    }

    @Override
    public Object getItem(int position) {
        return turmas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return turmas.get(position).getId();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        final int valor = position;
        Turma turma = turmas.get(position);
        final View layout;
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layout = inflater.inflate(R.layout.turmaadapter, null);
        }else{
            layout = convertView;
        }
        TextView TVturma = (TextView) layout.findViewById(R.id.TVturma);
        TVturma.setText(turma.getDescricao());

        TextView TVturno = (TextView) layout.findViewById(R.id.TVturno);
        TVturno.setText(turma.getTurno());

        TextView TVescola = (TextView) layout.findViewById(R.id.TVescola);
        int escola = turma.getEscola();
        for (int i = 0; i < escolas.size() ; i++) {
            if(escola == escolas.get(i).getIdEscola())
                TVescola.setText(escolas.get(i).getNome());

        }

        TextView TVano = (TextView) layout.findViewById(R.id.TVano);
        String ano = turma.getAno() +" ";

        TVano.setText(ano);
        Button btDelete = (Button)layout.findViewById(R.id.btnDeletar);
        Button btEdite = (Button) layout.findViewById(R.id.btnEditar);

        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DB db = new DB(contexto);
                db.deletar((int) getItemId(position));

                turmas.remove(position);
                notifyDataSetChanged();
            }
        });


        btEdite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(contexto, Editar.class);

                Bundle params = new Bundle();

                int resposta =position;
                params.putInt("Id", resposta);
                intent.putExtras(params);
                contexto.startActivity(intent);


            }
        });



        return layout;

    }


}
