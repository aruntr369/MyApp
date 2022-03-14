package com.arun.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.TextView;

public class NumberPickerEx extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_picker_ex);

        TextView tv=(TextView) findViewById(R.id.tvNPicker);
        NumberPicker np=(NumberPicker) findViewById(R.id.np);

        tv.setTextColor(Color.parseColor("#e07a5f"));

        np.setMinValue(0);
        np.setMaxValue(15);

        np.setWrapSelectorWheel(false);

        np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldValue, int newValue) {
                tv.setTextColor(Color.parseColor("#9b2226"));
                tv.setText("Selected value :"+newValue);
            }
        });

    }
}