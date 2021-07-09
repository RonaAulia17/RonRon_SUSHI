package com.example.ronronsushi;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class OutletActivity extends MainActivity {
    TextView namapembeli;
    TextView namaoutlet;
    public String np;
    String no;
    String nalamat;
    private ImageView peta;



    public void onCreate(Bundle savedInstanceStates){
        super.onCreate(savedInstanceStates);
        setContentView(R.layout.outlet_pilih);
        namapembeli=findViewById(R.id.Nama_outlet);
        namaoutlet=findViewById(R.id.Tampil_outlet1);

        np = getIntent().getExtras().getString("Nama",nama_pembeli);
        no = getIntent().getExtras().getString("Outlet",nama_outlet);
        nalamat = getIntent().getExtras().getString("Alamat",alamat_pembeli);
        namapembeli.setText(np);
        namaoutlet.setText(no);

        Button PESAN = (Button) findViewById(R.id.tombolpesan);
        PESAN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent UIdaftarmenu = new Intent(OutletActivity.this, DaftarMenuActivity.class);
                UIdaftarmenu.putExtra("Nama", np);
                UIdaftarmenu.putExtra("Alamat", nalamat);
                startActivity(UIdaftarmenu);
            }
        });

        peta = (ImageView) findViewById(R.id.tombollokasi);
        peta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(no.equals("Grand Metropolitan")){
                    Intent buka_peta = new Intent(Intent.ACTION_VIEW);
                    buka_peta.setData(Uri.parse("geo:-6.2494237,106.98122"));
                    Intent chooser = Intent.createChooser(buka_peta,"Cari Lokasi");
                    startActivity(chooser);
                }
                else{
                    Intent buka_peta = new Intent(Intent.ACTION_VIEW);
                    buka_peta.setData(Uri.parse("geo:-6.2261276,106.9988877"));
                    Intent chooser = Intent.createChooser(buka_peta,"Cari Lokasi");
                    startActivity(chooser);
                }

            }

        });







    }
}
