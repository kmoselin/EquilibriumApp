package com.example.trina.equilibriumapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.Toast;

public class calendarView extends AppCompatActivity {
    Button select;
    DatePicker pickDate;
    CalendarView calendarView;
    String date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_view);

        calendarView = findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange( CalendarView calendarView, int year, int month, int dayOfMonth) {
                date = month+1 + "/" + dayOfMonth + "/" + year;
                Log.d(String.valueOf(this), "date: " + date);



            }
        });
    }

    public void gotoEvent(View view) {
        Intent intent = new Intent(this, addEvent.class );

        intent.putExtra("date", date);

        if(date != null) {
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Select a date!", Toast.LENGTH_SHORT).show();
        }
    }


    public DatePicker getPickDate() {
        return pickDate;
    }

    public void gotoSchedule(View view) {

        Intent intent = new Intent(this, ViewSchedule.class);
        intent.putExtra("date", date);
        startActivity(intent);
    }
}