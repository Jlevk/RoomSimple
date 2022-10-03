package com.example.myapplication335.db;

import androidx.room.Dao;

import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PersonDao {

    @Query("SELECT * FROM person")
    List<Person> getAllPersons();

    @Insert
    void insertPerson(Person... persons);

}
