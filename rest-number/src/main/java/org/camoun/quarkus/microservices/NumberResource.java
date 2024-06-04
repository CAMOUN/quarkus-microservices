package org.camoun.quarkus.microservices;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.camoun.quarkus.microservices.entity.IsbnNumbers;
import org.camoun.quarkus.microservices.repository.NumberRespository;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/api/numbers")
@Tag(name = "Number REST Endpoints")
public class NumberResource {

    @Inject
    NumberRespository numberRespository;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Generates book numbers", description = "ISBN 13 and ISBN 10 numbers")
    public IsbnNumbers generateIsbnNumber() {
        return numberRespository.generateIsbnNumbers();
    }
}
