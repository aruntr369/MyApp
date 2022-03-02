package com.arun.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.zip.Inflater;

public class CustomFruits extends BaseAdapter {
    Context context;
    String fruits[];
    int fruitsimg[];
    LayoutInflater inflater;

    public CustomFruits(Context applicationContext, String[] fruits, int[] fruitsimg) {
        context= applicationContext.getApplicationContext();
        this.fruits=fruits;
        this.fruitsimg=fruitsimg;
    }

    @Override
    public int getCount() {
        return fruits.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        inflater = LayoutInflater.from(context);
        view =inflater.inflate(R.layout.custom_layout,null);
        ImageView image=(ImageView) view.findViewById(R.id.customimage);
        TextView textView=(TextView)  view.findViewById(R.id.customtext);
        image.setImageResource(fruitsimg[i]);
        textView.setText(fruits[i]);
        return view;
    }
}
