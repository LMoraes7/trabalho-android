package com.example.trabalho.android.utils;

import android.text.Editable;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public final class Utils {

    public static String buscarTexto(final AppCompatActivity appCompatActivity, final int id) {
        final EditText txt = appCompatActivity.findViewById(id);
        final Editable text = txt.getText();
        if (text.toString().isEmpty())
            return "-1";
        return txt.getText().toString();
    }

    public static void limparTexto(final List<TextView> textViews) {
        for (TextView textView : textViews) {
            textView.setText("");
        }
    }
}
