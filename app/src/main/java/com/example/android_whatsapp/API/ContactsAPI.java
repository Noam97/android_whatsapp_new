package com.example.android_whatsapp.API;

import android.widget.ArrayAdapter;

import com.example.android_whatsapp.DataModels.DataContact;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ContactsAPI{

    Retrofit retrofit;
    WebServiceApi api;
    String BASE_URL = "http://10.0.2.2:5116/";
    private ArrayAdapter<DataContact> adapter;



    public ContactsAPI() {
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
