package com.example.spakler;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.experimental.UseExperimental;
import androidx.appcompat.app.AppCompatActivity;

import com.example.spakler.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Register extends AppCompatActivity {

    //to auto generate id number
    public static final String USER_PREFIX = "SPU-00";

    //assigning variable names
    Button RegisterButton;
    TextView RegisterText;
    EditText UserName, Email, PhoneNo, Password;
    ProgressDialog progressDialog;
    ProgressBar progressBar;

    //to generate the id
    int ID = 0;

    //key word for the database
    FirebaseDatabase rootNode;
    //to access the fields in the database
    DatabaseReference reference;

    //validations for email and password(regular expressions)
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String passwordPattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // mapping with the frontend
        RegisterButton = findViewById(R.id.registerButton);
        RegisterText = findViewById(R.id.signInText);
        UserName = findViewById(R.id.username);
        Email = findViewById(R.id.email);
        PhoneNo = findViewById(R.id.phone_no);
        Password = findViewById(R.id.password);
        progressBar = findViewById(R.id.progressBar_Reg);
        progressDialog = new ProgressDialog(this);

        //User Registration
        //to make the buttons clickable
        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //assigning user inputs to the variables
                String uName = UserName.getText().toString();
                String uEmail = Email.getText().toString();
                String uPhone = PhoneNo.getText().toString();
                String uPass = Password.getText().toString();

                //validation to check to null values in the register form
                if (uName.isEmpty()) {
                    UserName.setError("Username can not be empty.");
                }
                if (uEmail.isEmpty()) {
                    Email.setError("Email can not be empty.");
                }
                if (uPhone.isEmpty()) {
                    PhoneNo.setError("Phone can not be empty.");
                }
                if (uPass.isEmpty()) {
                    Password.setError("Password can not be empty.");
                }

            //to check the validation in email and password
                if (!uEmail.matches(emailPattern)) {
                    Email.setError("Email is not a valid email. Please enter valid email.");
                }
                if (!uPass.matches(passwordPattern)) {
                    Password.setError("Password must be include a digit, a lower, an upper, a special and no whitespace allowed.");
                } else {
                    //firebase access
                    rootNode = FirebaseDatabase.getInstance();
                    //to create the table in the database
                    reference = rootNode.getReference("userList");

                    //to read the data from the database
                    reference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            ID = (int) snapshot.getChildrenCount(); //to check the number of records
                            System.out.println(ID);
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }
                    });

                    ID = ID + 1;//id starts with number one

                    String id = USER_PREFIX + ID; // id generated
                    User user = new User(id, uName, uEmail, uPhone, uPass);
                    reference.child(uName).setValue(user); //to save the entered data to the database
                    Toast.makeText(Register.this, "Successfully Registered...", Toast.LENGTH_SHORT).show();

                    Intent reg = new Intent(getApplicationContext(), Login.class);
                    startActivity(reg);
                }

            }
        });

        //to navigate to the sign in screen
        RegisterText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
    }
}