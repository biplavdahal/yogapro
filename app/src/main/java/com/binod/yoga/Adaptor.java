package com.binod.yoga;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class Adaptor extends RecyclerView.Adapter<Adaptor.plansViewHolder> {

    private List<Modelling> yogaPlansList;
    private RecycleViewClickInterface recycleViewClickInterface;

    public Adaptor(List<Modelling> yogaPlansList,RecycleViewClickInterface recycleViewClickInterface) {
        this.yogaPlansList = yogaPlansList;
        this.recycleViewClickInterface=recycleViewClickInterface;
    }

    @NonNull
    @Override
    public plansViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.main_activity_list,parent,false);
        return new plansViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull plansViewHolder holder, int position) {
        Modelling modelling=yogaPlansList.get(position);

        holder.title.setText(yogaPlansList.get(position).getTitle());
        holder.discountType.setText(yogaPlansList.get(position).getDiscountType());
        holder.imageView.setImageResource(yogaPlansList.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return yogaPlansList.size();
    }


    public class plansViewHolder extends RecyclerView.ViewHolder  {

        ImageView imageView;
        TextView title,discountType;

        public plansViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.image);
            title=itemView.findViewById(R.id.title);
            discountType=itemView.findViewById(R.id.discounttype);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recycleViewClickInterface.onItemClick(getAdapterPosition());
                }
            });

        }


    }
}
