package com.arun.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SearchViewEx extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view_ex);

        ArrayAdapter adapter;

        ListView listView =(ListView) findViewById(R.id.thelist);

        List<String> names = new ArrayList<>();
        names.add("raj");
        names.add("roy");
        names.add("amal");
        names.add("ajith");
        names.add("steve");

        SearchView searchView=(SearchView) findViewById(R.id.sv);

        adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,names);
        listView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(names.contains(query)){
                    adapter.getFilter().filter(query);
                }else {
                    Toast.makeText(SearchViewEx.this, "No match found", Toast.LENGTH_SHORT).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                {
                    adapter.getFilter().filter(newText);
                }
                return false;
            }
        });

    }
}