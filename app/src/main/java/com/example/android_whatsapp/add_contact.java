package com.example.android_whatsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import android.os.Bundle;

public class add_contact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
    }

    @Entity
    public static class Post {
        @PrimaryKey(autoGenerate=true)
        private int id;
        private String contact;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getContact() {
            return contact;
        }

        public void setContact(String contact) {
            this.contact = contact;
        }

        public Post(int id, String contact) {
            this.id = id;
            this.contact = contact;
        }

        public Post() {
        }

        @Override
        public String toString() {
            return contact;
        }
    }
}