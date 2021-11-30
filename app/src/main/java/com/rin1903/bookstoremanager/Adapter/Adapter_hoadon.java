package com.rin1903.bookstoremanager.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.rin1903.bookstoremanager.MainActivity;
import com.rin1903.bookstoremanager.R;
import com.rin1903.bookstoremanager.SQLite.HOADON;
import com.rin1903.bookstoremanager.SQLite.KHACHHANG;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class Adapter_hoadon extends BaseAdapter {
    private Context context;
    private int Layout;
    private ArrayList<HOADON> arrayList;

    public Adapter_hoadon(Context context, int layout, ArrayList<HOADON> arrayList) {
        this.context = context;
        Layout = layout;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private static class ViewHoler{
        TextView tv_tieude;
        TextView tv_mota;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHoler holer;
        if(convertView==null){
            holer=new ViewHoler();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView= inflater.inflate(Layout,null);
            holer.tv_tieude= convertView.findViewById(R.id.tv_item_khongcohinh_hienthi);
            holer.tv_mota= convertView.findViewById(R.id.tv_item_mota_khongcohinh_hienthi);
            convertView.setTag(holer);
        }
        else {
            holer= (ViewHoler) convertView.getTag();
        }
        HOADON hoadon= arrayList.get(position);
        holer.tv_tieude.setText(hoadon.getMAHOADON());
        holer.tv_mota.setText("Ngày Lập: "+hoadon.getNGAY_HD());

        return convertView;

    }
}
