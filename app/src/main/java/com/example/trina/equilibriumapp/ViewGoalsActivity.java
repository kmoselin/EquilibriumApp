package com.example.trina.equilibriumapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ViewGoalsActivity extends AppCompatActivity {

    MyDB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_goals);
        db = new MyDB(this, "Goals", null, 1);
    }
}
