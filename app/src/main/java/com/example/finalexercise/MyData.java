package com.example.finalexercise;

public class MyData {
    private String nama;
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

    public MyData(String nama, String url) {
        this.nama = nama;
        this.url = url;
    }
}
