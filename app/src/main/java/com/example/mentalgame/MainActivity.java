package com.example.mentalgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button BtnPlay;
    private Button BtnPerso;
    private Button BtnAPropos;
    private Button BtnScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BtnPlay = findViewById(R.id.button_play);
        BtnPerso = findViewById(R.id.button_perso);
        BtnAPropos = findViewById(R.id.button_a_propos);
        BtnScore = findViewById(R.id.button_score);

        BtnPlay.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,CalculActivity.class);
            startActivity(intent);
        });

        BtnScore.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,ScoreActivity.class);
            startActivity(intent);
        });

        BtnAPropos.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,AproposActivity.class);
            startActivity(intent);
        });




    }
}