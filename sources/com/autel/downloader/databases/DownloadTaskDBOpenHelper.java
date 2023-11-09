package com.autel.downloader.databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DownloadTaskDBOpenHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "downloadtask.db";
    private static final int DATABASE_VERSION = 1;

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public DownloadTaskDBOpenHelper(Context context) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 1);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        createTable(sQLiteDatabase);
    }

    private void createTable(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS DownloadQueue( _id INTEGER PRIMARY KEY, url VCHAR, path VCHAR, status TINYINT(7), receive_length INTEGER, total_length INTEGER)");
    }
}
