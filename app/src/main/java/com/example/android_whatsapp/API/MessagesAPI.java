package com.example.android_whatsapp.API;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MessagesAPI {
    Retrofit retrofit;
    WebServiceApi api;


    public MessagesAPI(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String BASE_URL = "http://"+ prefs.getString("serverUrl", "") +"/";
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

