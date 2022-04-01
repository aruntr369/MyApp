package com.arun.myapp.json;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.arun.myapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class JsonFromUrl extends AppCompatActivity {

    private String TAG = JsonFromUrl.class.getSimpleName();

    private ProgressDialog progressDialog;
    private ListView listView;

    // URL to get contacts JSON
    private static String url = "https://api.androidhive.info/contacts/";

    ArrayList<HashMap<String,String>> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_from_url);

        contactList = new ArrayList<>();
        listView = (ListView) findViewById(R.id.list);
        new GetContacts().execute();
    }

    private class GetContacts extends AsyncTask<Void,Void,Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(JsonFromUrl.this);
            progressDialog.setMessage("Please wait....");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            HttpHandler handler = new HttpHandler();

            String jsonStr = handler.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null){
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);
                    JSONArray contacts = jsonObj.getJSONArray("contacts");

                    for (int i = 0; i < contacts.length(); i++){

                        JSONObject c = contacts.getJSONObject(i);

                        String id = c.getString("id");
                        String name = c.getString("name");
                        String email = c.getString("email");
                        String address = c.getString("address");
                        String gender = c.getString("gender");

                        JSONObject phone = c.getJSONObject("phone");

                        String mobile = phone.getString("mobile");
                        String home = phone.getString("home");
                        String office = phone.getString("office");

                        // tmp hash map for single contact
                        HashMap<String,String> contact =new HashMap<>();

                        // adding each child node to HashMap key => value
                        contact.put("id",id);
                        contact.put("name", name);
                        contact.put("email", email);
                        contact.put("mobile", mobile);

                        // adding contact to contact list
                        contactList.add(contact);

                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }else {
                Log.e(TAG, "Couldn't get json from server." );
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            if (progressDialog.isShowing())
                progressDialog.dismiss();

            ListAdapter adapter =new SimpleAdapter(JsonFromUrl.this,contactList,
                    R.layout.list_json_url,
                    new String[]{"name", "email", "mobile"},
                    new int[]{R.id.nameJ,R.id.emailJ,R.id.mobileJ});

            listView.setAdapter(adapter);
        }
    }
}