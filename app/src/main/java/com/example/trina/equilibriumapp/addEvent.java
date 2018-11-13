package com.example.trina.equilibriumapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class addEvent extends AppCompatActivity {
    TextView dateText;
    EditText day;
    EditText timeStart;
    EditText event;
    EditText timeEnd;
    EditText priority;

    MyDB db;

    String date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        dateText = findViewById(R.id.textView);

       date = getIntent().getStringExtra("date");
        if(!date.matches("")){
            dateText.setText(date);
        }
        else {
            dateText.setText("No date selected");
        }




        timeStart = findViewById(R.id.startTime);
        timeEnd = findViewById(R.id.endTime);
        event = findViewById(R.id.Event);
        priority = findViewById(R.id.Priority);

        db = new MyDB(this, "Events", null, 1);
    }

    public void insertInfo(View view) {

        String eventDay = date;
        String start = timeStart.getText().toString();
        String end = timeEnd.getText().toString();
        String eventInfo = event.getText().toString();
        String priorityInfo = priority.getText().toString();


        db.insertEvent(eventDay, start, end, eventInfo, priorityInfo);

        Toast.makeText(this, eventInfo + " data Entered!", Toast.LENGTH_LONG).show();





    }

}