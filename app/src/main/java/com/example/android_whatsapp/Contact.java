package com.example.android_whatsapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity
 public class Contact {
    @PrimaryKey(autoGenerate=true)
    private int ContactId;
    private static String id;
    private String name;
    private String contact;
    private String server;
    private String last;
    private String lastDate;
    private static ArrayList<chat_object> chats;

    public static ArrayList<chat_object> getChats() {
        return chats;
    }

    public void setChats(ArrayList<chat_object> chats) {
        this.chats = chats;
    }

    public  static String getId() {
        return id;
    }

    public static void  setId(String _id) {
        id = _id;
    }

    public void setContactId(int contactId) {
        ContactId = contactId;
    }



    public String getServer() {
        return server;
    }

    public int getContactId() {
        return ContactId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }

    public String getLastDate() {
        return lastDate;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Contact(int id, String contact, String server) {
        this.ContactId= id;
        this.name = contact;
        this.id = contact;
        this.contact = contact;
        this.server = server;
    }

    public Contact() {
    }

    @Override
    public String toString() {
        return contact;
    }
}
