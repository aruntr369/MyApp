package com.arun.myapp.storage.sharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.arun.myapp.R;

public class LoginUsingShared extends AppCompatActivity {

    EditText uname, pwd;
    Button loginBtn;
    SharedPreferences pref;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_using_shared);

        uname = (EditText)findViewById(R.id.txtName);
        pwd = (EditText)findViewById(R.id.txtPwd);
        loginBtn = (Button)findViewById(R.id.btnLogin);

        pref = getSharedPreferences("user_details",MODE_PRIVATE);

        intent = new Intent(LoginUsingShared.this,SecondPageShared.class);

        if(pref.contains("username") && pref.contains("password")){
            startActivity(intent);
        }
        loginBtn.setOnClickListener(view -> {
            String username = uname.getText().toString();
            String password = pwd.getText().toString();

            if(username.equals("arun") && password.equals("1234")){

                SharedPreferences.Editor editor = pref.edit();
                editor.putString("username",username);
                editor.putString("password",password);
                editor.commit();

                Toast.makeText(getApplicationContext(), "Login Successful",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
            else
            {
                Toast.makeText(getApplicationContext(),"Credentials are not valid",Toast.LENGTH_SHORT).show();
            }
            });


    }
}