package com.example.estudiante.listas_poner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private ListView lv_noticias;
    NoticiaAdapter customAdapter;

    EditText et_titulo;
    Button btn_generar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        et_titulo=findViewById(R.id.et_titulo);
        btn_generar=findViewById(R.id.btn_generar);



    lv_noticias= findViewById(R.id.lv_noticias);
    customAdapter=new NoticiaAdapter(this);
    lv_noticias.setAdapter(customAdapter);



    final Noticia noticia1=
            new Noticia("Cambio de logo","30/08/2018","Va aver un cambio en el lkogo de hoy es diseño" );
        Noticia noticia2=
                new Noticia("Cambio de logo","30/08/2018","Va aver un cambio en el lkogo de hoy es diseño" );


        customAdapter.agregarNoticia(noticia1);

        customAdapter.agregarNoticia(noticia2);

        lv_noticias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

            Noticia noticia_click= (Noticia) customAdapter.getItem(position);

            Toast.makeText(MainActivity.this,noticia_click.getTitulo(), Toast.LENGTH_SHORT).show();


        }
    });
        btn_generar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month =c.get(Calendar.MONTH);
                int day =c.get(Calendar.DAY_OF_MONTH);

                String fecha = day+"/"+month+"/"+year;


                String titulo = et_titulo.getText().toString();
                Noticia newNoticia =new Noticia(titulo, fecha, "NO DESCRIPTION");
                customAdapter.agregarNoticia(newNoticia);



            }
        });

    }
}
