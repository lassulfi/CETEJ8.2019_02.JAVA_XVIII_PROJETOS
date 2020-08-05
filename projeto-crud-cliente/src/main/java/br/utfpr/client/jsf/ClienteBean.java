package br.utfpr.client.jsf;

import br.utfpr.client.resources.CidadeRestResource;
import br.utfpr.client.resources.ClienteRestResouce;
import br.utfpr.restws.model.Cidade;
import br.utfpr.restws.model.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@Named(value = "clienteBean")
@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String codigo = "";
    private Cliente cliente;
    private List<Cliente> clientes;

    private String cidade = "";

    public ClienteBean() {
        cliente = new Cliente();
        clientes = new ArrayList<>();
    }
    
    public String save() {
        if(codigo == null || codigo.isEmpty()) {
            this.saveCliente(cliente);
        } else {
            this.updateCliente(codigo, cliente);
        }
        codigo = null;
        this.cliente = new Cliente();

        return "index.xhtml";
    }
    
    public void edit(int codigo) {
        ClienteRestResouce resource = new ClienteRestResouce();
        List<Cliente> clientes = resource.getClientes();
        resource.close();
        
        this.cliente = clientes.stream().filter(c -> c.getCodigo() == codigo).findFirst().orElse(null);
        this.cidade = this.cliente.getCidade().getNome();
        
        this.codigo = String.valueOf(this.cliente.getCodigo());
    }
    
    public String delete(String codigo) {
        ClienteRestResouce resource = new ClienteRestResouce();
        resource.deleteCliente(codigo);
        resource.close();
        
        return "index.xhtml";
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClientes() {
        ClienteRestResouce resource = new ClienteRestResouce();
        clientes = resource.getClientes();
        resource.close();
        
        return clientes;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    private void saveCliente(Cliente cliente) {
        cliente.setCidade(this.getCidadeByName());
        ClienteRestResouce resouce = new ClienteRestResouce();
        resouce.saveCliente(cliente);
        resouce.close();
    }

    private void updateCliente(String codigo, Cliente cliente) {
        cliente.setCidade(this.getCidadeByName());
        ClienteRestResouce resouce = new ClienteRestResouce();
        resouce.updateCliente(codigo, cliente);
        resouce.close();
    }

    private Cidade getCidadeByName() {
        CidadeRestResource resource = new CidadeRestResource();
        List<Cidade> cidades = resource.getCidades();
        resource.close();
        
        return cidades.stream().filter(c -> c.getNome().equals(this.cidade)).findFirst().orElse(null);
    }
}
