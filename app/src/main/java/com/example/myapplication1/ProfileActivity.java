package com.example.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication1.databinding.ActivityMainBinding;
import com.example.myapplication1.databinding.ActivityProfileBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //binding = ActivityProfileBinding.inflate(getLayoutInflater());

        // Initialize TextView
        textView = findViewById(R.id.user_details);
       // Button button = binding.cameraButton;
       Button button = findViewById(R.id.cameraButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CameraActivity.class);
                startActivity(intent);
                finish();
            }
        });

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
