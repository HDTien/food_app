package com.example.btl_ddnc.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.btl_ddnc.R;
import com.example.btl_ddnc.databinding.ActivityLoginBinding;
import com.example.btl_ddnc.databinding.ActivityTrangChuBinding;

public class TrangChuActivity extends BaseActivity {
ActivityTrangChuBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTrangChuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setVariable();
    }
    private void setVariable() {
        binding.btnThemHs.setOnClickListener(v -> startActivity(new Intent(TrangChuActivity.this, ThemHSActivity.class)));
        binding.btnxemDS.setOnClickListener(v -> startActivity(new Intent(TrangChuActivity.this, DanhSachActivity.class)));

    }
}