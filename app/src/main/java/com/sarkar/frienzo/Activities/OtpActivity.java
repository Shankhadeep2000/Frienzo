package com.sarkar.frienzo.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.sarkar.frienzo.R;
import com.sarkar.frienzo.databinding.ActivityOtpBinding;

public class OtpActivity extends AppCompatActivity {
    ActivityOtpBinding binding;
    FirebaseAuth auth;
    String verificationId;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOtpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        dialog = new ProgressDialog(this);
        dialog.setMessage("Sending OTP...");
        dialog.setCancelable(false);
        dialog.show();


    }
}