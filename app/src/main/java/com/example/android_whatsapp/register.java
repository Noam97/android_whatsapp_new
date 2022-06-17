package com.example.android_whatsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android_whatsapp.API.UsersAPI;
import com.example.android_whatsapp.API.WebServiceApi;
import com.example.android_whatsapp.DataModels.LoginUser;
import com.example.android_whatsapp.DataModels.RegisterUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView register_loginLink = findViewById(R.id.register_loginLink);
        register_loginLink.setOnClickListener(v -> {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            Log.i("register_activity","");
        });

        UsersAPI api = new UsersAPI(this);

        Button btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(v -> {

        EditText userName = findViewById(R.id.editTextTextPersonName);
        EditText displayName = findViewById(R.id.editDisplayName);
        EditText password1 = findViewById(R.id.editTextTextPassword);
        EditText password2 = findViewById(R.id.editConfirmPass);
        EditText registerError = findViewById(R.id.registerError);


        // fields are not empty
            if(userName.getText().toString().equals("") ||
                displayName.getText().toString().equals("") ||
                password1.getText().toString().equals("") ||
                password2.getText().toString().equals("")) {
                registerError.setText("Fields cannot be empty");
                return;
            }
        // passwords are valid
            if(!password1.getText().toString().equals(password2.getText().toString())) {
                registerError.setText("Passwords are not identical");
                return;
            }
        registerError.setText("");
        Intent i = new Intent(this, contacts_list.class);
        register(i,
                api,
                userName.getText().toString(),
                displayName.getText().toString(),
                password1.getText().toString());
        });

        Log.i("register_activity","");
    }

    public void register(Intent i, UsersAPI usersAPI, String userName, String displayName, String password) {
        WebServiceApi api = usersAPI.getApi();
        RegisterUser user = new RegisterUser(userName, displayName, password);
        Call<String> call = api.createUser(user);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                System.out.println(response.body());
                if(response.isSuccessful()) {

                    i.putExtra("jwtToken", response.body());
                    i.putExtra("userId", userName.toString());
                    i.putExtra("isNewUser", true);
                    startActivity(i);
                    Log.i("mainActivity", "");
                }
                else {
                    //
                }
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                EditText registerError = findViewById(R.id.registerError);
                registerError.setText("User id already exists");
                System.out.println("ERORRRRRRR");
                System.out.println(t.toString());
            }

        });
    }


}
