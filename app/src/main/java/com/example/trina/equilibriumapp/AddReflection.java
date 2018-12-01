package com.example.trina.equilibriumapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

//activity just shows a listView of Reflections
public class AddReflection extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reflection);

        listView = findViewById(R.id.reflectionList);

        ArrayList<String> reflectionList = new ArrayList<>();

    }

}
