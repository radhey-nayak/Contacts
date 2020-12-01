package com.example.contacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class add_new_contact extends AppCompatActivity {

    EditText E_name, E_number;
    Button done, cancel;

    String name = null, number = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_contact);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        E_name = findViewById(R.id.e_name);
        E_number = findViewById(R.id.e_number);

        done = findViewById(R.id.done);
        cancel = findViewById(R.id.cancel);

        // onclick listener for button done
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = E_name.getText().toString() ;
                number = E_number.getText().toString();
                System.out.println("h"+name);

                if (name.isEmpty() || number.isEmpty()){

                    Toast.makeText(add_new_contact.this, "Please enter somthing", Toast.LENGTH_SHORT).show();
                } else {

                    // sending name and number through Intent
                    Intent intent2 = new Intent(ContactsContract.Intents.Insert.ACTION);
                    intent2.setType(ContactsContract.RawContacts.CONTENT_TYPE);
                    intent2.putExtra(ContactsContract.Intents.Insert.NAME, name)
                            .putExtra(ContactsContract.Intents.Insert.PHONE, number);
                    startActivityForResult(intent2, 1);
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}