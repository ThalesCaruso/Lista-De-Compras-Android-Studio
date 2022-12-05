package com.example.listadecomprasfinal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CategoryAdapter.HandleCategoryClick {

            private ModelView viewModel;
            private TextView semResultadoTV;
            private RecyclerView recyclerView;
            private CategoryAdapter categoryAdapter;
            private Category categoryForEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Lista de compras");
        semResultadoTV = findViewById(R.id.semResultado);
        recyclerView = findViewById(R.id.recyclerView);
        ImageView addCategoria = findViewById(R.id.addCategoriaImagem);
        addCategoria.


                initViewModel();
        initRecyclerView();
    }


    private void InitRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        categoryAdapter = new CategoryAdapter(this,this);
        recyclerView.setAdapter(categoryAdapter);

    }

    private void initViewModel(){
        viewModel = new ViewModelProvider(this).get(ModelView.class);
        viewModel.getListCategoriesObserver().observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> categories) {
                if (categories == null) {
                    semResultadoTV.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.GONE);
                } else {
                    categoryAdapter.setCategoryList(categories);
                    recyclerView.setVisibility(View.VISIBLE);
                    semResultadoTV.setVisibility(View.GONE);
                }
            }
        });
    }

    private void mostrarAddCategoriaDialog (boolean isForEdit) {
        AlertDialog dialogBuilder = new AlertDialog.Builder(this).create();
        View dialogView = getLayoutInflater().inflate(R.layout.addcategorialayout, null);
        EditText enterCategoryInput = dialogView.findViewById(R.id.enterCategoryInput);
        TextView botaoCriar = dialogView.findViewById(R.id.botaoCriar);
        TextView botaoCancelar = dialogView.findViewById(R.id.botaoCancelar);

        if (isForEdit){
            botaoCriar.setText("Atualizar");
            enterCategoryInput.setText(CategoryForEdit.NomeCategoria);
        }


        botaoCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBuilder.dismiss();
            }
        });
    }
}