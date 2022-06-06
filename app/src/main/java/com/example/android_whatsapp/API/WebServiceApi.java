package com.example.android_whatsapp.API;
import com.example.android_whatsapp.DataModels.Contact;
import com.example.android_whatsapp.DataModels.LoginUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Body;

public interface WebServiceApi {

    @POST("api/users")
    Call<String> login(@Body LoginUser user);

    @GET("api/contacts")
    Call<List<Contact>> getContacts(@Header("Authorization") String auth);

}
