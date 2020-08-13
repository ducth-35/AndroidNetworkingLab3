package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

public class ShowData extends AppCompatActivity {
 WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdetail);
        webView = findViewById(R.id.WedView);
        setTitle("Trương Huỳnh Đức - Lab3");
        Intent intent = getIntent();
        String data= intent.getStringExtra("link");
        webView.loadUrl(data);
    }
}