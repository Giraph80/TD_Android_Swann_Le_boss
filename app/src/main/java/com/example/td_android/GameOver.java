package com.example.td_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.td_android.DAO.CalculBaseHelper;
import com.example.td_android.DAO.CalculDao;
import com.example.td_android.entities.Score;

import java.util.Objects;

public class GameOver extends AppCompatActivity {

    private TextView score;
    private CalculDao calculDao;

    private Button home;
    private Button retry;
    private EditText InputName;
    //TODO:relier les bouton, changer design carte, virgule , diviser , empecher non vide

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        Intent intent = getIntent();
        Integer scorefinal = intent.getIntExtra("SCORE",0);

        score = findViewById(R.id.textViewScore);

        InputName = findViewById(R.id.editTextTextPersonName);

        home = findViewById(R.id.bouton_menu);
        home.setOnClickListener(v -> {


            enregistreScore(scorefinal,InputName.getText().toString());

            Intent switchActivityIntent = new Intent(this,MainActivity.class);
            startActivity(switchActivityIntent);

        });



        retry = findViewById(R.id.boutton_rejouer);
        retry.setOnClickListener(v -> {

            enregistreScore(scorefinal,InputName.getText().toString());

            Intent switchActivityIntent = new Intent(this,Jeu.class);
            startActivity(switchActivityIntent);

        });

        calculDao = new CalculDao(new CalculBaseHelper(this, "BDD",1));



        score.setText("Score : " + scorefinal);




    }


    private void enregistreScore(Integer score, String nom){
        if(Objects.equals(nom, "")){
            nom = "User";
        }
        Score monScore = new Score(nom, score);
        calculDao.create(monScore);
    }

}