package org.nrenaud.microprofile.test.service;

import org.nrenaud.microprofile.test.modele.Book;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class BookService {

    public List<Book> getAll(){
        return List.of(
                new Book("Test1", "author 1"),
                new Book("test2", "author 2"));
    }
}
