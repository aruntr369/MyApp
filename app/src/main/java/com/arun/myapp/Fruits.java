package com.arun.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class Fruits extends AppCompatActivity {
    String fruits[]={"Mango","Orange","Apple","Banana","Pineapple","Grapes"};
    int fruitsimg[]={R.drawable.mangoicon,R.drawable.orangeicon,R.drawable.appleicon,R.drawable.bananasicon,R.drawable.pineappleicon,R.drawable.grapesicon};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits);

        ListView fruitlist =(ListView) findViewById(R.id.fruitsList);

        CustomFruits customFruits =new CustomFruits(getApplicationContext(),fruits,fruitsimg);
        fruitlist.setAdapter(customFruits);
        fruitlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), fruits[i]+" clicked", Toast.LENGTH_SHORT).show();
            }
        });

        Spinner fruitspin =(Spinner) findViewById(R.id.spinnerFruits);
        fruitspin.setAdapter(customFruits);
        fruitspin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), fruits[i]+" Selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
}