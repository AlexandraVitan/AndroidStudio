package com.example.myapplication1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Initialize TextView
        textView = findViewById(R.id.user_details);

        // Retrieve current user information
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

        if (currentUser != null) {
            // User is signed in, display their email
            String userEmail = currentUser.getEmail();
            textView.setText("User Email: " + userEmail);
        } else {
            // No user is signed in, handle this case accordingly
            textView.setText("No user signed in.");
        }
    }
}
