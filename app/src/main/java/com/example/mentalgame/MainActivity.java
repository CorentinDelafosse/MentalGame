package com.example.mentalgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.example.mentalgame.DAO.CalculBaseHelper;
import com.example.mentalgame.DAO.CalculDao;
import com.example.mentalgame.DAO.PersoBaseHelper;
import com.example.mentalgame.DAO.PersoDao;
import com.example.mentalgame.entities.Calcul;
import com.example.mentalgame.entities.Perso;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private Button BtnPlay;
    private Button BtnPerso;
    private Button BtnAPropos;
    private Button BtnScore;

    private Integer id;

    private PersoDao PersoDao;

    private ImageView imagebg;

    private ImageView imageperso;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


        BtnPlay = findViewById(R.id.button_play);
        BtnPerso = findViewById(R.id.button_perso);
        BtnAPropos = findViewById(R.id.button_a_propos);
        BtnScore = findViewById(R.id.button_score);

        PersoDao = new PersoDao(new PersoBaseHelper(this,"BDD1",1));



        BtnPlay.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,CalculActivity.class);
            intent.putExtra("IdPerso", id);
            startActivity(intent);
        });

        BtnPerso.setOnClickListener(view -> {
            id = changPerso();
            enregistrerid(id);
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

    public Integer changPerso(){
        imagebg = findViewById(R.id.imageView2);
        imageperso = findViewById(R.id.imageSaberMenu);
        Random random = new Random();
        int randomNumber = random.nextInt(4);
        switch (randomNumber) {
            case 0:
                Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.fatebg, null);
                imagebg.setBackground(drawable);
                System.out.println("Le nombre n'est pas compris entre 1");
                imageperso.setImageResource(R.drawable.saber_art);
                break;
            case 1:
                Drawable drawable1 = ResourcesCompat.getDrawable(getResources(), R.drawable.bgkonosuba, null);
                imagebg.setBackground(drawable1);
                System.out.println("Le nombre n'est pas compris entre 2");
                imageperso.setImageResource(R.drawable.megumin);
                break;
            case 2:
                Drawable drawable2 = ResourcesCompat.getDrawable(getResources(), R.drawable.bgrezero, null);
                imagebg.setBackground(drawable2);
                System.out.println("Le nombre n'est pas compris entre 2");
                imageperso.setImageResource(R.drawable.rem);
                break;
            case 3:
                Drawable drawable3 = ResourcesCompat.getDrawable(getResources(), R.drawable.saobghome, null);
                imagebg.setBackground(drawable3);
                System.out.println("Le nombre n'est pas compris entre 2");
                imageperso.setImageResource(R.drawable.kirito);
                break;
            default:
                System.out.println("Le nombre n'est pas compris entre 0 et 5.");
        }
        return randomNumber;
    }
    private void enregistrerid(Integer score){
        Perso monScore = new Perso(score);
        PersoDao.create(monScore);
    }
}