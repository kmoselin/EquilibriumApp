package com.example.trina.equilibriumapp;


import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class ViewGoalsActivity extends AppCompatActivity {

    static ImageView imageView;
//    ConnectivityManager connectivityManager;
//    NetworkInfo networkInfo;

    MyDB db;
    ListView listview;
    List<GoalItem> goalList;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_goals);

//        connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
//        networkInfo = connectivityManager.getActiveNetworkInfo();

        db = new MyDB(this, "Goals", null, 1);

        listview = findViewById(R.id.goallist);
        checkBox = findViewById(R.id.checkBox);


        populateListView();

    }

    private void populateListView(){
        //ArrayList<String> infoList = new ArrayList<>();

        goalList = new ArrayList<>();

        Cursor data = db.getAllGoals();
        if(data.getCount() == 0){
            Toast.makeText(this, "There are currently no goals in the database", Toast.LENGTH_SHORT).show();
        }
        else{
            while(data.moveToNext()){
                String goalItem = "Goal: " + data.getString(1) +"\n" + "Type: " + data.getString(2) + "\n" + "Priority: " + data.getString(3) + "\n" + "Status: "+ data.getString(4);
                goalList.add(new GoalItem(goalItem));
                MyListAdapter listAdapter = new MyListAdapter(this, R.layout.one_row, goalList);
                listview.setAdapter(listAdapter);
            }
        }
    }

    public void viewProgress(View view) {
        Intent i = new Intent(this, ShowProgressActivity.class);
        startActivity(i);
    }


}
