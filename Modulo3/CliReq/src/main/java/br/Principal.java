 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br;

/**
 *
 * @author lassulfi
 */
public class Principal {
    public static void main(String[] args) {
        System.out.println("Chamar web service");
        
        try { // Call Web Service Operation
            br.cli.WsServicoCalc_Service service = new br.provider.WsServicoCalc_Service();
            br.cli.WsServicoCalc port = service.getWsServicoCalcPort();
            // TODO initialize WS operation arguments here
            int v1 = 10;
            int v2 = 81;
            // TODO process result here
            int result = port.somar(v1, v2);
            System.out.println("Result = "+result);
        } catch (Exception ex) {
            System.out.println("Erro");
        }

    }
 
}
