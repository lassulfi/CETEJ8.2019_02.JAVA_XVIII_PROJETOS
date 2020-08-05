package br.utfpr.client.resources;

import br.utfpr.restws.model.Cliente;
import java.text.MessageFormat;
import java.util.List;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

public class ClienteRestResouce {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/projeto-crud-cliente-1.0-SNAPSHOT/clientes/api/v1";

    public ClienteRestResouce() {
        this.client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("clientes");
    }

    public List<Cliente> getClientes() throws ClientErrorException {
        WebTarget resource = this.webTarget;
        return resource.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Cliente>>(){});
    }

    public Cliente getClientById(String id) throws ClientErrorException {
        WebTarget resource = this.webTarget;
        resource.path("/" + MessageFormat.format("{0}", new Object[]{id}));
        return resource.request(MediaType.APPLICATION_JSON).get(Cliente.class);
    }

    public void saveCliente(Cliente requestEntity) throws ClientErrorException {
        webTarget.request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(requestEntity, MediaType.APPLICATION_JSON));
    }

    public void updateCliente(String id, Cliente requestEntity) throws ClientErrorException {
        WebTarget resource = this.webTarget.path("/" + MessageFormat.format("{0}", new Object[]{id}));
        resource.request()
                .put(Entity.entity(requestEntity, MediaType.APPLICATION_JSON));
    }

    public void deleteCliente(String id) throws ClientErrorException {
        WebTarget resource = this.webTarget.path("/" + MessageFormat.format("{0}", new Object[]{id}));
        resource.request().delete();
    }

    public void close() {
        client.close();
    }
}
