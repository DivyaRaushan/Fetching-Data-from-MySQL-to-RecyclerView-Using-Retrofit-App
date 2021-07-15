package com.example.fetchingmysqldatatorecyclerviewusingretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiSet {
    @GET("fetch")
   Call<List<ResponseModel>> getdata();
}
