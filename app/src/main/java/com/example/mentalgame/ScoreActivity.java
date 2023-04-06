package com.example.mentalgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mentalgame.DAO.CalculBaseHelper;
import com.example.mentalgame.DAO.CalculDao;
import com.example.mentalgame.entities.Calcul;
import com.google.android.material.color.utilities.Score;

public class ScoreActivity extends AppCompatActivity {

    private TextView textViewResultat;
    private Button buttonRetour;
    private CalculDao calculDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        calculDao = new CalculDao(new CalculBaseHelper(this, "BDD", 1));
        Calcul monCalcul = calculDao.lastOrNull();
        textViewResultat = findViewById(R.id.textViewScore);
        if(monCalcul != null){
            String affichage = getString(R.string.best_score) + " : " + monCalcul.getResultat();
            textViewResultat.setText(affichage);
        }
        else{
            textViewResultat.setText(R.string.aucun_score);
        }

        buttonRetour = findViewById(R.id.buttonRetour);
        buttonRetour.setOnClickListener(view -> {
            Intent intentHome = new Intent(ScoreActivity.this,MainActivity.class);
            startActivity(intentHome);
        });
    }
}