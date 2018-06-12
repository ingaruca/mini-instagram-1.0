package com.example.aaron.mini_instagram;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import OpenHelper.Sqlite_OpenHelper;

public class MainActivity extends AppCompatActivity {

    EditText txtUsuario,txtContraseña;
    Button btnIniciarSesion,btnRegistrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIniciarSesion = (Button) findViewById(R.id.btnIniciarSesion);
        btnRegistrarse = (Button) findViewById(R.id.btnRegistrar);
        txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        txtContraseña = (EditText) findViewById(R.id.txtContraseña);

        final Sqlite_OpenHelper helper = new Sqlite_OpenHelper(this,"MiniInstagram",null,1);

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), registro.class);
                startActivity(i);
            }
        });

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*LogearUsuario();*/

                EditText txtUsuario = (EditText)findViewById(R.id.txtUsuario);
                EditText txtContraseña = (EditText)findViewById(R.id.txtContraseña);

                try
                {
                    Cursor cursor = helper.Consultar(txtUsuario.getText().toString(), txtContraseña.getText().toString());
                    if(cursor.getCount()>0)
                    {
                        Intent i = new Intent(getApplicationContext(),Listado.class);
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"usuario y/o password incorrectos",Toast.LENGTH_LONG).show();
                    }
                    txtUsuario.setText("");
                    txtContraseña.setText("");
                    txtUsuario.findFocus();
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

        /*public void LogearUsuario()
        {
            String usuario = txtUsuario.getText().toString().trim();
            String contraseña = txtContraseña.getText().toString().trim();

            if(TextUtils.isEmpty(usuario))
            {
                Toast.makeText(this,"Se debe Ingresar Usuario",Toast.LENGTH_LONG).show();

                return;
            }
            if(TextUtils.isEmpty(contraseña))
            {
                Toast.makeText(this,"Se debe Ingresar Contraseña",Toast.LENGTH_LONG).show();
                return;
            }

        }*/

}
