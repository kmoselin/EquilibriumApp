package com.example.trina.equilibriumapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CalendarView;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

//        calendarButton = findViewById(R.id.goToCalendarButton);
////        todaysTask = findViewById(R.id.goToTaskButton);
////
////        //navigates to calendarView
////        calendarButton.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                Intent intent = new Intent(HomePageActivity.this,calendarView.class);
////                startActivity(intent);
////            }
////        });




    }

    public void goToAddGoals(View view) {
        Intent intent = new Intent(HomePageActivity.this,AddGoalActivity.class);
        startActivity(intent);
    }



    public void viewSchedule(View view) {
        Intent intent = new Intent(this, ViewSchedule.class);
        startActivity(intent);
    }

    public void showProgress(View view) {
        Intent intent = new Intent(this, ViewGoalsActivity.class);
        startActivity(intent);
    }

    public void wellBeing(View view) {
    }

    public void viewCalendar(View view) {
        Intent intent = new Intent(this, calendarView.class);
        startActivity(intent);
    }
}
