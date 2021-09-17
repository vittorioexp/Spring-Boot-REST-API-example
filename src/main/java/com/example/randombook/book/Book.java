package com.example.randombook.book;

public class Book {

    private int id_book;
    private String title;
    private String description;
    private String author;
    private String publisher;
    private String releaseDate;
    private String isbn;
    private int id_category;
    private String images;

    public Book() {

    }

    public Book(int id_book, String title, String description, String author, String publisher, String releaseDate, String isbn, int id_category, String images) {
        this.id_book = id_book;
        this.title = title;
        this.description = description;
        this.author = author;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
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

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getReleaseDate() {
        return releaseDate;
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

    public void setIDBook(int id_book) {
        this.id_book = id_book;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setIDCategory(int id_category) {
        this.id_category = id_category;
    }

    public void setImages(String images) {
        this.images = images;
    }

}
