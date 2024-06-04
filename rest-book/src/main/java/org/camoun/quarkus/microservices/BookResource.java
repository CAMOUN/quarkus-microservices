package org.camoun.quarkus.microservices;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.camoun.quarkus.microservices.entity.Book;
import org.camoun.quarkus.microservices.proxy.NumberProxy;
import org.camoun.quarkus.microservices.repository.BookRepository;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/api/books")
@Tag(name = "Book REST Endpoints")
public class BookResource {

    @Inject
    BookRepository bookRepository;


    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a Book", description = "Creates a Book with an ISBN number")
    public Response createABook(@FormParam("title") String title, @FormParam("author") String author,
                                @FormParam("year") int yearOfPublication, @FormParam("genre") String genre) {
        return bookRepository.createABook(title, author, yearOfPublication, genre);
    }


}
