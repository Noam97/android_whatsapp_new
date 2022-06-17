package com.example.android_whatsapp.DataModels;


public class DataMessage {
    String content;
    String id;
    String sender;
    String created;

    public DataMessage(String content, String userId, String sender) {
        this.content = content;
        this.sender = sender;
        this.id = userId;
        this.created = "";
    }

    public String getMessage() {
        return content;
    }

    public String getCreatedAt() {
        return created;
    }

    public String getSender() {
        return (sender == null) ? "" : sender;
    }
}