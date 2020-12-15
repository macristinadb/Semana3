package com.android.proyectosemana3;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.app.ActionBar;

import java.util.Calendar;

import negocio.Cliente;

public class MainActivity extends AppCompatActivity {
  private EditText txtNombreCompleto;
  private EditText txtFechaNacimiento;
  private EditText txtTelefono;
  private EditText txtEmail;
  private EditText txtContacto;
  private Button btnSgte;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNombreCompleto = (EditText)findViewById(R.id.txtNombreCompleto);
        txtFechaNacimiento = (EditText)findViewById(R.id.txtFechaNacimiento);
        txtTelefono = (EditText)findViewById(R.id.txtTelefono);
        txtEmail = (EditText)findViewById(R.id.txtEmail);
        txtContacto = (EditText)findViewById(R.id.txtContacto);
        btnSgte = (Button) findViewById(R.id.btnSgte);

    }


    public void irSgte(View view) {
        Cliente cliente = new Cliente(
                String.valueOf(txtNombreCompleto.getText()),
                String.valueOf(txtFechaNacimiento.getText()),
                        String.valueOf(txtTelefono.getText()),
                                String.valueOf(txtEmail.getText()),
                                        String.valueOf(txtContacto.getText())
        );

        Intent in = new Intent(MainActivity.this,Registro.class);
        in.putExtra("cliente",cliente);
        startActivity(in);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onRestoreInstanceState(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal,menu);
        return super.onCreateOptionsMenu(menu);

    }

    public void mostrarFecha(View view) {
        final Calendar cldr = Calendar.getInstance();
        int day = cldr.get(Calendar.DAY_OF_MONTH);
        int month = cldr.get(Calendar.MONTH);
        int year = cldr.get(Calendar.YEAR);
        // date picker dialog
        DatePickerDialog picker = new DatePickerDialog(MainActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        txtFechaNacimiento.setText(i2 + "/" + (i1 + 1) + "/" + i);
                    }

                }, year, month, day);
        picker.show();
    }
}