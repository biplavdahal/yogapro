package com.binod.yoga.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.binod.yoga.Adaptor;
import com.binod.yoga.AdvancedActivity;
import com.binod.yoga.BeginnersActivity;
import com.binod.yoga.IntermediateActivity;
import com.binod.yoga.Modelling;
import com.binod.yoga.R;
import com.binod.yoga.RecycleViewClickInterface;
import com.binod.yoga.spaceItemDecoration;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MyHomeFragment extends Fragment implements RecycleViewClickInterface {


    private static final String TAG = "MyHomeFragment";
    BottomNavigationView bottomNavigationView;
    RecyclerView recyclerView;
    CardView cardView,advertisement;
    Adaptor adaptor;
    List<Modelling> yogaPlanList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home_my,null);
        Log.d(TAG, "onCreateView: called");

        recyclerView=view.findViewById(R.id.recycleView);
        cardView=view.findViewById(R.id.mainCardView);
       // adView=view.findViewById(R.id.adView);
       // advertisement=view.findViewById(R.id.advertisement);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        spaceItemDecoration spaceItemDecoration=new spaceItemDecoration(40);
        recyclerView.addItemDecoration(spaceItemDecoration);
        recyclerView.setAdapter(new Adaptor(initializeData(),this));

     //   checkInternetConnection();

        //MobileAds.initialize(getContext(), "ca-app-pub-3940256099942544~3347511713");
//        MobileAds.initialize(getActivity(), new OnInitializationCompleteListener() {
//            @Override
//            public void onInitializationComplete(InitializationStatus initializationStatus) {
//
//            }
//        });
//        mAView = (AdView) view.findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAView.loadAd(adRequest);



        return view;

    }

    private List<Modelling> initializeData() {

        yogaPlanList=new ArrayList<>();
        yogaPlanList.add(new Modelling(1,"Beginners Yoga","Free",R.drawable.one));
        yogaPlanList.add(new Modelling(2,"Intermediate Yoga","Free",R.drawable.intermediate));
        yogaPlanList.add(new Modelling(3,"Advanced Yoga","Free",R.drawable.two));

        return yogaPlanList;
    }

//    public void checkInternetConnection() {
//        ConnectivityManager connMgr = (ConnectivityManager) getActivity().getApplicationContext()
//                .getSystemService(Context.CONNECTIVITY_SERVICE);
//
//        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
//        if (null != networkInfo) {
//
//            if (networkInfo.getType() ==  connMgr.TYPE_WIFI) {
//
//                advertisement.setVisibility(View.VISIBLE);
//            }  if (networkInfo.getType() ==  connMgr.TYPE_MOBILE) {
//                advertisement.setVisibility(View.VISIBLE);
//            }
//        }
//        else
//        {
//            advertisement.setVisibility(View.GONE);
//        }
//    }


    @Override
    public void onItemClick(int position) {

        Log.d(TAG, "onItemClick: clicked" +position);
        yogaPlanList.get(position);

        if (position==0)
        {
            //getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame,new MyHomeFragment()).commit();
            Intent intent=new Intent(getContext(), BeginnersActivity.class);
            startActivity(intent);
        }
        else if (position==1)
        {
            Intent intent=new Intent(getContext(), IntermediateActivity.class);
            startActivity(intent);
        }
        else
        {
            Intent intent=new Intent(getContext(), AdvancedActivity.class);
            startActivity(intent);
        }


    }

}

