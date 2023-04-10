package com.example.trabalho.android.validador;

import java.math.BigDecimal;
import java.util.List;

public final class ValidarNota {

    public static void validar(final List<BigDecimal> notas) {
        for (final BigDecimal nota : notas) {
            validarSeEhNulo(nota);
            validarNumeroDeCasasDecimais(nota);
            validarSeEstaEntreZeroEDez(nota);
        }
    }

    private static void validarSeEhNulo(final BigDecimal nota) {
        if (nota == null)
            throw new IllegalArgumentException("Nota não pode ser nula!");
    }

    private static void validarNumeroDeCasasDecimais(final BigDecimal nota) {
        if (nota.scale() > 1)
            throw new IllegalArgumentException("Nota só pode ter 1 casa decimal!");
    }

    private static void validarSeEstaEntreZeroEDez(final BigDecimal nota) {
        if (nota.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Nota não pode ser negativa!");

        if (nota.compareTo(new BigDecimal("10.0")) > 0)
            throw new IllegalArgumentException("Nota não pode ser maior que 10!");
    }

}
