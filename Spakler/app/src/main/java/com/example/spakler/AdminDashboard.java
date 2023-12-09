package com.example.spakler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class AdminDashboard extends AppCompatActivity {

    RelativeLayout EmployeePage, AllEmployee, AllAppointment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        EmployeePage = findViewById(R.id.addEmployee);
        AllEmployee = findViewById(R.id.allEmployee);
        AllAppointment = findViewById(R.id.rl3);

        EmployeePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go = new Intent(getApplicationContext(), AddEmployee.class);
                startActivity(go);
            }
        });

        AllEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go = new Intent(getApplicationContext(), AllEmployeesList.class);
                startActivity(go);
            }
        });

        AllAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go = new Intent(getApplicationContext(), AllAppointmentList.class);
                startActivity(go);
            }
        });
    }
}