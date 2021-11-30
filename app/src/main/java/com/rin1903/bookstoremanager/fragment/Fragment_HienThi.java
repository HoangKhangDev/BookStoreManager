package com.rin1903.bookstoremanager.fragment;

import static com.rin1903.bookstoremanager.MainActivity.Tag;
import static com.rin1903.bookstoremanager.MainActivity.database;
import static com.rin1903.bookstoremanager.MainActivity.dulieu;
import static com.rin1903.bookstoremanager.MainActivity.hoadonArrayList;
import static com.rin1903.bookstoremanager.MainActivity.khachhangArrayList;
import static com.rin1903.bookstoremanager.MainActivity.nhacungcapArrayList;
import static com.rin1903.bookstoremanager.MainActivity.refesh_khachhang;
import static com.rin1903.bookstoremanager.MainActivity.refesh_nhacungcap;
import static com.rin1903.bookstoremanager.MainActivity.refesh_sach;
import static com.rin1903.bookstoremanager.MainActivity.refesh_tacgia;
import static com.rin1903.bookstoremanager.MainActivity.refesh_theloai;
import static com.rin1903.bookstoremanager.MainActivity.sachArrayList;
import static com.rin1903.bookstoremanager.MainActivity.tacgiaArrayList;
import static com.rin1903.bookstoremanager.MainActivity.theloaiArrayList;

