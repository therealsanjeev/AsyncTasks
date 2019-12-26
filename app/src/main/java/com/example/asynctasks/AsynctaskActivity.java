package com.example.asynctasks;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class AsynctaskActivity extends AppCompatActivity {
    Button btnStart;
    TextView tvCounter;
    Button btnRandom;
    public static final String TAG="Async";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asynctask);

        btnStart=findViewById(R.id.btnStart);
        tvCounter=findViewById(R.id.tvCounter);
        btnRandom=findViewById(R.id.btnRandom);

        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random=new Random();
                tvCounter.setText(String.valueOf(random.nextInt(100)));
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CountTask cTask = new CountTask();
                cTask.execute(5);
            }
        });

    }

    class CountTask extends AsyncTask<Integer,Integer,Void>{

        @Override
        protected Void doInBackground(Integer... integers){
            Log.d(TAG,"doInBackground: started");
            int n= integers[0];
            waitNSec(n);
            Log.d(TAG,"doInBackground: ended");
            return null;
        }
    }
    void wait1Sec(){
        long start=System.currentTimeMillis();
        while (System.currentTimeMillis()< start+1000);

    }
    void waitNSec(int n){
        for(int i=0;i<n;i++){
            wait1Sec();
        }
    }

}
