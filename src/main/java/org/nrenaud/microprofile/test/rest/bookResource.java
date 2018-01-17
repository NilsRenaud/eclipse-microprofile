package org.nrenaud.microprofile.test.rest;


import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.nrenaud.microprofile.test.modele.Book;
import org.nrenaud.microprofile.test.service.BookService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Path("/books") //a JAX-RS Resource
public class bookResource {

    @Inject //use CDI to inject a service
    private BookService bookService;

    @Inject //Use CDI to inject a property.
    @ConfigProperty(name="port", defaultValue = "9081")
    private int port;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> findAll() {
        return bookService.getAll();
    }

    @Path("/port")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public int getPort(){
        return port;
    }

}
