package com.example.fetchingmysqldatatorecyclerviewusingretrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiController
{
    private static final String url="http://192.168.29.74/api/";
    private static ApiController controllerobject;
    private static Retrofit retrofit;

    ApiController(){
        retrofit = new Retrofit.Builder()
                      .baseUrl(url)
                      .addConverterFactory(GsonConverterFactory.create())
                      .build();
    }

    public static synchronized ApiController getInstance()
    {
        if (controllerobject==null)
        {
            controllerobject = new ApiController();
        }
        return controllerobject;
    }
     ApiSet getapi()
     {
         return retrofit.create(ApiSet.class);
     }

}
