package com.example.gads2020leaderboard.Retrofit;

public class Post {
    private String firstName;
    private String lastName;
    private String email;
    private String Link;

    public Post(String firstName, String lastName, String email, String link) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        Link = link;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getLink() {
        return Link;
    }
}
