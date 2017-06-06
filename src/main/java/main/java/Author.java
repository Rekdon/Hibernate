package main.java;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Rekdon on 03.06.2017.
 */
@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="year")
    private int year;

    @Column(name="country" , length = 30)
    private String country;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "author")
    private Set<Book> books;

    public Author(){}

    public Author(String name, int year, String country, Set<Book> books) {
        this.name = name;
        this.year = year;
        this.country = country;
        this.books = books;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
