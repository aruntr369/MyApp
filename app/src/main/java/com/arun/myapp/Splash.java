package com.arun.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

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
        },2000);
    }
}