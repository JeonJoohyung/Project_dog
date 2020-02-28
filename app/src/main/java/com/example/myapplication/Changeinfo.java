package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.JsonArray;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;


public class Changeinfo  extends AppCompatActivity
{
    static EditText editTextId;
    static EditText editTextPw;
    static EditText editTextName;
    static EditText editTextAge;
    static EditText editTextDogName;
    static EditText editTextDogAge;
    static EditText editTextKind;
    static Handler mHandler;
    static String User_id;
    static String User_password;
    static String id ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changeinfo);
        Intent intent = getIntent();
        Bundle extras = this.getIntent().getExtras();
        id = extras.getString("ID");
        Toast.makeText(Changeinfo.this,id,Toast.LENGTH_LONG).show();

        editTextId=(EditText) findViewById(R.id.email_edit_CI);
        editTextPw=(EditText) findViewById(R.id.password_edit_CI);
        editTextName=(EditText) findViewById(R.id.name_edit_CI);
        editTextAge = (EditText)findViewById(R.id.age_edit_CI);
        editTextDogName =(EditText) findViewById(R.id.dogname_edit_CI);
        editTextDogAge = (EditText) findViewById(R.id.dogage_edit_CI);
        editTextKind = (EditText) findViewById(R.id.kind_edit_CI);

        if(id != null){
            ChangeinfoMysql ChiM = new ChangeinfoMysql(id);
            ChangeinfoMysql.active = true;
            ChiM.start();
        }
    }

    static public void set_text(String pw, String name, String age) {
        editTextId.setText(id);
        editTextPw.setText(pw);
        editTextName.setText(name);
        editTextAge.setText(age);
    }
}