package com.example.springapi.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;




@Getter
@Setter
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String author;
    private double rating;
    private String genre;
    private String url;
    private String text;
    public Book() {
    }

    public Book(String title, String author, double rating, String genre, String url, String text) {
        this.title = title;
        this.author = author;
        this.rating = rating;
        this.genre = genre;
        this.url = url;
        this.text = text;
    }



    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", rating=" + rating +
                ", genre='" + genre + '\'' +
                ", url='" + url + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}



