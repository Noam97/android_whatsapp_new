package com.example.android_whatsapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.android_whatsapp.API.ContactsAPI;
import com.example.android_whatsapp.DataModels.DataContact;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class form extends AppCompatActivity {

    private AppDB db;
    private ContactDao postDao;
    private ContactsAPI api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        Intent intent = getIntent();
        api = new ContactsAPI();

        db = Room.databaseBuilder(getApplicationContext(),
                AppDB.class,
                "PostDB").allowMainThreadQueries().build();
        postDao= db.contactDao();
        Button btnSaveNewContact = findViewById(R.id.btnSaveNewContact);
        btnSaveNewContact.setOnClickListener(view -> {
            EditText etItem = findViewById(R.id.etItem);
            EditText etItemServer = findViewById(R.id.etItemServer);
            Contact contact = new Contact(0,
                    etItem.getText().toString(),
                    etItemServer.getText().toString());
            postDao.insert(contact);
            this.addNewContacts(intent.getStringExtra("jwtToken"), contact);
        });
    }

    public void addNewContacts(String token, Contact newContact) {
        Call<String> call = this.api.getApi().addContact("Bearer " + token, newContact);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                finish();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                finish();

            }
        });
    }
}