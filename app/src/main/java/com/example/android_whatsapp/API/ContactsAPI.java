package com.example.android_whatsapp.API;
import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.ArrayAdapter;

import androidx.preference.PreferenceManager;

import com.example.android_whatsapp.DataModels.DataContact;
import com.example.android_whatsapp.R;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ContactsAPI{

    Retrofit retrofit;
    WebServiceApi api;
    private ArrayAdapter<DataContact> adapter;



    public ContactsAPI(Context context) {
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
