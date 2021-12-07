package com.example.eztest.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.eztest.R;

import java.io.Serializable;

public class ScoreActivity extends AppCompatActivity implements Serializable {

    int score;
    TextView scoreText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        scoreText=findViewById(R.id.score_text);
        if(getIntent().hasExtra("score")){
            score=getIntent().getIntExtra("score",50);
            scoreText.setText(score+"/100");
        }

    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}