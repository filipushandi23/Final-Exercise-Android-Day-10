package com.example.finalexercise.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_url")
public class URLData {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "nama")
    private String nama;

    @ColumnInfo(name = "url")
    private String url;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Ignore
    public URLData(String nama, String url) {
        this.nama = nama;
        this.url = url;
    }

    public URLData(int id, String nama, String url) {
        this.id = id;
        this.nama = nama;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
