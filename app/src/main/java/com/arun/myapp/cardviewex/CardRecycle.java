package com.arun.myapp.cardviewex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.arun.myapp.R;

public class CardRecycle extends AppCompatActivity {

    int carimg[] ={R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4
            ,R.drawable.a5,R.drawable.a6,R.drawable.a7,R.drawable.a8,R.drawable.a9,R.drawable.a10,R.drawable.a11
            ,R.drawable.a12,R.drawable.a13,R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4
            ,R.drawable.a5,R.drawable.a6,R.drawable.a7,R.drawable.a8,R.drawable.a9,R.drawable.a10,R.drawable.a11
            ,R.drawable.a12,R.drawable.a13};
    String carname[] ={"car1","car2","car3","car4","car5","car6","car7","car8" ,
            "car9","car10","car11","car12","car13","car1","car2","car3","car4","car5","car6","car7","car8" ,
            "car9","car10","car11","car12","car13"};

    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_recycle);

        searchView = findViewById(R.id.searchViewCard);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyCard);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        CusRecyceCard cusRecyceCard = new CusRecyceCard(getApplicationContext(),carname,carimg);
        recyclerView.setAdapter(cusRecyceCard);
    }
}