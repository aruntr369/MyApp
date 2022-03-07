package com.arun.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

public class AutoCompleteEx extends AppCompatActivity {

    String[] Countries={"india","Usa","uk","australia","Italy","africa"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_ex);

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line,Countries);
        AutoCompleteTextView actv =(AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);

        actv.setThreshold(1);
        actv.setAdapter(adapter);

        actv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override           //AdaterView's obj is adapterview
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String name=(String)adapterView.getItemAtPosition(i);

                Toast.makeText(AutoCompleteEx.this, "Selected item "+name, Toast.LENGTH_SHORT).show();

            }
        });



    }
}