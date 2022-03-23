package com.arun.myapp.recyclerviewex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.arun.myapp.R;

import java.util.ArrayList;
import java.util.Arrays;

import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

public class MainActivityRecycler extends AppCompatActivity {

    ArrayList<Integer> carimj =new ArrayList<>(Arrays.asList(R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4
            ,R.drawable.a5,R.drawable.a6,R.drawable.a7,R.drawable.a8,R.drawable.a9,R.drawable.a10,R.drawable.a11
            ,R.drawable.a12,R.drawable.a13,R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4
            ,R.drawable.a5,R.drawable.a6,R.drawable.a7,R.drawable.a8,R.drawable.a9,R.drawable.a10,R.drawable.a11
            ,R.drawable.a12,R.drawable.a13));
    ArrayList<String> carname =new ArrayList<>(Arrays.asList("car1","car2","car3","car4","car5","car6","car7","car8" ,
            "car9","car10","car11","car12","car13","car1","car2","car3","car4","car5","car6","car7","car8" ,
            "car9","car10","car11","car12","car13"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recycler);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.reCyView);
        //Grid Layout
        //GridLayoutManager gridLayoutManager =new GridLayoutManager(getApplicationContext(),3, GridLayoutManager.HORIZONTAL,false);
        //recyclerView.setLayoutManager(gridLayoutManager);

        //StagedGrid layout
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        //LInear Layout
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        //recyclerView.setLayoutManager(linearLayoutManager);

        //decorater
        //RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        //recyclerView.addItemDecoration(itemDecoration);

        //set animation
        recyclerView.setItemAnimator(new SlideInUpAnimator());

        CustomAdapterRecycleV cusadp =new CustomAdapterRecycleV(MainActivityRecycler.this,carname,carimj);
        recyclerView.setAdapter(cusadp);
    }
}