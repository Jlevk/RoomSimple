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

    @ColumnInfo(name = "now")
    public Integer now;

    @ColumnInfo(name = "left")
    public Integer left;

    public Person(String firstname, Integer now, Integer left){
        this.firstname = firstname;
        this.now = now;
        this.left = left;

    }

}
