package com.example.android_whatsapp.API;

import android.widget.Adapter;
import android.widget.ArrayAdapter;

import com.example.android_whatsapp.DataModels.Contact;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ContactsAPI{

    Retrofit retrofit;
    WebServiceApi api;
    String BASE_URL = "http://10.0.2.2:5116/";
    private ArrayAdapter<Contact> adapter;



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
