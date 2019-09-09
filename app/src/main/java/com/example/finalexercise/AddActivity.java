package com.example.finalexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finalexercise.model.URLData;
import com.example.finalexercise.util.AppDatabase;

public class AddActivity extends AppCompatActivity {

    private AppDatabase mDb;
    private Button btnAdd;
    private EditText txtName;
    private EditText txtUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Add Data");

        mDb = AppDatabase.getInstance(getApplicationContext());
        btnAdd = findViewById(R.id.btn_add);
        txtName = findViewById(R.id.text_name_add);
        txtUrl = findViewById(R.id.text_url_add);

        btnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //check if edit text is null
                if(txtName.getText().toString().equals("") || txtUrl.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"You must fill the textfield!",Toast.LENGTH_SHORT).show();
                }
                else{
                    String nama = txtName.getText().toString();
                    String url = txtUrl.getText().toString();
                    URLData urlData = new URLData(nama,url);
                    mDb.urlDao().insert(urlData);
                    finish();
                }
            }
        });
    }
}
