package org.camoun.quarkus.microservices.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.json.bind.JsonbBuilder;
import jakarta.ws.rs.core.Response;
import org.camoun.quarkus.microservices.entity.Book;
import org.camoun.quarkus.microservices.proxy.NumberProxy;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.Instant;

@ApplicationScoped
public class BookRepository {

    @Inject
    Logger logger;


    @Inject
    @RestClient
    NumberProxy numberProxy;


    @Fallback(fallbackMethod = "fallbackOnCreatingABook")
    @Retry(delay = 3000, maxRetries = 3)
    public Response createABook(String title, String author, int yearOfPublication, String genre) {
        Book book = new Book();
        book.setIsbn13(numberProxy.generateIsbnNumber().getIsbn13());
        book.setTitle(title);
        book.setAuthor(author);
        book.setYearOfPublication(yearOfPublication);
        book.setGenre(genre);
        book.setCreationDate(Instant.now());
        logger.info("Book created : " + book);

        return Response.status(201).entity(book).build();

    }

    public Response fallbackOnCreatingABook(String title, String author, int yearOfPublication, String genre) throws FileNotFoundException {
        Book book = new Book();
        book.setIsbn13("Will be set later");
        book.setTitle(title);
        book.setAuthor(author);
        book.setYearOfPublication(yearOfPublication);
        book.setGenre(genre);
        book.setCreationDate(Instant.now());
        saveBookOnDisk(book);
        logger.warn("Book saved on disk " + book);
        return Response.status(206).entity(book).build();
    }

    private void saveBookOnDisk(Book book) throws FileNotFoundException {
        String bookJSON = JsonbBuilder.create().toJson(book);
        try(PrintWriter out = new PrintWriter("book-" + Instant.now().toEpochMilli() + ".json")) {
            out.println(bookJSON);
        }
    }

}
