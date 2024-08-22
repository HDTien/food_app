package com.example.btl_ddnc.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.btl_ddnc.Adapter.BestFoodsAdapter;
import com.example.btl_ddnc.Adapter.CategoryAdapter;
import com.example.btl_ddnc.Adapter.DanhSachAdapter;
import com.example.btl_ddnc.Domain.Category;
import com.example.btl_ddnc.Domain.Foods;
import com.example.btl_ddnc.Domain.HocSinh;
import com.example.btl_ddnc.R;
import com.example.btl_ddnc.databinding.ActivityDanhSachBinding;
import com.example.btl_ddnc.databinding.ActivityThemHsactivityBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DanhSachActivity extends BaseActivity {
ActivityDanhSachBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDanhSachBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initHocSinh();
//        initCategory();
    }
    private void initHocSinh() {
        DatabaseReference myRef = database.getReference("SinhVien");

        ArrayList<HocSinh> list = new ArrayList<>();
        myRef.addListenerForSingleValueEvent(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot issue : snapshot.getChildren()) {
                        list.add(issue.getValue(HocSinh.class));
                    }
                    if (list.size() > 0) {
                        binding.DanhSachView.setLayoutManager(new LinearLayoutManager(DanhSachActivity.this, LinearLayoutManager.HORIZONTAL, false));
                        RecyclerView.Adapter adapter = new DanhSachAdapter(list);
                        binding.DanhSachView.setAdapter(adapter);
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void initCategory() {
        DatabaseReference myRef = database.getReference("SinhVien");

        ArrayList<Category> list = new ArrayList<>();

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot issue : snapshot.getChildren()) {
                        list.add(issue.getValue(Category.class));
                    }
                    if (list.size() > 0) {
                        binding.DanhSachView.setLayoutManager(new GridLayoutManager(DanhSachActivity.this, 4));
                        RecyclerView.Adapter adapter = new CategoryAdapter(list);
                        binding.DanhSachView.setAdapter(adapter);
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}