package com.arun.myapp.webserviceRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CountryArrayAPI {

    @GET("/arpitmandliya/AndroidRestJSONExample/master/countries.json")
    public Call<List<Country>> getCountries();

}
