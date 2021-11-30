package com.rin1903.bookstoremanager.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rin1903.bookstoremanager.R;
import com.rin1903.bookstoremanager.SQLite.SACH;

import java.util.ArrayList;

public class Adapter_sach extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<SACH> sachArrayList;

    public Adapter_sach(Context context, int layout, ArrayList<SACH> sachArrayList) {
        this.context = context;
        this.layout = layout;
        this.sachArrayList = sachArrayList;
    }

    @Override
    public int getCount() {
        return sachArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return sachArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private static class ViewHolder{
        TextView tv_tieude,tv_mota;
        ImageView imageView;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            holder= new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(layout,null);
            holder.tv_tieude=(TextView) convertView.findViewById(R.id.tv_tieude_item_cohinh_listview_hienthi);
            holder.tv_mota=(TextView) convertView.findViewById(R.id.tv_mota_item_cohinh_listview_hienthi);
            holder.imageView=(ImageView) convertView.findViewById(R.id.image_item_cohinh_list_hienthi);
            convertView.setTag(holder);
        }
        else {
            holder=(ViewHolder) convertView.getTag();
        }
        SACH sach= sachArrayList.get(position);
        holder.tv_tieude.setText(sach.getTENSACH());
        holder.tv_mota.setText(String.format("Số Lượng :%d", sach.getSOQUYEN()));

        byte[] hinh = sach.getHINH_SACH();
        Bitmap bitmap = BitmapFactory.decodeByteArray(hinh,0,hinh.length);
        holder.imageView.setImageBitmap(bitmap);

        return convertView;
    }
}
