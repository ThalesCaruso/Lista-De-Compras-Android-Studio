package com.example.listadecomprasfinal.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Category {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "NomeCategoria")
    public String NomeCategoria;





}
