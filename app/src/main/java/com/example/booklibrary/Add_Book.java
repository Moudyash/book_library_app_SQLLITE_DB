package com.example.booklibrary;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class Add_Book extends AppCompatActivity {
    static  Boolean fav;

    static int count =0;
    public static final int PERMISSION_REQUEST_CODE = 1020;

    public static final int PROFILE_IMAGE_REQUEST_CODE = 1202;
    public static final int COVER_IMAGE_REQUEST_CODE = 1203;
    private CircleImageView circleimage;

    private boolean storagePermissionStatus = false;
    Context context;
    ImageButton imagebtn;
    Spinner spinner;
Button favbtn;
    //***********************************************

    private TextView tvStoragePermissionStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        //******************************ALL EDIT TEXT************************
        //******************************Book name EDIT TEXT************************

        com.google.android.material.textfield.TextInputEditText book_ed = findViewById(R.id.ed_bookname);
        com.google.android.material.textfield.TextInputLayout book_la = findViewById(R.id.bookname_til);
//********************************aurthor name********************
        com.google.android.material.textfield.TextInputEditText aurthorname_ed = findViewById(R.id.ed_aurthorname);
        com.google.android.material.textfield.TextInputLayout aurthorname_la = findViewById(R.id.aurthorname_til);
        //********************************Release Year********************
        com.google.android.material.textfield.TextInputEditText release_ed = findViewById(R.id.ed_release);
        com.google.android.material.textfield.TextInputLayout release_la = findViewById(R.id.release_til);
//******************************** Pages Number********************
        com.google.android.material.textfield.TextInputEditText pagesnumber_ed = findViewById(R.id.ed_pagesnumber);
        com.google.android.material.textfield.TextInputLayout pagesnumber_la = findViewById(R.id.pagesnumber_til);
         favbtn=findViewById(R.id.favbtn);
        Button btn = findViewById(R.id.createbookbtn);
        //spinner = (Spinner) findViewById(R.id.spinner);


        favbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (count%2 ==0) {
                    favbtn.setBackgroundResource(R.drawable.favorite_icon_full);
                    Toast.makeText(getBaseContext(), "Book Add To Favorite Successfully", Toast.LENGTH_SHORT).show();
                    fav=true;
                }else{
                    favbtn.setBackgroundResource(R.drawable.favorite_icon);
                    Toast.makeText(getBaseContext(), "Book Removed From Favorite", Toast.LENGTH_SHORT).show();
                    fav=false;
                }
                count++;





            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                if (TextUtils.isEmpty(book_ed.getText().toString()) || TextUtils.isEmpty(aurthorname_ed.getText().toString()) ||
                        TextUtils.isEmpty(release_ed.getText().toString()) || TextUtils.isEmpty(pagesnumber_ed.getText().toString())) {
                    Toast.makeText(getBaseContext(), "some Field Is Required", Toast.LENGTH_SHORT).show();


                } else {
                    MyDatabase db = new MyDatabase(Add_Book.this);
                    String book = book_ed.getText().toString();
                    String author = aurthorname_ed.getText().toString();
                    String release = release_ed.getText().toString();
                    int pages = Integer.parseInt(pagesnumber_ed.getText().toString());
                    String isfavorite = fav.toString();

                    Book b = new Book(book, author, release, pages, isfavorite);
                    db.insertbook(b);
                }


                if (TextUtils.isEmpty(book_ed.getText().toString())) {
                    Toast.makeText(getBaseContext(), "Book Field Is Required", Toast.LENGTH_SHORT).show();
                    book_la.setHelperText("Required*");
                } else {
                    book_la.setHelperText("");


                }
                if (TextUtils.isEmpty(aurthorname_ed.getText().toString())) {
                    Toast.makeText(getBaseContext(), "Aurthor name_ Field Is Required", Toast.LENGTH_SHORT).show();
                    aurthorname_la.setHelperText("Required*");
                } else {
                    aurthorname_la.setHelperText("");


                }
                if (TextUtils.isEmpty(release_ed.getText().toString())) {
                    Toast.makeText(getBaseContext(), "Release Year Field Is Required", Toast.LENGTH_SHORT).show();
                    release_la.setHelperText("Required*");
                } else {

                    release_la.setHelperText("");


                }
                if (TextUtils.isEmpty(pagesnumber_ed.getText().toString())) {
                    Toast.makeText(getBaseContext(), "Pages Number_ Field Is Required", Toast.LENGTH_SHORT).show();


                    pagesnumber_la.setHelperText("Required*");
                } else {
                    pagesnumber_la.setHelperText("");


                }

            }
        });
favbtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {


        if (count%2 ==0) {
            favbtn.setBackgroundResource(R.drawable.favorite_icon_full);
            Toast.makeText(getBaseContext(), "Book Add To Favorite Successfully", Toast.LENGTH_SHORT).show();
            fav=true;
        }else{
            favbtn.setBackgroundResource(R.drawable.favorite_icon);
            Toast.makeText(getBaseContext(), "Book Removed From Favorite", Toast.LENGTH_SHORT).show();
            fav=false;
        }
        count++;





    }
});

       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        imagebtn = findViewById(R.id.btn_addimage);
        circleimage = (CircleImageView) findViewById(R.id.bookimg);
       // Step 1 : Check Permissions (you must add permission in Manifest.xml file)
        int permissionStatus = ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        if (permissionStatus == PackageManager.PERMISSION_DENIED /*-1*/) {
            //Ask User to allow our app read external storage
           String[] permissions = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE};
            ActivityCompat.requestPermissions(Add_Book.this, permissions, PERMISSION_REQUEST_CODE);
        } else {
            //Change storagePermissionStatus to true
            storagePermissionStatus = true;
        }
        imagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Before open PickImageActivity you have to check permission
                if (storagePermissionStatus) {
                    //Open PickImageActivity using implicit intent (Data "file path" return in other callback function)

                  Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                   intent.setType("image/*");
                    startActivityForResult(Intent.createChooser(intent, "Select Profile Picture"), PROFILE_IMAGE_REQUEST_CODE);
                } else {
                    //Permission denied (Ask User again)
                }
           }
        });
    }

   @Override
   public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
       super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_DENIED /*-1*/) {
                //User denied our app to access storage (Ask him again)
               tvStoragePermissionStatus.setText("User Denied Storage Permission");
                storagePermissionStatus = false;
          } else {
                //User granted our app to read storage
               tvStoragePermissionStatus.setText("User Granted Storage Permission");
               storagePermissionStatus = true;
            }
      }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case PROFILE_IMAGE_REQUEST_CODE:
                //Result (selected file path) will be in intent called data and will be as Uri object
                //Here you need to check if user select image or not (data will be null)
                if (data != null) {
                    Uri profileURI = data.getData();
                    //You could extract selected image file path from URI and store it in DB
                    circleimage.setImageURI(profileURI);
                } else {
                    //User back with NO DATA
                    Toast.makeText(this, "Please select profile image", Toast.LENGTH_SHORT).show();
                }

                break;

        }


    }



}