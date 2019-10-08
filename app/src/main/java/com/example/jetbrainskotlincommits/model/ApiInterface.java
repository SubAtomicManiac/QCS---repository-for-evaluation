package com.example.jetbrainskotlincommits.model;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiInterface {

    //https://api.github.com/repos/JetBrains/kotlin/commits
    @GET("repos/JetBrains/kotlin/commits")
    Observable<ArrayList<ResultsPojo>> getCommitData();

}
