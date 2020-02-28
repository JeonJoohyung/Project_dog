package com.example.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;




public class Sub extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sanchack);
        Intent intent = getIntent();

        String lat = intent.getStringExtra("lat");
        String lon = intent.getStringExtra("lon");

        Toast.makeText(this,lat+lon,Toast.LENGTH_LONG).show();
    }


}
