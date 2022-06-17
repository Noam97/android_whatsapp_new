package com.example.android_whatsapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_whatsapp.API.ContactsAPI;
import com.example.android_whatsapp.API.MessagesAPI;
import com.example.android_whatsapp.API.UsersAPI;
import com.example.android_whatsapp.DataModels.DataMessage;
import com.example.android_whatsapp.DataModels.DataContact;
import com.example.android_whatsapp.databinding.ActivityChatBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Chat extends AppCompatActivity {
    private RecyclerView mMessageRecycler;
    private MessagesAPI api;
    private ActivityChatBinding binding;
    private MessageListAdapter mMessageAdapter;
    private List<DataMessage> mMessageList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();

        String chatUserId = intent.getStringExtra("currentUserId");
        String currentUserId = intent.getStringExtra("userId");
        String token = intent.getStringExtra("jwtToken");

        api = new MessagesAPI(this);
        this.getAllMessages(this, token, chatUserId, currentUserId);

        Button sendMsgBtn = binding.buttonGchatSend;
        sendMsgBtn.setOnClickListener(v -> {
            EditText message = findViewById(R.id.edit_gchat_message);
            if(message.getText().toString().equals("")) {
                return;
            }
            this.sendMessage(this, token, message.getText().toString(), chatUserId, currentUserId);
            message.setText("");
        });
    }

    public void getAllMessages(Context ctx, String token, String userId, String CurrentUserId) {
        Call<List<DataMessage>> call = this.api.getApi().getMessagesByContact("Bearer " + token, userId);
        call.enqueue(new Callback<List<DataMessage>>() {
            @Override
            public void onResponse(Call<List<DataMessage>> call, Response<List<DataMessage>> response) {
                if(response.isSuccessful()) {
                    mMessageList = response.body();
                    mMessageRecycler = (RecyclerView) findViewById(R.id.recycler_gchat);
                    mMessageAdapter = new MessageListAdapter(ctx, CurrentUserId , mMessageList);
                    mMessageRecycler.setLayoutManager(new LinearLayoutManager(ctx));
                    mMessageRecycler.setAdapter(mMessageAdapter);

                }
            }

            @Override
            public void onFailure(Call<List<DataMessage>> call, Throwable t) {
                System.out.println(t.toString());

            }
        });
    }

    public void sendMessage(Context ctx, String token, String content, String userId, String CurrentUserId) {
            DataMessage newMsg = new DataMessage(content, userId, CurrentUserId);
            mMessageList.add(newMsg);
            mMessageRecycler = (RecyclerView) findViewById(R.id.recycler_gchat);
            mMessageAdapter = new MessageListAdapter(ctx, CurrentUserId , mMessageList);
            mMessageRecycler.setLayoutManager(new LinearLayoutManager(ctx));
            mMessageRecycler.setAdapter(mMessageAdapter);
            Call<String> call =  this.api.getApi().sendMessage("Bearer " + token, userId, newMsg);
            call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                System.out.println(response.body());
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                System.out.println(t.toString());
            }

        });
    }


}