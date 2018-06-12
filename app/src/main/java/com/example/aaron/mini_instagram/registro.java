package com.example.aaron.mini_instagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import OpenHelper.Sqlite_OpenHelper;

public class registro extends AppCompatActivity {

    EditText txtUsuario,txtContraseña;
    Button btnRegistrar;

    Sqlite_OpenHelper helper = new Sqlite_OpenHelper(this,"MiniInstagram",null,1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnRegistrar = (Button)findViewById(R.id.btnRegistrar);

        txtUsuario = (EditText)findViewById(R.id.txtUsuario);
        txtContraseña = (EditText)findViewById(R.id.txtContraseña);


        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                helper.abrir();
                helper.insertarRegistro(String.valueOf(txtUsuario.getText()),
                                        String.valueOf(txtContraseña.getText()));
                helper.cerrar();

                Toast.makeText(getApplicationContext(),"Registro Valido",Toast.LENGTH_LONG).show();

                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);

            }
        });



    }
}
