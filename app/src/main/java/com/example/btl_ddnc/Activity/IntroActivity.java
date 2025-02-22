package com.example.btl_ddnc.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.btl_ddnc.R;
import com.example.btl_ddnc.databinding.ActivityIntroBinding;

public class IntroActivity extends BaseActivity {
ActivityIntroBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIntroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setVariable();        
    }

    private void setVariable() {
//        binding.loginBtn.setOnClickListener(v -> {
//            if (mAuth.getCurrentUser() != null) {
//                startActivity(new Intent(IntroActivity.this, MainActivity.class));
//            } else {
//                startActivity(new Intent(IntroActivity.this, LoginActivity.class));
//            }
//        });
        binding.loginBtn.setOnClickListener(v -> startActivity(new Intent(IntroActivity.this,LoginActivity.class)));
        binding.signupBtn.setOnClickListener(v -> startActivity(new Intent(IntroActivity.this, SignupActivity.class)));
    }
}