package com.binod.yoga;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class MountainPose extends AppCompatActivity {

    NestedScrollView color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mountain_pose);

        color=findViewById(R.id.nestedScrollView);
        color.setBackgroundColor(getResources().getColor(R.color.mountainPose));


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
