package com.example.trina.equilibriumapp;

import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class ShowProgressActivity extends AppCompatActivity {
    int incompleteCount = 0;
    int completeCount = 0;

    MyDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_progress);

        db = new MyDB(this, "Goals", null, 1);

        populateChart();

    }

    public void populateChart(){
        PieChartView pieChartView = findViewById(R.id.progressChart);
        List<SliceValue> pieData = new ArrayList<>();

        Cursor incomplete = db.getIncompleteCount();
        Cursor completed = db.getCompleteCount();

        while(incomplete.moveToNext()){
            incompleteCount++;
        }
        while (completed.moveToNext()){
            completeCount++;
        }
        pieData.add(new SliceValue(incompleteCount, Color.parseColor("#0097A7")).setLabel("In Progress: "+ incompleteCount + " goals"));
        pieData.add(new SliceValue(completeCount,Color.parseColor("#ffd364")).setLabel("Completed: "+ completeCount + " goals"));

        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);
        pieChartData.setHasCenterCircle(true).setCenterText1("My Goals").setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#5e6590"));
        pieChartView.setPieChartData(pieChartData);
    }
}
