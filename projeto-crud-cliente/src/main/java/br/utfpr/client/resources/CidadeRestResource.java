package br.utfpr.client.resources;

import br.alerario.ICidade;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class CidadeRestResource {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://maventest.herokuapp.com/mavenTest-1.0-SNAPSHOT/webresources/";

    public CidadeRestResource() {
        this.client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("cidade");
    }

    public List<ICidade> getCidades(Class<List> responseType) throws ClientErrorException {
        WebTarget resource = this.webTarget;
        return resource.request(MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
}
