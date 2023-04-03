package com.example.td_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button bouton_jeu;
    private Button bouton_scores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bouton_jeu = findViewById(R.id.button_jeu);
        bouton_scores = findViewById(R.id.button_score);

        bouton_jeu.setOnClickListener(v ->{
            Intent switchActivityIntent = new Intent(this,Jeu.class);
            startActivity(switchActivityIntent);
        });

        bouton_scores.setOnClickListener(v->{
            Intent switchActivityIntent = new Intent(this,Scores.class);
            startActivity(switchActivityIntent);
        });
    }


}