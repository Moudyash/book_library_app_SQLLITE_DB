package com.example.booklibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.booklibrary.Adapters.BookAdapter;

import java.util.ArrayList;

public class favourites extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        MyDatabase db = new MyDatabase(this);
        ArrayList<Book> books = db.getALLFAV();

        recyclerView =findViewById(R.id.rvfav);
        BookAdapter adapter = new BookAdapter(books);
        recyclerView.setAdapter(adapter);
        recyclerView.hasFixedSize();
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(lm);


    }

}