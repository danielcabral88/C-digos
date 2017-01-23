package br.ceuma.sisagenda.siag;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by INFORMÁT on 22/05/2016.
 */
public class AgendamentoAdapter extends BaseAdapter { // Classe para transformar um objeto em um item da ListView

    Context context;
    List<Agendamento> agendamentoList;

    public AgendamentoAdapter(Context context, List<Agendamento> agendamentoList) {
        this.context = context;
        this.agendamentoList = agendamentoList;
    }

    @Override
    public int getCount() {
        return agendamentoList.size();
    }

    @Override
    public Object getItem(int position) {
        return agendamentoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        Agendamento agendamento = agendamentoList.get(position);

        View linha = LayoutInflater.from(context).inflate(R.layout.item_agendamento, null);

        ImageView logo = (ImageView) linha.findViewById(R.id.imgLogo);

        logo.setImageResource(R.drawable.ic_date_range_black_24dp);

        TextView txtNome = (TextView) linha.findViewById(R.id.txtNome);
        txtNome.setText(agendamento.getNome());

        TextView txtData = (TextView) linha.findViewById(R.id.txtData);
        txtData.setText(String.valueOf(agendamento.getDataAgendamento()));

        TextView txtCategoria = (TextView) linha.findViewById(R.id.txtCategoria);
        txtCategoria.setText(agendamento.getCategoria());

        TextView txtServico = (TextView) linha.findViewById(R.id.txtServico);
        txtServico.setText(agendamento.getServico());

        return linha;
    }

}
