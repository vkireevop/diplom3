package com.example.diplom3.dto;

import java.util.List;

public class QuestionAndOptions {
    private String question;
    private List<String> options;

    public QuestionAndOptions(String question, List<String> options) {
        this.question = question;
        this.options = options;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }
}