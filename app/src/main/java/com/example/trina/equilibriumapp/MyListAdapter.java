package com.example.trina.equilibriumapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyListAdapter extends ArrayAdapter<GoalItem> {
    List<GoalItem> goalList;
    Context context;
    int resource;

    public MyListAdapter(Context context, int resource, List<GoalItem> goalList){
        super(context, resource, goalList);
        this.context = context;
        this.resource = resource;
        this.goalList = goalList;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater layoutInflater = LayoutInflater.from(context); //get the view of xml from out list item, need layoutinflater
        //mDataBase = new DataBase(this, "photos", null, 1);

        View view = layoutInflater.inflate(resource,null,false); //getting view

        TextView textView = view.findViewById(R.id.goal_list_item);
        CheckBox checkBox = view.findViewById(R.id.checkBox);


        GoalItem goal = goalList.get(position);
        //GoalItem check = goalList.get(position);
        textView.setText(goal.getGoal());
        //checkBox.setChecked(check.isChecked());

        return view;

    }


}
