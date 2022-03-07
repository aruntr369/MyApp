package com.arun.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

public class SeekBarEx extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar);


        SeekBar sb =(SeekBar) findViewById(R.id.seekBar);
        TextView tv =(TextView)  findViewById(R.id.tvSeekbar);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress=0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                this.progress=i;
                tv.setTextSize(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(SeekBarEx.this, "start at "+progress, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(SeekBarEx.this, "stop at "+progress, Toast.LENGTH_SHORT).show();

            }
        });

    }
}