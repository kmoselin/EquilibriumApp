package com.example.trina.equilibriumapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class AddGoalActivity extends AppCompatActivity {
    EditText goalText;
    int mPriority;
    MyDB db;
    EditText goal;
    EditText typeOfGoal;
    //EditText completion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_goal);
        db = new MyDB(this, "Goals", null, 1);

        // Initialize to highest mPriority by default (mPriority = 1)
        ((RadioButton) findViewById(R.id.radButton1)).setChecked(true);
        mPriority = 1;
        goal = findViewById(R.id.goalDescription);
        typeOfGoal = findViewById(R.id.typeInput);


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
        String goalInput = goal.getText().toString();
        String pr;

        if(mPriority == 1){
            pr = "High";
        }
        else if(mPriority == 2){
            pr = "Medium";
        }

        else if(mPriority == 3){
            pr = "Low";
        }
        else{
            pr = "Not specified";
        }
        String type = typeOfGoal.getText().toString();
        String Completed = "Not completed";
        if(goalInput.matches("")){
            Toast.makeText(this, "Enter your goal!", Toast.LENGTH_SHORT).show();
        }

        if(type.matches("")){
            Toast.makeText(this, "Enter type of goal", Toast.LENGTH_SHORT).show();
        }
        if(pr.matches("Not Specified")){
            Toast.makeText(this, "Specify priority", Toast.LENGTH_SHORT).show();
        }

        else{
            db.insertGoal(goalInput, type, pr, Completed);
            Toast.makeText(this, "Goal added!", Toast.LENGTH_SHORT).show();
            finish();
        }





        //add sqlite stuff here to input into database (content values, cv.put...)


        // Finish activity (this returns back to MainActivity)
        //finish();
        //Intent intent = new Intent(this, ViewGoalsActivity.class);
       // startActivity(intent);
    }
}
