package com.example.preferencias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextbusqueda,editTextnombre,editTextcodigo,editTextescuela,editTexttelefono;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextbusqueda=findViewById(R.id.EditTextBusqueda);
        editTextnombre=findViewById(R.id.EditTextnombre);
        editTextcodigo=findViewById(R.id.EditTextcodigo);
        editTextescuela=findViewById(R.id.EditTextescuela);
        editTexttelefono=findViewById(R.id.EditTexttelefono);

    }
    public void buscar(View view){
        String buscarId=editTextbusqueda.getText().toString();
        pref = this.getSharedPreferences(buscarId, Context.MODE_PRIVATE);
        String nom=pref.getString("nombres","");
        String codi=pref.getString("codigo","");
        String escu=pref.getString("escuela","");
        String telefono=pref.getString("telefono","");
        if(codi.length()>0){
            String mensaje= "Se ha encontrado un registro";
            Toast.makeText(this,mensaje, Toast.LENGTH_LONG).show();
            editTextcodigo.setText(codi);
            editTextnombre.setText(nom);
            editTextescuela.setText(escu);
            editTexttelefono.setText(telefono);
        }else{
            String error= "No se ha encontrado un registro";
            Toast.makeText(this,error, Toast.LENGTH_LONG).show();
        }

    }
    public void guardar(View view){
        pref = this.getSharedPreferences(editTextcodigo.getText().toString(), Context.MODE_PRIVATE);
        editor=pref.edit();
        editor.putString("codigo",editTextcodigo.getText().toString());
        editor.putString("nombres",editTextnombre.getText().toString());
        editor.putString("escuela",editTextescuela.getText().toString());
        editor.putString("telefono",editTexttelefono.getText().toString());
        editor.apply();
        Toast.makeText(this,"Registro Guardado", Toast.LENGTH_LONG).show();
        editTextcodigo.setText("");
        editTextnombre.setText("");
        editTextescuela.setText("");
        editTexttelefono.setText("");
    }

}