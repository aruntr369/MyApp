package com.arun.myapp.notificationss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.arun.myapp.R;

public class RingtuneService extends AppCompatActivity implements View.OnClickListener{

    private Button start, stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ringtune_service);

        start = (Button) findViewById(R.id.startButton);
        stop = (Button) findViewById(R.id.stopButton);

        start.setOnClickListener(this);
        stop.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        if(view == start){
            startService(new Intent(this, ServiceRingtune.class));
        }

        else if (view == stop){
            stopService(new Intent(this,ServiceRingtune.class));
        }

    }
}