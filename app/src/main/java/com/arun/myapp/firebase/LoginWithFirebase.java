package com.arun.myapp.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.arun.myapp.R;

public class LoginWithFirebase extends AppCompatActivity {

    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_with_firebase);

        btnSignUp = (Button) findViewById(R.id.btnSignUpLF);
        btnSignUp.setOnClickListener(view -> startActivity(new Intent(LoginWithFirebase.this,RegisterWithFirebase.class)));



    }
}