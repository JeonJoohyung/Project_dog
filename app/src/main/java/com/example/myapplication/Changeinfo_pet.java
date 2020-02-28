package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class Changeinfo_pet extends AppCompatActivity {

    String id ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changeinfo);
        Intent intent = getIntent();
        id = intent.getStringExtra("ID");
        Toast.makeText(Changeinfo_pet.this,id,Toast.LENGTH_LONG).show();


    }
}