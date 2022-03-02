package com.arun.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton radioButton;
    CheckBox read,write,run;
    String remark;
    String result;
    String distrticts[]={"Alappuzha","Ernakulam","Idukki","Kannur","Kasaragod","Kollam","Kottayam","Kozhikode","Malappuram","Palakkad","Pathanamthitta","Thiruvananthapuram","Thrissur","Wayanad"};
    Spinner dist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

        dist =(Spinner)findViewById(R.id.spinner);
        ArrayAdapter adapter=new ArrayAdapter(getApplicationContext(), android.R.layout.simple_dropdown_item_1line,distrticts);
        dist.setAdapter(adapter);
        dist.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),distrticts[i],Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        read = (CheckBox) findViewById(R.id.reading);
        write = (CheckBox) findViewById(R.id.writing);
        run = (CheckBox) findViewById(R.id.running);

        Button btn = (Button)findViewById(R.id.btnSubmit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText eu =(EditText)findViewById(R.id.uname);
                EditText pu =(EditText)findViewById(R.id.pwd);

                String user =eu.getText().toString();
                String  pwd =pu.getText().toString();

                Intent i = new Intent(getApplicationContext(),LoginNew.class);
                i.putExtra("username",user);
                i.putExtra("password",pwd);
                startActivity(i);


                //for toast checkbox after submit btn
                result = "Selected Hobbies";
                if (read.isChecked()) {
                    result += "\nReading";
                }
                if (write.isChecked()) {
                    result += "\nWritting";
                }
                if (run.isChecked()) {
                    result += "\nRunning";
                }
                if (result != "Selected Hobbies") {
                    radioButton = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
                    //radio btn text to radioButton
                    remark = radioButton.getText().toString();

                    Toast.makeText(getApplicationContext(),"you gender is "+remark+"\n"+result, Toast.LENGTH_LONG).show();
                }
            }
        });

        radioGroup =(RadioGroup) findViewById(R.id.radioGroup1);
    }

    //to print toast when click check box
    public void onCheckboxClicked(View view) {

      boolean checked =((CheckBox) view).isChecked();
      String str="a";

      switch (view.getId()){
          case R.id.reading:
              str = checked?"Reading Selected":"Reading Deselected";
              break;
          case R.id.writing:
              str = checked?"Writing Selected":"Writing Deselected";
              break;
          case R.id.running:
              str = checked?"Running Selected":"Running Deselected";
              break;
      }
     // Toast.makeText(getApplicationContext(),str,Toast.LENGTH_LONG).show();
    }

public void Submit(View view) {
    }
}