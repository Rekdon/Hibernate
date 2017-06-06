package main.java;

import javax.persistence.*;

/**
 * Created by Rekdon on 03.06.2017.
 */
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="page")
    private int pages;

    @Column(name="price")
    private double price;

    @Column(name="title",length = 20)
    private String title;

    @Column(name="year")
    private int year;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;


    public Book() {
    }

    public Book(int pages, double price, String title, int year, Author author) {
        this.pages = pages;
        this.price = price;
        this.title = title;
        this.year = year;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
