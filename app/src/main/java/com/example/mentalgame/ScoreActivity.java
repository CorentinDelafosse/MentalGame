package com.example.mentalgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mentalgame.DAO.CalculBaseHelper;
import com.example.mentalgame.DAO.CalculDao;
import com.example.mentalgame.entities.Calcul;

public class ScoreActivity extends AppCompatActivity {

    TextView textViewResultat;
    private CalculDao calculDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        calculDao = new CalculDao(new CalculBaseHelper(this, "BDD", 1));
        Calcul monCalcul = calculDao.lastOrNull();
        textViewResultat = findViewById(R.id.textBestScore);
        if(monCalcul != null){
            String affichage = R.string.best_score + " : " + monCalcul.getResultat();
            Toast.makeText(this, affichage, Toast.LENGTH_SHORT).show();
            textViewResultat.setText(affichage);
        }
        else{
            textViewResultat.setText(R.string.aucun_score);
        }
    }
}