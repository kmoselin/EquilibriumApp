package com.example.trina.equilibriumapp;


import android.database.Cursor;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
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
    ConnectivityManager connectivityManager;
    NetworkInfo networkInfo;

    MyDB db;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_goals);

        connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        networkInfo = connectivityManager.getActiveNetworkInfo();

        db = new MyDB(this, "Goals", null, 1);

        listview = findViewById(R.id.goallist);
        ArrayList<String> infoList = new ArrayList<>();

        Cursor data = db.getAllGoals();
        if(data.getCount() == 0){
            Toast.makeText(this, "There are currently no goals in the database", Toast.LENGTH_SHORT).show();
        }
        else{
            while(data.moveToNext()){
                infoList.add("Goal Description: " + data.getString(1) +"\n" + "Type: " + data.getString(2) + "\n" + "Priority: " + data.getString(3) + "\n" + "Status: "+ data.getString(4));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, infoList);
                listview.setAdapter(listAdapter);
            }
        }


        PieChartView pieChartView = findViewById(R.id.progressChart);
        List<SliceValue> pieData = new ArrayList<>();
//        pieData.add(new SliceValue(15, Color.BLUE));
//        pieData.add(new SliceValue(25, Color.GRAY));
//        pieData.add(new SliceValue(10, Color.RED));
//        pieData.add(new SliceValue(60, Color.MAGENTA));

        pieData.add(new SliceValue(15, Color.YELLOW).setLabel("Q1: $10"));
        pieData.add(new SliceValue(25, Color.GRAY).setLabel("Q2: $4"));
        pieData.add(new SliceValue(10, Color.RED).setLabel("Q3: $18"));
        pieData.add(new SliceValue(60, Color.MAGENTA).setLabel("Q4: $28"));

        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);
        pieChartData.setHasCenterCircle(true).setCenterText1("Sales in million").setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#0097A7"));

        pieChartView.setPieChartData(pieChartData);
    }

}
