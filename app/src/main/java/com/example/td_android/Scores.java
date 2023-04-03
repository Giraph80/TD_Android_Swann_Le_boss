package com.example.td_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.td_android.DAO.CalculBaseHelper;
import com.example.td_android.DAO.CalculDao;
import com.example.td_android.entities.Score;

import java.util.List;

public class Scores extends AppCompatActivity {

    private CalculDao calculDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);

        calculDao = new CalculDao(new CalculBaseHelper(this, "BDD",1));
        List<Score> messcore = calculDao.bestFive();

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new Adapter(getApplicationContext(),messcore));


    }
}