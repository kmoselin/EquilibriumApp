package com.example.trina.equilibriumapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

public class HomePageActivity extends AppCompatActivity {
    Button calendarButton, todaysTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        calendarButton = findViewById(R.id.goToCalendarButton);
        todaysTask = findViewById(R.id.goToTaskButton);

        //navigates to calendarView
        calendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this,calendarView.class);
                startActivity(intent);
            }
        });


    }
}
