package br.utfpr.client.jsf;

import br.alerario.ICliente;
import br.utfpr.client.resources.ClienteRestResouce;

import javax.inject.Named;

@Named(value = "clienteBean")
public class ClienteBean {

    private String codigo;
    public ICliente cliente;

    public ClienteBean() {

    }

    public String salvar(ICliente cliente) {
        if(codigo == null || codigo.isEmpty()) {
            this.saveCliente(cliente);
        } else {
            this.updateCliente(codigo, cliente);
        }
    }

    public ICliente getCliente() {
        return cliente;
    }

    public void setCliente(ICliente cliente) {
        this.cliente = cliente;
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
}
