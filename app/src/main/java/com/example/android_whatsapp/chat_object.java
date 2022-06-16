package com.example.android_whatsapp;

import java.util.ArrayList;
//
public class chat_object {
    ArrayList<messages> messages;
    int id;
    String id1;
    String id2;

    public chat_object(ArrayList<com.example.android_whatsapp.messages> messages, int id, String id1, String id2) {
        this.messages = messages;
        this.id = id;
        this.id1 = id1;
        this.id2 = id2;
    }

    public ArrayList<com.example.android_whatsapp.messages> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<com.example.android_whatsapp.messages> messages) {
        this.messages = messages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
