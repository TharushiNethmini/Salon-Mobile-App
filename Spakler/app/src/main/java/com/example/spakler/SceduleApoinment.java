package com.example.spakler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.spakler.model.AddSchedule;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SceduleApoinment extends AppCompatActivity {

    public static final String SCHEDULE_PREFIX = "SCH-00";
    String userName, userEmail, userContact, userPassword;

    Spinner spinner;// dropdown
    CalendarView calendarView;
    TimePicker timePicker;
    Button Create;

    DatabaseReference reference;//to access the beutician table
    DatabaseReference aReference;//to create the appointment
    FirebaseDatabase rootNode;

    int ID = 0;


    ValueEventListener valueEventListener;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    Object item = new Object();//to assign the data from the dropdown
    String Time = "";
    String Date = "";
    String temp = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scedule_apoinment);

        spinner = findViewById(R.id.spinner);
        calendarView = findViewById(R.id.calendar_frame);
        timePicker = findViewById(R.id.time);
        Create = findViewById(R.id.createButton);

        list = new ArrayList<String>();
        adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, list);//to show the dropdown list
        spinner.setAdapter(adapter);

        reference = FirebaseDatabase.getInstance().getReference("UserProfile");

        //to pass data to the
        valueEventListener = reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot mydata : snapshot.getChildren()) {
                    String FirstName = mydata.child("firstName").getValue().toString();
                    String LastNAme = mydata.child("lastName").getValue().toString();
                    String FullName = FirstName + " " + LastNAme;
                    list.add(FullName);//to add firstname and lastname
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //select the dropdown
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                item = adapterView.getItemAtPosition(i);
                System.out.println(item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        System.out.println(item);

        //to select the calendar
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            //date=i2,month=i1,year=i
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                Date = i2 + "/" + (i1 + 1) + "/" + i;//date format
                System.out.println("Date" + temp);
            }
        });

        //set time
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            //hour=i,minutes=i1
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                Time = i + ":" + i1;//time format
                System.out.println("Time" + " " + Time);
            }
        });

        Intent getUserName = getIntent();
        userName = getUserName.getStringExtra("userName").toString();
        userEmail = getUserName.getStringExtra("userEmail").toString();
        userContact = getUserName.getStringExtra("userContact").toString();
        userPassword = getUserName.getStringExtra("userPassword").toString();

        rootNode = FirebaseDatabase.getInstance();
        aReference = rootNode.getReference("AppointmentList");

        aReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ID = (int) snapshot.getChildrenCount();
                System.out.println(ID);
                ID = ID + 1;


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        //create appointment
        Create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                System.out.println("ID" + ID);
                String id = SCHEDULE_PREFIX + ID;

                String DateNow = Date;
                String TimeNow = Time;
                String UserName = userName;
                String AppID = id;
                String USerContact = userContact;
                Object NameSpring = item;
                String NameS = NameSpring.toString();//to change object type to string
                int isApprove = 2;

                //overload constructor
                AddSchedule addSchedule = new AddSchedule(id,DateNow, TimeNow, UserName, NameS, isApprove);
                aReference.child(id).setValue(addSchedule);//save data to database
                Toast.makeText(SceduleApoinment.this, "Appointment is created successfully.", Toast.LENGTH_SHORT).show();

                //to pass the entered data to the report
                Intent goNext = new Intent(getApplicationContext(), ScheduleReport.class);
                goNext.putExtra("DateNow", DateNow);
                goNext.putExtra("TimeNow", TimeNow);
                goNext.putExtra("UserName", UserName);
                goNext.putExtra("AppID", AppID);
                goNext.putExtra("userContact", USerContact);
                goNext.putExtra("NameS", NameS);
                goNext.putExtra("userEmail", userEmail);
                goNext.putExtra("userPassword", userPassword);
                startActivity(goNext);
            }

        });

    }

}