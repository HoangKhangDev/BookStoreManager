package com.rin1903.bookstoremanager.Adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ChiTietHoaDonAdapter {
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_ten,tv_gia;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
