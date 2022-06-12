package com.example.booklibrary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;


public class MyDatabase extends SQLiteOpenHelper {
    private static String db_name = "library.db";
    private static String table_name = "BOOKS";
    private static String table_name2 = "Categories";
    private static int db_version = 3;
    Context context;

    public MyDatabase(@Nullable Context context) {
        super(context, db_name, null, db_version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + table_name + "(ID INTEGER PRIMARY KEY AUTOINCREMENT" +
                ",BOOK_NAME TEXT , Author_NAME TEXT , RELEASE_YEAR TEXT ,Pages_Number INTEGER, isfavorite TEXT);";
        String query2 = "CREATE TABLE " + table_name2 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT" +
                ",category_name TEXT);";
        sqLiteDatabase.execSQL(query);
        sqLiteDatabase.execSQL(query2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "DROP TABLE IF EXISTS " + table_name;
        String query2 = "DROP TABLE IF EXISTS " + table_name2;
        sqLiteDatabase.execSQL(query);
        sqLiteDatabase.execSQL(query2);
        onCreate(sqLiteDatabase);

    }

    public void insertbook(Book book) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("BOOK_NAME", book.getBook_name());
        cv.put("Author_NAME", book.getAuthor_name());
        cv.put("RELEASE_YEAR", book.getRelease_year());
        cv.put("Pages_Number", book.getPages_number());
        cv.put("isfavorite", book.getIsfavorite());
        long result = db.insert(table_name, null, cv);
        if (result != -1) {
            Toast.makeText(context, "add successfully", Toast.LENGTH_SHORT).show();


        } else {
            Toast.makeText(context, "field to add book", Toast.LENGTH_SHORT).show();


        }
    }

    public void insertcategory(Categorydb cat) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("category_name", cat.getCategory_name());
        long result = db.insert(table_name2, null, cv);
        if (result != -1) {
            Toast.makeText(context, "add category successfully", Toast.LENGTH_SHORT).show();


        } else {
            Toast.makeText(context, "field to add category", Toast.LENGTH_SHORT).show();


        }
    }

    public ArrayList<Book> getALLBOOKS() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + table_name;
        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        if (cursor == null) {
            return null;
        } else {
            ArrayList<Book> books = new ArrayList<>();
            while (cursor.moveToNext()) {
                String BookName = cursor.getString(1);
                String AuthorName = cursor.getString(2);
                String ReleaseYear = cursor.getString(3);
             int   PagesNumber = cursor.getInt(4);
                String isfavorite = cursor.getString(5);
                Book b = new Book(BookName, AuthorName, ReleaseYear, PagesNumber,isfavorite);

                books.add(b);


            }
            return books;

        }

    }
    public ArrayList<Categorydb> getALLCategories() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + table_name2;
        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        if (cursor == null) {
            return null;
        } else {
            ArrayList<Categorydb>  categorydb = new ArrayList<>();
            while (cursor.moveToNext()) {
                String CategoryName = cursor.getString(1);

                Categorydb c = new Categorydb(CategoryName);
                String s =c.getCategory_name();

                categorydb.add(c);


            }
            return categorydb;

        }

    }


    public ArrayList<Book> getALLFAV() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + table_name+" WHERE isfavorite Like 'true'";
        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        if (cursor == null) {
            return null;
        } else {
            ArrayList<Book> Book = new ArrayList<>();
            while (cursor.moveToNext()) {
                String BookName = cursor.getString(1);
                String AuthorName = cursor.getString(2);
                String ReleaseYear = cursor.getString(3);
                int   PagesNumber = cursor.getInt(4);
                String isfavorite = cursor.getString(5);
                Book b = new Book(BookName, AuthorName, ReleaseYear, PagesNumber,isfavorite);

                Book.add(b);


            }
            return Book;

        }

    }
}
