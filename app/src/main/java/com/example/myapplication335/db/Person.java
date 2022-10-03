package com.example.myapplication335.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Person {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "first_name")
    public String firstname;

    @ColumnInfo(name = "last_name")
    public String lastname;


    public Person(String firstname, String lastname){
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
