package com.example.myapplication335;


import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.myapplication335.db.AppDatabase;
import com.example.myapplication335.db.Person;
import com.example.myapplication335.db.PersonDao;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    List<String> names = new ArrayList<>();
    private EditText EditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "person-database").allowMainThreadQueries().build();

        EditText = findViewById(R.id.name_input);
        Button UpdateButton = findViewById(R.id.update_button);
        Person me = new Person("Ян");
        Person notMe = new Person("авыпывп");//создали несколько объектов

        db.personDao().insertPerson(me, notMe);// добавили их в бд
        List <Person> personList = db.personDao().getAllPersons();
        // получили все экземляры назад для дальнейшей работы с ними


        for (Person list: personList) {
            Log.d("who?", list.firstname);//вывод
            names.add("user: " + list.firstname);
        }

        ListView nameList = findViewById(R.id.listView);
        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, names);

        // устанавливаем для списка адаптер
        nameList.setAdapter(adapter);

        nameList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                nameList.setVisibility(View.GONE);
                EditText.setVisibility(View.VISIBLE);
                UpdateButton.setVisibility(View.VISIBLE);
            }
        });
        int extraUserId = getIntent().getIntExtra("pos", 0) + 1;

        EditText.setText(db.personDao().getUserById(extraUserId).firstname);
        UpdateButton.setOnClickListener(view -> db.personDao().updateUser(
                EditText.getText().toString(),
                extraUserId
        ));
        View.OnClickListener oclBtnOk = new View.OnClickListener() {
            @Override
            public void onClick(View v)  {
                Person person =
                        new Person(
                                EditText.getText().toString());
                db.personDao().insertPerson(person);
                List <Person> personList = db.personDao().getAllPersons();
                for (Person list: personList) {
                    Log.d("who?", list.firstname);//вывод
                    names.add("user: " + list.firstname);
                }
                nameList.setVisibility(View.VISIBLE);
                EditText.setVisibility(View.GONE);
                UpdateButton.setVisibility(View.GONE);
            }
        };

        // присвоим обработчик кнопке OK (btnOk)
        UpdateButton.setOnClickListener(oclBtnOk);
    }


}