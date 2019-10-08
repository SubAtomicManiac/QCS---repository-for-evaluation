package com.example.jetbrainskotlincommits.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CommitDatabase extends SQLiteOpenHelper {

    public CommitDatabase(Context context) {
        super(context,
                DatabaseUtil.databaseName,
                null,
                DatabaseUtil.dabtabaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE TABLE "+
                        DatabaseUtil.TaskTable.tableName +
                        " (" +
                        DatabaseUtil.TaskTable._ID +
                        " INTEGER PRIMARY KEY," +
                        DatabaseUtil.TaskTable.nameColumn +
                        " VARCHAR(255)," +
                        DatabaseUtil.TaskTable.messageColumn +
                        " VARCHAR(255)," +
                        DatabaseUtil.TaskTable.photoColumn +
                        " VARCHAR(255)," +
                        DatabaseUtil.TaskTable.dateColumn +
                        " VARCHAR(255))"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
