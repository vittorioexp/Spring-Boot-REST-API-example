package com.example.randombook.book;

import com.example.randombook.category.Category;

import java.sql.Date;

public class Book {

    private final int id;
    private final String title;
    private final String author;
    private final Date releaseDate;
    private final String isbn;
    private final int category;
    private final String images;

    public Book(int id, String title, String author, Date releaseDate, String isbn, int category, String images) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
        this.isbn = isbn;
        this.category = category;
        this.images = images;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets author.
     *
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Gets release date.
     *
     * @return the release date
     */
    public Date getReleaseDate() {
        return releaseDate;
    }

    /**
     * Gets isbn.
     *
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Gets category.
     *
     * @return the ID of the category
     */
    public int getCategory() {
        return category;
    }

    /**
     * Gets images.
     *
     * @return the URLs of the images
     */
    public String getImages() {
        return images;
    }

    /**
     * Gets the string representation of a book
     *
     * @return the string representation of a book
     */
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", releaseDate=" + releaseDate +
                ", isbn='" + isbn + '\'' +
                ", category=" + category +
                ", images='" + images + '\'' +
                '}';
    }


}
