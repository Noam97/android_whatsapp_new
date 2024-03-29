package com.example.android_whatsapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities={Contact.class},version=1)
public abstract class AppDB extends RoomDatabase{
    public abstract ContactDao contactDao();
}
