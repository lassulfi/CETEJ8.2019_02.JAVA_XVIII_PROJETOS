/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.utfpr.converters;

import br.alerario.ICidade;
import br.utfpr.client.resources.CidadeRestResource;
import br.utfpr.restws.model.Cidade;
import java.io.Serializable;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author lassulfi
 */
@FacesConverter(value="cidadeConverter", forClass = Cidade.class)
public class CidadeConverter implements Converter, Serializable{
    private static final long serialVersionUID = 1L;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && !value.isEmpty()) {
            String id = value.split("-")[0].trim();
            System.out.println("Index of element in the combobox: " + id);
            CidadeRestResource resource = new CidadeRestResource();
            List<Cidade> cidades = resource.getCidades();
            resource.close();
            
            ICidade cidade = cidades.stream()
                    .filter(c -> String.valueOf(c.getCodigo()).equals(id))
                    .findFirst().orElse(null);
                                  
            return cidade;
        }
        
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null && value instanceof ICidade) {
            return String.valueOf(((Cidade) value).getCodigo());
        }
        
        return null;
    }    
}
