package com.binod.yoga;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.binod.yoga.fragment.ExploreFragment;
import com.binod.yoga.fragment.MyHomeFragment;
import com.binod.yoga.fragment.VideoFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity  {

    private Toolbar mainToolbar;
    private BottomNavigationView bottomNavigationView;
    private FrameLayout mainFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainToolbar=findViewById(R.id.mainToolbar);
        mainToolbar.setTitle("Pick Your Plan");
        mainToolbar.setTitleTextColor(getResources().getColor(R.color.black));
        setSupportActionBar(mainToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mainFrame=findViewById(R.id.mainFrame);
        bottomNavigationView=findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.bottomNavigationHome);

        if (savedInstanceState==null)
        {
            loadFragment(new MyHomeFragment());
        }


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment selectedFragment=null;
                switch (item.getItemId())
                {
                    case R.id.bottomNavigationHome:
                        selectedFragment=new MyHomeFragment();
                        mainToolbar.setTitle("Pick Your Plan");
                        break;

                    case R.id.bottomNavigationVideo:
                        selectedFragment=new VideoFragment();
                        mainToolbar.setTitle("Videos");
                        break;

                    case R.id.bottomNavigationExplore:
                        selectedFragment=new ExploreFragment();
                        mainToolbar.setTitle("Explore");
                        break;

                    default:
                        return false;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame,selectedFragment).commit();
                return true;
            }
        });


   }



   private Boolean loadFragment(Fragment fragment)
   {

       if (fragment!=null)
       {
           getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame,fragment).commit();
           return true;
       }

       return false;
   }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId()==android.R.id.home)
        {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onBackPressed() {

        if (bottomNavigationView.getSelectedItemId()==R.id.bottomNavigationHome)
        {


            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setMessage("Aye you sure want to Exit ??")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            MainActivity.super.onBackPressed();
                        }
                    })

                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alertDialog= builder.create();
            alertDialog.show();

        }

        else
        {
            bottomNavigationView.setSelectedItemId(R.id.bottomNavigationHome);
        }


    }


}
