package com.arun.myapp.webserviceRetrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.arun.myapp.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitMain extends AppCompatActivity {

    private Button btnSubmit;
    Activity activity;
    ArrayList<Country> countries = new ArrayList<>();
    private ProgressDialog progressDialog;
    ListView listView;

    public static final String BASE_URL = "https://cdn.rawgit.com";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_main);
        activity = this;
        btnSubmit = (Button) findViewById(R.id.btnSubmitRetro);
        listView = (ListView) findViewById(R.id.lvRetrofit);

        btnSubmit.setOnClickListener(view -> {
            countries.clear();

            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Fetching country data");
            progressDialog.setCancelable(false);
            progressDialog.show();
            //Call WebService
            getWebServiceResponseData();
        });
    }

    protected Void getWebServiceResponseData(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CountryArrayAPI api = retrofit.create(CountryArrayAPI.class);
        Call<List<Country>> call = api.getCountries();

        call.enqueue((new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                try {
                    countries =(ArrayList)response.body();
                    if (progressDialog.isShowing())
                        progressDialog.dismiss();
                    CustomCountryList customCountryList = new CustomCountryList(activity, countries);
                    listView.setAdapter(customCountryList);

                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            Toast.makeText(RetrofitMain.this, "You Selected "+countries.get(i).getCountryName()+ " as Country", Toast.LENGTH_SHORT).show();
                        }
                    });
                }catch (Exception e){
                    Log.d("onResponse", "There is an error");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {

            }
        }));


        return null;
    }


}