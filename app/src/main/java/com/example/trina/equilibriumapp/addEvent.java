package com.example.trina.equilibriumapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class addEvent extends AppCompatActivity {
    TextView dateText;
    EditText day;
    EditText timeStart;
    EditText event;
    EditText timeEnd;
    EditText priority;

    Spinner hourStart;
    Spinner hourEnd;

    Spinner Start_ampm;
    Spinner End_ampm;
    MyDB db;

    String date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        dateText = findViewById(R.id.textView);

        hourStart = findViewById(R.id.StartHour);
        hourEnd = findViewById(R.id.EndHour);

        Start_ampm = findViewById(R.id.ampm1);
        End_ampm = findViewById(R.id.ampm2);

        date = getIntent().getStringExtra("date");

        dateText.setText(date);
       /* if(!date.matches("")){
            dateText.setText(date);
        }
        else {
            dateText.setText("No date selected");
        }*/





        event = findViewById(R.id.Event);


        db = new MyDB(this, "Events", null, 1);
    }

    public void insertInfo(View view) {

        String eventDay = date;
        String start = hourStart.getSelectedItem().toString();
        String end = hourEnd.getSelectedItem().toString();
        String start_ampm = Start_ampm.getSelectedItem().toString();
        String end_ampm = End_ampm.getSelectedItem().toString();

        //String start = timeStart.getText().toString();
        //String end = timeEnd.getText().toString();
        String eventInfo = event.getText().toString();


        Log.d("check", start + " " + start_ampm + " " + end + " " + end_ampm + " " + eventInfo);



        db.insertEvent(eventDay, start + " " + start_ampm , end + " " + end_ampm, eventInfo, "High priority");

        Toast.makeText(this, eventInfo + " data Entered!", Toast.LENGTH_LONG).show();





    }


}