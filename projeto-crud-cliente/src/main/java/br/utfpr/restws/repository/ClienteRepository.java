package br.utfpr.restws.repository;

import br.utfpr.restws.model.Cliente;
import br.utfpr.restws.repository.exceptions.ClienteNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
    private static List<Cliente> clientes = new ArrayList<>();

    public ClienteRepository() {
    }

    public void save(Cliente cliente) {
        clientes.add(cliente);
    }

    public void update(int id, Cliente cliente) throws ClienteNotFoundException {
        Cliente entity = this.findById(id);
        if(entity != null) {
            entity.setCidade(cliente.getCidade());
            entity.setNome(cliente.getNome());
            this.clientes.set(id, entity);
        } else {
            throw new ClienteNotFoundException("Cliente não encontrado. Id = " + cliente.getCodigo());
        }
    }

    public List<Cliente> getAll() {
        return this.clientes;
    }

    public Cliente findById(int codigo) {
        return this.clientes.stream().filter(c -> c.getCodigo() == codigo).findFirst().orElse(null);
    }

    public void delete(int codigo) {
        this.clientes.removeIf(c -> c.getCodigo() == codigo);
    }
}
