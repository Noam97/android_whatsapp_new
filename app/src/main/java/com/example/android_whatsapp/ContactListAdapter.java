package com.example.android_whatsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactListAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<Contact> contactList;
    private String mCurrentUser;

    public ContactListAdapter(Context context, List<Contact> mcontactList) {
        mContext = context;
        contactList = mcontactList;
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    // Inflates the appropriate layout according to the ViewType.
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_layout, parent, false);

        return new ContactHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Contact contact = (Contact) contactList.get(position);
        ((ContactHolder) holder).bind(contact);
        }

    private class ContactHolder extends RecyclerView.ViewHolder {
        TextView contactText;

        ContactHolder(View itemView) {
            super(itemView);

            contactText = (TextView) itemView.findViewById(R.id.contactItem);
        }

        void bind(Contact contact) {
            contactText.setText(contact.getName());
        }
    }
}