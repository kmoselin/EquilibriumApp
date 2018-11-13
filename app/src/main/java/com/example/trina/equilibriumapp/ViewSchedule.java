package com.example.trina.equilibriumapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;




public class ViewSchedule extends AppCompatActivity {


    String date;
    MyDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_schedule);

        date = getIntent().getStringExtra("date");
        db = new MyDB(this, "Events", null, 1);
    }
}
