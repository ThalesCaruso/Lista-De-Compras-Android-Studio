package com.example.listadecomprasfinal.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Itens {

    @PrimaryKey (autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "NomeItem")
    public String NomeItem;

    @ColumnInfo(name = "IdCategoria")
    public String IdCategoria;

    @ColumnInfo(name = "Completado")
    public boolean Completado;



}
