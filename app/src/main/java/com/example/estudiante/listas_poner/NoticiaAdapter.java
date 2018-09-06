package com.example.estudiante.listas_poner;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class NoticiaAdapter extends BaseAdapter {


    ArrayList <Noticia>noticias;
    Activity activity;

    public NoticiaAdapter(Activity activity) {
    this.activity=activity;
    noticias=new ArrayList<>();
}

    @Override
    public int getCount() {
        return noticias.size();
    }

    @Override
    public Object getItem(int i) {
        return noticias.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    //generar un reglon por objeto
    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = activity.getLayoutInflater();


        View reglon = inflater.inflate(R.layout.reglon, null,false);
        TextView item_titulo = reglon.findViewById(R.id.item_titulo);
        TextView item_fecha = reglon.findViewById(R.id.item_fecha);
        Button btn_llamar = reglon.findViewById(R.id.btn_llamar);
        Button btn_eliminar = reglon.findViewById(R.id.btn_eliminar);




        item_titulo.setText(noticias.get(position).getTitulo());
        item_fecha.setText(noticias.get(position).getFecha());
        btn_llamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //noticias.remove(position);
                // notifyDataSetChanged();

                Intent intent = new Intent(activity, NoticiaView.class);
                activity.startActivity(intent);


            }
        });


        return reglon;
    }


    public void agregarNoticia(Noticia noticia){

        noticias.add(noticia);
        notifyDataSetChanged();

    }



}
