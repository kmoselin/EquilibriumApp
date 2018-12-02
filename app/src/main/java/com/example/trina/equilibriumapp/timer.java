package com.example.trina.equilibriumapp;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.text.Editable;

public class timer extends AppCompatActivity {
    ProgressBar progressBar;
    int total;
    Button start_timer,stop_timer;
    MyCountDownTimer myCountDownTimer;
    String seconds, minutes, hours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timer);
        start_timer=(Button)findViewById(R.id.button);
        stop_timer=(Button)findViewById(R.id.button2);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);


        start_timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seconds = ((TextView) findViewById(R.id.enterSeconds)).getText().toString();
                if(seconds == null || seconds.trim().equals("")){
                    seconds = "00";
                }
                minutes = ((TextView) findViewById(R.id.enterMinutes)).getText().toString();
                if(minutes == null || minutes.trim().equals("")){
                    minutes = "00";
                }
                hours = ((TextView) findViewById(R.id.enterHours)).getText().toString();
                if(hours == null || hours.trim().equals("")){
                    hours = "00";
                }

                total = Integer.parseInt(seconds) + Integer.parseInt(minutes)*60 + Integer.parseInt(hours)*3600;
                myCountDownTimer = new MyCountDownTimer(total*1000, 1000);
                myCountDownTimer.start();

            }
        });

        stop_timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myCountDownTimer.cancel();

            }
        });

    }

    public class MyCountDownTimer extends CountDownTimer {

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            int progress = (int) (millisUntilFinished/1000);
            int percent = (int)(((float)progress/(float)total)*100);
            Log.d("wtf",Integer.toString(percent));

            progressBar.setProgress(percent);

            int secondsLeft = progress%60;



            int minutesLeft = (progress/60)%60;

            int hoursLeft = (progress/3600);

            TextView viewMinutes = (TextView)findViewById(R.id.viewMinutes);
            TextView viewSeconds = (TextView)findViewById(R.id.viewSeconds);
            TextView viewHours = (TextView)findViewById(R.id.viewHours);
            viewMinutes.setText(Integer.toString(minutesLeft));
            viewSeconds.setText(Integer.toString(secondsLeft));
            viewHours.setText(Integer.toString(hoursLeft));

        }

        @Override
        public void onFinish() {
            finish();
        }
    }
}