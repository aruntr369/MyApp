package com.arun.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginNew extends AppCompatActivity {

    EditText username , password;
    String un;
    String pw;
    Button cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginnew);

        username =(EditText) findViewById(R.id.userName);
        password =(EditText) findViewById(R.id.passWord);
        cancel =(Button) findViewById(R.id.btnCancel);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            finish();
            }
        });


        Intent intentfromreg = getIntent();
        un = intentfromreg.getStringExtra("username");
        pw = intentfromreg.getStringExtra("password");

        username.setText(un);
        password.setText(pw);

        Button toregi =(Button) findViewById(R.id.infobtn);
        toregi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aa =new Intent(getApplicationContext(),Registration.class);
                startActivity(aa);
            }
        });

    }



    public void click_to_login(View view) {
        //typing values get stored in uname & paswd
        String uname =username.getText().toString();
        String paswd =password.getText().toString();

        if(uname.equals(un) && paswd.equals(pw)){
            Intent i =new Intent(getApplicationContext(),HomePage.class);
            startActivity(i);
            finish();
        }
        else {
            Toast.makeText(getApplicationContext(), "user name or password incorrect", Toast.LENGTH_LONG).show();
        }
    }

}