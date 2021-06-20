package com.sarkar.frienzo.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.sarkar.frienzo.R;
import com.sarkar.frienzo.databinding.ActivityPhoneSignUpBinding;

public class PhoneSignUpActivity extends AppCompatActivity {
        ActivityPhoneSignUpBinding binding;
        FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhoneSignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        auth = FirebaseAuth.getInstance();
        binding.phoneBox.requestFocus();
        if(auth.getCurrentUser() != null){
            Intent intent = new Intent(PhoneSignUpActivity.this , MainActivity.class);
            startActivity(intent);
            finish();
        }

        binding.continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PhoneSignUpActivity.this , PhoneSignInActivity.class);
                intent.putExtra("phoneNumber" , binding.phoneBox.getText().toString());
                startActivity(intent);
                
            }
        });



    }
}