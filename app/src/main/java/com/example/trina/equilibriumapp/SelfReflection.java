package com.example.trina.equilibriumapp;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class SelfReflection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_reflection);
        RadioButton rb = (RadioButton) findViewById(R.id.radioButton);//happy emoji
        rb.setText(new String(Character.toChars(0x1F60A)));

        RadioButton rb2 = (RadioButton) findViewById(R.id.radioButton2);//neutral emoji
        rb2.setText(new String(Character.toChars(0x1F614)));

        RadioButton rb3 = (RadioButton) findViewById(R.id.radioButton3);//angry emoji
        rb3.setText(new String(Character.toChars(0x1F620)));
    }

    public void viewReflections(View view) {
        Intent i = new Intent(this, AddReflection.class);
        startActivity(i);
    }

    public void saveReflection(View view) {

    }
}
