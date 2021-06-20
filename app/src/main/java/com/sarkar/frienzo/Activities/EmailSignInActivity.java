package com.sarkar.frienzo.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.sarkar.frienzo.databinding.ActivityEmailSignInBinding;
import com.sarkar.frienzo.databinding.ActivityEmailSignUpBinding;

public class EmailSignInActivity extends AppCompatActivity {
    ActivityEmailSignInBinding binding;
    ProgressDialog dialog;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEmailSignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        auth = FirebaseAuth.getInstance();
        dialog = new ProgressDialog(EmailSignInActivity.this);

        dialog.setTitle("Login");
        dialog.setMessage("Login to your account");
        binding.btnClickSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmailSignInActivity.this , SignUpActivity.class);
                startActivity(intent);
            }
        });
        binding.btnSignInEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.emailBox.getText().toString().isEmpty()){
                    binding.emailBox.setError("Enter Your Email");
                    return;
                }

                if(binding.passwordBox.getText().toString().isEmpty()){
                    binding.passwordBox.setError("Enter Your Password");
                    return;
                }


                dialog.show();
                auth.signInWithEmailAndPassword(binding.emailBox.getText().toString(), binding.passwordBox.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        dialog.dismiss();
                        if(task.isSuccessful()){
                            Intent intent = new Intent(EmailSignInActivity.this , SetProfileActivity.class);
                            startActivity(intent);
                            finishAffinity();

                        }
                        else{
                            Toast.makeText(EmailSignInActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}