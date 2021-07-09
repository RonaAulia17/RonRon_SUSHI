package com.example.ronronsushi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class OrderActivity extends MainActivity {
    TextView infonama, infoaalamat, infomakanan, resi_;
    String in, ia;
    RadioGroup RK;
    RadioButton k1, k2, k3;
    ImageView K;
    public void onCreate(Bundle savedInstanceStates){
        super.onCreate(savedInstanceStates);
        setContentView(R.layout.detail_pesanan);

        infonama = findViewById(R.id.Pemesan);
        in = getIntent().getExtras().getString("Nama",nama_outlet);
        infonama.setText(in);

        infoaalamat = findViewById(R.id.Alamattuju);
        ia = getIntent().getExtras().getString("Alamat",alamat_pembeli);
        infoaalamat.setText(ia);

        infomakanan = findViewById(R.id.Makananpesan);
        Bundle bundle = getIntent().getExtras();
        ArrayList <String> array_list = (ArrayList<String>) getIntent().getSerializableExtra("menuchecked");
        infomakanan.setText(String.valueOf(array_list));
        ArrayList <String> ik = new ArrayList<>();

        RK = findViewById(R.id.radio_group);
        k1 = findViewById(R.id.Kirim1);
        k2 = findViewById(R.id.Kirim2);
        k3 = findViewById(R.id.Kirim3);
        k1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (k1.isChecked()){
                    Toast.makeText(getApplicationContext(), "Self Take dipilih", Toast.LENGTH_SHORT).show();
                    k1.setEnabled(false);
                    k2.setEnabled(false);
                    k3.setEnabled(false);
                    ik.add("Self Take, Langsung ambil aja");
                    ik.remove("RonRon Go\nTunggu dulu ya, nggak sampai 1 jam kok");
                    ik.remove("Go atau Grab Food\nTunggu dulu ya, nggak sampai 2 jam kok");
                }

            }
        });
        k2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (k2.isChecked()){
                    Toast.makeText(getApplicationContext(), "RonRon Go dipilih", Toast.LENGTH_SHORT).show();
                    k1.setEnabled(false);
                    k2.setEnabled(false);
                    k3.setEnabled(false);
                    ik.add("RonRon Go\nTunggu dulu ya, nggak sampai 1 jam kok");
                    ik.remove("Self Take, Langsung ambil aja");
                    ik.remove("Go atau Grab Food\nTunggu dulu ya, nggak sampai 2 jam kok");
                }

            }
        });
        k3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (k3.isChecked()){
                    Toast.makeText(getApplicationContext(), "Go atau Grab Food dipilih", Toast.LENGTH_SHORT).show();
                    k1.setEnabled(false);
                    k2.setEnabled(false);
                    k3.setEnabled(false);
                    ik.add("Go atau Grab Food\nTunggu dulu ya, nggak sampai 2 jam kok");
                    ik.remove("Self Take, Langsung ambil aja");
                    ik.remove("RonRon Go Tunggu dulu ya, nggak sampai 1 jam kok");
                }

            }
        });

        K = findViewById(R.id.KIRIM1);
        resi_ = findViewById(R.id.resi);
        String namaresi = infonama.getText().toString();
        String makananresi = infomakanan.getText().toString();
        K.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if (k1.isChecked()||k2.isChecked()||k3.isChecked()){
                    resi_.setText("-ありがとう-\nTerima kasih, "+namaresi+" telah memesan\n"+makananresi+"\nMode Pengiriman :\n"+ik);
                    k1.setEnabled(false);
                    k2.setEnabled(false);
                    k3.setEnabled(false);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Harap Piliih Mode Pengiriman", Toast.LENGTH_SHORT).show();
                }

            }
        });




    }
}
