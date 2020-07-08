/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.web;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author lassulfi
 */
@Named(value = "jsfRequest")
@RequestScoped
public class JsfRequest {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/WsServicoCalc/WsServicoCalc.wsdl")
    private br.cli.WsServicoCalc_Service service;

    private int v1, v2, resultado;
    
    /**
     * Creates a new instance of JsfRequest
     */
    public JsfRequest() {
    }
    
    public void somar() {
        
        try { // Call Web Service Operation
            br.cli.WsServicoCalc port = service.getWsServicoCalcPort();
            resultado = port.somar(v1, v2);
        } catch (Exception ex) {
            resultado = 0;
        }

    }

    public int getV1() {
        return v1;
    }

    public void setV1(int v1) {
        this.v1 = v1;
    }

    public int getV2() {
        return v2;
    }

    public void setV2(int v2) {
        this.v2 = v2;
    }

    public int getResultado() {
        return resultado;
    }
    
    
} 
 