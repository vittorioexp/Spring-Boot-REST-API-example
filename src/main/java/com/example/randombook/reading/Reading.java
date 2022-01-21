package com.example.randombook.reading;

import java.sql.Date;

public class Reading {

    private final int id;
    private final int customer;
    private final int book;
    private final Date date;
    private final String state;

    public Reading(int id, int customer, int book, Date date, String state) {
        this.id = id;
        this.customer = customer;
        this.book = book;
        this.date = date;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public int getCustomer() {
        return customer;
    }

    public int getBook() {
        return book;
    }

    public Date getDate() {
        return date;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return "Reading{" +
                "id=" + id +
                ", user=" + customer +
                ", book=" + book +
                ", date=" + date +
                ", state='" + state + '\'' +
                '}';
    }
}
