package com.example.jetbrainskotlincommits.viewmodel;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Database;

import com.example.jetbrainskotlincommits.Database.CommitDatabase;
import com.example.jetbrainskotlincommits.Database.DatabaseUtil;
import com.example.jetbrainskotlincommits.R;
import com.example.jetbrainskotlincommits.model.ApiInterface;
import com.example.jetbrainskotlincommits.model.ResultsPojo;
import com.example.jetbrainskotlincommits.view.MainActivity;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static androidx.constraintlayout.widget.Constraints.TAG;
import static androidx.room.RoomMasterTable.TABLE_NAME;

public class CustomViewModel extends ViewModel {

    private MutableLiveData<ArrayList<ResultsPojo>> commitsList;
    private SQLiteDatabase sqLiteDatabase;

    public LiveData<ArrayList<ResultsPojo>> getCommits() {
        commitsList = new MutableLiveData<>();
        loadCommits();
        return commitsList;
    }

    public void setSqLiteDatabase(SQLiteDatabase sqLiteDatabase) {
        this.sqLiteDatabase = sqLiteDatabase;
    }

    private void loadCommits() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        apiInterface.getCommitData().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<ArrayList<ResultsPojo>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ArrayList<ResultsPojo> resultsPojos) {
                commitsList.setValue(resultsPojos);
                clearEntries();
                for (int i=0; i<resultsPojos.size(); i++){
                    String name = resultsPojos.get(i).commit.author.name;
                    String message = resultsPojos.get(i).commit.message;
                    String photo;
                    if (resultsPojos.get(i).author != null){
                         photo = resultsPojos.get(i).author.avatarUrl;
                    } else {
                        photo = "https://www.science-emergence.com/media/images/thumbnails_1000_1000/question-mark-img.JPEG?lastmod=1568857970.943363";
                    }
                    String date = resultsPojos.get(i).commit.author.date;
                    saveEntry(name, message, photo, date);
                }
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    public void saveEntry(String name, String message, String photo, String date) {
        ContentValues values = new ContentValues();
        values.put(DatabaseUtil.TaskTable.nameColumn, name);
        values.put(DatabaseUtil.TaskTable.messageColumn, message);
        values.put(DatabaseUtil.TaskTable.photoColumn, photo);
        values.put(DatabaseUtil.TaskTable.dateColumn, date);
        sqLiteDatabase.insert(DatabaseUtil.TaskTable.tableName, null, values);
    }

    public void clearEntries(){
        sqLiteDatabase.execSQL("delete from "+ DatabaseUtil.TaskTable.tableName);
    }
}
