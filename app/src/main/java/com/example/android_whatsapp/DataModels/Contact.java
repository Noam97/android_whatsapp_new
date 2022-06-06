package com.example.android_whatsapp.DataModels;

public class Contact {
    String id;
    String name;
    String server;
    String last;
    String lastdate;

    public Contact(String id, String name, String server, String last, String lastdate) {
        this.id = id;
        this.name = name;
        this.server = server;
        this.last = last;
        this.lastdate = lastdate;
    }
}