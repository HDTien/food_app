package com.example.btl_ddnc.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.btl_ddnc.R;
import com.example.btl_ddnc.databinding.ActivityThemHsactivityBinding;
import com.example.btl_ddnc.databinding.ActivityTrangChuBinding;

public class ThemHSActivity extends BaseActivity {
ActivityThemHsactivityBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityThemHsactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}