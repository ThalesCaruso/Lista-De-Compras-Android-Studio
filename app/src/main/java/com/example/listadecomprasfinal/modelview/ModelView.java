package com.example.listadecomprasfinal.modelview;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import android.app.Application;
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
