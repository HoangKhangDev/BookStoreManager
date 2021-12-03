package com.rin1903.bookstoremanager.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.rin1903.bookstoremanager.Extension.CaptureAct;
import com.rin1903.bookstoremanager.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Fragment_TaoHoaDon extends Fragment {
    Unbinder unbinder;
    @BindView(R.id.btn_huy_fragment_taohoadon)
    Button btn_huy;
    @BindView(R.id.btn_thanhtoan_fragment_taohoadon) Button btn_thanhtoan;
    @BindView(R.id.image_themsach_taohoadon)
    ImageView img_themsachtheospinner;
    @BindView(R.id.img_quetsach_fragment_taohoadon) ImageView img_quetmahoadon;
    @BindView(R.id.image_khachhang_taohoadon) ImageView img_quetmakhachhang;
    @BindView(R.id.tv_thanhtien_fragment_taohoadon)
    TextView tv_thanhtien;
    @BindView(R.id.tv_tensach_taohoadon) TextView tv_tensach;
    @BindView(R.id.tv_tenkhachhang_taohoadon) TextView tv_tenkhachhang;
    @BindView(R.id.recycleview_fragment_taohoadon)
    RecyclerView recyclerView_thongtinhoadon;
    @BindView(R.id.spinner_makhachhang_taohoadon)
    Spinner spinner_makhachhang;
    @BindView(R.id.spinner_masach_taohoadon) Spinner spinner_masach;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_taohoadon,container,false);
        unbinder = ButterKnife.bind(this,view);
        img_quetmahoadon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scancode();
            }
        });
        return view;
    }
    public void scancode(){
        IntentIntegrator integrator= new IntentIntegrator(getActivity());
        integrator.setCaptureActivity(CaptureAct.class);
        integrator.setOrientationLocked(false);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        integrator.setPrompt("Scanning ...");
        integrator.initiateScan();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result= IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(result.getContents()!=null) {
            Toast.makeText(getActivity(), ""+result.getContents(), Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}
