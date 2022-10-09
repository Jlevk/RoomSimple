package com.example.myapplication335.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Person {

    @PrimaryKey(autoGenerate = true)
    public int userId;

    @ColumnInfo(name = "first_name")
    public String firstname;


    public Person(String firstname){
        this.firstname = firstname;

    }
}
