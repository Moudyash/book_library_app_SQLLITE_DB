package com.example.booklibrary.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.booklibrary.Book;
import com.example.booklibrary.Categorydb;
import com.example.booklibrary.R;
import com.example.booklibrary.ViewHolders.BookViewHolder;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private final ArrayList<Categorydb> Categorys;
    Context context;
    public CategoryAdapter(ArrayList<Categorydb> Categorys) {
        this.Categorys = Categorys;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context =parent.getContext();
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cat, parent, false);

        return new CategoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Categorydb c=Categorys.get(position);
        holder.CategoryName.setText(c.getCategory_name());
    }

    @Override
    public int getItemCount() {
        return Categorys.size();
    }





    /*View Holder*/

    public class CategoryViewHolder extends RecyclerView.ViewHolder {


        public TextView CategoryName;


        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            CategoryName=itemView.findViewById(R.id.cattxt);
        }
    }
}
