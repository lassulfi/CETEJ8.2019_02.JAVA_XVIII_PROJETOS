package br.utfpr.client.jsf;

import br.alerario.ICidade;
import br.utfpr.client.resources.CidadeRestResource;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

@Named(value = "cidadeBean")
@ManagedBean
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
