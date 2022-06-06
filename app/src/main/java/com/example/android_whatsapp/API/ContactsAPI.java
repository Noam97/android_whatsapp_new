package com.example.android_whatsapp.API;

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


    public ContactsAPI() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(WebServiceApi.class);
    }

    public List<Contact> getAllContacts(String token) {
        Call<List<Contact>> call = this.api.getContacts("Bearer " + token);
        final List<Contact>[] res = new List[1];
        call.enqueue(new Callback<List<Contact>>() {
            @Override
            public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
                res[0] = response.body();
                System.out.println(response.body());
            }

            @Override
            public void onFailure(Call<List<Contact>> call, Throwable t) {
                System.out.println(t.toString());

            }
        });
        return res[0];
    }

}
