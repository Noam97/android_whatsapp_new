package com.example.android_whatsapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class Contact {
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

    public Contact(int id, String contact) {
        this.id = id;
        this.contact = contact;
    }

    public Contact() {
    }

    @Override
    public String toString() {
        return contact;
    }
}
