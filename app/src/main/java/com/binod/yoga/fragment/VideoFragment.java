package com.binod.yoga.fragment;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.binod.yoga.R;
import com.binod.yoga.adaptor.YoutubeAdaptor;
import com.binod.yoga.modelling.VideoModelling;

import java.util.ArrayList;

public class VideoFragment extends Fragment {
    RecyclerView videorecycleView;
    ArrayList<VideoModelling> arrayList;
    VideoModelling videoModelling;
    private Toolbar mtoolbar;
    //Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_video,null);

        videorecycleView=view.findViewById(R.id.videoRecycleView);
        videorecycleView.setHasFixedSize(true);
        videorecycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        arrayList=new ArrayList<VideoModelling>();

        VideoModelling videoModelling=new VideoModelling("https://www.youtube.com/watch?v=v7AYKMP6rOE&t=126s");
        arrayList.add(videoModelling);
        videoModelling=new VideoModelling("https://www.youtube.com/watch?v=s2NQhpFGIOg&t=21s");
        arrayList.add(videoModelling);
        videoModelling=new VideoModelling("https://www.youtube.com/watch?v=Z6jRKThDCBU");
        arrayList.add(videoModelling);
        videoModelling=new VideoModelling("https://www.youtube.com/watch?v=CiaD3jP0YhA&t=105s");
        arrayList.add(videoModelling);
        videoModelling=new VideoModelling("https://www.youtube.com/watch?v=_ckvBL-erGU");
        arrayList.add(videoModelling);
        videoModelling=new VideoModelling("https://www.youtube.com/watch?v=6LeKFE_aB4I&t=41s");
        arrayList.add(videoModelling);
        videoModelling=new VideoModelling("https://www.youtube.com/watch?v=5lF70cw7vGA");
        arrayList.add(videoModelling);


        YoutubeAdaptor youtubeAdaptor=new YoutubeAdaptor(arrayList,getActivity().getApplicationContext());
        videorecycleView.setAdapter(youtubeAdaptor);
        checkInternetConnection();
        return view;
    }

    private void checkInternetConnection() {
        ConnectivityManager connMgr = (ConnectivityManager) getActivity()
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (null != networkInfo) {

            if (networkInfo.getType() ==  connMgr.TYPE_WIFI) {


                Toast.makeText(getContext(),"Online",Toast.LENGTH_SHORT).show();

            }  if (networkInfo.getType() ==  connMgr.TYPE_MOBILE) {

                Toast.makeText(getContext(),"Online",Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            //advertisement.setVisibility(View.GONE);
            Toast.makeText(getContext(),"Internet not connected !!\nVideo unavailable ",Toast.LENGTH_LONG).show();
        }

   }



}
