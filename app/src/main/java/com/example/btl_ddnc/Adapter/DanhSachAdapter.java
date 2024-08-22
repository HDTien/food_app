package com.example.btl_ddnc.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.btl_ddnc.Domain.Foods;
import com.example.btl_ddnc.Domain.HocSinh;
import com.example.btl_ddnc.R;

import java.util.ArrayList;

public class DanhSachAdapter extends RecyclerView.Adapter<DanhSachAdapter.viewholder>{
    @NonNull
    ArrayList<HocSinh> items;
    Context context;

    public DanhSachAdapter(@NonNull ArrayList<HocSinh> items) {
        this.items = items;
    }

    @Override
    public DanhSachAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_danhsach, parent, false);
        return new DanhSachAdapter.viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull DanhSachAdapter.viewholder holder, int position) {

        holder.titleTxt.setText(items.get(position).getMa());
        holder.priceTxt.setText(items.get(position).getTenHs());
        holder.timeTxt.setText(items.get(position).getDiaChi() );
        holder.starTxt.setText(items.get(position).getNgaySinh());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView titleTxt, priceTxt, starTxt, timeTxt;


        public viewholder(@NonNull View itemView) {
            super(itemView);
            titleTxt = itemView.findViewById(R.id.textViewMaSV);
            priceTxt = itemView.findViewById(R.id.textViewHoTen);
            starTxt = itemView.findViewById(R.id.textViewDiaChi);
            timeTxt = itemView.findViewById(R.id.textViewNgaySinh);


        }
    }
}
