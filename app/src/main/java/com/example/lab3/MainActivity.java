package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtSearch;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Trương Huỳnh Đức - Lab3");
        edtSearch = findViewById(R.id.edtSearch);
        recyclerView = findViewById(R.id.rclRecycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String search = edtSearch.getText().toString().trim();
        GetLoader getLoader = new GetLoader(recyclerView,this);
        getLoader.execute(search);
    }

    public void btnResult(View view) {
        String search = edtSearch.getText().toString().trim();
        GetLoader getLoader = new GetLoader(recyclerView,this);
        getLoader.execute(search);
    }
}