package com.example.spakler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ServicesCustomer extends AppCompatActivity {


    String userName, userEmail, userContact, userPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_customer);


        Intent getUserName = getIntent();
        userName = getUserName.getStringExtra("userName").toString();
        userEmail = getUserName.getStringExtra("userEmail").toString();
        userContact = getUserName.getStringExtra("userContact").toString();
        userPassword = getUserName.getStringExtra("userPassword").toString();

    }


    public void AddCart(View view) {

        Intent go = new Intent(getApplicationContext(), SceduleApoinment.class);
        go.putExtra("userName", userName);
        go.putExtra("userEmail", userEmail);
        go.putExtra("userContact", userContact);
        go.putExtra("userPassword", userPassword);
        startActivity(go);

    }
}