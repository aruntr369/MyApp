package com.arun.myapp.storage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.arun.myapp.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class InternalStorageActivity extends AppCompatActivity {

    EditText textmsg;
    static final int READ_BLOCK_SIZE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage);

        textmsg=(EditText)findViewById(R.id.editText1);
    }
    //to write
    public void WriteBtn(View view) {
        try {
            FileOutputStream fileout = openFileOutput("mytextfile.txt",MODE_PRIVATE);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileout);
            outputStreamWriter.write(textmsg.getText().toString());
            outputStreamWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //to read
    public void ReadBtn(View view) {
        try {
            FileInputStream fileIn = openFileInput("mytextfile.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileIn);

            char[] inputBuffer = new char[READ_BLOCK_SIZE];
            String s = "";
            int charRead;

            while ((charRead = inputStreamReader.read(inputBuffer))>0) {
                String readstring =String.copyValueOf(inputBuffer,0,charRead);
                s += readstring;
            }
            inputStreamReader.close();
            textmsg.setText(s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}