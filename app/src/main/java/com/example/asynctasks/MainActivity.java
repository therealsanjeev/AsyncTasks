package com.example.asynctasks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnBGChange;
    ConstraintLayout clBackground;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBGChange=findViewById(R.id.btnBGchange);
        clBackground=findViewById(R.id.tvBackground);

        btnBGChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clBackground.setBackgroundColor(Color.RED);
            }
        });
    }
}
