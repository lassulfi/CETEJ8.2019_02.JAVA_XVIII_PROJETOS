package br.utfpr.restws.repository;

import br.alerario.ICliente;
import br.utfpr.restws.repository.exceptions.ClienteNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
    private static List<ICliente> clientes = new ArrayList<>();

    public ClienteRepository() {
    }

    public void save(ICliente cliente) {
        clientes.add(cliente);
    }

    public void update(int id, ICliente cliente) throws ClienteNotFoundException {
        ICliente entity = this.findById(id);
        if(cliente != null) {
            entity.setCidade(cliente.getCidade());
            entity.setNome(cliente.getNome());
        } else {
            throw new ClienteNotFoundException("Cliente não encontrado. Id = " + id);
        }
    }

    public List<ICliente> getAll() {
        return this.clientes;
    }

    public ICliente findById(int codigo) {
        return this.clientes.stream().filter(c -> c.getCodigo() == codigo).findFirst().orElse(null);
    }

    public void delete(int codigo) {
        this.clientes.removeIf(c -> c.getCodigo() == codigo);
    }
}
