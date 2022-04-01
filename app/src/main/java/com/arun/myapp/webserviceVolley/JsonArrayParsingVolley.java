package com.arun.myapp.webserviceVolley;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.arun.myapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonArrayParsingVolley extends AppCompatActivity {
    private static final String TAG = "JsonArrayParsingVolley";

    private RecyclerView courseRV;
    private CourseAdapter adapter;
    private ArrayList<CourseModalNew> courseModalArrayList;

    String url = "https://jsonkeeper.com/b/WO6S";
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_array_parsing_volley);

        courseRV = findViewById(R.id.idRVCourses);
        progressBar = findViewById(R.id.idPB);

        courseModalArrayList = new ArrayList<>();
        getData();

        buildRecyclerView();

    }

    private void getData() {

        RequestQueue queue = Volley.newRequestQueue(JsonArrayParsingVolley.this);
        Log.d(TAG, "getData: started......");

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                progressBar.setVisibility(View.GONE);
                courseRV.setVisibility(View.VISIBLE);
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject responseObj = response.getJSONObject(i);
                        String courseName = responseObj.getString("courseName");
                        String courseTracks = responseObj.getString("courseTracks");
                        String courseMode = responseObj.getString("courseMode");
                        String courseImageURL = responseObj.getString("courseimg");
                        courseModalArrayList.add(new CourseModalNew(courseName, courseImageURL, courseMode, courseTracks));
                        buildRecyclerView();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(JsonArrayParsingVolley.this, "Fail to get the data..", Toast.LENGTH_SHORT).show();

            }
        });
        queue.add(jsonArrayRequest);

    }

    private void buildRecyclerView() {
        adapter = new CourseAdapter(courseModalArrayList, JsonArrayParsingVolley.this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        courseRV.setHasFixedSize(true);
        courseRV.setLayoutManager(manager);
        courseRV.setAdapter(adapter);

    }
}