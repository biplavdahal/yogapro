package com.binod.yoga;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;

import com.google.android.material.button.MaterialButton;

import pl.droidsonroids.gif.GifImageView;

public class PlankPose extends AppCompatActivity {

    TextView pose,howToDoAns,benefitsAns;
    GifImageView image;
    ConstraintLayout constraintLayout;
    NestedScrollView color;
    MaterialButton button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mountain_pose);

        pose=findViewById(R.id.mountainPose);
        benefitsAns=findViewById(R.id.mountainPoseBenefitsAns);
        howToDoAns=findViewById(R.id.mountainposeText);
        image=findViewById(R.id.mountainimage);
        constraintLayout=findViewById(R.id.layoutContainer);
        color=findViewById(R.id.nestedScrollView);
        button=findViewById(R.id.startButton);

        image.setImageResource(R.drawable.plankpose);
        pose.setText("Plank pose");
        howToDoAns.setText(getString(R.string.plankpose));
        benefitsAns.setText(getString(R.string.plankposebenefits));
        constraintLayout.setBackgroundColor(getResources().getColor(R.color.white));
        color.setBackgroundColor(getResources().getColor(R.color.white));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PlankPose.this,TimerActivity.class);
                startActivity(intent);
            }
        });



        initializeButton();
    }

    public void initializeButton()
    {
        MaterialButton button;
        button=findViewById(R.id.backbuttonofYogaday);

        button.setBackgroundColor(getResources().getColor(R.color.white));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}


