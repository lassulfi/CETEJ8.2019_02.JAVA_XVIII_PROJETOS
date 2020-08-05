package br.utfpr.client.resources;

import br.utfpr.restws.model.Cidade;
import java.text.MessageFormat;
import java.util.List;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

public class CidadeRestResource {

    private final WebTarget webTarget;
    private final Client client;
    private static final String BASE_URI = "http://maventest.herokuapp.com/mavenTest-1.0-SNAPSHOT/webresources/";

    public CidadeRestResource() {
        this.client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("cidade");
    }

    public List<Cidade> getCidades() throws ClientErrorException {
        return this.webTarget.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Cidade>>() {});
    }
    
    public Cidade getById(String id) throws ClientErrorException {
        final WebTarget resource = this.webTarget;
        resource.path(MessageFormat.format("{0}", new Object[]{id}));
        return resource.request(MediaType.APPLICATION_JSON).get(Cidade.class);
    }

    public void close() {
        client.close();
    }
}
