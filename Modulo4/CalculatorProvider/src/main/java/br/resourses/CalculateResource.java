/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.resourses;

import br.services.ICalculator;
import br.services.impl.CalculatorImpl;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author lassulfi
 */
@Path("operations")
public class CalculateResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CalculateResource
     */
    public CalculateResource() {
    }

    /**
     * Retrieves representation of an instance of br.CalculateResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("sum/{value1}/{value2}")
    @Produces(MediaType.TEXT_PLAIN)
    public int getSum(@PathParam("value1") int value1, 
            @PathParam("value2") int value2) {
        ICalculator calculator = new CalculatorImpl();
        return calculator.sum(value1, value2);
    }
}
