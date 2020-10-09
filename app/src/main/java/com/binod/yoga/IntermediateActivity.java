package com.binod.yoga;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.binod.yoga.adaptor.BeginnersAdaptor;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class IntermediateActivity extends AppCompatActivity implements RecycleViewClickInterface{

    private static final String TAG = "oi";
    CollapsingToolbarLayout collapsingToolbarLayout;
    ImageView imageView;
    RecyclerView recycleViewBeginners;
    List<String> titleEnglish=new ArrayList<>();
    List<String> titleSanskrit=new ArrayList<>();
    MaterialButton button;
    private int[] imageName={R.drawable.plankpose,R.drawable.fourlimbedstaffpose,R.drawable.upwardfacingdog,R.drawable.halfmoonpose,R.drawable.warriorfirst,R.drawable.warriorthird,
            R.drawable.intensesidestretch,R.drawable.dolphinpose,R.drawable.bowposegif,R.drawable.camelpose,R.drawable.sideplank,R.drawable.revolvedtrianglepose};
    private Object Tag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginners);



        initialize();
    }

    private void initialize() {
        recycleViewBeginners=(RecyclerView)findViewById(R.id.beginnersRecycleViewBeginners);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,1);
        recycleViewBeginners.setLayoutManager(gridLayoutManager);
        recycleViewBeginners.setHasFixedSize(true);
        spaceItemDecoration spaceItemDecoration=new spaceItemDecoration(40);
        recycleViewBeginners.addItemDecoration(spaceItemDecoration);
        collapsingToolbarLayout=findViewById(R.id.collapsingToolbar);
        imageView=findViewById(R.id.beginnersImageView);
        button=findViewById(R.id.backbutton);
        button.setBackgroundColor(getResources().getColor(R.color.intermediate));


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        collapsingToolbarLayout.setTitle("Intermediate Yogasana");
        imageView.setImageResource(R.drawable.intermediate);



        titleEnglish.add("Plank Pose");
        titleSanskrit.add("Kumbhakasana");

        titleEnglish.add("Four-Limbed Staff Pose");
        titleSanskrit.add("Chaturanga Dandasana");

        titleEnglish.add("Upward-Facing Dog");
        titleSanskrit.add("Urdhva Mukha Svanasana");

        titleEnglish.add("Half Moon ");
        titleSanskrit.add("Ardha Chandrasana");

        titleEnglish.add("Warrior I");
        titleSanskrit.add("Virabhadrasana I");

        titleEnglish.add("Warrior III");
        titleSanskrit.add("Virabhadrasana III");

        titleEnglish.add("Intense side stretch");
        titleSanskrit.add("Parsvottanasana");


        titleEnglish.add("Dolphin Pose");
        titleSanskrit.add("Ardha Pincha Mayurasana");

        titleEnglish.add("Bow Pose");
        titleSanskrit.add("Dhanurasana");

        titleEnglish.add("Camel Pose");
        titleSanskrit.add("Ustrasana");

        titleEnglish.add("Side plank");
        titleSanskrit.add("Vasisthasana");

        titleEnglish.add("Revolved Triangle");
        titleSanskrit.add(" Parivrtta Trikonasana");


        recycleViewBeginners.setAdapter(new BeginnersAdaptor(titleEnglish,titleSanskrit,imageName,this));



    }


    @Override
    public void onItemClick(int position) {

        Log.d(TAG,"Clicked"+position);
        final Intent intent;
        switch (position)
        {
            case 0:
                intent=new Intent(this,PlankPose.class);
                startActivity(intent);
                break;

            case 1:
                intent=new Intent(this,FourLimbedStaff.class);
                startActivity(intent);
                break;

            case 2:
                intent=new Intent(this,UpwardFacingDog.class);
                startActivity(intent);
                break;

            case 3:
                intent=new Intent(this,HalfMoon.class);
                startActivity(intent);
                break;

            case 4:
                intent=new Intent(this,WarriorFirst.class);
                startActivity(intent);
                break;

            case 5:
                intent=new Intent(this,WarriorThird.class);
                startActivity(intent);
                break;

            case 6:
                intent=new Intent(this,IntenseSideStretch.class);
                startActivity(intent);
                break;

            case 7:
                intent=new Intent(this,DolphinPose.class);
                startActivity(intent);
                break;

            case 8:
                intent=new Intent(this,BowPose.class);
                startActivity(intent);
                break;

            case 9:
                intent=new Intent(this,CamelPose.class);
                startActivity(intent);
                break;

            case 10:
                intent=new Intent(this,SidePlank.class);
                startActivity(intent);
                break;

            case 11:
                intent=new Intent(this,RevolvedTriangle.class);
                startActivity(intent);
                break;

        }
        //startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
