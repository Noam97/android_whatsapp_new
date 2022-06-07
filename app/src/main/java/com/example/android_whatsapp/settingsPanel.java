package com.example.android_whatsapp;
import android.content.SharedPreferences;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

public class settingsPanel extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        EditText etItem = findViewById(R.id.etItemServerSettings);

        etItem.setHint(prefs.getString("serverUrl", ""));
        Button btnSaveNewContact = findViewById(R.id.btnSaveSettings);
        btnSaveNewContact.setOnClickListener(view -> {
            SharedPreferences.Editor prefEditor = prefs.edit();
            prefEditor.putString("serverUrl", etItem.getText().toString());
            prefEditor.apply();
        });
    }
}
