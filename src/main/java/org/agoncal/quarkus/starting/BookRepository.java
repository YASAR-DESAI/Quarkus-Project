package org.agoncal.quarkus.starting;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class BookRepository {

    public List<Book> getAllBooks() {
        return List.of(
                new Book(1, "The Alchemist" ,"Paulo Cohelo" , 2003 , "Fiction"),
                new Book(2, "Atomic Habits" ,"James Clear" , 2015 , "Self-help"),
                new Book(3, "HTNGAF" ,"Mark Manson" , 2014 , "Self-help"));

    }

    public int getCount(){
        return getAllBooks().size();
    }

    public Book getSpecificBook(@PathParam("id") int id){
        List<Book> books = new ArrayList<>();
        books = getAllBooks();
        for (Book book: books) {

            if(book.id == id )
                return book;
        }
        return null;
    }

}
