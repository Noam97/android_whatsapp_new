package com.example.android_whatsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class chat extends AppCompatActivity {
    androidx.appcompat.widget.Toolbar toolbar_chat;
    ImageButton back_button_chat;
    CardView profile_chat;
    ImageView image_user;
    TextView name_of_user;
    EditText get_message;
    ImageButton send_message_button;
    private String enter_message;

    String reciver_name, sender_name, reciver_uid, sender_uid;
    String sender_room, reciver_room;

    Intent intent;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        toolbar_chat=findViewById(R.id.toolsbar_chat);
        back_button_chat=findViewById(R.id.back_button_from_chat);
        profile_chat=findViewById(R.id.profile_user_in_chat);
        image_user= findViewById(R.id.profile_user_in_chat);
        name_of_user=findViewById(R.id.user_name_chat);
        get_message=findViewById(R.id.getmessage);
        send_message_button=findViewById(R.id.card_send_message);
        intent=getIntent();

        setSupportActionBar((toolbar_chat));

        firebaseAuth = FirebaseAuth.getInstance();
        sender_uid=firebaseAuth.getUid();
        reciver_uid=firebaseAuth.getUid();

        sender_room=sender_uid+reciver_uid;
        reciver_room=reciver_uid+sender_uid;
        name_of_user.setText(reciver_name);

//        send_message_button.setOnClickListener(view ->{
//            @Override
//            public void OnClick(View view){
//                enter_message=get_message.getText().toString();
//                if(enter_message.isEmpty()){
//                    Toast.makeText(getApplicationContext(), "Enter message", Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    messages messages = new messages(enter_message, firebaseAuth.getUid());
//                }
//            }
//        });
    }
}