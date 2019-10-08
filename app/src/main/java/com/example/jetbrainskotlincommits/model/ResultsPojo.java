package com.example.jetbrainskotlincommits.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultsPojo {

    @SerializedName("committer")
    @Expose
    public CommiterPojo committer;
    @SerializedName("parents")
    @Expose
    public List<ParentPojo> parents = null;
    @SerializedName("sha")
    @Expose
    public String sha;
    @SerializedName("node_id")
    @Expose
    public String nodeId;
    @SerializedName("commit")
    @Expose
    public CommitPojo commit;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("html_url")
    @Expose
    public String htmlUrl;
    @SerializedName("comments_url")
    @Expose
    public String commentsUrl;
    @SerializedName("author")
    @Expose
    public Author_Pojo author;

}
