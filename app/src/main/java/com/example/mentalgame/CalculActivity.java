package com.example.mentalgame;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.LayoutDirection;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.mentalgame.DAO.CalculBaseHelper;
import com.example.mentalgame.DAO.CalculDao;
import com.example.mentalgame.entities.Calcul;

import java.util.Random;
import com.bumptech.glide.Glide;


public class CalculActivity extends AppCompatActivity {

    private String Calcul = "";
    private Integer compteurTaille = 0;

    private LinearLayout Imagebg;

    private ImageView ImageGif;
    private TextView textViewCalcul;
    private TextView textViewCalcul2;
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
    private Integer resultat = 0;
    private Integer score = 0;

    private Integer idpersowait = 0;
    private Integer idpersoloose = 0;
    private Integer idpersoatt = 0;

    private boolean reussi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcul);
        ImageView imageView = findViewById(R.id.my_image_view);
        textViewCalcul = findViewById(R.id.textcalcul);
        textViewCalcul2 = findViewById(R.id.textCalcul2);
        Imagebg = findViewById(R.id.layoutbg);
        ImageGif = findViewById(R.id.my_image_view);

        switch(recupId()){
            case 0:
                Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.fatebg, null);
                Imagebg.setBackground(drawable);
                idpersoatt=R.drawable.saberatt;
                idpersowait=R.drawable.gifsaber;
                idpersoloose=R.drawable.saberfail;

                break;
            case 1:
                Drawable drawable1 = ResourcesCompat.getDrawable(getResources(), R.drawable.bgkonosuba, null);
                Imagebg.setBackground(drawable1);
                idpersoatt=R.drawable.meguminatt;
                idpersowait=R.drawable.meguminwait;
                idpersoloose=R.drawable.meguminausol;
                break;
            case 2:
                Drawable drawable2 = ResourcesCompat.getDrawable(getResources(), R.drawable.bgrezero, null);
                Imagebg.setBackground(drawable2);
                idpersoatt=R.drawable.rematt;
                idpersowait=R.drawable.remwait;
                idpersoloose=R.drawable.remtombe;
                break;
            case 3:
                Drawable drawable3 = ResourcesCompat.getDrawable(getResources(), R.drawable.swordartonlinefield, null);
                Imagebg.setBackground(drawable3);
                idpersoatt=R.drawable.kiritoatt;
                idpersowait=R.drawable.kiritowait;
                idpersoloose=R.drawable.kiritodead;
                break;
            default:
                break;

        }





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
            if(textViewCalcul.getText().toString()=="")
                Toast.makeText(this, "Vide", Toast.LENGTH_LONG).show();
            else {
                reussi = validerReponse(resultat, textViewCalcul.getText().toString());
                if(reussi) {
                    resultat = randomCalcul();
                    Calcul = "";
                    textViewCalcul.setText("");
                    compteurTaille = 0;
                    score++;
                    Glide.with(CalculActivity.this)
                            .asGif()
                            .load(idpersoatt)

                            .into(imageView);
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Glide.with(CalculActivity.this)
                                .load(idpersowait)
                                .into(imageView);
                    }
                }, 1000);
            }
        });
        resultat = randomCalcul();
        scoreDao = new CalculDao(new CalculBaseHelper(this,"BDD",1));
        Glide.with(this)
                .load(idpersowait)
                .into(imageView);


    }

    private boolean ajoutCharacter(String characterAjout){
        Calcul += characterAjout;
        textViewCalcul.setText(Calcul);
        return true;
    }

    private boolean ajouterNombre(String nombre){
        if(compteurTaille <=4) {
            compteurTaille++;
            ajoutCharacter(nombre);
            return true;
        }
        return false;
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
    private Integer recupId(){
        Intent intent = getIntent();
        Integer Id = intent.getIntExtra("IdPerso", 0);
        return Id;
    }
    private boolean validerReponse(Integer resultat, String reponse){
        if(resultat.equals(Integer.valueOf(reponse))){
            return true;
        }
        return false;
    }


    private Integer randomCalcul(){
        Random rand = new Random();
        Integer signe = rand.nextInt(3);
        String retour = "";
        Integer resultat = 0;
        if(signe == 0){
            Integer premierNombre = rand.nextInt(999) + 1;
            Integer deuxiemeNombre = rand.nextInt(999) + 1;
            retour = premierNombre + " + " + deuxiemeNombre;
            resultat = premierNombre + deuxiemeNombre;
        } else if (signe == 1) {
            Integer premierNombre = rand.nextInt(999) + 1;
            Integer deuxiemeNombre = rand.nextInt(999) + 1;
            if(premierNombre<deuxiemeNombre){
                retour = deuxiemeNombre + " - " + premierNombre;
                resultat = deuxiemeNombre - premierNombre;
            }
            else{
                retour = premierNombre + " - " + deuxiemeNombre;
                resultat = premierNombre - deuxiemeNombre;
            }
        } else if (signe == 2) {
            Integer premierNombre = rand.nextInt(99) + 1;
            Integer deuxiemeNombre = rand.nextInt(99) + 1;
            retour = premierNombre + " * " + deuxiemeNombre;
            resultat = premierNombre * deuxiemeNombre;
        }
        textViewCalcul2.setText(retour);
        return resultat;
    }

    private void enregistrerLeScore(Integer score){
        Calcul monScore = new Calcul(score);
        scoreDao.create(monScore);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.toolbar, menu);
        MenuItem textTimer = menu.findItem(R.id.toolbar_timer);
        MenuItem boutonNetoyer = menu.findItem(R.id.item);
        boutonNetoyer.setOnMenuItemClickListener(view -> {
            Intent intentHome = new Intent(CalculActivity.this,MainActivity.class);
            startActivity(intentHome);
            return true;
        });
        countDownTimer = new CountDownTimer(31000,1000) {
            @Override
            public void onTick(long l) {
                if(reussi){
                    countDownTimer.cancel();
                    countDownTimer.start();
                    reussi = false;
                }
                int tempsRestantEnSecondes = (int) (l / 1000);

                textTimer.setTitle(String.valueOf(tempsRestantEnSecondes));
            }

            @Override
            public void onFinish() {
                ImageView imageView = findViewById(R.id.my_image_view);
                Calcul bestScore = scoreDao.lastOrNull();
                Glide.with(CalculActivity.this)
                        .asGif()
                        .load(idpersoloose)
                        .into(imageView);

                if(bestScore != null && bestScore.getResultat() != null){
                    if(bestScore.getResultat() < score){
                        enregistrerLeScore(score);
                    }
                }else{
                    enregistrerLeScore(score);
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(CalculActivity.this,ResultActivity.class);
                        intent.putExtra("Score", score);
                        startActivity(intent);
                    }
                }, 900);
            }
        }.start();

        MenuItem boutonCalcul = menu.findItem(R.id.toolbar_timer);
        return super.onCreateOptionsMenu(menu);
    }
}