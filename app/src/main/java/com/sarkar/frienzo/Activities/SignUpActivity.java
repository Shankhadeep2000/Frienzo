package com.sarkar.frienzo.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.sarkar.frienzo.R;
import com.sarkar.frienzo.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {
        ActivitySignUpBinding binding;
        FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();
        auth = FirebaseAuth.getInstance();

        if(auth.getCurrentUser() != null){
            Intent intent = new Intent(SignUpActivity.this , MainActivity.class);
            startActivity(intent);
            finish();
        }

        binding.btnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this , PhoneSignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });

        binding.btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this , EmailSignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}