package com.example.ronronsushi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
public String nama_pembeli;
public String alamat_pembeli;
public String nama_outlet;


EditText n_p;
EditText a_p;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner_outlet = findViewById(R.id.spinner_outlet);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.outlet, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_outlet.setAdapter(adapter);
        spinner_outlet.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);


        //Tombol Submit
        Button SUBMIT = (Button) findViewById(R.id.button);
        n_p = findViewById(R.id.edit_nama);
        a_p = findViewById(R.id.edit_Alamat);
        SUBMIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent UIoutlet = new Intent(MainActivity.this, OutletActivity.class);
                Intent UIdaftarmenu = new Intent(MainActivity.this, DaftarMenuActivity.class);
                Intent UIorder2 = new Intent(MainActivity.this, OrderActivity.class);

                nama_pembeli=n_p.getText().toString();
                alamat_pembeli=a_p.getText().toString();
                nama_outlet=spinner_outlet.getSelectedItem().toString();
                UIoutlet.putExtra("Nama",nama_pembeli);
                UIoutlet.putExtra("Outlet",nama_outlet);
                UIoutlet.putExtra("Alamat", alamat_pembeli);
                UIdaftarmenu.putExtra("Nama", nama_pembeli);
                UIdaftarmenu.putExtra("Alamat", alamat_pembeli);


                startActivity(UIoutlet);
            }

        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id){

    }
    @Override
    public void onNothingSelected(AdapterView<?> parent){}

}