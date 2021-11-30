package com.rin1903.bookstoremanager.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.rin1903.bookstoremanager.R;
import com.rin1903.bookstoremanager.SQLite.KHACHHANG;
import com.rin1903.bookstoremanager.SQLite.NHACUNGCAP;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class Adapte_nhacungcap extends BaseAdapter {
    private Context context;
    private int Layout;
    private ArrayList<NHACUNGCAP> nhacungcapArrayList;

    public Adapte_nhacungcap(Context context, int layout, ArrayList<NHACUNGCAP> nhacungcapArrayList) {
        this.context = context;
        Layout = layout;
        this.nhacungcapArrayList = nhacungcapArrayList;
    }

    @Override
    public int getCount() {
        return nhacungcapArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return nhacungcapArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private static class ViewHoler{
        TextView tv_tieude;
        TextView tv_mota;
        CircleImageView img_hinh;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHoler holer;
        if(convertView==null){
            holer=new ViewHoler();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView= inflater.inflate(Layout,null);
            holer.tv_tieude= convertView.findViewById(R.id.tv_tieude_item_cohinh_listview_hienthi);
            holer.tv_mota= convertView.findViewById(R.id.tv_mota_item_cohinh_listview_hienthi);
            holer.img_hinh=convertView.findViewById(R.id.image_item_cohinh_list_hienthi);
            convertView.setTag(holer);
        }
        else {
            holer= (ViewHoler) convertView.getTag();
        }
        NHACUNGCAP nhacungcap= nhacungcapArrayList.get(position);
        holer.tv_tieude.setText(nhacungcap.getTENNHACUNGCAP());
        holer.tv_mota.setText(nhacungcap.getSDT_NCC());
        //decode byte to image
        byte[] hinh = nhacungcap.getHINH_NHACUNGCAP();
        Bitmap bitmap = BitmapFactory.decodeByteArray(hinh,0,hinh.length);
        holer.img_hinh.setImageBitmap(bitmap);

        return convertView;

    }
}
