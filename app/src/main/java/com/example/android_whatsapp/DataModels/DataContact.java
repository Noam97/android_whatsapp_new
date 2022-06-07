package com.example.android_whatsapp.DataModels;

public class DataContact {
    String id;
    String name;
    String server;
    String last;
    String lastdate;

    public DataContact(String id, String name, String server, String last, String lastdate) {
        this.id = id;
        this.name = name;
        this.server = server;
        this.last = last;
        this.lastdate = lastdate;
    }

    public String getName() {
        return name;
    }

    public String getServer() {
        return server;
    }
}