package com.example.finalexercise.util;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.finalexercise.model.URLData;

@Database(entities = {URLData.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static final String TAG = "AppDatabase";
    private static final Object LOCK = new Object();
    private static final String databaseName = "finalproject";
    private static AppDatabase sInstance;

    public static AppDatabase getInstance(Context context){
        if(sInstance==null){
            synchronized (LOCK){
                Log.d(TAG,"creating new database instance");
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class,AppDatabase.databaseName)
                        .allowMainThreadQueries()
                        .build();
            }
        }
        Log.d(TAG,"Getting database instance");
        return sInstance;
    }

    public abstract URLDao urlDao();
}