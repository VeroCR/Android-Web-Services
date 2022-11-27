package com.example.dpmo_u3_ea_verm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSalir = findViewById(R.id.btnSalir);
        Button btnRegistro = findViewById(R.id.btnRegistro);

        btnRegistro.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent i = new Intent(MainActivity.this, Registrar.class);
                startActivity(i);
                    }
        });

        btnSalir.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                finish();
                System.exit(0);
            }
        });
    }
}