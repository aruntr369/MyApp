package com.arun.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.arun.myapp.asyncccc.AsyncEx;
import com.arun.myapp.cardviewex.CardRecycle;
import com.arun.myapp.firebase.LoginWithFirebase;
import com.arun.myapp.json.JsonFromUrl;
import com.arun.myapp.notificationss.BatteryBoardCast;
import com.arun.myapp.notificationss.RingtuneService;
import com.arun.myapp.recyclerviewex.MainActivityRecycler;
import com.arun.myapp.storage.ExStorageActivity;
import com.arun.myapp.storage.InternalStorageActivity;
import com.arun.myapp.storage.SqliteWithoutOpenHelper;
import com.arun.myapp.storage.sharedPreferences.LoginUsingShared;
import com.arun.myapp.storage.sqlroom.MainActivityRoom;
import com.arun.myapp.webserviceRetrofit.RetrofitMain;
import com.arun.myapp.webserviceVolley.JsonArrayParsingVolley;

import connectionss.BluethoothEx;
import connectionss.PhoneCallEx;
import connectionss.SMSactivity;
import fragmentsEx.FragmentEX;
import fragmentsEx.viewPager2.ActivityViewPager2;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        ImageView iv =(ImageView) findViewById(R.id.imageView);
        Animation faddeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        iv.startAnimation(faddeIn);

        TextView tv =(TextView) findViewById(R.id.starttx);
       /* Animation rotate =AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
        tv.startAnimation(rotate);
        //animation of start
        */

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
              Intent i =new Intent(getApplicationContext(), LoginWithFirebase.class);
              startActivity(i);
              finish();
            }
        },3000);
    }
}