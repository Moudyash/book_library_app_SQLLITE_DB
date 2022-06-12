package com.example.booklibrary.Adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.booklibrary.R;

public class FavoriteAdapter {


    /*View Holder*/

    public class  FavoriteViewHolder extends RecyclerView.ViewHolder {


        public ImageView img;
        public TextView booktxt,authortext,releasetxt,isfavorite;

        public FavoriteViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.itbookimage);
            booktxt=itemView.findViewById(R.id.booktxt);
            authortext=itemView.findViewById(R.id.authortxt);
            releasetxt=itemView.findViewById(R.id.releasetxt);
        }
    }

}
