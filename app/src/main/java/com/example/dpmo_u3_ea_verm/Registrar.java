package com.example.dpmo_u3_ea_verm;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Registrar extends AppCompatActivity {

    Button btnGuardar;
    EditText edtNombre, edtApellidos, edtEdad, edtEstado, edtTelefono, edtCorreo;
    Spinner spnSexo, spnPais;
    RequestQueue requestQueue;

    private static final String url = "http://verorm.epizy.com/guardar.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        edtNombre = findViewById(R.id.edtNombre);
        edtApellidos = findViewById(R.id.edtApellidos);
        edtEdad = findViewById(R.id.edtEdad);
        edtEstado = findViewById(R.id.edtEstado);
        edtTelefono = findViewById(R.id.edtTelefono);
        edtCorreo = findViewById(R.id.edtCorreo);
        spnSexo = findViewById(R.id.spnSexo);
        spnPais = findViewById(R.id.spnPais);
        btnGuardar = findViewById(R.id.btnGuardar);

        requestQueue = Volley.newRequestQueue(this);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = edtNombre.getText().toString().trim();
                String apellidos = edtApellidos.getText().toString().trim();
                String edad = edtEdad.getText().toString().trim();
                String estado = edtEstado.getText().toString().trim();
                String telefono = edtTelefono.getText().toString().trim();
                String correo = edtCorreo.getText().toString().trim();
                String sexo = spnSexo.getSelectedItem().toString().trim();
                String pais = spnPais.getSelectedItem().toString().trim();
                if(nombre.equals("") || apellidos.equals("") || edad.equals("") || estado.equals("") || telefono.equals("") || correo.equals("") || sexo.equals("") || pais.equals("") ){
                    Toast.makeText(Registrar.this, "Agregue todos los valores.", Toast.LENGTH_SHORT).show();
                }else {
                    registrar(nombre, apellidos, edad, estado, telefono, correo, sexo, pais);
                }


            }
        });

    }

    private void registrar(final String nombre, final String apellidos, final String edad, final String estado, final String telefono, final String correo, final String sexo, final String pais) {

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Registrar.this, "Registro exitoso", Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Registrar.this, "No se ha podido realizar el registro", Toast.LENGTH_LONG).show();
                    }
                }
        ){
            @NonNull
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("nombre", nombre);
                params.put("apellidos", apellidos);
                params.put("edad", edad);
                params.put("sexo", sexo);
                params.put("pais", pais);
                params.put("estado", estado);
                params.put("telefono", telefono);
                params.put("correo", correo);
                return params;
            }
        };

        requestQueue.add(stringRequest);
    }
}