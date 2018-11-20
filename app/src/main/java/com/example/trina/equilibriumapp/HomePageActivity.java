package com.example.trina.equilibriumapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;


public class HomePageActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authStateListener;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        textView = findViewById(R.id.textView);

        auth = FirebaseAuth.getInstance();

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


    public void showProgress(View view) {
        Intent prog = new Intent(this, ViewGoalsActivity.class);
        startActivity(prog);
    }

    public void wellBeing(View view) {
        Intent schedge = new Intent(this, SelfReflection.class);
        startActivity(schedge);
    }

    public void viewCalendar(View view) {
        Intent intent = new Intent(this, calendarView.class);
        startActivity(intent);
    }

    public void viewTimer(View view) {
        Intent intent = new Intent(this, timer.class);
        startActivity(intent);
    }

    public void logOut(View view) {

    }


}
