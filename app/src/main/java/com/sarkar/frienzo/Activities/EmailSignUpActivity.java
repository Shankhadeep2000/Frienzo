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
import com.google.firebase.database.FirebaseDatabase;
import com.sarkar.frienzo.Models.User;
import com.sarkar.frienzo.R;
import com.sarkar.frienzo.databinding.ActivityEmailSignUpBinding;

public class EmailSignUpActivity extends AppCompatActivity {
    ActivityEmailSignUpBinding binding;
    ProgressDialog dialog;
    FirebaseAuth auth;
    FirebaseDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEmailSignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        auth = FirebaseAuth.getInstance();
        database= FirebaseDatabase.getInstance();
        dialog= new ProgressDialog(this);
        dialog.setTitle("Creating Your Account");
        dialog.setCancelable(false);

        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
                auth.createUserWithEmailAndPassword
                        (binding.etEmailBox.getText().toString() , binding.etPasswordBox.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        dialog.dismiss();
                        if(task.isSuccessful()){
                            User user = new User( binding.etEmailBox.getText().toString() ,
                                    binding.etPasswordBox.getText().toString());

                            String id = task.getResult().getUser().getUid();
                            database.getReference().child("users").child(id).setValue(user);

                            Toast.makeText(EmailSignUpActivity.this, "User created Successfully", Toast.LENGTH_SHORT).show();

                        }
                        else{
                            Toast.makeText(EmailSignUpActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });


            }
        });
        binding.btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmailSignUpActivity.this , SignInActivity.class);
                startActivity(intent);
            }
        });


    }
}