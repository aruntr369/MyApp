package com.arun.myapp.cardviewex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.arun.myapp.R;

public class SecondActivityCard extends AppCompatActivity {

    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_card);

        iv = (ImageView) findViewById(R.id.ivCard2); // init a ImageView
        Intent intent = getIntent(); // get Intent which we set from Previous Activity
        iv.setImageResource(intent.getIntExtra("image", 0)); // get image from Intent and set it in ImageView

    }
}