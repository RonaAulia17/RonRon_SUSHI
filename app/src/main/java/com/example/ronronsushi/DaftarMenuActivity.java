package com.example.ronronsushi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DaftarMenuActivity extends MainActivity {

    private ImageView pilihonigiri;
    private ImageView pilihsashimi;
    private ImageView pilihroll;
    private ImageView cart;
    private CheckBox  c1, c2, c3;

    TextView namapembeli2;
    String np2;
    String na2;

    @Override
    public void onCreate(Bundle savedInstanceStates) {
        super.onCreate(savedInstanceStates);
        setContentView(R.layout.daftar_menu);

        namapembeli2 = findViewById(R.id.Nama_menu);
        np2 = getIntent().getExtras().getString("Nama",nama_outlet);

        namapembeli2.setText(np2);
        na2 = getIntent().getExtras().getString("Alamat",alamat_pembeli);

        c1 = findViewById(R.id.checkBox);
        c2 = findViewById(R.id.checkBox2);
        c3 = findViewById(R.id.checkBox3);
        ArrayList <String> menupilihan = new ArrayList<>();
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c1.isChecked()){
                    menupilihan.add("ONIGIRI");
                    Toast.makeText(getApplicationContext(), "ONIGIRI dipilih", Toast.LENGTH_SHORT).show(); }
                 else{
                    menupilihan.remove("ONIGIRI");}
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c2.isChecked()){
                    menupilihan.add("TUNA SASHIMI");
                    Toast.makeText(getApplicationContext(), "TUNA SASHIMI dipilih", Toast.LENGTH_SHORT).show();}
                else{
                    menupilihan.remove("TUNA SASHIMI");}

            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c3.isChecked()){
                    menupilihan.add("TUNA ROLL");
                    Toast.makeText(getApplicationContext(), "TUNA ROLL dipilih", Toast.LENGTH_SHORT). show();}
                    else{
                        menupilihan.remove("TUNA ROLL");}
            }
        });

        cart = (ImageView) findViewById(R.id.kart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent UIorder = new Intent(DaftarMenuActivity.this,OrderActivity.class);
                UIorder.putExtra("Nama", np2);
                UIorder.putExtra("Alamat", na2);

                if (c1.isChecked() || c2.isChecked() || c3.isChecked()){

                    UIorder.putExtra("menuchecked", menupilihan);
                    startActivity(UIorder);}
                else{
                    Toast.makeText(getApplicationContext(), "Harap Pilih Menu", Toast.LENGTH_SHORT). show();}

            }
        });

        pilihonigiri = (ImageView) findViewById(R.id.fotoonigiri);
        pilihonigiri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Nasi hangat dengan isian nikmat disertai rumput laut kualitas terbaik",Toast.LENGTH_LONG).show();
            }
        });
        pilihsashimi = (ImageView) findViewById(R.id.fotosalmon);
        pilihsashimi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Fillet tuna pilihan dari laut dalam 100% fresh dan higienis",Toast.LENGTH_LONG).show();
            }
        });
        pilihroll = (ImageView) findViewById(R.id.fotoroll);
        pilihroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Tuna roll kombinasi daging tuna isian dan balutan rumput laut racikan chef Jepang",Toast.LENGTH_LONG).show();
            }
        });




    }

}

