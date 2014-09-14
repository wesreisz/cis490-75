package com.wesleyreisz.quizapp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wesleyreisz on 9/14/14.
 */
public class Question {
    private String question = "";
    private String answer = "";
    private Map<String,String> optionMap = new HashMap<String,String>();

    public Question(){}
    public Question(String question, String answer, Map<String,String> options){
        this.question = question;
        this.answer = answer;
        this.optionMap = options;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Map<String, String> getOptionMap() {
        return optionMap;
    }

    public void setOptionMap(Map<String, String> optionMap) {
        this.optionMap = optionMap;
    }
}
