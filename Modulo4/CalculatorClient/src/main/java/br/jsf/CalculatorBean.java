/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jsf;

import br.client.CalculatorClient;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author lassulfi
 */
@Named(value = "calculatorBean")
@RequestScoped
public class CalculatorBean {

    private Integer value1, value2, sum;
    
    /**
     * Creates a new instance of CalculatorBean
     */
    public CalculatorBean() {
    }
    
    public void calculate() {
        CalculatorClient client = new CalculatorClient();
        sum = client.getSum(Integer.class, value1, value2);
        client.close();
    }
    
    public Integer getValue1() {
        return value1;
    }

    public void setValue1(Integer value1) {
        this.value1 = value1;
    }

    public Integer getValue2() {
        return value2;
    }

    public void setValue2(Integer value2) {
        this.value2 = value2;
    }
    
    public Integer getSum() {
        return this.sum;       
    }
}
