package com.example.jetbrainskotlincommits.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ParentPojo {

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("email")
    @Expose
    public String email;
    @SerializedName("date")
    @Expose
    public String date;

}
