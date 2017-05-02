package com.example.sonny_cole.projet_1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sonny-cole on 17/03/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static DatabaseHelper sInstance;

    private final String CREATE_TABLE =
            "CREATE TABLE table (" +
                    "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "MESSAGE TEXT);";


    private DatabaseHelper(Context context) {
        super(context, "database.db", null, 1);
    }

    public static DatabaseHelper getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new DatabaseHelper(context);
        }
        return sInstance;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int
            oldVersion, int newVersion) {
        // gérer ce cas
    }


}