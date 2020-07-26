package br.utfpr.client.jsf;

import br.alerario.ICidade;
import br.alerario.ICliente;
import br.utfpr.client.resources.CidadeRestResource;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named(value = "cidadeBean")
@RequestScoped
public class CidadeBean {

    private ICidade cidade;

    public CidadeBean() {

    }

    public List<ICidade> getCidades() {
        CidadeRestResource resource = new CidadeRestResource();
        List<ICidade> cidades = resource.getCidades(List.class);
        resource.close();

        return cidades;
    }

    public ICidade getCidade() {
        return cidade;
    }

    public void setCidade(ICidade cidade) {
        this.cidade = cidade;
    }
}
