package com.arun.myapp.webserviceRetrofit;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.arun.myapp.R;

import java.util.ArrayList;

public class CustomCountryList extends BaseAdapter {
    private Activity context;
    ArrayList<Country> countries;
    public CustomCountryList(Activity activity, ArrayList<Country> countries) {
        this.context = activity;
        this.countries = countries;
    }

    public static class ViewHolder {
        TextView textViewId;
        TextView textViewCountry;
    }

    @Override
    public int getCount() {
        if(countries.size()<=0)
            return 1;
        return countries.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row = view;

        LayoutInflater inflater = context.getLayoutInflater();
        ViewHolder vh;
        if (view==null){
            vh = new ViewHolder();
            row = inflater.inflate(R.layout.row_item_retrofit,null,true);
            vh.textViewId = (TextView) row.findViewById(R.id.textViewId);
            vh.textViewCountry = (TextView) row.findViewById(R.id.textViewCountry);
            // store the holder with the view.
            row.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }
        vh.textViewCountry.setText(countries.get(i).getCountryName());
        vh.textViewId.setText(""+countries.get(i).getId());

        return  row;


    }
}
