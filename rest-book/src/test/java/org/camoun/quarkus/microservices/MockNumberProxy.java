package org.camoun.quarkus.microservices;

import io.quarkus.test.Mock;
import org.camoun.quarkus.microservices.entity.IsbnThirteen;
import org.camoun.quarkus.microservices.proxy.NumberProxy;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Mock
@RestClient
public class MockNumberProxy implements NumberProxy {
    @Override
    public IsbnThirteen generateIsbnNumber() {
        IsbnThirteen isbnThirteen = new IsbnThirteen();
        isbnThirteen.setIsbn13("13-Mock");
        return isbnThirteen;
    }
}
