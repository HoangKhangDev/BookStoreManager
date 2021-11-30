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
import com.rin1903.bookstoremanager.SQLite.TACGIA;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class Adapter_tacgia extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<TACGIA> tacgiaArrayList;

    public Adapter_tacgia(Context context, int layout, ArrayList<TACGIA> tacgiaArrayList) {
        this.context = context;
        this.layout = layout;
        this.tacgiaArrayList = tacgiaArrayList;
    }

    @Override
    public int getCount() {
        return tacgiaArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return tacgiaArrayList.get(position);
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
            convertView= inflater.inflate(layout,null);
            holer.tv_tieude= convertView.findViewById(R.id.tv_tieude_item_cohinh_listview_hienthi);
            holer.tv_mota= convertView.findViewById(R.id.tv_mota_item_cohinh_listview_hienthi);
            holer.img_hinh=convertView.findViewById(R.id.image_item_cohinh_list_hienthi);
            convertView.setTag(holer);
        }
        else {
            holer= (ViewHoler) convertView.getTag();
        }
        TACGIA tacgia= tacgiaArrayList.get(position);
        holer.tv_tieude.setText(tacgia.getTENTACGIA());
        holer.tv_mota.setText(tacgia.getNGAYSINH_TG());
        //decode byte to image
        byte[] hinh = tacgia.getHINH_TACGIA();
        Bitmap bitmap = BitmapFactory.decodeByteArray(hinh,0,hinh.length);
        holer.img_hinh.setImageBitmap(bitmap);

        return convertView;

    }
}
