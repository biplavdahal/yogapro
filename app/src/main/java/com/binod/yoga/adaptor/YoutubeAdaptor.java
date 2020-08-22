package com.binod.yoga.adaptor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.binod.yoga.FullScreenVideo;
import com.binod.yoga.R;
import com.binod.yoga.modelling.VideoModelling;

import java.util.ArrayList;

public class YoutubeAdaptor extends RecyclerView.Adapter<YoutubeAdaptor.YoutubeViewHolder> {

    ArrayList<VideoModelling> arrayList;
    Context context;

    public YoutubeAdaptor(ArrayList<VideoModelling> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public YoutubeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.video_row,parent,false);
        return new YoutubeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull YoutubeViewHolder holder, int position) {

        final VideoModelling current=arrayList.get(position);
        holder.webView.loadUrl(current.getLink());
        holder.fullscreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(context, FullScreenVideo.class);
                i.putExtra("link",current.getLink());
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class YoutubeViewHolder extends RecyclerView.ViewHolder {

        WebView webView;
        Button fullscreen;
        @SuppressLint("SetJavaScriptEnabled")
        public YoutubeViewHolder(@NonNull View itemView) {
            super(itemView);

            webView=itemView.findViewById(R.id.youtubeVideo);
            fullscreen=itemView.findViewById(R.id.fullscreen);

            webView.setWebViewClient(new WebViewClient());
            webView.setWebChromeClient(new WebChromeClient());
            webView.getSettings().setJavaScriptEnabled(true);
        }
    }
}
