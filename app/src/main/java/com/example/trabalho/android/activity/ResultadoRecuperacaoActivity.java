package com.example.trabalho.android.activity;

import static com.example.trabalho.android.utils.Utils.buscarTexto;
import static com.example.trabalho.android.utils.Utils.limparTexto;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trabalho.android.R;
import com.example.trabalho.android.modelo.Aluno;
import com.example.trabalho.android.modelo.vo.Resultado;
import com.example.trabalho.android.validador.ValidarNota;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

public class ResultadoRecuperacaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_recuperacao);

        findViewById(R.id.btCalcularRecuperacao).setOnClickListener((final View view) -> {
            final TextView txtResultado = findViewById(R.id.txtResultadoRecuperacao);
            final TextView txtErrorRecuperacao = findViewById(R.id.txtErrorRecuperacao);
            limparTexto(Arrays.asList(txtResultado, txtErrorRecuperacao));

            final BigDecimal notaRecuperacao = new BigDecimal(buscarTexto(this, R.id.txtNotaRecuperacao));

            try {
                ValidarNota.validar(Collections.singletonList(notaRecuperacao));
            } catch (final IllegalArgumentException ex) {
                txtErrorRecuperacao.setText(ex.getMessage());
                txtErrorRecuperacao.setVisibility(View.VISIBLE);
                return;
            }

            final Aluno aluno = (Aluno) getIntent().getExtras().getParcelable("aluno");
            final BigDecimal media = aluno.calcularMediaRecuperacao(notaRecuperacao);

            Resultado resultado;
            if (media.compareTo(new BigDecimal("6.0")) >= 0)
                resultado = Resultado.APROVADO;
            else
                resultado = Resultado.REPROVADO;

            txtResultado.setText(resultado.valor);
            txtResultado.setVisibility(View.VISIBLE);
        });
    }
}