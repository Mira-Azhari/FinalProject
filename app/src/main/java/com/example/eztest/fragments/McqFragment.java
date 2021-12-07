package com.example.eztest.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eztest.R;
import com.example.eztest.activities.ScoreActivity;
import com.example.eztest.activities.StudentMain;
import com.example.eztest.models.question;
import com.example.eztest.models.test;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link McqFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class McqFragment extends Fragment implements View.OnClickListener {

    ArrayList<question> questions;
    ArrayList<String> answers;
    TextView question;
    int score=0;
    int current;
    int clickedid;
    boolean clicked=false;
    String currentAnswer;
    androidx.appcompat.widget.AppCompatButton option1;
    androidx.appcompat.widget.AppCompatButton option2;
    androidx.appcompat.widget.AppCompatButton option3;
    androidx.appcompat.widget.AppCompatButton next;
    androidx.appcompat.widget.AppCompatButton back;
    View rootview;
    RelativeLayout testRelativeLayout;

    private test test;




    public McqFragment() {

    }
    public static McqFragment newInstance(test test1) {
        McqFragment fragment = new McqFragment();
        Bundle args = new Bundle();
        args.putSerializable("test", test1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        test = (test) getArguments().getSerializable("test");
        rootview= inflater.inflate(R.layout.fragment_mcq, container, false);
        setupviews();
        return rootview;

    }
    private void setupviews(){

        questions=new ArrayList<>();
        question = rootview.findViewById(R.id.question_text);
        option1 = rootview.findViewById(R.id.option1);
        option2 = rootview.findViewById(R.id.option2);
        option3 = rootview.findViewById(R.id.option3);
        next = rootview.findViewById(R.id.next_button);
        back = rootview.findViewById(R.id.back_button);
        testRelativeLayout = rootview.findViewById(R.id.testRelativeLayout);

        questions= test.getQuestions();
        answers=questions.get(0).getAnswers();
        question.setText(questions.get(0).getQuestion());

        option1.setText(answers.get(0));
        option2.setText(answers.get(1));
        option3.setText(answers.get(2));
        current=0;

        option1.setOnClickListener(this);
        option2.setOnClickListener(this);
        option3.setOnClickListener(this);
        next.setOnClickListener(this);
        back.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.option1:
                option1.setTextColor(getResources().getColor(R.color.black));
                option2.setTextColor(getResources().getColor(R.color.white));
                option3.setTextColor(getResources().getColor(R.color.white));

                currentAnswer= option1.getText().toString();
                clickedid=1;
                clicked=true;
                break;
            case R.id.option2:

                option2.setTextColor(getResources().getColor(R.color.black));
                option1.setTextColor(getResources().getColor(R.color.white));
                option3.setTextColor(getResources().getColor(R.color.white));

                currentAnswer=option2.getText().toString();
                clicked=true;
                clickedid=2;
                break;
            case R.id.option3:

                option3.setTextColor(getResources().getColor(R.color.black));
                option2.setTextColor(getResources().getColor(R.color.white));
                option1.setTextColor(getResources().getColor(R.color.white));
                currentAnswer=option3.getText().toString();
                clicked=true;
                clickedid=3;
                break;
            case R.id.back_button:
                if(current==0){

                }else{
                    previousQuestion();
                }
                break;
            case R.id.next_button:
                if(current==questions.size()-1){

                        if(clicked){
                            if(currentAnswer.equalsIgnoreCase(questions.get(current).getCorrectAnswer())){
                                score++;
                            }
                        }
                        int s=score*(100)/questions.size();
                    Intent intent = new Intent(getActivity().getApplicationContext(), ScoreActivity.class);
                    intent.putExtra("score",s);
                    startActivity(intent);




                }else{
                    nextQusetion();
                }
                break;

        }

    }

    private void previousQuestion() {
        current--;
        clicked=false;
        question.setText(questions.get(current).getQuestion());
        answers=questions.get(current).getAnswers();
        option1.setText(answers.get(0));
        option1.setTextColor(getResources().getColor(R.color.white));
        option2.setText(answers.get(1));
        option2.setTextColor(getResources().getColor(R.color.white));
        option3.setText(answers.get(2));
        option3.setTextColor(getResources().getColor(R.color.white));


    }

    private void nextQusetion() {

        if(questions.get(current).getSelectedAnswerID()==-1) {
            if(clicked){
                if(currentAnswer.equalsIgnoreCase(questions.get(current).getCorrectAnswer())){
                    score++;
                }
            }

        }else {

            if(clicked){
                if(currentAnswer.equalsIgnoreCase(questions.get(current).getCorrectAnswer())){
                    if(questions.get(current).getSelectedAnswerID()!=clickedid)
                    score++;
                }else{
                    score--;
                }
            }

        }
        questions.get(current).setSelectedAnswerID(clickedid);
        current++;
        clicked=false;
        answers=questions.get(current).getAnswers();
        question.setText(questions.get(current).getQuestion());
        option1.setText(answers.get(0));
        option1.setTextColor(getResources().getColor(R.color.white));
        option2.setText(answers.get(1));
        option2.setTextColor(getResources().getColor(R.color.white));
        option3.setText(answers.get(2));
        option3.setTextColor(getResources().getColor(R.color.white));


    }

}