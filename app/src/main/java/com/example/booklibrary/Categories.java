package com.example.booklibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.booklibrary.Adapters.CategoryAdapter;

import java.util.ArrayList;

public class Categories extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        MyDatabase db = new MyDatabase(this);
recyclerView=findViewById(R.id.catrv);
        ArrayList<Categorydb> Categorys=db.getALLCategories();
        CategoryAdapter adpter =new CategoryAdapter(Categorys);
recyclerView.setAdapter(adpter);
        recyclerView.hasFixedSize();
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(lm);
    }
}