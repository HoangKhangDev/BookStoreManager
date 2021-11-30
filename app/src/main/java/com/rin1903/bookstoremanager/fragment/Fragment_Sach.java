package com.rin1903.bookstoremanager.fragment;

import static android.app.Activity.RESULT_OK;

import static com.rin1903.bookstoremanager.MainActivity.SELECT_PICTURE;
import static com.rin1903.bookstoremanager.MainActivity.Tag;
import static com.rin1903.bookstoremanager.MainActivity.database;
import static com.rin1903.bookstoremanager.MainActivity.refesh_tacgia;
import static com.rin1903.bookstoremanager.MainActivity.refesh_theloai;
import static com.rin1903.bookstoremanager.MainActivity.tacgiaArrayList;
import static com.rin1903.bookstoremanager.MainActivity.theloaiArrayList;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.rin1903.bookstoremanager.MainActivity;
import com.rin1903.bookstoremanager.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Fragment_Sach extends Fragment {
    Unbinder unbinder;
    @BindView(R.id.btn_huy_sach)
    Button btn_huy;
    @BindView(R.id.btn_update_sach) Button btn_update;
    @BindView(R.id.edt_giaban_sach)
    EditText edt_giaban;
    @BindView(R.id.edt_ten_sach) EditText edt_tensach;
    @BindView(R.id.edt_soquyen_sach) EditText edt_soquyen;
    @BindView(R.id.img_add_tacsach_sach)
    ImageView img_add_tacgia;
    @BindView(R.id.img_add_loaisach_sach) ImageView img_add_loaisach;
    @BindView(R.id.img_hinh_sach) ImageView img_sach;
    @BindView(R.id.spinner_tacgia_sach)
    Spinner spinner_tentacgia;
    @BindView(R.id.spinner_tenloaisach_sach) Spinner spinner_tenloaisach;
    @BindView(R.id.img_barcode_sach) ImageView img_barcode;
    @BindView(R.id.img_save_barcode_sach) ImageView img_barcode_save;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_sach,container,false);
        Tag= Fragment_Sach.class.getName();

        unbinder= ButterKnife.bind(this,view);

        reload_loaisach();
        reload_tacgia();

        img_add_tacgia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle1= new Bundle();
                bundle1.putString("guidulieu","tao-Tác Giả-khong co gi");
                Fragment_TacGia fragment=new Fragment_TacGia();
                fragment.setArguments(bundle1);
                getFragmentManager().beginTransaction().replace(R.id.fragment_content,fragment).addToBackStack(Tag).commit();
            }
        });

        img_add_loaisach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog= new Dialog(getActivity());
                dialog.setContentView(R.layout.dialog_theloai);

                EditText edt_tenloai = dialog.findViewById(R.id.edt_tenloaisach_theloai);
                Button btn_them = dialog.findViewById(R.id.btn_them_theloai);
                Button btn_huy = dialog.findViewById(R.id.btn_huy_theloai);
                btn_them.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!edt_tenloai.getText().toString().isEmpty()){
                            if(theloaiArrayList.size()==0){
                                database.INSERT_THELOAI("LS-1",edt_tenloai.getText().toString());
                                Toast.makeText(getActivity(), "Thêm Loại "+edt_tenloai.getText().toString()+" Thành Công", Toast.LENGTH_SHORT).show();
                                edt_tenloai.setText(null);
                                reload_loaisach();
                                dialog.cancel();
                            }
                            else {
                                int so = theloaiArrayList.size()-1;
                                String[] tach= theloaiArrayList.get(so).getMALOAI().split("-");
                                so= Integer.parseInt(tach[1])+1;
                                database.INSERT_THELOAI("LS-"+String.valueOf(so),edt_tenloai.getText().toString());
                                Toast.makeText(getActivity(), "Thêm Loại "+edt_tenloai.getText().toString()+" Thành Công", Toast.LENGTH_SHORT).show();
                                reload_loaisach();
                                dialog.cancel();

                            }
                        }
                    }
                });
                btn_huy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                dialog.show();

            }
        });



        img_sach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageChooser();
            }
        });
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!edt_tensach.getText().toString().isEmpty()&!edt_giaban.getText().toString().isEmpty()
                &!edt_soquyen.getText().toString().isEmpty()&spinner_tentacgia.getSelectedItem().toString()=="Không có tác giả,vui lòng thêm"
                &spinner_tenloaisach.getSelectedItem().toString()=="Không có thể loại,vui lòng thêm"
                        &img_sach.getDrawable()!=getResources().getDrawable(R.drawable.no_pictures)){
                    Toast.makeText(getActivity(), "da thay doi", Toast.LENGTH_SHORT).show();
                }

            }
        });
        btn_huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });
        return view;
    }
    private void taomabarcode(){
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode("code123", BarcodeFormat.CODE_128, img_barcode.getWidth(), img_barcode.getHeight());
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            img_barcode.setImageBitmap(barcodeEncoder.createBitmap(bitMatrix));
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
    void reload_loaisach(){
        refesh_theloai();
        ArrayList<String> list= new ArrayList<>();
        if(theloaiArrayList.size()==0){
            list.add("Không có thể loại,vui lòng thêm");
        }
        else {
            for (int i=0;i<theloaiArrayList.size();i++){
                list.add(theloaiArrayList.get(i).getTENLOAI());
            }
        }
        ArrayAdapter adapter= new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_dropdown_item,list);
        spinner_tenloaisach.setAdapter(adapter);
    }
    void reload_tacgia(){
        refesh_tacgia();
        ArrayList<String> list= new ArrayList<>();
        if(tacgiaArrayList.size()==0){
            list.add("Không có tác giả,vui lòng thêm");
        }
        else {
            for (int i=0;i<tacgiaArrayList.size();i++){
                list.add(tacgiaArrayList.get(i).getTENTACGIA());
            }
        }
        ArrayAdapter adapter= new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_dropdown_item,list);
        spinner_tentacgia.setAdapter(adapter);
    }

    //themhinhanh
    void imageChooser() {

        // create an instance of the
        // intent of the type image
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
    }
    // this function is triggered when user
    // selects the image from the imageChooser
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == SELECT_PICTURE) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    img_sach.setImageURI(selectedImageUri);
                }
            }
        }
    }


}
