package com.example.jetbrainskotlincommits.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CommitPojo {

    @SerializedName("author")
    @Expose
    public AuthorPojo author;
    @SerializedName("committer")
    @Expose
    public CommiterPojo committer;
    @SerializedName("message")
    @Expose
    public String message;
    @SerializedName("tree")
    @Expose
    public TreePojo tree;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("comment_count")
    @Expose
    public Integer commentCount;
    @SerializedName("verification")
    @Expose
    public VerificationPojo verification;

}
