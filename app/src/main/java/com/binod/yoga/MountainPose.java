package com.binod.yoga;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MountainPose extends  AppCompatActivity {

    NestedScrollView color;
    MaterialButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mountain_pose);

        color=findViewById(R.id.nestedScrollView);
        color.setBackgroundColor(getResources().getColor(R.color.mountainPose));
        button=findViewById(R.id.startButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MountainPose.this,TimerActivity.class);
                startActivity(intent);
            }
        });

        initializeButton();


    }


    public void initializeButton()
    {
        MaterialButton button;
        button=findViewById(R.id.backbuttonofYogaday);
        button.setBackgroundColor(getResources().getColor(R.color.boatpose));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


}
