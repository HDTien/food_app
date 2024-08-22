package com.example.btl_ddnc.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.btl_ddnc.R;
import  com.example.btl_ddnc.databinding.ActivitySignupBinding;

public class SignupActivity extends BaseActivity {
 ActivitySignupBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setVariable();

    }

    private void setVariable() {
        binding.signupBtn.setOnClickListener(v -> {
            String email = binding.userEdt.getText().toString();
            String password = binding.passEdt.getText().toString();

            if (password.length() < 6) {
                Toast.makeText(SignupActivity.this, "your password must be 6 character", Toast.LENGTH_SHORT).show();
                return;
            }
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignupActivity.this, task -> {
                if (task.isSuccessful()) {
                    Log.i(TAG, "onComplete: ");
                    startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                } else {
                    Log.i(TAG, "failure: " + task.getException());
                    Toast.makeText(SignupActivity.this, "Authentication failed", Toast.LENGTH_SHORT).show();
                }
            });
        });


//        binding.signupBtn.setOnClickListener(v -> {
//            String email = binding.userEdt.getText().toString();
//            String password = binding.passEdt.getText().toString();
//
//            if (password.length() < 6) {
//                Toast.makeText(SignupActivity.this, "Your password must be at least 6 characters", Toast.LENGTH_SHORT).show();
//                return;
//            }
//
//            // Check if password contains both letters and digits
//            if (!containsLetterAndDigit(password)) {
//                Toast.makeText(SignupActivity.this, "Your password must contain both letters and digits", Toast.LENGTH_SHORT).show();
//                return;
//            }
//
//            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignupActivity.this, task -> {
//                if (task.isSuccessful()) {
//                    Log.i(TAG, "onComplete: ");
//                    startActivity(new Intent(SignupActivity.this, LoginActivity.class));
//                } else {
//                    Log.i(TAG, "failure: " + task.getException());
//                    Toast.makeText(SignupActivity.this, "Authentication failed", Toast.LENGTH_SHORT).show();
//                }
//            });
//        });

        binding.btnlogin1.setOnClickListener(v ->startActivity(new Intent(SignupActivity.this,LoginActivity.class)) );

    }

    private boolean containsLetterAndDigit(String str) {
        boolean containsLetter = false;
        boolean containsDigit = false;

        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                containsLetter = true;
            } else if (Character.isDigit(c)) {
                containsDigit = true;
            }

            if (containsLetter && containsDigit) {
                return true;
            }
        }

        return false;
    }


}