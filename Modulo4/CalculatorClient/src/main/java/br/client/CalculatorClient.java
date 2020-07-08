/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.client;

import java.text.MessageFormat;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * Jersey REST client generated for REST resource:CalculateResource
 * [operations]<br>
 * USAGE:
 * <pre>
 *        CalculatorClient client = new CalculatorClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author lassulfi
 */
public class CalculatorClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/CalculatorProvider/calculator/api/v1";

    public CalculatorClient() {
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("operations");
    }

    public <T> T getSum(Class<T> responseType, int value1, int value2)
            throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(MessageFormat.format("sum/{0}/{1}", 
                new Object[]{value1, value2}));
        return resource.request(MediaType.TEXT_PLAIN).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
