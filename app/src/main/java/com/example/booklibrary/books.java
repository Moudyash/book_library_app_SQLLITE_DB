package com.example.booklibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.booklibrary.Adapters.BookAdapter;

import java.util.ArrayList;

public class books extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        MyDatabase db = new MyDatabase(this);
        ArrayList<Book> books = db.getALLBOOKS();
        recyclerView =findViewById(R.id.rv_book);
        BookAdapter adapter = new BookAdapter(books);
        recyclerView.setAdapter(adapter);
        recyclerView.hasFixedSize();
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(lm);
    }
}