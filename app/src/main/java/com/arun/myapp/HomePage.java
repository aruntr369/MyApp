package com.arun.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        EditText url = (EditText) findViewById(R.id.urll);
        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            String data= url.getText().toString();
            @Override
            public void onClick(View view) {
                Intent obj =new Intent(Intent.ACTION_VIEW,Uri.parse("https://www."+data+".com"));

                startActivity(obj);
            }
        });



    }
}