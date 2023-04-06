package com.example.mentalgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView textViewScore;
    private Button buttonRetour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textViewScore = findViewById(R.id.textViewScore);
        Intent intent = getIntent();
        Integer score = intent.getIntExtra("Score", 0);
        textViewScore.setText(score.toString());

        buttonRetour.setOnClickListener(view -> {

        });
    }
}