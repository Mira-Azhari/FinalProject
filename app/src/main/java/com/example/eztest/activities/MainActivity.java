package com.example.eztest.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.eztest.R;
import com.example.eztest.models.User;
import com.example.eztest.models.question;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int usertype=2;
    EditText username;
    EditText password;
    AppCompatButton next;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupviews();
    }
    public void setupviews(){
        username= findViewById(R.id.username_edittext);
        password=findViewById(R.id.password_edittext);
        next = findViewById(R.id.loginBtn);

        next.setOnClickListener(this);

        user = new User();
        user.setUsername("admin");
        user.setPassword("1234");
        user.setTeacher(true);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loginBtn:
                handleNextClick();
        }
    }

    private void handleNextClick() {
        if(userverification()){
        if(user.isTeacher()){
            Intent intent = new Intent(this,TeacherMain.class);
            startActivity(intent);

        }else {
            Intent intent = new Intent(this,StudentMain.class);
            startActivity(intent);
        }
        }
    }
    private boolean userverification(){
        if(username.getText().toString().equalsIgnoreCase(user.getUsername())){
            if(password.getText().toString().equals(user.getPassword())){
                return true;
            }
        }
        return false;
    }
}