package com.example.preference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtIdBuscar, txtCodigo, txtNombre, txtUniverdidad;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtIdBuscar = findViewById(R.id.txtIdBuscar);
        txtCodigo = findViewById(R.id.txtCodigo);
        txtNombre = findViewById(R.id.txtNombre);
        txtUniverdidad = findViewById(R.id.txtUniversidad);
    }

    public void buscar(View view){
        String buscarId = txtIdBuscar.getText().toString();
        pref = this.getSharedPreferences(buscarId, Context.MODE_PRIVATE);
        String codigo = pref.getString("codigo", "");
        String nombre = pref.getString("nombre", "");
        String universidad = pref.getString("universidad", "");
        if (codigo.length()>0){
            String mensaje= "Usuario Encontrado";
            Toast.makeText(this,mensaje, Toast.LENGTH_LONG).show();
            txtCodigo.setText(codigo);
            txtNombre.setText(nombre);
            txtUniverdidad.setText(universidad);
        }else{
            String error= "Usuario no Encontrado";
            Toast.makeText(this,error, Toast.LENGTH_LONG).show();
        }
    }
    public void guardar(View view){
        pref = this.getSharedPreferences(txtCodigo.getText().toString(), Context.MODE_PRIVATE);
        editor=pref.edit();
        editor.putString("codigo",txtCodigo.getText().toString());
        editor.putString("nombre",txtNombre.getText().toString());
        editor.putString("universidad",txtUniverdidad.getText().toString());
        editor.apply();
        Toast.makeText(this,"Registro Guardado Correctamente", Toast.LENGTH_LONG).show();
        txtCodigo.setText("");
        txtNombre.setText("");
        txtUniverdidad.setText("");
    }
}