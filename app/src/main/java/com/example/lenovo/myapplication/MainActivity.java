package com.example.lenovo.myapplication;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button ac;
    Button kapat;
    Button gyap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ac=(Button)findViewById(R.id.ac);
        kapat=(Button)findViewById(R.id.kapa);
        gyap=(Button)findViewById(R.id.gyap);
        final BluetoothAdapter adapter=BluetoothAdapter.getDefaultAdapter();
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(adapter==null){
                    Toast.makeText(MainActivity.this,"Bluetooth aygıtı bulunamadı",Toast.LENGTH_SHORT).show();
                }
                else{
                    if(!adapter.isEnabled()) {
                        Intent bluetoothBaslat = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                        startActivityForResult(bluetoothBaslat, 1);
                        Toast.makeText(MainActivity.this,"BLuetooth Açık",Toast.LENGTH_SHORT).show();

                    }
                    else {adapter.disable();}
                    }
                }
        });
        gyap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gorunurYap = new Intent(adapter.ACTION_REQUEST_DISCOVERABLE);
                startActivityForResult(gorunurYap, 1);
                Toast.makeText(MainActivity.this, "Bluetooth Görünür Hale Geldi", Toast.LENGTH_SHORT).show();
            }
        });
        kapat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!adapter.isEnabled()) {
                } else adapter.disable();
                Toast.makeText(MainActivity.this, "Kapatıldı.", Toast.LENGTH_SHORT).show();
            }

        });

    }
}
