package com.example.spakler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.spakler.adapter_class.AllAppontmentListListAdapter;
import com.example.spakler.adapter_class.AllEmployeesListAdapter;
import com.example.spakler.model.AddSchedule;
import com.example.spakler.model.Employee;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AllAppointmentList extends AppCompatActivity {

    RecyclerView recyclerView;
    AllAppontmentListListAdapter allAppointmentList;
    ValueEventListener valueEventListener;
    DatabaseReference reference;
    TextView AllAppointment;

    FirebaseDatabase rootNode;
    int size = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_appointment_list);

        recyclerView = (RecyclerView) findViewById(R.id.recview);
        AllAppointment = findViewById(R.id.count);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<AddSchedule> options =
                new FirebaseRecyclerOptions.Builder<AddSchedule>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("AppointmentList"), AddSchedule.class)
                        .build();

        allAppointmentList = new AllAppontmentListListAdapter(options);
        recyclerView.setAdapter(allAppointmentList);
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("AppointmentList");


        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                size = (int) snapshot.getChildrenCount();

                System.out.println(size);
                String id = String.valueOf( size);
                AllAppointment.setText(id);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        allAppointmentList.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        allAppointmentList.stopListening();
    }
}