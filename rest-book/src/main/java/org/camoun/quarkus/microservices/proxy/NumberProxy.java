package org.camoun.quarkus.microservices.proxy;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.camoun.quarkus.microservices.entity.IsbnThirteen;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/numbers")
@RegisterRestClient(configKey = "number.proxy")
public interface NumberProxy {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    IsbnThirteen generateIsbnNumber();
}
