package com.binod.yoga;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;

import com.google.android.material.button.MaterialButton;

import pl.droidsonroids.gif.GifImageView;

public class FourLimbedStaff extends AppCompatActivity {

    TextView pose,howToDoAns,benefitsAns;
    GifImageView image;
    ConstraintLayout constraintLayout;
    NestedScrollView color;



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

        image.setImageResource(R.drawable.fourlimbedstaffpose);
        pose.setText("Four limbed staff");
        howToDoAns.setText(getString(R.string.fourlimbedstaff));
        benefitsAns.setText(getString(R.string.fourlimbedstaffbenefits));
        constraintLayout.setBackgroundColor(getResources().getColor(R.color.white));
        color.setBackgroundColor(getResources().getColor(R.color.white));



        initializeButton();
    }

    public void initializeButton()
    {
        MaterialButton button;
        button=findViewById(R.id.backbuttonofYogaday);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}

