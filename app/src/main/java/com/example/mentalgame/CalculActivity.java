package com.example.mentalgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class CalculActivity extends AppCompatActivity {

    private String calcul = "";
    private Integer compteurTaille = 0;
    private TextView textViewCalcul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcul);
    }


    private boolean ajouterCharactere(String charactereAAjouter) {
        calcul += charactereAAjouter;
        textViewCalcul.setText(calcul);
        return true;
    }

    private boolean ajouterNombre(String nombre) {
        ajouterCharactere(nombre);
        return true;
    }
}