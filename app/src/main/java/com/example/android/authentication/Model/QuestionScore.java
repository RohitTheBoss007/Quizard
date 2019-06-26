package com.example.android.authentication.Model;

public class QuestionScore {
    private String user;
    private String score;

    public QuestionScore(String user, String score) {
        this.user = user;
        this.score = score;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public QuestionScore() {

    }
}
