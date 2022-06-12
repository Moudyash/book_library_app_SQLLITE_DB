package com.example.booklibrary.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.booklibrary.Book;
import com.example.booklibrary.R;
import com.example.booklibrary.ViewHolders.BookViewHolder;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookViewHolder> {
    ArrayList<Book> books;
Context context;
    public BookAdapter(ArrayList<Book> books) {
        this.books = books;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       context =parent.getContext();
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design_books, parent, false);
        return new BookViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Book b = books.get(position);
        holder.booktxt.setText(b.getBook_name());
        holder.authortext.setText(b.getAuthor_name());
        holder.releasetxt.setText(b.getRelease_year());
    }

    @Override
    public int getItemCount() {
        return books.size();
    }
}
