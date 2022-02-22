package com.arun.myapp;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class BtnBack extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.btnback);

        Button btn22 = (Button) findViewById(R.id.btn2);
        btn22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in =new Intent(BtnBack.this,LoginNew.class);
                startActivity(in);
            }
        });
        finish();

    }
}
