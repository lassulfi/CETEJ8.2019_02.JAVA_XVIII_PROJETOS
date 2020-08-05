package br.utfpr.restws.controller;

import br.utfpr.restws.model.Cliente;
import br.utfpr.restws.repository.ClienteRepository;
import br.utfpr.restws.repository.exceptions.ClienteNotFoundException;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("clientes")
@RequestScoped
public class ClienteController {

    @Context
    private UriInfo context;

    private ClienteRepository repository;

    public ClienteController() {
        this.repository = new ClienteRepository();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> getAllClientes() {
        return this.repository.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente getClienteById(@PathParam("id") int id) {
        return this.repository.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createCliente(Cliente cliente) {
        this.repository.save(cliente);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateCliente(@PathParam("id") int id, Cliente cliente) throws ClienteNotFoundException {
        this.repository.update(id, cliente);
    }

    @DELETE
    @Path("/{id}")
    public void deleteCliente(@PathParam("id") int id) {
        this.repository.delete(id);
    }
}
