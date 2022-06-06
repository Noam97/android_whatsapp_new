package com.example.android_whatsapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.android_whatsapp.API.ContactsAPI;
import com.example.android_whatsapp.API.UsersAPI;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class contacts_list extends AppCompatActivity {

    private List<Post> posts;
    private AppDB db;
    private PostDao postDao;
    private  ArrayAdapter<Post> adapter;
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

        ContactsAPI api = new ContactsAPI();
        api.getAllContacts(token);



        posts= new ArrayList<>();

        ListView contacts = findViewById(R.id.contacts);
        adapter = new ArrayAdapter<Post>(this, android.R.layout.simple_list_item_1,posts);
        contacts.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        posts.clear();
        posts.addAll(postDao.index());
        adapter.notifyDataSetChanged();
    }

}