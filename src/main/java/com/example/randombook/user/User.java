package com.example.randombook.user;

public class User {

    private final int id;
    private final String username;
    private final String email;
    private final String password;
    private final String picture;

    public User(int id, String username, String email, String password, String picture) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPicture() {
        return picture;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}
