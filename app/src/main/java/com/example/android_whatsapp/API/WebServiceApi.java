package com.example.android_whatsapp.API;
import com.example.android_whatsapp.Contact;
import com.example.android_whatsapp.DataModels.DataMessage;
import com.example.android_whatsapp.DataModels.DataContact;
import com.example.android_whatsapp.DataModels.LoginUser;
import com.example.android_whatsapp.DataModels.RegisterUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Body;
import retrofit2.http.Path;

public interface WebServiceApi {

    @POST("api/users")
    Call<String> login(@Body LoginUser user);

    @GET("api/contacts")
    Call<List<DataContact>> getContacts(@Header("Authorization") String auth);

    @POST("api/contacts")
    Call<String> addContact(@Header("Authorization") String auth, @Body Contact dataContact);

    @GET("api/contacts/{id}")
    Call<DataContact> getContactById(@Header("Authorization") String auth, @Path(value = "id") String id);

    @GET("api/contacts/{id}/messages")
    Call<List<DataMessage>> getMessagesByContact(@Header("Authorization") String auth,  @Path(value = "id") String id);

    @POST("api/contacts/{id}/messages")
    Call<String> sendMessage(@Header("Authorization") String auth, @Path(value = "id") String id, @Body DataMessage message);

    @POST("api/register")
    Call<String> createUser(@Body RegisterUser user);



}
