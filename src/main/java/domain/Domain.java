package domain;

import bl.HibernateUtil;
import main.java.Author;
import main.java.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Rekdon on 03.06.2017.
 */
public class Domain {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();


        Set<Book> books = new HashSet<Book>();
        Book book1 = new Book();
        book1.setPages(200);
        book1.setYear(1842);
        book1.setPrice(180.4);
        book1.setTitle("Demon");

        Book book2 = new Book();
        book2.setPages(300);
        book2.setYear(1843);
        book2.setPrice(180.4);
        book2.setTitle("Valerik");



        books.add(book1);
        books.add(book2);


        Author author = new Author("Lermontov", 1814, "Russia", books);
        book1.setAuthor(author);
        book2.setAuthor(author);

        session.save(author);
        session.save(book1);
        session.save(book2);


        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }
}

