package com.example.eztest.models;

import java.io.Serializable;
import java.util.ArrayList;

public class question implements Serializable {
private String question;
private int type;
private ArrayList<String> answers;
private String correctAnswer;
private int selectedAnswerID=-1;

    public question() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }



    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }

    public int getSelectedAnswerID() {
        return selectedAnswerID;
    }

    public void setSelectedAnswerID(int selectedAnswer) {
        this.selectedAnswerID = selectedAnswer;
    }
}
