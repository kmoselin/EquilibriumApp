package com.example.trina.equilibriumapp;

import android.widget.Button;
import android.widget.CheckBox;

public class GoalItem {
    String goal;
    CheckBox checkboxItem;

    //private boolean checked = false;

    GoalItem(String goal){
        this.goal = goal;
    }

    public String getGoal(){
        return goal;
    }

    public CheckBox getCheckbox(){
        return checkboxItem;
    }

//    public boolean isChecked(){
//        return checked;
//    }
}
