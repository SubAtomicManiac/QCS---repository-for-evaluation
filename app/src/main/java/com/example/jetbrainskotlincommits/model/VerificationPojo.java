package com.example.jetbrainskotlincommits.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VerificationPojo {

    @SerializedName("verified")
    @Expose
    public Boolean verified;
    @SerializedName("reason")
    @Expose
    public String reason;
    @SerializedName("signature")
    @Expose
    public Object signature;
    @SerializedName("payload")
    @Expose
    public Object payload;

}
