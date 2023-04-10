package com.example.trabalho.android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trabalho.android.R;
import com.example.trabalho.android.modelo.Aluno;
import com.example.trabalho.android.modelo.vo.Resultado;

import java.math.BigDecimal;

public class ResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        final TextView txtNome = findViewById(R.id.txtNome);
        final TextView txtMedia = findViewById(R.id.txtMedia);
        final TextView txtResultado = findViewById(R.id.txtResultado);
        final Button btRecuperacao = findViewById(R.id.btRecuperacao);

        final Aluno aluno = (Aluno) getIntent().getExtras().getParcelable("aluno");
        final BigDecimal media = aluno.calcularMedia();

        Resultado resultado;
        if (media.compareTo(new BigDecimal("6.0")) >= 0)
            resultado = Resultado.APROVADO;
        else if (media.compareTo(new BigDecimal("4.0")) >= 0) {
            resultado = Resultado.RECUPERACAO;
            btRecuperacao.setVisibility(View.VISIBLE);
        } else
            resultado = Resultado.REPROVADO;

        txtNome.setText(aluno.getNome());
        txtMedia.setText(media.toString());
        txtResultado.setText(resultado.valor);

        btRecuperacao.setOnClickListener((final View view) -> {
            final Intent intent = new Intent(
                    getApplicationContext(),
                    ResultadoRecuperacaoActivity.class
            );
            intent.putExtra("aluno", aluno);
            startActivity(intent);
        });
    }
}