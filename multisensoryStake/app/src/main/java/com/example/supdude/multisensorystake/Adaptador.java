package com.example.supdude.multisensorystake;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {

    Context contexto;
    ArrayList<Parcela> lista;

    public Adaptador(Context contexto, ArrayList<Parcela> lista) {
        this.contexto = contexto;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vista = view;
        if(vista == null){
            LayoutInflater inflador = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vista = inflador.inflate(R.layout.distribucionvistas, viewGroup, false);
        }

        TextView tvId, tvParcela, tvPh, tvHumedad, tvSalinidad, tvTemperatura;

        tvId = vista.findViewById(R.id.tvId);
        tvParcela = vista.findViewById(R.id.tvParcela);
        tvPh = vista.findViewById(R.id.tvPh);
        tvHumedad = vista.findViewById(R.id.tvHumedad);
        tvSalinidad = vista.findViewById(R.id.tvSalinidad);
        tvTemperatura = vista.findViewById(R.id.tvTemperatura);

        tvId.setText(lista.get(i).getId());
        tvParcela.setText("Parcela: "+lista.get(i).getParcela());
        tvPh.setText("PH: "+lista.get(i).getPh());
        tvHumedad.setText("Humedad: "+lista.get(i).getHumedad());
        tvSalinidad.setText("Saliniad: "+lista.get(i).getSalinidad());
        tvTemperatura.setText("Temperatura: "+lista.get(i).getTemperatura());

        return vista;
    }
}