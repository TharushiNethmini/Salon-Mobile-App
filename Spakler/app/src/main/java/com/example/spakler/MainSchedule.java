package com.example.spakler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainSchedule extends AppCompatActivity {

    Button create, all;

    String userName, userEmail, userContact, userPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_schedule);

        create = findViewById(R.id.createButton);
        all = findViewById(R.id.allButton);

        //getStringExtra is used to catch data from another activity
        Intent getUserName = getIntent();
        userName = getUserName.getStringExtra("userName").toString();
        userEmail = getUserName.getStringExtra("userEmail").toString();
        userContact = getUserName.getStringExtra("userContact").toString();
        userPassword = getUserName.getStringExtra("userPassword").toString();

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //putExtra is used to pass the data to another activity
                //passing data to the SceduleApoinment activity
                Intent go = new Intent(getApplicationContext(), SceduleApoinment.class);
                go.putExtra("userName", userName);
                go.putExtra("userEmail", userEmail);
                go.putExtra("userContact", userContact);
                go.putExtra("userPassword", userPassword);
                startActivity(go);

            }
        });

        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //passing data to the AllAppointmentList activity
                Intent go = new Intent(getApplicationContext(), AllAppointmentList.class);
                go.putExtra("userName", userName);
                go.putExtra("userEmail", userEmail);
                go.putExtra("userContact", userContact);
                go.putExtra("userPassword", userPassword);
                startActivity(go);
            }
        });
    }
}