package com.example.media;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        resultado = findViewById(R.id.resultado);

        // Obtenha a média e o status de aprovação do Intent
        double media = getIntent().getDoubleExtra("media", 0);
        boolean aprovado = getIntent().getBooleanExtra("aprovado", false);

        // Atualize o TextView com a média e o status de aprovação
        resultado.setText(String.format("Média: %.2f\n%s", media, aprovado ? "Aprovado" : "Reprovado"));
    }
}