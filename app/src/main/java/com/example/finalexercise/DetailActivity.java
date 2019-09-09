package com.example.finalexercise;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private EditText mName;
    private EditText mUrl;
    private Button btnEdit;
    private Button btnOpenUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mName = findViewById(R.id.text_name_detail);
        mUrl = findViewById(R.id.text_url_detail);
        btnEdit = findViewById(R.id.edit_btn);
        btnOpenUrl = findViewById(R.id.open_url_btn);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String url = intent.getStringExtra("url");

        mName.setText(name);
        mUrl.setText(url);

    }
}
