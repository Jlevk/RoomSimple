package com.example.myapplication335;


import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import com.example.myapplication335.db.AppDatabase;
import com.example.myapplication335.db.Person;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "person-database").allowMainThreadQueries().build();

        Person me = new Person("Ян", "Ян");
        Person notMe = new Person("авыпывп", "фыавпр");//создали несколько объектов

        db.personDao().insertPerson(me, notMe);// добавили их в бд
        List <Person> personList = db.personDao().getAllPersons();
        // получили все экземляры назад для дальнейшей работы с ними


        for (Person list: personList) {
            Log.d("who?", list.firstname + " " + list.lastname);//вывод
        }

    }
}