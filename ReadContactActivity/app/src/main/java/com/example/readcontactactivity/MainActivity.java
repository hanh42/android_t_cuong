package com.example.readcontactactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.readcontactactivity.DataModel.Person;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Person> personArrayList;
    private ArrayList<String> numberArrayList;
    private ArrayList<String> emailArrayList;
    private ArrayList<String> addressArrayList;

    private ListView listView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        createData();
        personArrayList.add(new Person("Chu Dinh Hanh", numberArrayList, emailArrayList, addressArrayList));
        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, personArrayList);
        listView.setAdapter(arrayAdapter);
    }
    public void anhXa(){
        listView = findViewById(R.id.list_view);
    }

    public void createData() {
        //Create phone number data
        numberArrayList = new ArrayList<>();
        numberArrayList.add("0988244510");
        numberArrayList.add("01632494161");
        numberArrayList.add("19008198");
        numberArrayList.add("371160524");
        personArrayList = new ArrayList<>();
        //Create gmail data
        emailArrayList = new ArrayList<>();
        emailArrayList.add("dinhh7844@gmail1.com");
        emailArrayList.add("dinhh7844@gmail2.com");
        emailArrayList.add("dinhh7844@gmail3.com");
        emailArrayList.add("dinhh7844@gmail4.com");
        //Create address data
        addressArrayList = new ArrayList<>();
        addressArrayList.add("147 streets PLB, Thu Duc City");
        addressArrayList.add("1478 streets PLB, Thu Duc City");
        addressArrayList.add("149m streets PLB, Thu Duc City");
        addressArrayList.add("150m streets PLB, Thu Duc City");
    }
}