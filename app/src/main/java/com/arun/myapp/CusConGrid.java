package com.arun.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CusConGrid extends BaseAdapter {

    Context context;
    String countries[];
    int conImg[];
    LayoutInflater inflater;
    public CusConGrid(Context applicationContext, String[] countries, int[] conImg) {
        context=applicationContext.getApplicationContext();
        this.countries=countries;
        this.conImg=conImg;



    }

    @Override
    public int getCount() {
        return countries.length;
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
        view =inflater.inflate(R.layout.grid_countries,null);
        ImageView image=(ImageView) view.findViewById(R.id.imageView2);
        TextView textView=(TextView)  view.findViewById(R.id.tvcon);
        image.setImageResource(conImg[i]);
        textView.setText(countries[i]);
        return view;
    }
}
