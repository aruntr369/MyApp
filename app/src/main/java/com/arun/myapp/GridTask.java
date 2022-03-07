package com.arun.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class GridTask extends AppCompatActivity {

    String countries[]={"India","Australia","China","USA"};
    int conImg[]={R.drawable.india,R.drawable.australia,R.drawable.china,R.drawable.usa};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_task);

        GridView con =(GridView) findViewById(R.id.gridtask);

        CusConGrid i = new CusConGrid(getApplicationContext(),countries,conImg);
        con.setAdapter(i);
        con.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //get image resource based on adapter click position.
                int imageRes = conImg[i];

                //then pass it with the intent.
                Intent intent = new Intent(getApplicationContext(),ImageClicked.class);
                intent.putExtra("IMAGE_RES", imageRes);
                startActivity(intent);

            }
        });
    }
}