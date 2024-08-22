package com.example.btl_ddnc.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.btl_ddnc.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class BaseActivity extends AppCompatActivity {
public FirebaseAuth mAuth;
 public FirebaseDatabase database;
  public  String TAG = "HDT";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mAuth  =FirebaseAuth.getInstance();
        database =FirebaseDatabase.getInstance();
    }
}