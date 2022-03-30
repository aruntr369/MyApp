package com.arun.myapp.storage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.arun.myapp.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExStorageActivity extends AppCompatActivity {

    EditText uname, pwd;
    Button saveBtn;
    FileOutputStream fstream;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_storage);

        uname = (EditText)findViewById(R.id.txtName);
        pwd = (EditText)findViewById(R.id.txtPwd);
        saveBtn = (Button)findViewById(R.id.btnSave);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = uname.getText().toString()+"\n";
                String password = pwd.getText().toString();
                try {
                    ActivityCompat.requestPermissions(ExStorageActivity.this, new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE},23);
                    File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
                    File file = new File(folder,"user_details");
                    fstream = new FileOutputStream(file);
                    fstream.write(username.getBytes());
                    fstream.write(password.getBytes());
                    fstream.close();
                    Toast.makeText(getApplicationContext(), "Details Saved in "+file.getAbsolutePath(),Toast.LENGTH_SHORT).show();

                    intent =new Intent(ExStorageActivity.this,ExDetailsActivity.class);
                    startActivity(intent);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}