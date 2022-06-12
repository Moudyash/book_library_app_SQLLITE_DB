package com.example.booklibrary;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CardView library=findViewById(R.id.card1);
        CardView favorite=findViewById(R.id.card2);
        CardView createBook=findViewById(R.id.card3);
        CardView createCategory=findViewById(R.id.card4);
        library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , books.class);
                startActivity(intent);
            }
        });





        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , favourites.class);
                startActivity(intent);
            }
        });
        createBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , Add_Book.class);
                startActivity(intent);
            }
        });
        createCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , add_new_category.class);
                startActivity(intent);
            }
        });
    }
}