package com.example.booklibrary;

public class Book {
    private int id;
    private String book_name;
    private String author_name;
    private String release_year;
    private int pages_number;
    private String isfavorite;
    public Book(String book_name, String author_name, String release_year, int pages_number, String isfavorite) {
        this.book_name = book_name;
        this.author_name = author_name;
        this.release_year = release_year;
        this.pages_number = pages_number;
        this.isfavorite = isfavorite;
    }

    public String getIsfavorite() {
        return isfavorite;
    }

    public void setIsfavorite(String isfavorite) {
        this.isfavorite = isfavorite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getRelease_year() {
        return release_year;
    }

    public void setRelease_year(String release_year) {
        this.release_year = release_year;
    }

    public int getPages_number() {
        return pages_number;
    }

    public void setPages_number(int pages_number) {
        this.pages_number = pages_number;
    }
}
