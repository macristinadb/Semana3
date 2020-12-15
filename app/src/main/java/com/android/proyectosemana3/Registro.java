package com.android.proyectosemana3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import negocio.Cliente;

public class Registro extends AppCompatActivity {
    TextView lblNombre;
    TextView  lblFechaNacimiento;
    TextView lblTelefono;
    TextView lblDescripcion;
    TextView  lblEmail;
    Cliente cliente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registro);
        lblNombre = (TextView)findViewById(R.id.lblNombre);
        lblTelefono = (TextView)findViewById(R.id.lblTelefono);
        lblFechaNacimiento = (TextView)findViewById(R.id.lblFechaNacimiento);
        lblDescripcion = (TextView)findViewById(R.id.lblDescripcion);
        lblEmail = (TextView)findViewById(R.id.lblEmail);

      /*  Bundle extra = getIntent().getExtras();
        String nombre = extra.getString("NOMBRE");
        String telf = extra.getString("TELEFONO");
       */


       /* ab.setTitle(R.string.app_name);
        ab.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        ab.show();*/

        cliente = getIntent().getParcelableExtra("cliente");
        if (cliente != null){
            cargarCliente(cliente);
        }
    }

    private void cargarCliente(Cliente cli) {
        lblNombre.setText(cli.getNombreCompleto());
        lblTelefono.setText(cli.getTelefono());
        lblFechaNacimiento.setText(cli.getFechaNac());
        lblEmail.setText(cli.getEmail());
        lblDescripcion.setText(cli.getContacto());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_registro,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);


    }


    public void editarInfo(View view) {
        onBackPressed();
    }
}