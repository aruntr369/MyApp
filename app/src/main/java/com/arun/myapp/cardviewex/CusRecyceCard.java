package com.arun.myapp.cardviewex;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arun.myapp.R;

public class CusRecyceCard extends RecyclerView.Adapter<CusRecyceCard.ViewHolderCuss> {

    String[] carname;
    int[] carimg;
    Context context;
    public CusRecyceCard(Context applicationContext, String[] carname, int[] carimg) {
        this.carimg=carimg;
        this.carname=carname;
        this.context=applicationContext;
    }

    @NonNull
    @Override
    public ViewHolderCuss onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_recycle_ex,parent,false);
        ViewHolderCuss vhh = new ViewHolderCuss(v);
        return vhh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderCuss holder, int position) {
        holder.image.setImageResource(carimg[position]);
        holder.name.setText(carname[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SecondActivityCard.class);
                intent.putExtra("image", carimg[position]);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent); // start Intent
            }
        });

    }

    @Override
    public int getItemCount() {
        return carname.length;
    }

    public class ViewHolderCuss extends RecyclerView.ViewHolder {

        TextView name;
        ImageView image;
        public ViewHolderCuss(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tvCard);
            image = (ImageView) itemView.findViewById(R.id.ivCard);

        }
    }
}
