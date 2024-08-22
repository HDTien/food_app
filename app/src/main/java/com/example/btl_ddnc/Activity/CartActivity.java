package com.example.btl_ddnc.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.btl_ddnc.Adapter.CartAdapter;
import com.example.btl_ddnc.Helper.ManagmentCart;
import com.example.btl_ddnc.R;
import com.example.btl_ddnc.databinding.ActivityCartBinding;

public class CartActivity extends BaseActivity {
    private ActivityCartBinding binding;
    private RecyclerView.Adapter adapter;
    private ManagmentCart managmentCart;
    private double tax;
    private TextView noteTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        managmentCart = new ManagmentCart(this);
        noteTxt =findViewById(R.id.noteTxt);
        setVariable();
        calculateCart();
        initList();
        
    }

    private void initList() {
        if (managmentCart.getListCart().isEmpty()) {
            binding.emptyTxt.setVisibility(View.VISIBLE);
            binding.scrollviewCart.setVisibility(View.GONE);
        } else {
            binding.emptyTxt.setVisibility(View.GONE);
            binding.scrollviewCart.setVisibility(View.VISIBLE);
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.cardView.setLayoutManager(linearLayoutManager);
        adapter = new CartAdapter(managmentCart.getListCart(), this, () -> calculateCart());
        binding.cardView.setAdapter(adapter);
    }

    private void calculateCart() {
        double percentTax = 0.02; //percent 2% tax
        double delivery = 10; // 10 Dollar

//        tax = Math.round(managmentCart.getTotalFee() * percentTax * 100.0) / 100;
//
//        double total = Math.round((managmentCart.getTotalFee() + tax + delivery) * 100) / 100;
//        double itemTotal = Math.round(managmentCart.getTotalFee() * 100) / 100;

        double total = managmentCart.getTotalFee()  ;

//        binding.totalFeeTxt.setText("$" + itemTotal);
//        binding.taxTxt.setText("$" + tax);
//        binding.deliveryTxt.setText("$" + delivery);
        binding.totalTxt.setText("$" + total);
    }

    private void setVariable() {
        binding.backBtn.setOnClickListener(v -> finish());
//        binding.btnbill.setOnClickListener(v -> {
//            String note = noteTxt.getText().toString();
//            Intent intent = new Intent(CartActivity.this, BillActivity.class);
//            intent.putExtra("NOTE_KEY", note);
//            startActivity(intent);
//        });
//        binding.btnbill.setOnClickListener(v -> startActivity(new Intent(this, BillActivity.class)));
        
    }
}