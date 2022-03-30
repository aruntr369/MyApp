package com.arun.myapp.storage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.TextView;

import com.arun.myapp.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_details);

        TextView result = (TextView)findViewById(R.id.resultView);
        Button back = (Button)findViewById(R.id.btnBack);
        try {
            File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
            File file = new File(folder,"user_details");
            FileInputStream fstream = new FileInputStream(file);
            StringBuffer stringBuffer = new StringBuffer();
            int i;
            while ((i = fstream.read())!= -1){
                stringBuffer.append((char)i);
            }
            fstream.close();
            String details[] = stringBuffer.toString().split("\n");
            result.setText("Name: "+ details[0]+"\nPassword: "+details[1]);



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        back.setOnClickListener(view -> finish());
    }
}