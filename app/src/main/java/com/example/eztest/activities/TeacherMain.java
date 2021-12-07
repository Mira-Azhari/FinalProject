package com.example.eztest.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Switch;

import com.example.eztest.R;
import com.example.eztest.adapters.quizAdapter;
import com.example.eztest.fragments.CreateFill;
import com.example.eztest.fragments.CreateMCQ;
import com.example.eztest.fragments.CreateTrueFalse;
import com.example.eztest.fragments.McqFragment;
import com.example.eztest.models.question;

import java.util.ArrayList;

public class TeacherMain extends AppCompatActivity {
    ArrayList<String> types;
    RecyclerView recyclerView;
    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_main);

        setupviews();
    }
    private void setupviews(){
        frameLayout = findViewById(R.id.framelayout_main);
        recyclerView = findViewById(R.id.types_recyclerview);
        types =new ArrayList<>();
        types.add("MCQ");
        types.add("Fill in the blank");
        types.add("True or False");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        quizAdapter adapter = new quizAdapter(this,types);
        adapter.setClickListener(new quizAdapter.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                frameLayout.setVisibility(View.VISIBLE);
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                switch (position){
                    case 0:
                        Log.i("tag", "onItemClick: 0");
                        Fragment fragment = CreateMCQ.newInstance();
                        ft.replace(R.id.framelayout_main, fragment);
                        ft.commit();
                        break;
                    case 1:
                        Log.i("tag", "onItemClick: 1");

                        Fragment fragment1 = CreateFill.newInstance();
                        ft.replace(R.id.framelayout_main, fragment1);
                        ft.commit();
                        break;
                    case 2:
                        Log.i("tag", "onItemClick: 2");

                        Fragment fragment2 = CreateTrueFalse.newInstance();
                        ft.replace(R.id.framelayout_main, fragment2);
                        ft.commit();
                        break;
                }
            }
        });
        recyclerView.setAdapter(adapter);
        Log.i("tag", "setupviews: "+adapter.getItemCount());
    }
}