package com.example.android_whatsapp.API;

import android.content.Intent;
import android.util.Log;

import com.example.android_whatsapp.DataModels.LoginUser;
import com.example.android_whatsapp.R;
import com.example.android_whatsapp.contacts_list;

import java.io.Console;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UsersAPI{

    Retrofit retrofit;
    WebServiceApi api;
    String BASE_URL = "http://10.0.2.2:5116/";


    public UsersAPI() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(WebServiceApi.class);
    }

    public WebServiceApi getApi() {
        return api;
    }
}
