package com.binod.yoga.adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.binod.yoga.R;
import com.binod.yoga.RecycleViewClickInterface;

import java.util.ArrayList;
import java.util.List;

import pl.droidsonroids.gif.GifImageView;

public class BeginnersAdaptor extends RecyclerView.Adapter<BeginnersAdaptor.Beginners> {

    List<String> titleEnglish=new ArrayList<>();
    List<String> titleSanskrit=new ArrayList<>();
    private int[] imageName;
    private RecycleViewClickInterface BrecycleViewClickInterface;

    public BeginnersAdaptor(List<String> titleEnglish,List<String> titleSanskrit,int[] imageName,RecycleViewClickInterface recycleViewClickInterface) {
        this.titleEnglish=titleEnglish;
        this.titleSanskrit=titleSanskrit;
        this.imageName=imageName;
        this.BrecycleViewClickInterface=recycleViewClickInterface;
    }

    @NonNull
    @Override
    public Beginners onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        return new Beginners(view,BrecycleViewClickInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull Beginners holder, int position) {
        int image_id=imageName[position];
        holder.imageView.setImageResource(image_id);
        holder.english.setText(titleEnglish.get(position));
        holder.sanskrit.setText(titleSanskrit.get(position));
    }

    @Override
    public int getItemCount() {
        return imageName.length;
    }

    public class Beginners extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView english,sanskrit;
        GifImageView imageView;
        //ImageView imageView;
        RecycleViewClickInterface recycleViewClickInterface;
        public Beginners(@NonNull View itemView,RecycleViewClickInterface recycleViewClickInterface) {
            super(itemView);

            english=itemView.findViewById(R.id.englishTitle);
            sanskrit=itemView.findViewById(R.id.sanskritTitle);
            imageView=itemView.findViewById(R.id.yogaimage);
            this.recycleViewClickInterface=recycleViewClickInterface;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            recycleViewClickInterface.onItemClick(getAdapterPosition());

        }
    }

}
