package com.example.spakler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spakler.model.AddSchedule;
import com.example.spakler.model.Employee;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ScheduleReport extends AppCompatActivity {

    public static final String SCHEDULE_PREFIX = "SCH-00";
    TextView AppointmentID, userName, AppoDate, AppoTime, Stylist;
    Button Confirm, Cancle;
    String DateNow, TimeNow, UserName, AppID, NameS, userEmail, userContact, userPassword;

    FirebaseDatabase rootNode;
    DatabaseReference reference;
    int ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_report);

        AppointmentID = findViewById(R.id.aID);
        userName = findViewById(R.id.aUserNAme);
        AppoDate = findViewById(R.id.aDate);
        AppoTime = findViewById(R.id.aTime);
        Stylist = findViewById(R.id.aSpe);
        Confirm = findViewById(R.id.confirm);


        Intent getUserName = getIntent();
        DateNow = getUserName.getStringExtra("DateNow").toString();
        TimeNow = getUserName.getStringExtra("TimeNow").toString();
        UserName = getUserName.getStringExtra("UserName").toString();
        AppID = getUserName.getStringExtra("AppID").toString();
        NameS = getUserName.getStringExtra("NameS").toString();

        userEmail = getUserName.getStringExtra("userEmail").toString();
        userContact = getUserName.getStringExtra("userContact").toString();
        userPassword = getUserName.getStringExtra("userPassword").toString();


        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("AppointmentList");


        AppointmentID.setText(AppID);
        userName.setText(UserName);
        AppoDate.setText(DateNow);
        AppoTime.setText(TimeNow);
        Stylist.setText(NameS);

        Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent refresh = new Intent(getApplicationContext(), DashBoard.class);
                refresh.putExtra("userName", UserName);
                refresh.putExtra("userEmail", userEmail);
                refresh.putExtra("userContact", userContact);
                refresh.putExtra("userPassword", userPassword);
                startActivity(refresh);
            }
        });
    }
}