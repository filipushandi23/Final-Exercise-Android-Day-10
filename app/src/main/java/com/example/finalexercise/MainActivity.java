package com.example.finalexercise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyAdapter.MyAdapterClickHandler {
    private RecyclerView recyclerView;
    private List<MyData> listUrl;
    private MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        listUrl = populateFakeData();

        myAdapter = new MyAdapter(this);
        myAdapter.setListURL(listUrl);
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
    }

    @Override
    public void onClick(MyData data) {
        Intent intent = new Intent(this,DetailActivity.class);
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

    public List<MyData> populateFakeData(){
        List<MyData> listUrl = new ArrayList<>();
        listUrl.add(new MyData("Google","www.google.com"));
        listUrl.add(new MyData("Yahoo","www.yahoo.com"));
        listUrl.add(new MyData("Manchester United","www.manutd.com"));
        listUrl.add(new MyData("Vogella","www.vogella.com"));
        listUrl.add(new MyData("Medium","www.medium.com"));
        return listUrl;
    }
}
