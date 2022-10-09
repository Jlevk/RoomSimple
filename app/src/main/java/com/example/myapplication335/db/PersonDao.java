package com.example.myapplication335.db;

import androidx.room.Dao;

import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PersonDao {

    @Query("SELECT * FROM person")
    List<Person> getAllPersons();

    @Query("SELECT * FROM person WHERE userId=:id")
    Person getUserById(int id);

    @Insert
    void insertPerson(Person... persons);

    @Query("UPDATE person SET first_name = :firstname WHERE userId = :userId ")
    void updateUser(String firstname, int userId);

}
