package com.example.jetbrainskotlincommits.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;

import com.example.jetbrainskotlincommits.Database.CommitDatabase;
import com.example.jetbrainskotlincommits.Database.CommitType;
import com.example.jetbrainskotlincommits.Database.DatabaseUtil;
import com.example.jetbrainskotlincommits.R;
import com.example.jetbrainskotlincommits.model.ResultsPojo;
import com.example.jetbrainskotlincommits.viewmodel.CustomAdapter;
import com.example.jetbrainskotlincommits.viewmodel.CustomViewModel;
import com.example.jetbrainskotlincommits.viewmodel.SavedCustomAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CustomAdapter adapter;
    private SavedCustomAdapter savedAdapter;
    private RecyclerView recyclerView;
    private CustomViewModel model;
    String name, message, date, photo;
    CommitType commitType = new CommitType(name, message, photo, date);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView =findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            createModelWithData();
        } else {
            //offline
            readCommits();
        }

    }

    public void createModelWithData(){
        model = ViewModelProviders.of(this).get(CustomViewModel.class);
        model.setSqLiteDatabase(new CommitDatabase(this).getWritableDatabase());
        model.getCommits().observe(this, new Observer<ArrayList<ResultsPojo>>() {
            @Override
            public void onChanged(ArrayList<ResultsPojo> resultsPojos) {
                adapter = new CustomAdapter(MainActivity.this, resultsPojos);
                recyclerView.setAdapter(adapter);
            }
        });

    }

    public void readCommits() {
        CommitDatabase toDoDatabase = new CommitDatabase(this);
        SQLiteDatabase readableDB = toDoDatabase.getReadableDatabase();

        Cursor cursor = readableDB.query(
                DatabaseUtil.TaskTable.tableName,
                null,
                null,
                null,
                null,
                null,
                null);
        List<CommitType> dataset = new ArrayList<>();
        CommitType item;

        while (cursor.moveToNext()) {
            String itemName =
                    cursor.getString(
                            cursor.getColumnIndexOrThrow(
                                    DatabaseUtil.TaskTable.nameColumn
                            )
                    );
            String itemMessage =
                    cursor.getString(
                            cursor.getColumnIndexOrThrow(
                                    DatabaseUtil.TaskTable.messageColumn
                            )
                    );
            String itemPhoto =
                    cursor.getString(
                            cursor.getColumnIndexOrThrow(
                                    (DatabaseUtil.TaskTable.photoColumn)
                            )
                    );
            String itemDate =
                    cursor.getString(
                            cursor.getColumnIndexOrThrow(
                                    DatabaseUtil.TaskTable.dateColumn
                            )
                    );
            item = new CommitType(itemName, itemMessage, itemPhoto, itemDate);
            dataset.add(item);
        }
        savedAdapter = new SavedCustomAdapter(MainActivity.this, dataset, commitType);
        recyclerView.setAdapter(savedAdapter);
    }
}
