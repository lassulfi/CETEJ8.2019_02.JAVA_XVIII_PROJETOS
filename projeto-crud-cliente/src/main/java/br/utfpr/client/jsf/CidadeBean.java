package br.utfpr.client.jsf;

import br.alerario.ICidade;
import br.utfpr.client.resources.CidadeRestResource;
import br.utfpr.restws.model.Cidade;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@Named(value = "cidadeBean")
@ManagedBean
@ViewScoped
public class CidadeBean {

    private ICidade cidade;

    public CidadeBean() {

    }

    public List<Cidade> getCidades() {
        CidadeRestResource resource = new CidadeRestResource();
        List<Cidade> cidades = resource.getCidades();
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
