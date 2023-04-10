package com.example.trabalho.android.activity;

import static com.example.trabalho.android.utils.Utils.buscarTexto;
import static com.example.trabalho.android.utils.Utils.limparTexto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trabalho.android.R;
import com.example.trabalho.android.modelo.Aluno;
import com.example.trabalho.android.validador.ValidarNome;
import com.example.trabalho.android.validador.ValidarNota;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btCalcular).setOnClickListener((final View view) -> {
            final TextView txtError = findViewById(R.id.txtError);
            limparTexto(Collections.singletonList(txtError));

            final BigDecimal primeiraNota = new BigDecimal(buscarTexto(this, R.id.ipPrimeiraNota));
            final BigDecimal segundaNota = new BigDecimal(buscarTexto(this, R.id.ipSegundaNota));
            final String nome = buscarTexto(this, R.id.ipNome);

            try {
                ValidarNome.validar(Collections.singletonList(nome));
                ValidarNota.validar(Arrays.asList(primeiraNota, segundaNota));
            } catch (final IllegalArgumentException ex) {
                txtError.setText(ex.getMessage());
                txtError.setVisibility(View.VISIBLE);
                return;
            }

            final Aluno aluno = new Aluno(nome, primeiraNota, segundaNota);

            final Intent intent = new Intent(getApplicationContext(), ResultadoActivity.class);
            intent.putExtra("aluno", aluno);
            startActivity(intent);
        });
    }
}