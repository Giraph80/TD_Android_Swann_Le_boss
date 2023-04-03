package com.example.td_android;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class Jeu extends AppCompatActivity {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button0;
    private TextView textViewCalcul;
    private TextView textViewReponse;
    private Button buttonEffacer;
    private Button buttonEnvoyer;
    private Integer score = 0;
    private int vie = 3;
    private String reponseUtilisateur = "";
    private Calcul calcul;
    private MenuItem star1;
    private MenuItem star2;
    private MenuItem star3;
    private MenuItem scoreMenu;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);

        textViewReponse = findViewById(R.id.textviewReponse);
        textViewCalcul = findViewById(R.id.textCalcul);

        button0 = findViewById(R.id.button_0);
        button0.setOnClickListener(view -> ajouterNombre("0"));

        button1 = findViewById(R.id.button_1);
        button1.setOnClickListener(view -> ajouterNombre("1"));

        button2 = findViewById(R.id.button_2);
        button2.setOnClickListener(view -> ajouterNombre("2"));

        button3 = findViewById(R.id.button_3);
        button3.setOnClickListener(view -> ajouterNombre("3"));

        button4 = findViewById(R.id.button_4);
        button4.setOnClickListener(view -> ajouterNombre("4"));

        button5 = findViewById(R.id.button_5);
        button5.setOnClickListener(view -> ajouterNombre("5"));

        button6 = findViewById(R.id.button_6);
        button6.setOnClickListener(view -> ajouterNombre("6"));

        button7 = findViewById(R.id.button_7);
        button7.setOnClickListener(view -> ajouterNombre("7"));

        button8 = findViewById(R.id.button_8);
        button8.setOnClickListener(view -> ajouterNombre("8"));

        button9 = findViewById(R.id.button_9);
        button9.setOnClickListener(view -> ajouterNombre("9"));

        buttonEnvoyer = findViewById(R.id.button_envoyer);
        buttonEnvoyer.setOnClickListener(view -> verificationResultat());

        buttonEffacer = findViewById(R.id.button_effacer);
        buttonEffacer.setOnClickListener(view -> effacerCalcul());


        vie = 3;

        calcul = new Calcul();


        textViewReponse.setText("");
        textViewCalcul.setText(calcul.toString());


    }

    private void effacerCalcul(){
        textViewReponse.setText((""));
        reponseUtilisateur="";
    }

    private void verificationResultat(){

        if(calcul.verifResultat(reponseUtilisateur)){
            score++;
            scoreMenu.setTitle(score.toString());
            effacerCalcul();

            calcul = new Calcul();

            textViewCalcul.setText(calcul.toString());


        }else{
            effacerCalcul();
            switch (vie){

                case 0:
                    gameOver();
                    break;

                case 1:
                    star3.setIcon(R.drawable.ic_star_empty);
                    vie--;
                    break;

                case 2:
                    star2.setIcon(R.drawable.ic_star_empty);
                    vie--;
                    break;


                case 3:
                    star1.setIcon(R.drawable.ic_star_empty);
                    vie--;
                    break;

            }

            Toast.makeText(this,R.string.BAD_RESPONSE,Toast.LENGTH_SHORT).show();


        }

    }

    private void gameOver() {

        Intent switchActivityIntent = new Intent(this,GameOver.class);

        switchActivityIntent.putExtra("SCORE",score);

        startActivity(switchActivityIntent);

        score = 0;
        scoreMenu.setTitle("0");


    }

    private boolean ajouterNombre(String charactereAjouter){
        reponseUtilisateur +=charactereAjouter;
        textViewReponse.setText(reponseUtilisateur);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater toolbar = getMenuInflater();
        toolbar.inflate(R.menu.toolbar_jeu,menu);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);

        star1 = menu.findItem(R.id.item_coeur_1);
        star2 = menu.findItem(R.id.item_coeur_2);
        star3 = menu.findItem(R.id.item_coeur_3);
        scoreMenu = menu.findItem(R.id.item_score);

        return super.onCreateOptionsMenu(menu);
    }
}