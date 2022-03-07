package com.arun.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageClicked extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_clicked);

        ImageView image =(ImageView) findViewById(R.id.imageView3);
        //retrieve the resource clicked and set to the imageView.
        //Intent imjFromGrid=getIntent();
        int imageRes = getIntent().getIntExtra("IMAGE_RES",0);
        image.setImageResource(imageRes);
    }
}