package com.example.trina.equilibriumapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class ViewSchedule extends AppCompatActivity {

    ListView listView;
    String date;
    MyDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_schedule);

        date = getIntent().getStringExtra("date");
        db = new MyDB(this, "Events", null, 1);
        listView = findViewById(R.id.eventList);
        ArrayList<String> infoList = new ArrayList<>();

        Cursor data = db.getAllEvents();
        if(data.getCount() == 0){
            Toast.makeText(this, "There are currently no events in the database", Toast.LENGTH_SHORT).show();
        }
        else{
            while(data.moveToNext()){
                infoList.add("Date: " + data.getString(1) +"\n" + "Start Time: " + data.getString(2) + "\n" + "End Time: "+ data.getString(3) + "\n" + "Event Description: " + data.getString(4) );
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, infoList);
                listView.setAdapter(listAdapter);
            }
        }
    }
}
