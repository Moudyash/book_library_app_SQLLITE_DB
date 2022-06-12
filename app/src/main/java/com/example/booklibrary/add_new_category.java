package com.example.booklibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class add_new_category extends AppCompatActivity {
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_catrgory);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        com.google.android.material.textfield.TextInputEditText cat_ed = findViewById(R.id.cat_ed);
        com.google.android.material.textfield.TextInputLayout cat_la = findViewById(R.id.cat_la);

        Button btn = findViewById(R.id.btncreatecategory);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(cat_ed.getText().toString())) {
                    cat_la.setError("this field cant be empty!");
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            cat_la.setError("");
                            cat_la.setHelperText("Required*");

                        }
                    }, 4000);


                } else {
                    String cated = cat_ed.getText().toString();
                    MyDatabase db = new MyDatabase(add_new_category.this);

                    Categorydb a = new Categorydb(cated);
                    db.insertcategory(a);
                    db.getALLCategories();
                    cat_la.setHelperText("");

                }
            }
        });


    }
}