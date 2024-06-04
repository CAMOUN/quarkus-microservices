package org.camoun.quarkus.microservices.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.camoun.quarkus.microservices.entity.IsbnNumbers;
import org.jboss.logging.Logger;

import java.time.Instant;
import java.util.Random;

@ApplicationScoped
public class NumberRespository {

    @Inject
    Logger logger;

    public IsbnNumbers generateIsbnNumbers() {
        IsbnNumbers isbnNumbers = new IsbnNumbers();
        isbnNumbers.setIsbn13("13-" + new Random().nextInt(100_000_000));
        isbnNumbers.setIsbn10("10-" + new Random().nextInt(100_000));
        isbnNumbers.setGenerationDate(Instant.now());
        logger.info("Numbers generated " + isbnNumbers);
        return isbnNumbers;
    }

}
