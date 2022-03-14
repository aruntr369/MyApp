package com.arun.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

public class ToggleSwitch extends AppCompatActivity {
    Switch sw1, sw2;
    Button btnGet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_switch);

        sw1 = (Switch) findViewById(R.id.switch1);
        sw2 = (Switch) findViewById(R.id.switch2);
        btnGet = (Button) findViewById(R.id.btnSwitch);

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str1, str2;

                if (sw1.isChecked()) {
                    str1 = sw1.getTextOn().toString();
                } else str1 = sw1.getTextOff().toString();
                if (sw2.isChecked()) {
                    str2 = sw2.getTextOn().toString();
                } else str2 = sw2.getTextOff().toString();
                Toast.makeText(ToggleSwitch.this, "sw1 -"+str1+"\nsw2 -"+str2, Toast.LENGTH_SHORT).show();
            }

        });

    }
}