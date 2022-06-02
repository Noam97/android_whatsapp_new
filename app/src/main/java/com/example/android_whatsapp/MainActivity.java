package com.example.android_whatsapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.android_whatsapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private AppDB db;
    private PostDao postDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db = Room.databaseBuilder(getApplicationContext(), AppDB.class, "PostDB").allowMainThreadQueries().build();
        postDao= db.postDao();
        TextView login_registerLink = findViewById(R.id.login_registerLink);
        login_registerLink.setOnClickListener(v -> {
            Intent i = new Intent(this, register.class);
            startActivity(i);
            Log.i("mainActivity","");
        });


        Button btn_login = binding.btnLogin;
        btn_login.setOnClickListener(v -> {
            Intent i = new Intent(this, contacts_list.class);
            startActivity(i);
            Log.i("mainActivity","");
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
}