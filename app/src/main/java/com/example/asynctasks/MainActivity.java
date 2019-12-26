package com.example.asynctasks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    Button btnBGChange;
    ConstraintLayout clBackground;
    ListView lvText;

    public static final String TAG="Tag";

    final String items[] = new String[]{
            "Apple", "Banana","Strawberry","Pineapple","Guava","Grapes","kiwi"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBGChange=findViewById(R.id.btnBGchange);
        clBackground=findViewById(R.id.tvBackground);
        lvText=findViewById(R.id.lvText);


        ArrayAdapter<String> itemAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                items
        );
        lvText.setAdapter(itemAdapter);



        btnBGChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                waitNSec(10);
//                clBackground.setBackgroundColor(Color.RED);
                Handler handler = new Handler();
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        clBackground.setBackgroundColor(Color.RED);
                    }
                };

                handler.postDelayed(runnable,5000);
            }
        });
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
