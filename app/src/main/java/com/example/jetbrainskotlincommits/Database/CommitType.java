package com.example.jetbrainskotlincommits.Database;

public class CommitType {
    public String name, message, date, photo;

    public CommitType(String name, String message, String photo, String date) {
        this.name = name;
        this.message = message;
        this.photo = photo;
        this.date = date;
    }
}
