package com.example.trabalho.android.modelo.vo;

public enum Resultado {
    APROVADO("Aprovado"),
    REPROVADO("Reprovado"),
    RECUPERACAO ("Avaliacao Substitutiva");

    public final String valor;

    Resultado(final String valor) {
        this.valor = valor;
    }
}
