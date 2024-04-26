package com.example.media;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.media.ResultadoActivity;

public class MainActivity extends AppCompatActivity {

    private EditText nota1;
    private EditText nota2;
    private Button calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nota1 = findViewById(R.id.nota1);
        nota2 = findViewById(R.id.nota2);
        calcular = findViewById(R.id.calcular);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n1 = nota1.getText().toString();
                String n2 = nota2.getText().toString();

                if (n1.isEmpty() || n2.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Por favor, insira ambas as notas", Toast.LENGTH_SHORT).show();
                } else {
                    double media = (Double.parseDouble(n1) + Double.parseDouble(n2)) / 2;
                    boolean aprovado = media >= 7;

                    // Crie um Intent para iniciar a ResultadoActivity
                    Intent intent = new Intent(MainActivity.this, ResultadoActivity.class);
                    intent.putExtra("media", media);
                    intent.putExtra("aprovado", aprovado);

                    // Inicie a ResultadoActivity
                    startActivity(intent);
                }
            }
        });
    }
}