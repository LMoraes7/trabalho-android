package com.example.trabalho.android.validador;

import java.util.List;

public class ValidarNome {

    public static void validar(final List<String> nomes) {
        for (final String nome : nomes) {
            validarSeEhNuloOuVazio(nome);
        }
    }

    private static void validarSeEhNuloOuVazio(final String nome) {
        if (nome == null || nome.isEmpty() || nome.equals("-1"))
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio!");
    }
}
