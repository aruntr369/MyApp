package com.arun.myapp.recyclerviewex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.arun.myapp.R;

public class SecondActivityRecycle extends AppCompatActivity {

    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_recycle);

        iv =(ImageView) findViewById(R.id.ivSecondReCy);
        Intent intent = getIntent();
        iv.setImageResource(intent.getIntExtra("image",0));
    }
}