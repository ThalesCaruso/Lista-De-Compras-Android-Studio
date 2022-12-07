package com.example.listadecomprasfinal.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Category.class, Itens.class}, version = 1)
public abstract class DataBase extends RoomDatabase {


    public abstract ListaCompras listaCompras();

    public static DataBase INSTANCE;

    public static DataBase getDBInstance(Context context) {
        if(INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), DataBase.class, name: "AppDB")
            .allowMainThreadQueries()
                    .build();

        }

        return INSTANCE;

    }
}
