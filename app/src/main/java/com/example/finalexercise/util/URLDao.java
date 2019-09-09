package com.example.finalexercise.util;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.finalexercise.model.URLData;

import java.util.List;

@Dao
public interface URLDao {
    //table_url itu di define di class URLData di bagian entity
    @Query("SELECT * FROM table_url")
    List<URLData> getAll();

    @Query("SELECT * FROM table_url WHERE id IN (:id)")
    List<URLData> loadAllByIds(int[] id);

    @Insert
    void insert(URLData urlData);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateData(URLData urLdata);

    @Delete
    void delete(URLData urlData);
}
