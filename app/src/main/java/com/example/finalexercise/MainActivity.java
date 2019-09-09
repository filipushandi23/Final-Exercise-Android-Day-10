package com.example.finalexercise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.example.finalexercise.model.URLData;
import com.example.finalexercise.util.AppDatabase;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyAdapter.MyAdapterClickHandler {
    private RecyclerView recyclerView;
    private List<URLData> listUrl;
    private MyAdapter myAdapter;
    private AppDatabase mDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        myAdapter = new MyAdapter(this);
        recyclerView.setAdapter(myAdapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(gridLayoutManager);

        FloatingActionButton floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddActivity.class);
                startActivity(intent);
            }
        });
        mDb = AppDatabase.getInstance(getApplicationContext());
    }

    @Override
    protected void onResume() {
        super.onResume();
        myAdapter.setListURL(mDb.urlDao().getAll());
    }

    @Override
    public void onClick(URLData data) {
        Intent intent = new Intent(this,DetailActivity.class);
        Log.d("ID",data.getId()+"");
        Log.d("NAME",data.getNama()+"");

        intent.putExtra("id",String.valueOf(data.getId()));
        intent.putExtra("name",data.getNama());
        intent.putExtra("url",data.getUrl());
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    public List<URLData> getData(){
//        List<URLData> listUrl;
//
//        listUrl = mDb.urlDao().getAll();
//        return listUrl;
//    }
}
