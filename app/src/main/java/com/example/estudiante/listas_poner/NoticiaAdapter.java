package com.example.estudiante.listas_poner;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
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

        TextView item_nombre= reglon.findViewById(R.id.item_nombre);
        TextView item_telefono = reglon.findViewById(R.id.item_telefono);
        ImageView item_genero = reglon.findViewById(R.id.item_genero);
        ImageButton btn_llamar = reglon.findViewById(R.id.btn_llamar);
        Button btn_eliminar = reglon.findViewById(R.id.btn_eliminar);


        item_nombre.setText(noticias.get(position).getNombre());
        item_telefono.setText(noticias.get(position).getTelefono());

        String genero = noticias.get(position).getGenero();
        final String telefono= noticias.get(position).getTelefono();

        if(genero.equals("F")){

            item_genero.setImageResource(R.drawable.woman);


        }


        if(genero.equals("M")) {

            item_genero.setImageResource(R.drawable.man);

        }


        btn_llamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int Request_phone_call = 1;
                Intent call = new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse("tel: "+telefono));
                if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                    if(ContextCompat.checkSelfPermission(activity, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                        ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CALL_PHONE},Request_phone_call);
                    }else {
                        activity.startActivity(call);
                    }
                }
            }
        });


        btn_eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noticias.remove(position);
                notifyDataSetChanged();


            }
        });


        return reglon;
    }


    public void agregarNoticia(Noticia noticia){

        noticias.add(noticia);
        notifyDataSetChanged();

    }



}
