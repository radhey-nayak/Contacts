package com.example.contacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class RecycleviewContactAdapter extends RecyclerView.Adapter<RecycleviewContactAdapter.ContactHolder> {

    MainActivity mainActivity;
    ArrayList<String> Name;
    ArrayList<String> Number;

    public RecycleviewContactAdapter(MainActivity mainactivity, ArrayList<String> name, ArrayList<String> number) {

        mainActivity = mainactivity;
        Name = name;
        Number = number;
    }


    @NonNull
    @Override
    public RecycleviewContactAdapter.ContactHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mainActivity);
        View view = inflater.inflate(R.layout.contacts_design, parent, false);

        return new ContactHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleviewContactAdapter.ContactHolder holder, int position) {

        holder.ContactName.setText(Name.get(position));
        holder.ContactNumber.setText(Number.get(position));

    }

    @Override
    public int getItemCount() {
        return Name.size();
    }

    public static class ContactHolder extends RecyclerView.ViewHolder {

        CardView ContactProfile;
        TextView ContactProfileText, ContactName, ContactNumber;

        public ContactHolder(@NonNull View itemView) {
            super(itemView);

            ContactProfile = itemView.findViewById(R.id.con_profile);

            ContactProfileText = itemView.findViewById(R.id.con_pro_lat);
            ContactName = itemView.findViewById(R.id.con_name);
            ContactNumber = itemView.findViewById(R.id.con_num);
        }
    }
}
