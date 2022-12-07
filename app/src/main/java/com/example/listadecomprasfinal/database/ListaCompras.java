package com.example.listadecomprasfinal.database;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ListaCompras {

    @Query("Select * from Category")
    List<Category> pegarTodasCategorias();

    @Insert
    void insertCategory(Category...categories);

    @Update
    void updateCategory(Category category);

    @Delete
    void deleteCategory(Category category);

    @Query("Select * from Itens where IdCategoria = :catId")
    List<Itens> pegarTodosItens(int catId);

    @Insert
    void insertItens (Itens itens);

    @Update
    void updateItens (Itens itens);

    @Delete
    void deleteItens (Itens itens);



}
