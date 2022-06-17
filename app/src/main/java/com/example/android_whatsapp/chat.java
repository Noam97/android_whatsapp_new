package com.example.android_whatsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class chat extends AppCompatActivity {

    EditText get_message;
    ImageButton send_message_button;
    CardView send_message;
    androidx.appcompat.widget.Toolbar toolbar_chat;
    ImageView image_user;
    TextView name_of_user;

    private String enter_message;
    Intent intent;
    String reciver_name, sender_name, reciver_uid, sender_uid;
    private FirebaseAuth firebaseAuth;
   // FirebaseDatebase firebaseDatebase;
    String sender_room, reciver_room;
    ImageButton back_button_chat;
    RecyclerView message_recycle_view;
    String current_time;
    Calendar calender;
    SimpleDateFormat simpleDateFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        get_message=findViewById(R.id.getmessage);
//        send_message=findViewById(R.id.view_of_send_message);
//        send_message_button=findViewById(R.id.image_view_send_message);
    }
}