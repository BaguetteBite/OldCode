/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit4;

/**
 *
 * @author 1dingrai
 */
public class PowerClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        PowerSupply name = new PowerSupply();
        PowerSupply.powered = false;
        
        System.out.println( name.powered);
        
        
    }
    
}
