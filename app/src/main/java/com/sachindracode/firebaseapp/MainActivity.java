package com.sachindracode.firebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sachindracode.firebaseApp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Write a message to the database

        // Initialize and Access the Firebase Database
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        // Get a reference to a specific node in the database
        DatabaseReference myRef = database.getReference("Users");

        // Write a value to the specified database location
        User user1 = new User("Jack", "jack@gmail.com");
        myRef.setValue(user1);

        myRef.setValue("Hello from our Course!");


        TextView textView = findViewById(R.id.textview);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                User user = snapshot.getValue(User.class);

                textView.setText("Email: " + user.getEmail());


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle Errors here
            }
        });
    }
}
