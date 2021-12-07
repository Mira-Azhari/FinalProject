package com.example.eztest.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.eztest.R;
import com.example.eztest.adapters.quizAdapter;
import com.example.eztest.fragments.FillFragment;
import com.example.eztest.fragments.McqFragment;
import com.example.eztest.fragments.TrueFalseFragment;
import com.example.eztest.models.question;
import com.example.eztest.models.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StudentMain extends AppCompatActivity {

    ArrayList<test> tests = new ArrayList<>();
    ArrayList<question> questions=new ArrayList<>();
    RecyclerView recyclerView;
    test test;
    String TAG="Mira";
    quizAdapter adapter;
    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_main);

    setupviews();
    }

    private void setupviews() {
        frameLayout=findViewById(R.id.framelayout_main);
        ArrayList<String> testsNames = new ArrayList<>();
        getTests();
        Log.i(TAG, "setupviews: tests"+tests.size());
        for (int i=0;i<tests.size();i++){
            testsNames.add(tests.get(i).getName());
        }


        recyclerView = findViewById(R.id.tests_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new quizAdapter(this,testsNames);
        adapter.setClickListener(new quizAdapter.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                frameLayout.setVisibility(View.VISIBLE);
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                switch (tests.get(position).getType()){
                    case 1:
                        Fragment fragment = McqFragment.newInstance(tests.get(position));
                        ft.replace(R.id.framelayout_main, fragment);
                        ft.commit();
                        break;
                    case 2:
                        Fragment fragment1 = FillFragment.newInstance(tests.get(position));
                        ft.replace(R.id.framelayout_main, fragment1);
                        ft.commit();
                        break;
                    case 3:
                        Fragment fragment2 = TrueFalseFragment.newInstance(tests.get(position));
                        ft.replace(R.id.framelayout_main, fragment2);
                        ft.commit();
                        break;
                }

            }
        });

        Log.i(TAG, "setupviews: "+testsNames);
        Log.i(TAG, "setupviews: "+adapter.getItemCount());
        recyclerView.setAdapter(adapter);

    }
    public void getTests(){
        question q = new question();
        q.setType(1);
        q.setQuestion("test 0");
        ArrayList<String> answers=new ArrayList<>();
        answers.add("a1");
        answers.add("b1");
        answers.add("c1");
        q.setAnswers(answers);
        q.setCorrectAnswer("a1");

        questions.add(q);

        question q1 = new question();
        q1.setType(1);
        q1.setQuestion("test 1");
        ArrayList<String> answers1=new ArrayList<>();
        answers1.add("a2");
        answers1.add("b2");
        answers1.add("c2");
        q1.setAnswers(answers1);
        q1.setCorrectAnswer("a2");

        questions.add(q1);

        question q2 = new question();
        q2.setType(1);
        q2.setQuestion("test 2");
        ArrayList<String> answers2=new ArrayList<>();
        answers2.add("a3");
        answers2.add("b3");
        answers2.add("c3");
        q2.setAnswers(answers2);
        q2.setCorrectAnswer("b3");

        questions.add(q2);

        test = new test();
        test.setName("firsttest");
        test.setType(2);
        test.setQuestions(questions);
        tests.add(test);

    }


}