import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.rin1903.bookstoremanager.Adapter.Adapte_nhacungcap;
import com.rin1903.bookstoremanager.Adapter.Adapter_hoadon;
import com.rin1903.bookstoremanager.Adapter.Adapter_khachhang;
import com.rin1903.bookstoremanager.Adapter.Adapter_sach;
import com.rin1903.bookstoremanager.Adapter.Adapter_tacgia;
import com.rin1903.bookstoremanager.Adapter.Adapter_theloai;
import com.rin1903.bookstoremanager.MainActivity;
import com.rin1903.bookstoremanager.R;
import com.rin1903.bookstoremanager.SQLite.KHACHHANG;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Fragment_HienThi extends Fragment{
    Unbinder unbinder;

    @BindView(R.id.listview_fragment_hienthi) ListView lv_hienthi;
    @BindView(R.id.tv_tenhienthi_fragment_hienthi) TextView tv_tenhienthi;
    @BindView(R.id.button_float_add_fragment_hienthi) FloatingActionButton btn_add;
    @BindView(R.id.back_fragment_hienthi) ImageView img_back;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hienthi,container,false);
        Tag= Fragment_HienThi.class.getName();
        unbinder=ButterKnife.bind(this,view);

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager= getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                Fragment_Main_Menu fragment_menu= new Fragment_Main_Menu();
                fragmentTransaction.replace(R.id.fragment_content,fragment_menu);
                fragmentTransaction.commit();
            }
        });





        Bundle bundle= getArguments();
        //loadlistview
        if(bundle!=null){
            dulieu=bundle.getString("guidulieu").split("-");
            tv_tenhienthi.setText(dulieu[1]);


            if(dulieu[1].toLowerCase().contains("thể loại")){
                refesh_theloai();

                if (theloaiArrayList.size()==0){
                    Dialog dialog = new Dialog(getActivity());
                    dialog.setContentView(R.layout.dialog_list_null);

                    Button btn= dialog.findViewById(R.id.btn_ok_dialog_list_null);

                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.cancel();
                        }
                    });
                    dialog.show();
                }
                else {
                    refesh_lv_theloai();
                }

            }
            else if (dulieu[1].toLowerCase().contains("khách hàng")){
                refesh_khachhang();
                if (khachhangArrayList.size()==0){
                    Dialog dialog = new Dialog(getActivity());
                    dialog.setContentView(R.layout.dialog_list_null);

                    Button btn= dialog.findViewById(R.id.btn_ok_dialog_list_null);

                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.cancel();
                        }
                    });
                    dialog.show();
                }
                else {
                    refesh_lv_khachhang();
                }
            }
            else if (dulieu[1].toLowerCase().contains("sách")){
                refesh_sach();
                if (sachArrayList.size()==0){
                    Dialog dialog = new Dialog(getActivity());
                    dialog.setContentView(R.layout.dialog_list_null);

                    Button btn= dialog.findViewById(R.id.btn_ok_dialog_list_null);

                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.cancel();
                        }
                    });
                    dialog.show();
                }
                else {
                    refesh_lv_sach();
                }
            }
            else if (dulieu[1].toLowerCase().contains("nhà cung cấp")){
                refesh_nhacungcap();
                if (sachArrayList.size()==0){
                    Dialog dialog = new Dialog(getActivity());
                    dialog.setContentView(R.layout.dialog_list_null);

                    Button btn= dialog.findViewById(R.id.btn_ok_dialog_list_null);

                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.cancel();
                        }
                    });
                    dialog.show();
                }
                else {
                    refesh_lv_nhacungcap();
                }
            }
            else if (dulieu[1].toLowerCase().contains("sách")){
                refesh_sach();
                if (sachArrayList.size()==0){
                    Dialog dialog = new Dialog(getActivity());
                    dialog.setContentView(R.layout.dialog_list_null);

                    Button btn= dialog.findViewById(R.id.btn_ok_dialog_list_null);

                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.cancel();
                        }
                    });
                    dialog.show();
                }
                else {
                    refesh_lv_sach();
                }
            }
            else if (dulieu[1].toLowerCase().contains("hoá đơn")){
                refesh_sach();
                if (sachArrayList.size()==0){
                    Dialog dialog = new Dialog(getActivity());
                    dialog.setContentView(R.layout.dialog_list_null);

                    Button btn= dialog.findViewById(R.id.btn_ok_dialog_list_null);

                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.cancel();
                        }
                    });
                    dialog.show();
                }
                else {
                    refesh_lv_hoadon();
                }
            }
            else if (dulieu[1].toLowerCase().contains("thể loại")){
                refesh_sach();
                if (sachArrayList.size()==0){
                    Dialog dialog = new Dialog(getActivity());
                    dialog.setContentView(R.layout.dialog_list_null);

                    Button btn= dialog.findViewById(R.id.btn_ok_dialog_list_null);

                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.cancel();
                        }
                    });
                    dialog.show();
                }
                else {
                    refesh_lv_theloai();
                }
            }
            else if (dulieu[1].toLowerCase().contains("tác giả")){
                refesh_tacgia();
                if (tacgiaArrayList.size()==0){
                    Dialog dialog = new Dialog(getActivity());
                    dialog.setContentView(R.layout.dialog_list_null);

                    Button btn= dialog.findViewById(R.id.btn_ok_dialog_list_null);

                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.cancel();
                        }
                    });
                    dialog.show();
                }
                else {
                    refesh_lv_tacgia();
                }
            }
        }



        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dulieu[1].toLowerCase().contains("khách hàng")){
                    Bundle bundle1= new Bundle();
                    bundle1.putString("guidulieu","tao-Khách Hàng");
                    Fragment_KhachHang fragment_khachhang=new Fragment_KhachHang();
                    fragment_khachhang.setArguments(bundle1);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_content,fragment_khachhang).addToBackStack(Tag).commit();
                }
                else if(dulieu[1].toString().toLowerCase().contains("thể loại"))
                {
                    Dialog dialog= new Dialog(getActivity());
                    dialog.setContentView(R.layout.dialog_theloai);

                    EditText edt_tenloai= (EditText) dialog.findViewById(R.id.edt_tenloaisach_theloai);
                    Button btn_update_add = (Button) dialog.findViewById(R.id.btn_them_theloai);
                    Button btn_update_huy = (Button) dialog.findViewById(R.id.btn_huy_theloai);

                    btn_update_add.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(!edt_tenloai.getText().toString().isEmpty()){
                                if(theloaiArrayList.size()==0){
                                    database.INSERT_THELOAI("LS-1",edt_tenloai.getText().toString());
                                    Toast.makeText(getActivity(), "Thêm Loại "+edt_tenloai.getText().toString()+" Thành Công", Toast.LENGTH_SHORT).show();
                                    edt_tenloai.setText(null);
                                    dialog.cancel();
                                }
                                else {
                                    int so = theloaiArrayList.size()-1;
                                   String[] tach= theloaiArrayList.get(so).getMALOAI().split("-");
                                    so= Integer.parseInt(tach[1])+1;
                                    database.INSERT_THELOAI("LS-"+String.valueOf(so),edt_tenloai.getText().toString());
                                    Toast.makeText(getActivity(), "Thêm Loại "+edt_tenloai.getText().toString()+" Thành Công", Toast.LENGTH_SHORT).show();
                                   dialog.cancel();

                                }
                            }
                                    }
                                });
                                btn_update_huy.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        dialog.cancel();
                                    }
                                });

                                dialog.show();

                            }
                else if(dulieu[1].toString().toLowerCase().contains("hoá đơn")){
                    Bundle bundle1= new Bundle();
                    bundle1.putString("guidulieu","tao-Hoá Đơn");
                    Fragment_TaoHoaDon fragment=new Fragment_TaoHoaDon();
                    fragment.setArguments(bundle1);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_content,fragment).addToBackStack(Tag).commit();
                }
                else if(dulieu[1].toString().toLowerCase().contains("sách")){
                    Bundle bundle1= new Bundle();
                    bundle1.putString("guidulieu","tao-Sách");
                    Fragment_Sach fragment_sach= new Fragment_Sach();
                    fragment_sach.setArguments(bundle1);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_content,fragment_sach).addToBackStack(Tag).commit();
                }
                else if(dulieu[1].toString().toLowerCase().contains("tác giả")){
                    Bundle bundle1= new Bundle();
                    bundle1.putString("guidulieu","tao-Tác Giả-ok");
                    Fragment_TacGia fragment=new Fragment_TacGia();
                    fragment.setArguments(bundle1);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_content,fragment).addToBackStack(Tag).commit();

                }
                else if(dulieu[1].toString().toLowerCase().contains("nhà cung cấp")){
                    Bundle bundle1= new Bundle();
                    bundle1.putString("guidulieu","tao-Nhà Cung Cấp");
                    fragment_nhacungcap fragment=new fragment_nhacungcap();
                    getFragmentManager().beginTransaction().replace(R.id.fragment_content,fragment).addToBackStack(Tag).commit();
                }
            }
        });


        lv_hienthi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        });

        return view;
    }
    public void refesh_lv_theloai(){
        refesh_theloai();
        Adapter_theloai adapter_theloai;
        adapter_theloai= new Adapter_theloai((MainActivity) getActivity(),R.layout.item_hienthi_khongcohinh,theloaiArrayList);
        lv_hienthi.setAdapter(adapter_theloai);
        adapter_theloai.notifyDataSetChanged();
    }
    public void refesh_lv_khachhang(){
        refesh_khachhang();
        Adapter_khachhang adapter_khachhang;
        adapter_khachhang= new Adapter_khachhang((MainActivity) getActivity(),R.layout.item_list_hienthi_cohinh,khachhangArrayList);
        lv_hienthi.setAdapter(adapter_khachhang);
        adapter_khachhang.notifyDataSetChanged();
    }
    public void refesh_lv_tacgia(){
        refesh_tacgia();
        Adapter_tacgia adapter;
        adapter= new Adapter_tacgia((MainActivity) getActivity(),R.layout.item_list_hienthi_cohinh,tacgiaArrayList);
        lv_hienthi.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    public void refesh_lv_sach(){
        refesh_sach();
        Adapter_sach adapter;
        adapter= new Adapter_sach((MainActivity) getActivity(),R.layout.item_list_hienthi_cohinh,sachArrayList);
        lv_hienthi.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    public void refesh_lv_nhacungcap(){
        refesh_nhacungcap();
        Adapte_nhacungcap adapter;
        adapter= new Adapte_nhacungcap((MainActivity) getActivity(),R.layout.item_list_hienthi_cohinh,nhacungcapArrayList);
        lv_hienthi.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    public void refesh_lv_hoadon(){
        refesh_lv_hoadon();
        Adapter_hoadon adapter;
        adapter= new Adapter_hoadon((MainActivity) getActivity(),R.layout.item_hienthi_khongcohinh,hoadonArrayList);
        lv_hienthi.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}
