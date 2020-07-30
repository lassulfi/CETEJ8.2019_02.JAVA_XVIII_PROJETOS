package br.utfpr.client.jsf;

import br.alerario.ICliente;
import br.utfpr.client.resources.ClienteRestResouce;
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
    private ICliente cliente;
    private List<ICliente> clientes;

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
        String codigoStr = String.valueOf(codigo);
        ClienteRestResouce resource = new ClienteRestResouce();
        cliente = resource.getClientById(codigoStr, ICliente.class);
        resource.close();
        
        this.codigo = String.valueOf(cliente.getCodigo());
    }
    
    public String delete(String codigo) {
        ClienteRestResouce resource = new ClienteRestResouce();
        resource.deleteCliente(codigo);
        resource.close();
        
        return "index.xhtml";
    }

    private void saveCliente(ICliente cliente) {
        ClienteRestResouce resouce = new ClienteRestResouce();
        resouce.saveCliente(cliente);
        resouce.close();
    }

    private void updateCliente(String codigo, ICliente cliente) {
        ClienteRestResouce resouce = new ClienteRestResouce();
        resouce.updateCliente(codigo, cliente);
        resouce.close();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public ICliente getCliente() {
        return cliente;
    }

    public void setCliente(ICliente cliente) {
        this.cliente = cliente;
    }

    public List<ICliente> getClientes() {
        ClienteRestResouce resource = new ClienteRestResouce();
        clientes = resource.getClientes(List.class);
        resource.close();
        
        return clientes;
    }
}
