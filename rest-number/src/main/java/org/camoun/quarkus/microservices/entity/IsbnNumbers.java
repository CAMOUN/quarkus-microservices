package org.camoun.quarkus.microservices.entity;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbTransient;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.Instant;

@Schema(description = "Several ISBN formats")
public class IsbnNumbers {

    @JsonbProperty("isbn_10")
    @Schema(required = true)
    private String isbn10;
    @JsonbProperty("isbn_13")
    @Schema(required = true)
    private String isbn13;
    @JsonbTransient
    private Instant generationDate;

    public IsbnNumbers() {
    }

    public IsbnNumbers(String isbn10, String isbn13, Instant generationDate) {
        this.isbn10 = isbn10;
        this.isbn13 = isbn13;
        this.generationDate = generationDate;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public Instant getGenerationDate() {
        return generationDate;
    }

    public void setGenerationDate(Instant generationDate) {
        this.generationDate = generationDate;
    }

    @Override
    public String toString() {
        return "IsbnNumber{" +
                "isbn10='" + isbn10 + '\'' +
                ", isbn13='" + isbn13 + '\'' +
                ", generationDate=" + generationDate +
                '}';
    }
}
