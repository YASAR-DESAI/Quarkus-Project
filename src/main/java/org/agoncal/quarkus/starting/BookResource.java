package org.agoncal.quarkus.starting;

import io.quarkus.arc.log.LoggerName;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    @Inject
    BookRepository bookRepository;

    @GET
    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/count")
    public int getCount(){
        return bookRepository.getCount();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Book getSpecificBook(@PathParam("id") int id) {
        return bookRepository.getSpecificBook(id);
    }

}