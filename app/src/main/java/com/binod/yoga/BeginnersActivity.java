package com.binod.yoga;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.binod.yoga.adaptor.BeginnersAdaptor;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class BeginnersActivity extends AppCompatActivity implements RecycleViewClickInterface{

    private static final String TAG = "oi";
    RecyclerView recycleViewBeginners;
    List<String> titleEnglish=new ArrayList<>();
    List<String> titleSanskrit=new ArrayList<>();
    MaterialButton button;

    private int[] imageName={R.drawable.mountainpose,R.drawable.chairpose,R.drawable.downdogonchair,R.drawable.downwardfacingdog,R.drawable.worriorsecondwala,R.drawable.trianglepose,
    R.drawable.treepose,R.drawable.bridgepose,R.drawable.boundankle,R.drawable.seatedforwardfold,R.drawable.corpse};
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
        spaceItemDecoration spaceItemDecoration=new spaceItemDecoration(20);
        recycleViewBeginners.addItemDecoration(spaceItemDecoration);
        button=findViewById(R.id.backbutton);
        button.setBackgroundColor(getResources().getColor(R.color.intermediate));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        titleEnglish.add("Mountain pose");
        titleSanskrit.add("Tadasana");

        titleEnglish.add("Chair pose");
        titleSanskrit.add("Utkatasana");

        titleEnglish.add("Down Dog on a chair");
        titleSanskrit.add("Uttana shishosana");

        titleEnglish.add("Downward-Facing Dog");
        titleSanskrit.add("Adho Mukha Svanasana");

        titleEnglish.add("Warrior II");
        titleSanskrit.add("Virabhadrasana II");

        titleEnglish.add("Triangle Pose");
        titleSanskrit.add("Trikonasana");

        titleEnglish.add("Tree Pose");
        titleSanskrit.add("Vrksasana");


        titleEnglish.add("Bridge Pose");
        titleSanskrit.add("Setu Bandha Sarvangasana");

        titleEnglish.add("Bound Ankle Pose");
        titleSanskrit.add("Baddha Konasana");

        titleEnglish.add("Seated Forward Fold");
        titleSanskrit.add("Paschimottanasana");

        titleEnglish.add("Corpse Pose");
        titleSanskrit.add(" Savasana");

        recycleViewBeginners.setAdapter(new BeginnersAdaptor(titleEnglish,titleSanskrit,imageName,this));



    }

    @Override
    public void onItemClick(int position) {

        Log.d(TAG,"Clicked"+position);
        final Intent intent;
//        Intent intent=new Intent(BeginnersActivity.this,GridActivity.class);
//        intent.putExtra("selected_Day",day.get(position));
//        startActivity(intent);

        switch (position)
        {
            case 0:
                intent=new Intent(this,MountainPose.class);
                startActivity(intent);
                break;

            case 1:
                intent=new Intent(this,ChairPose.class);
                startActivity(intent);
                break;

            case 2:
                intent=new Intent(this,DownDogOnChair.class);
                startActivity(intent);
                break;

            case 3:
                intent=new Intent(this,DownwardFacingDog.class);
                startActivity(intent);
                break;

            case 4:
                intent=new Intent(this,WarriorSecond.class);
                startActivity(intent);
                break;

            case 5:
                intent=new Intent(this,TrianglePose.class);
                startActivity(intent);
                break;

            case 6:
                intent=new Intent(this,TreePose.class);
                startActivity(intent);
                break;

            case 7:
                intent=new Intent(this,BridgePose.class);
                startActivity(intent);
                break;

            case 8:
                intent=new Intent(this,BoundAnkle.class);
                startActivity(intent);
                break;

            case 9:
                intent=new Intent(this,SeatedForwardFold.class);
                startActivity(intent);
                break;

            case 10:
                intent=new Intent(this,Corpse.class);
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
