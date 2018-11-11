package com.example.trina.equilibriumapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class addEvent extends AppCompatActivity {
    TextView dateText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        dateText = findViewById(R.id.textView);

        String date = getIntent().getStringExtra("date");
        if(date!=null){
            dateText.setText(date);
        }
    }
}
