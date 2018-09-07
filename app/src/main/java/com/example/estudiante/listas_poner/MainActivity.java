package com.example.estudiante.listas_poner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private ListView lv_noticias;
    NoticiaAdapter customAdapter;

    EditText et_nombre;
    EditText et_telefono;
    Switch sh_genero;
    Button btn_generar;
    String genero;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        et_nombre=findViewById(R.id.et_nombre);
        et_telefono =findViewById(R.id.et_telefono);
        btn_generar=findViewById(R.id.btn_generar);
        sh_genero=findViewById(R.id.sh_genero);


    lv_noticias= findViewById(R.id.lv_noticias);
    customAdapter=new NoticiaAdapter(this);
    lv_noticias.setAdapter(customAdapter);



        lv_noticias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

            Noticia noticia_click= (Noticia) customAdapter.getItem(position);

            Toast.makeText(MainActivity.this,noticia_click.getNombre(), Toast.LENGTH_SHORT).show();


        }
    });
        btn_generar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nombre = et_nombre.getText().toString();
                String telefono = et_telefono.getText().toString();


                if (sh_genero.isChecked()){
                    genero="F";
                }else{
                    genero="M";
                }

                Noticia newNoticia =new Noticia(nombre, telefono, genero);
                customAdapter.agregarNoticia(newNoticia);

                sh_genero.setChecked(false);
                et_nombre.setText("");
                et_telefono.setText("");



            }
        });

    }
}
