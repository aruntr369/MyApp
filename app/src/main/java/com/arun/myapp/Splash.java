package com.arun.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        ImageView iv =(ImageView) findViewById(R.id.imageView);
        Animation faddeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        iv.startAnimation(faddeIn);

        TextView tv =(TextView) findViewById(R.id.starttx);
        Animation rotate =AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
        tv.startAnimation(rotate);

//        Thread obj = new Thread(){
//            @Override
//            public void run() {
//                try {
//                    sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                Intent i =new Intent(getApplicationContext(),Login.class);
        //can use Splash.this instead of getApplicationContext
//                startActivity(i);
//                finish();
//            }
//        };
//        obj.start();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
              Intent i =new Intent(getApplicationContext(),LoginNew.class);
              startActivity(i);
              finish();
            }
        },5000);
    }
}