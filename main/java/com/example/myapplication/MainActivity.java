package com.example.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    EditText editText_otp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_otp = findViewById(R.id.editText_otp );
        requestPermissions();

        new OTPReceiver().setEditText_otp(editText_otp);

    }

    private void requestPermissions(){
        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.RECEIVE_SMS)
        != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                    Manifest.permission.RECEIVE_SMS
            },100);
        }
    }

    public void Submit(View vw){
        Toast.makeText(getApplicationContext(),"Hello Rajesh",Toast.LENGTH_SHORT).show();
    }

    public void mySubmit(View view){
//        String str1 = "null";
//        EditText txtname = findViewById(R.id.editTextTextPersonName);
//        str1 = txtname.getText().toString();
//        Intent telegramIntent = new Intent( Intent.ACTION_SEND);
//        telegramIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        telegramIntent.setData(Uri.parse("http://telegram.me/+1373818799"));
//        final String appName = "org.telegram.messenger";
//        telegramIntent.setPackage(appName);
//        telegramIntent.putExtra(Intent.EXTRA_TEXT, "Hello");
//        this.startActivity(telegramIntent);
//
        String str1 = "Message Sent";
        Toast.makeText(getApplicationContext(),str1,Toast.LENGTH_LONG).show();

    }
    }