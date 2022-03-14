package com.arun.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class TimePickerEx extends AppCompatActivity {
    TimePicker timePicker;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker_ex);

        textView=findViewById(R.id.tvTime);
        timePicker=findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);
        button=findViewById(R.id.btnTime);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hour,minute;
                String am_pm;

                if(Build.VERSION.SDK_INT>=23){
                    hour=timePicker.getHour();
                    minute=timePicker.getMinute();
                }else {
                    hour=timePicker.getCurrentHour();
                    minute=timePicker.getCurrentMinute();
                }
                if(hour > 12) {
                    am_pm = "PM";
                    hour = hour - 12;
                }
                else
                {
                    am_pm="AM";
                }
                textView.setText("Selected Hour: "+ hour +":"+ minute+" "+am_pm);
            }
        });


    }
}