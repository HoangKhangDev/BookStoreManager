package com.rin1903.bookstoremanager.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rin1903.bookstoremanager.R;
import com.rin1903.bookstoremanager.SQLite.PHIEUNHAP;

import java.util.ArrayList;

public class PhieuNhapAdapter extends RecyclerView.Adapter<PhieuNhapAdapter.ViewHolder>{
    private ArrayList<PHIEUNHAP> phieunhapArrayList;
    private Context context;

    public PhieuNhapAdapter(ArrayList<PHIEUNHAP> phieunhapArrayList, Context context) {
        this.phieunhapArrayList = phieunhapArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return phieunhapArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_tieude,tv_mota1,tv_mota2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_tieude= itemView.findViewById(R.id.tv_item_khongcohinh_hienthi);
            tv_mota1=itemView.findViewById(R.id.tv_item_mota1_khongcohinh_hienthi);
        }
    }
}
