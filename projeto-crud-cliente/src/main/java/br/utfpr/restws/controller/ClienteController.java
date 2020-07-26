package br.utfpr.restws.controller;

import br.alerario.ICliente;
import br.utfpr.restws.controller.exceptions.DataIntegrityException;
import br.utfpr.restws.repository.ClienteRepository;
import br.utfpr.restws.repository.exceptions.ClienteNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.util.List;

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
    public List<ICliente> getAllClientes() {
        return this.repository.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ICliente getClienteById(@PathParam("id") int id) {
        return this.repository.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createCliente(String content) throws DataIntegrityException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            final ICliente cliente = mapper.readValue(content, ICliente.class);
            this.repository.save(cliente);
        } catch (IOException e) {
           throw new DataIntegrityException("Erro na estrutura de dados");
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateCliente(@PathParam("id") int id, String content) throws DataIntegrityException,
            ClienteNotFoundException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            final ICliente cliente = mapper.readValue(content, ICliente.class);
            this.repository.update(id, cliente);
        } catch (IOException e) {
            throw new DataIntegrityException("Erro na estrutura de dados");
        }
    }

    @DELETE
    @Path("/{id}")
    public void deleteCliente(@PathParam("id") int id) {
        this.repository.delete(id);
    }
}
