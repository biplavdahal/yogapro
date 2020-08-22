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

public class AdvancedActivity extends AppCompatActivity implements RecycleViewClickInterface{

    private static final String TAG = "oi";
    CollapsingToolbarLayout collapsingToolbarLayout;
    ImageView imageView;
    RecyclerView recycleViewBeginners;
    List<String> titleEnglish=new ArrayList<>();
    List<String> titleSanskrit=new ArrayList<>();
    MaterialButton button;
    private int[] imageName={R.drawable.boatpose,R.drawable.crowpose,R.drawable.wheelpose,R.drawable.wallassistedhandstand,R.drawable.wallassistedforearm,R.drawable.headstand,
            R.drawable.shoulderstand};
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


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        collapsingToolbarLayout.setTitle("Advanced Yogasana");
        imageView.setImageResource(R.drawable.advanceee);


        titleEnglish.add("Boat Pose");
        titleSanskrit.add("Navasana");

        titleEnglish.add("Crow pose");
        titleSanskrit.add("Bakasana");

        titleEnglish.add("Wheel pose");
        titleSanskrit.add("Urdhva Dhanurasana");

        titleEnglish.add("Wall-assisted handstand");
        titleSanskrit.add("Adho Mukha Vrksasana");

        titleEnglish.add("Wall-assisted forearm stand");
        titleSanskrit.add("Pincha Mayurasana");

        titleEnglish.add("Headstand");
        titleSanskrit.add("Sirsasana");

        titleEnglish.add("Shoulder stand");
        titleSanskrit.add("Salamba Sarvangasana");


        recycleViewBeginners.setAdapter(new BeginnersAdaptor(titleEnglish,titleSanskrit,imageName,this));



    }

    @Override
    public void onItemClick(int position) {

        Log.d(TAG,"Clicked"+position);
        final Intent intent;

        switch (position)
        {
            case 0:
                intent=new Intent(this,BoatPose.class);
                startActivity(intent);
                break;

            case 1:
                intent=new Intent(this,CrowPose.class);
                startActivity(intent);
                break;

            case 2:
                intent=new Intent(this,Wheelpose.class);
                startActivity(intent);
                break;

            case 3:
                intent=new Intent(this,WallAssistedHandstand.class);
                startActivity(intent);
                break;

            case 4:
                intent=new Intent(this,WallAssistedForeArmStand.class);
                startActivity(intent);
                break;

            case 5:
                intent=new Intent(this,Headstand.class);
                startActivity(intent);
                break;

            case 6:
                intent=new Intent(this,ShoulderStand.class);
                startActivity(intent);
                break;

        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
