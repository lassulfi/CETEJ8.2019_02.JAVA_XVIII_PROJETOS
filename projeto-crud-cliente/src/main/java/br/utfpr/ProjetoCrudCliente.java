package br.utfpr;

import br.utfpr.restws.controller.ClienteController;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("clientes/api/v1")
public class ProjetoCrudCliente extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        this.addResourcesClasses(resources);
        return resources;
    }

    private void addResourcesClasses(Set<Class<?>> resources) {
        resources.add(ClienteController.class);
    }


}
