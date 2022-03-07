package com.arun.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProgressBarEx extends AppCompatActivity {

    int progress=0;
    ProgressBar pro;
    Button btn;
    TextView tvperr;
    String tvpp="a";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar_ex);

        tvperr=(TextView)findViewById(R.id.tvper);

        pro =(ProgressBar) findViewById(R.id.progressBar2);
        btn =(Button) findViewById(R.id.btnPro);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setProgressvalue(progress);
            }
        });
    }

    private void setProgressvalue(int progress){
       pro.setProgress(progress);
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
               // tvper.setText(progress+"");
              // tvpp =String.valueOf(progress);
                //tvperr.setText(tvpp);


                setProgressvalue(progress+10);
            }
        });
        thread.start();
    }
}