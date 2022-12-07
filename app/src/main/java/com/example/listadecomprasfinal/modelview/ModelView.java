package com.example.listadecomprasfinal.modelview;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listadecomprasfinal.database.Category;
import com.example.listadecomprasfinal.database.DataBase;

import java.util.List;

public class ModelView extends AndroidViewModel {


    private MutableLiveData<List<Category>> ListaCategorias;
    private DataBase dataBase;


    public ModelView(Application application){
        super(application);

        ListaCategorias = new MutableLiveData<>();

        dataBase = DataBase.getDBInstance(getApplication().getApplicationContext());

    }

    public MutableLiveData<List<Category>> getListCategoriesObserver(){
        return ListaCategorias;
    }
    public void getTodosListsCategories(){
        List<Category> categoryList = dataBase.listaCompras().pegarTodasCategorias();
        if (categoryList.size() > 0)
        {
            ListaCategorias.postValue(categoryList);
        }else {
            ListaCategorias.postValue(null);
        }
    }

    public void insertCategory(String catName){
        Category category = new Category();
        category.NomeCategoria = catName;
        dataBase.listaCompras().insertCategory(category);
        getTodosListsCategories();
    }

    public void updateCategory(Category category) {
        dataBase.listaCompras().updateCategory(category);
        getTodosListsCategories();
    }
    public void deleteCategory(Category category) {
        dataBase.listaCompras().deleteCategory(category);
        getTodosListsCategories();
    }
}
