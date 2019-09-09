package com.example.finalexercise;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalexercise.model.URLData;
import com.example.finalexercise.util.AppDatabase;

public class DetailActivity extends AppCompatActivity {

    private EditText mName;
    private EditText mUrl;
    private Button btnEdit;
    private Button btnOpenUrl;
    private AppDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Detail");

        mDb = AppDatabase.getInstance(getApplicationContext());

        mName = findViewById(R.id.text_name_detail);
        mUrl = findViewById(R.id.text_url_detail);
        btnEdit = findViewById(R.id.edit_btn);
        btnOpenUrl = findViewById(R.id.open_url_btn);

        Intent intent = getIntent();
        final String idString = intent.getStringExtra("id");
        String name = intent.getStringExtra("name");
        String url = intent.getStringExtra("url");

        mName.setText(name);
        mUrl.setText(url);

        //disable edit text
        //mName.setEnabled(false);
        //mUrl.setEnabled(false);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                mName.setEnabled(true);
//                mUrl.setEnabled(true);
//                btnEdit.setText("");

                if(mName.getText().toString().equals("") || mUrl.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"You must fill the textfield!",Toast.LENGTH_SHORT).show();
                }
                else{
                    int id = Integer.parseInt(idString);
                    String nama = mName.getText().toString();
                    String url = mUrl.getText().toString();
                    URLData urlData = new URLData(nama,url);
                    urlData.setId(id);
                    mDb.urlDao().updateData(urlData);
                    finish();
                }

            }
        });

        btnOpenUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openUrlIntent = new Intent(getApplicationContext(),WebViewActivity.class);
                openUrlIntent.putExtra("url",mUrl.getText().toString());
                startActivity(openUrlIntent);
            }
        });
    }

}
