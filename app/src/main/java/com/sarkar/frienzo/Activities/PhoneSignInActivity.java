package com.sarkar.frienzo.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.FirebaseDatabase;
import com.mukesh.OnOtpCompletionListener;
import com.sarkar.frienzo.Models.Phone;
import com.sarkar.frienzo.Models.User;
import com.sarkar.frienzo.R;
import com.sarkar.frienzo.databinding.ActivityPhoneSignInBinding;
import com.sarkar.frienzo.databinding.ActivitySignInBinding;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

public class PhoneSignInActivity extends AppCompatActivity {
        ActivityPhoneSignInBinding binding;
        FirebaseAuth auth;
        FirebaseDatabase database;
        String verificationId;
        ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityPhoneSignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        dialog= new ProgressDialog(this);
        dialog.setMessage("Sending OTP...");
        dialog.setCancelable(false);
        dialog.show();

        String phoneNumber = getIntent().getStringExtra("phoneNumber");
        binding.phoneLbl.setText("Verify " + phoneNumber);
        PhoneAuthOptions options = PhoneAuthOptions.newBuilder(auth)
                .setPhoneNumber(phoneNumber)
                .setTimeout(60L , TimeUnit.SECONDS)
                .setActivity(PhoneSignInActivity.this)
                .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                    }

                    @Override
                    public void onVerificationFailed(@NonNull FirebaseException e) {

                    }

                    @Override
                    public void onCodeSent(@NonNull String verifyId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        super.onCodeSent(verifyId, forceResendingToken);
                        dialog.dismiss();
                        verificationId = verifyId;

                        binding.otpView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                InputMethodManager imm = (InputMethodManager)   getSystemService(Context.INPUT_METHOD_SERVICE);
                                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
                                binding.otpView.requestFocus();
                            }
                        });
                    }
                }).build();

        PhoneAuthProvider.verifyPhoneNumber(options);

        binding.otpView.setOtpCompletionListener(new OnOtpCompletionListener() {
            @Override
            public void onOtpCompleted(String otp) {
                PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, otp);

                auth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
//                            Intent intent = new Intent(PhoneSignInActivity.this, MainActivity.class);
//                            startActivity(intent);
//                            finishAffinity();
                            String uid = auth.getUid();
                            String phoneNumber1 = auth.getCurrentUser().getPhoneNumber();
                            Phone phone = new Phone(uid , phoneNumber1);
                            database.getReference()
                                    .child("users")
                                    .child(uid)
                                    .setValue(phone)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void unused) {
                                            Intent intent = new Intent(PhoneSignInActivity.this, SetProfileActivity.class);
                                            startActivity(intent);
                                            finishAffinity();

                                        }
                                    });

                        } else {
                            Toast.makeText(PhoneSignInActivity.this, "Failed.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });





    }
}