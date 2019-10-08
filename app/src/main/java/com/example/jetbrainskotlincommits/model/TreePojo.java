package com.example.jetbrainskotlincommits.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TreePojo {

    @SerializedName("sha")
    @Expose
    public String sha;
    @SerializedName("url")
    @Expose
    public String url;

}
