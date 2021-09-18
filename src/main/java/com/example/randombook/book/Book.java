package com.example.randombook.book;

public class Book {

    private final int id_book;
    private final String title;
    private final String author;
    private final String publisher;
    private final String isbn;
    private final int id_category;
    private final String images;


    public Book(int id_book, String title, String author, String publisher, String isbn, int id_category, String images) {
        this.id_book = id_book;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.id_category = id_category;
        this.images = images;
    }

    public int getIDBook() {
        return id_book;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getIDCategory() {
        return id_category;
    }

    public String getImages() {
        return images;
    }

}
