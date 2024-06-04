package org.camoun.quarkus.microservices;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;

@QuarkusTest
class BookResourceTest {
    @Test
    void shouldCreateABook() {
        given()
                .formParam("title", "The priory of the orange tree")
                .formParam("author", "Samantha Shannon")
                .formParam("year", 2019)
                .formParam("genre", "Fantasy")
          .when()
                .post("/api/books")
          .then()
             .statusCode(201)
                .body("isbn_13", startsWith("13-"))
                .body("author", is("Samantha Shannon"))
                .body("title", is("The priory of the orange tree"))
                .body("year_of_publication", is(2019))
                .body("creation_date", startsWith("2024"));
    }

}