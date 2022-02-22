package com.arun.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private static final String TAG = "login";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btn =(Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: button clicked");
                Toast.makeText(Login.this,"Cliked BTN",Toast.LENGTH_SHORT).show();
                
            }
        });
        Button btn11 =(Button)  findViewById(R.id.btn1);
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(Login.this,BtnBack.class);
                startActivity(in);
            }
        });
    }
}