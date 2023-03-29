package com.example.mentalgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mentalgame.DAO.CalculBaseHelper;
import com.example.mentalgame.DAO.CalculDao;
import com.example.mentalgame.entities.Calcul;

import java.util.Random;

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
    private CountDownTimer countDownTimer;
    private CalculDao scoreDao;
    private String CalculAResoudre;


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
        CalculAResoudre = randomCalcul();
        scoreDao = new CalculDao(new CalculBaseHelper(this,"BDD",1));

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


    private String randomCalcul(){
        Random rand = new Random();
        Integer premierNombre = rand.nextInt(999) + 1;
        Integer deuxiemeNombre = rand.nextInt(999) + 1;
        Integer signe = rand.nextInt(3);
        String retour = "";
        if(signe == 0){
            retour = premierNombre + " + " + deuxiemeNombre;
        } else if (signe == 1) {
            retour = premierNombre + " - " + deuxiemeNombre;
        } else if (signe == 2) {
            retour = premierNombre + " * " + deuxiemeNombre;
        }
        return retour;
    }

    private void enregistreLeCalcul(Integer resultat){
        com.example.mentalgame.entities.Calcul monCalcul = new Calcul(resultat);
        scoreDao.create(monCalcul);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.toolbar, menu);
        MenuItem textTimer = menu.findItem(R.id.toolbar_timer);
        countDownTimer = new CountDownTimer(15000,1000) {
            @Override
            public void onTick(long l) {
                int tempsRestantEnSecondes = (int) (l / 1000);

                textTimer.setTitle(String.valueOf(tempsRestantEnSecondes));
            }

            @Override
            public void onFinish() {

            }
        }.start();


        MenuItem boutonCalcul = menu.findItem(R.id.toolbar_timer);
        return super.onCreateOptionsMenu(menu);
    }
}