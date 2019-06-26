package com.example.android.authentication.Model;

public class Ranking {
    private String username;
    private long marks;

    public Ranking() {
    }

    public Ranking(String username, long marks) {
        this.username = username;
        this.marks = marks;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getMarks() {
        return marks;
    }

    public void setMarks(long marks) {
        this.marks = marks;
    }
}

