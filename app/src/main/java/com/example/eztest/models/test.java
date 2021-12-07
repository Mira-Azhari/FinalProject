package com.example.eztest.models;

import java.io.Serializable;
import java.util.ArrayList;

public class test implements Serializable {
        private String name;
        private int type;
        private ArrayList<question> questions;

        public test() {
        }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ArrayList<question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<question> questions) {
        this.questions = questions;
    }
}
