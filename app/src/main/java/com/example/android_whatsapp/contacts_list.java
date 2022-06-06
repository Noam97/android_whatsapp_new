package com.example.android_whatsapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.android_whatsapp.API.ContactsAPI;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class contacts_list extends AppCompatActivity {

    private List<Contact> contacts;
    private AppDB db;
    private ContactsAPI api;
    private PostDao postDao;
    private  ArrayAdapter<Contact> adapter;
    private List<Contact> contactsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_contacts_list);
        db = Room.databaseBuilder(getApplicationContext(), AppDB.class, "PostDB").allowMainThreadQueries().build();
        postDao= db.postDao();

        FloatingActionButton btnAddContacts = findViewById(R.id.btnAddContacts);
        btnAddContacts.setOnClickListener(view -> {
            Intent i = new Intent(this, form.class);
            startActivity(i);
        });

        String token = intent.getStringExtra("jwtToken");
        String userId = intent.getStringExtra("userId");

        contactsList= new ArrayList<>();

        ListView contacts = findViewById(R.id.contacts);
        adapter = new ArrayAdapter<Contact>(contacts_list.this,
                android.R.layout.simple_list_item_1,
                contactsList);
        contacts.setAdapter(adapter);

        api = new ContactsAPI();
        //getAllContacts(token);
    }

    @Override
    protected void onResume() {
        super.onResume();
        contactsList.clear();
        contactsList.addAll(postDao.index());
        adapter.notifyDataSetChanged();
    }

    public void getAllContacts(String token) {
        Call<List<com.example.android_whatsapp.DataModels.Contact>> call = this.api.getApi().getContacts("Bearer " + token);
        call.enqueue(new Callback<List<com.example.android_whatsapp.DataModels.Contact>>() {
            @Override
            public void onResponse(Call<List<com.example.android_whatsapp.DataModels.Contact>> call, Response<List<com.example.android_whatsapp.DataModels.Contact>> response) {
                if(response.isSuccessful()) {
                    int i = 0;
                    for (com.example.android_whatsapp.DataModels.Contact contact: response.body()) {
                        if(postDao.get(contact.getName()) == null) {
                            postDao.insert(new Contact(0, contact.getName()));
                        }
                        i++;
                    }
                    System.out.println(response.body());
                }            }

            @Override
            public void onFailure(Call<List<com.example.android_whatsapp.DataModels.Contact>> call, Throwable t) {
                System.out.println(t.toString());

            }
        });
    }

}