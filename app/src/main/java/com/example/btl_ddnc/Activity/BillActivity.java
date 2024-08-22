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
import com.example.btl_ddnc.databinding.ActivityBillBinding;

public class BillActivity extends BaseActivity {
    private ActivityBillBinding binding;
    private RecyclerView.Adapter adapter;
    private ManagmentCart managmentCart;

    private double tax;
    private TextView noteTxtBill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBillBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        managmentCart = new ManagmentCart(this);


        setVariable();
        calculateCart();
        initList();
        getnote();
    }

    private void getnote() {
        noteTxtBill = findViewById(R.id.noteTxt);

        Intent intent = getIntent();
        if (intent != null) {
            String note = intent.getStringExtra("NOTE_KEY");
            if (note != null) {
                noteTxtBill.setText(note);
            }
        }
    }

    private void initList() {
        if (managmentCart.getListCart().isEmpty()) {
            binding.emptyTxt.setVisibility(View.VISIBLE);
            binding.scrollviewCart.setVisibility(View.GONE);
        } else {
            binding.emptyTxt.setVisibility(View.GONE);
            binding.scrollviewCart.setVisibility(View.VISIBLE);
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL, false);
        binding.billView.setLayoutManager(linearLayoutManager);
        adapter = new CartAdapter(managmentCart.getListCart(), this, () -> calculateCart());
        binding.billView.setAdapter(adapter);

    }

    private void calculateCart() {
//        double percentTax = 0.02; //percent 2% tax
//        double delivery = 10; // 10 Dollar
//
//        tax = Math.round(managmentCart.getTotalFee() * percentTax * 100.0) / 100;
//
//        double total = Math.round((managmentCart.getTotalFee() + tax + delivery) * 100) / 100;
//        double itemTotal = Math.round(managmentCart.getTotalFee() * 100) / 100;
//
//        binding.totalFeeTxt.setText("$" + itemTotal);
//        binding.taxTxt.setText("$" + tax);
//        binding.deliveryTxt.setText("$" + delivery);
//        binding.totalTxt.setText("$" + total);

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
//
//            Intent intent=new Intent(this, BillActivity.class);
//            intent.putExtra("object1",managmentCart.getListCart());
//            this.startActivity(intent);
//        });

    }

}