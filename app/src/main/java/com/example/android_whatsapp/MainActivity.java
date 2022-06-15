package com.example.android_whatsapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.android_whatsapp.API.UsersAPI;
import com.example.android_whatsapp.API.WebServiceApi;
import com.example.android_whatsapp.DataModels.LoginUser;
import com.example.android_whatsapp.databinding.ActivityMainBinding;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private AppDB db;
    private ContactDao postDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db = Room.databaseBuilder(getApplicationContext(), AppDB.class, "PostDB").allowMainThreadQueries().build();
        postDao= db.contactDao();
        TextView login_registerLink = findViewById(R.id.login_registerLink);
        login_registerLink.setOnClickListener(v -> {
            Intent i = new Intent(this, register.class);
            startActivity(i);
            Log.i("mainActivity","");
        });

        Intent i = new Intent(this, contacts_list.class);



        Button btn_login = binding.btnLogin;
        btn_login.setOnClickListener(v -> {
            EditText username = findViewById(R.id.editTextTextPersonName);
            EditText password = findViewById(R.id.editTextTextPassword);

            UsersAPI api = new UsersAPI();
            auth(i, api, username.getText().toString(), password.getText().toString());
        });
    }

    public void auth(Intent i, UsersAPI usersAPI, String userName, String password) {
        WebServiceApi api = usersAPI.getApi();
        LoginUser user = new LoginUser(userName, password);
        Call<String> call = api.login(user);
        final String[] res = new String[1];
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                System.out.println(response.body());
                if(response.isSuccessful()) {

                    i.putExtra("jwtToken", response.body());
                    i.putExtra("userId", userName.toString());
                    startActivity(i);
                    Log.i("mainActivity", "");
                }
                else {
                    //
                }
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                System.out.println(t.toString());
            }

        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("mainActivity","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("mainActivity","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("mainActivity","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("mainActivity","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("mainActivity","onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("mainActivity","onRestart");
    }


//    FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(MainActivity.this, newOnSucccessListener<InstanceIdResult>()){
//        String newToken = instanceIdResult.getToken();
//    }
}