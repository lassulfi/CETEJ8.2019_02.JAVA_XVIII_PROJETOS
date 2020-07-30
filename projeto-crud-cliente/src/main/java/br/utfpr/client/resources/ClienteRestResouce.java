package br.utfpr.client.resources;

import br.alerario.ICliente;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.text.MessageFormat;
import java.util.List;

public class ClienteRestResouce {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/projeto-crud-cliente-1.0-SNAPSHOT/clientes/api/v1";

    public ClienteRestResouce() {
        this.client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("clientes");
    }

    public List<ICliente> getClientes(Class<List> responseType) throws ClientErrorException {
        final WebTarget resource = this.webTarget;
        return resource.request(MediaType.APPLICATION_JSON).get(responseType);
    }

    public ICliente getClientById(String id, Class<ICliente> responseType) throws ClientErrorException {
        final WebTarget resource = this.webTarget;
        resource.path(MessageFormat.format("{0}", new Object[]{id}));
        return resource.request(MediaType.APPLICATION_JSON).get(responseType);
    }

    public void saveCliente(ICliente requestEntity) throws ClientErrorException {
        webTarget.request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(requestEntity, MediaType.APPLICATION_JSON));
    }

    public void updateCliente(String id, ICliente requestEntity) throws ClientErrorException {
        final WebTarget resource = this.webTarget;
        resource.path(MessageFormat.format("{0}", new Object[]{id}));
        resource.request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(requestEntity, MediaType.APPLICATION_JSON));
    }

    public void deleteCliente(String id) throws ClientErrorException {
        this.webTarget.path(MessageFormat.format("{0}", new Object[]{id})).request().delete();
    }

    public void close() {
        client.close();
    }
}
