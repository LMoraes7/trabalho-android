package com.example.trabalho.android.modelo;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class Aluno implements Parcelable {

    private final String nome;
    private final BigDecimal primeiraNota;
    private final BigDecimal segundaNota;

    public Aluno(final String nome, final BigDecimal primeiraNota, final BigDecimal segundaNota) {
        this.nome = nome;
        this.primeiraNota = primeiraNota;
        this.segundaNota = segundaNota;
    }

    private Aluno(final Parcel parcel) {
        this.nome = parcel.readString();
        this.primeiraNota = (BigDecimal) parcel.readValue(BigDecimal.class.getClassLoader());
        this.segundaNota = (BigDecimal) parcel.readValue(BigDecimal.class.getClassLoader());
    }

    public static final Parcelable.Creator<Aluno>
    CREATOR = new Parcelable.Creator<Aluno>() {
        @Override
        public Aluno createFromParcel(Parcel parcel) {
            return new Aluno(parcel);
        }

        @Override
        public Aluno[] newArray(int i) {
            return new Aluno[i];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(this.nome);
        parcel.writeValue(this.primeiraNota);
        parcel.writeValue(this.segundaNota);
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPrimeiraNota() {
        return primeiraNota;
    }

    public BigDecimal getSegundaNota() {
        return segundaNota;
    }

    public BigDecimal calcularMedia() {
        return this.primeiraNota.add(this.segundaNota)
                                .divide(new BigDecimal(2), RoundingMode.CEILING);
    }

    public BigDecimal calcularMediaRecuperacao(final BigDecimal notaRecuperacao) {
        return this.primeiraNota.add(this.segundaNota)
                                .add(notaRecuperacao)
                                .divide(new BigDecimal(2), RoundingMode.CEILING);
    }

}
