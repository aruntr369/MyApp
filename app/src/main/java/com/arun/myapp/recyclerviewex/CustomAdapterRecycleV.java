package com.arun.myapp.recyclerviewex;

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

import java.util.ArrayList;

public class CustomAdapterRecycleV extends RecyclerView.Adapter<CustomAdapterRecycleV.ViewHolderCus> {

    ArrayList<String> carNames;
    ArrayList<Integer> carImages;
    Context context;

    public CustomAdapterRecycleV(MainActivityRecycler mainActivityRecycler, ArrayList<String> carname, ArrayList<Integer> carimj) {
        this.context=mainActivityRecycler;
        this.carImages=carimj;
        this.carNames=carname;

    }

    @NonNull
    @Override
    public CustomAdapterRecycleV.ViewHolderCus onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_adapter_cus,parent,false);
       ViewHolderCus vh = new ViewHolderCus(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapterRecycleV.ViewHolderCus holder, int position) {
        holder.name.setText(carNames.get(position));
        holder.image.setImageResource(carImages.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,SecondActivityRecycle.class);
                intent.putExtra("image",carImages.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return carNames.size();
    }

    public class ViewHolderCus extends RecyclerView.ViewHolder{
        TextView name;
        ImageView image;
        public ViewHolderCus(@NonNull View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.tvRecycle);
            image = (ImageView)itemView.findViewById(R.id.ivRecycle);
        }
    }
}
