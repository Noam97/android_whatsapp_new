package com.example.android_whatsapp.DataModels;

public class RegisterUser {
    String UserId;
    String DisplayName;
    String Password;

    public RegisterUser(String userName, String displayName, String password) {
        this.UserId = userName;
        this.DisplayName = displayName;
        this.Password = password;
    }

}
