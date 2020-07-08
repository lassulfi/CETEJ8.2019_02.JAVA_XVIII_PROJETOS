/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.provider;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author lassulfi
 */
@WebService(serviceName = "WsServicoCalc")
@Stateless()
public class WsServicoCalc {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "somar")
    public int somar(@WebParam(name = "v1") int v1, @WebParam(name = "v2") int v2) {
        return v1 + v2;
    }
}
