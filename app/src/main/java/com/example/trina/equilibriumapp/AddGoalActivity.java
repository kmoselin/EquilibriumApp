package com.example.trina.equilibriumapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class AddGoalActivity extends AppCompatActivity {
    EditText goalText;
    int mPriority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_goal);

        // Initialize to highest mPriority by default (mPriority = 1)
        ((RadioButton) findViewById(R.id.radButton1)).setChecked(true);
        mPriority = 1;
        goalText = findViewById(R.id.goalDescription);
    }

    public void onPrioritySelected(View view) {
        if (((RadioButton) findViewById(R.id.radButton1)).isChecked()) {
            mPriority = 1;
        } else if (((RadioButton) findViewById(R.id.radButton2)).isChecked()) {
            mPriority = 2;
        } else if (((RadioButton) findViewById(R.id.radButton3)).isChecked()) {
            mPriority = 3;
        }
    }

    public void onClickAddGoal(View view) {
        String goalInput = goalText.getText().toString();
        if(goalInput.length() == 0){
            return;
        }
        //add sqlite stuff here to input into database (content values, cv.put...)


        // Finish activity (this returns back to MainActivity)
        //finish();
        Intent intent = new Intent(this, ViewGoalsActivity.class);
        startActivity(intent);
    }
}
