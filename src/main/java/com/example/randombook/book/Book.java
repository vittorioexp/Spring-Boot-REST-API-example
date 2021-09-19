package com.example.randombook.book;

import com.example.randombook.category.Category;

import java.sql.Date;

public class Book {

    private final int id;
    private final String title;
    private final String author;
    private final Date releaseDate;
    private final String isbn;
    private final Category category;
    private final String images;


    public Book(int id, String title, String author, Date releaseDate, String isbn, Category category, String images) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
        this.isbn = isbn;
        this.category = category;
        this.images = images;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public String getIsbn() {
        return isbn;
    }

    public Category getCategory() {
        return category;
    }

    public String getImages() {
        return images;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + getId() +
                ", title='" + getTitle() + "'" +
                ", author='" + getAuthor() + "'" +
                ", releaseDate='" + getReleaseDate().toString() + "'" +
                ", isbn='" + getIsbn() + "'" +
                ", category='" + getCategory().getName() + "'" +
                ", images='" + getImages() + "'" +
                '}';
    }
}
