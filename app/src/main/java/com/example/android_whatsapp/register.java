package com.example.android_whatsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

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

        Button btn_login = findViewById(R.id.btn_register);
        btn_login.setOnClickListener(v -> {
            Intent i = new Intent(this, register.class);
            startActivity(i);
            Log.i("register_activity","");
        });

        Log.i("register_activity","");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("register_activity","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("register_activity","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("register_activity","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("register_activity","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("register_activity","onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("register_activity","onRestart");
    }
}
