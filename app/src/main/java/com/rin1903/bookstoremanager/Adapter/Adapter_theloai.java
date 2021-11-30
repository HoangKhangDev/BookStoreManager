package com.rin1903.bookstoremanager.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rin1903.bookstoremanager.MainActivity;
import com.rin1903.bookstoremanager.R;
import com.rin1903.bookstoremanager.SQLite.THELOAI;

import java.util.ArrayList;
import java.util.Timer;

public class Adapter_theloai extends BaseAdapter {
    private MainActivity context;
    private int layout;
    private ArrayList<THELOAI> theloaiArrayList;

    public Adapter_theloai(MainActivity context, int layout, ArrayList<THELOAI> theloaiArrayList) {
        this.context = context;
        this.layout = layout;
        this.theloaiArrayList = theloaiArrayList;
    }

    @Override
    public int getCount() {
        return theloaiArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return theloaiArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public static class ViewHolder{
        TextView textView;
        ImageView imageView_delete;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            holder= new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(layout,null);
            holder.textView=(TextView) convertView.findViewById(R.id.tv_item_khongcohinh_hienthi);
            holder.imageView_delete=(ImageView) convertView.findViewById(R.id.img_delete_item_khongcohinh_hienthi);
            convertView.setTag(holder);
        }
        else {
            holder= (ViewHolder) convertView.getTag();
        }
        THELOAI theloai= theloaiArrayList.get(position);
        holder.textView.setText(theloai.getTENLOAI());

        holder.imageView_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.database.DELETE_THELOAI(theloai.getMALOAI());
            }
        });

        return convertView;
    }
}
