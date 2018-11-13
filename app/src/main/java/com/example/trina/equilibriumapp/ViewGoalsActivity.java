package com.example.trina.equilibriumapp;


import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewGoalsActivity extends AppCompatActivity {

    static ImageView imageView;
    ConnectivityManager connectivityManager;
    NetworkInfo networkInfo;
    MyDB db;
    ListView listview;
    DownloadImage di;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_goals);
        imageView = (ImageView) findViewById(R.id.imgView);
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

    }

    public void downloadImage(View view) {
        if (networkInfo != null && networkInfo.isConnected()) {
            di = new DownloadImage();
            di.execute("https://cdn-images-1.medium.com/max/1198/1*DIq4u0PzaPtayrRnpFr0BA.png");
        } else
            Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
    }
}
