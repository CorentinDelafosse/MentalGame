package com.example.mentalgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class CalculActivity extends AppCompatActivity {

    private String Calcul = "";
    private Integer compteurTaille = 0;
    private TextView textViewCalcul;
    private Button buttonOne;
    private Button buttonDeux;
    private Button buttonTrois;
    private Button buttonQuatre;
    private Button buttonCinq;
    private Button buttonSix;
    private Button buttonSept;
    private Button buttonHuit;
    private Button buttonNeuf;
    private Button buttonZero;
    private Button buttonValider;
    private ImageButton buttonRetour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcul);
        textViewCalcul = findViewById(R.id.textcalcul);
        buttonOne = findViewById(R.id.button_1);
        buttonOne.setOnClickListener(view -> {
            ajouterNombre("1");
        });
        buttonDeux = findViewById(R.id.button_2);
        buttonDeux.setOnClickListener(view -> {
            ajouterNombre("2");
        });
        buttonTrois = findViewById(R.id.button_3);
        buttonTrois.setOnClickListener(view -> {
            ajouterNombre("3");
        });
        buttonQuatre = findViewById(R.id.button_4);
        buttonQuatre.setOnClickListener(view -> {
            ajouterNombre("4");
        });
        buttonCinq = findViewById(R.id.button_5);
        buttonCinq.setOnClickListener(view -> {
            ajouterNombre("5");
        });
        buttonSix = findViewById(R.id.button_6);
        buttonSix.setOnClickListener(view -> {
            ajouterNombre("6");
        });
        buttonSept = findViewById(R.id.button_7);
        buttonSept.setOnClickListener(view -> {
            ajouterNombre("7");
        });
        buttonHuit = findViewById(R.id.button_8);
        buttonHuit.setOnClickListener(view -> {
            ajouterNombre("8");
        });
        buttonNeuf = findViewById(R.id.button_9);
        buttonNeuf.setOnClickListener(view -> {
            ajouterNombre("9");
        });
        buttonZero = findViewById(R.id.button_0);
        buttonZero.setOnClickListener(view -> {
            ajouterNombre("0");
        });
        buttonRetour = findViewById(R.id.button_retour);
        buttonRetour.setOnClickListener(view -> {
            suppressionNombre();
        });
        buttonValider = findViewById(R.id.button_valider);
        buttonValider.setOnClickListener(view -> {
            validerReponse();
        });

    }

    private boolean ajoutCharacter(String characterAjout){
        Calcul += characterAjout;
        textViewCalcul.setText(Calcul);
        return true;
    }

    private boolean ajouterNombre(String nombre){
        compteurTaille++;
        ajoutCharacter(nombre);
        return true;
    }

    private boolean suppressionNombre(){
        if(compteurTaille>0){
            compteurTaille--;
            Calcul = Calcul.substring(0, Calcul.length() - 1);
            textViewCalcul.setText(Calcul);
            return true;
        }
        else{
            return false;
        }
    }

    private boolean validerReponse(){
        return true;
    }
}