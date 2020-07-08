/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.services.impl;

import br.services.ICalculator;

/**
 *
 * @author lassulfi
 */
public class CalculatorImpl implements ICalculator {

    @Override
    public int sum(int value1, int value2) {
        return value1 + value2;
    }
    
}
