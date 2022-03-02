package com.arun.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class GridViewFruits extends AppCompatActivity {

    String fruits[]={"Mango","Orange","Apple","Banana","Pineapple","Grapes"};
    int fruitsimg[]={R.drawable.mangoicon,R.drawable.orangeicon,R.drawable.appleicon,R.drawable.bananasicon,R.drawable.pineappleicon,R.drawable.grapesicon};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_fruits);

        GridView gridFruits =(GridView) findViewById(R.id.gridView);

        CustomFruitsGrid customFruits =new CustomFruitsGrid(getApplicationContext(),fruits,fruitsimg);
        gridFruits.setAdapter(customFruits);

    }
}