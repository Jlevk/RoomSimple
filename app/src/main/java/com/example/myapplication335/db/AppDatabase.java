package com.example.myapplication335.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Person.class}, version  = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PersonDao personDao();

}
