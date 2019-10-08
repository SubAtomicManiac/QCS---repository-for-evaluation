package com.example.jetbrainskotlincommits.Database;

import android.provider.BaseColumns;

public class DatabaseUtil {
    public static final String databaseName = "tododb";
    public static final int dabtabaseVersion = 1;

    public class TaskTable implements BaseColumns {
        public static final String tableName = "task";
        public static final String nameColumn = "name";
        public static final String messageColumn = "message";
        public static final String photoColumn = "photo";
        public static final String dateColumn = "date";

    }
}
