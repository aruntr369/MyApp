package com.arun.myapp.asyncccc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.arun.myapp.R;

public class AsyncEx extends AppCompatActivity {

    private Button button;
    private EditText time;
    private TextView finalResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_ex);

        time = (EditText) findViewById(R.id.in_time);
        button = (Button) findViewById(R.id.btn_run);
        finalResult = (TextView) findViewById(R.id.tv_result);
        button.setOnClickListener(view -> {
            AsyncTaskRunner runner = new AsyncTaskRunner();
            String sleepTime = time.getText().toString();
            runner.execute(sleepTime);
        });
    }

    private class AsyncTaskRunner extends AsyncTask<String,String,String>{

        private  String resp;
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(AsyncEx.this,
                    "progressDialog",
                    "Wait for "+time.getText().toString()+" seconds");
        }

        @Override
        protected String doInBackground(String... strings) {
            publishProgress("Sleeping..");
            try {
                int time = Integer.parseInt(strings[0])*1000;
                Thread.sleep(time);
                resp = "Slept for "+ strings[0] + " seconds";
            } catch (InterruptedException e) {
                e.printStackTrace();
                resp = e.getMessage();
            } catch (Exception e){
                e.printStackTrace();
                resp = e.getMessage();
            }
            return resp;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            finalResult.setText(values[0]);//get value "sleeping..."

        }

        @Override
        protected void onPostExecute(String s) {
            progressDialog.dismiss();
            finalResult.setText(s);//set value "selpt for --- seconds"
        }
    }
}