/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit6.muir;

/**
 *
 * @author 1dingrai
 */
public class ConfigurableLock extends Lock {

    public ConfigurableLock() {
        System.out.println("ConfigurableLock() : Configurable Lock Constructor");
        for( int i = 0; i < this.combo.length; i++ ) {
            this.combo[i] = -1;
        }
    }

    public void lock() {
        if( this.combo[0] == -1 ) {
            System.out.println("ConfigurableLock.lock() : Lock Combo Not Set.  Can't Lock");
        }
        else {
            this.open = false;
            System.out.println("ConfigurableLock.lock() : Locked!");
        }
    }

    @Override
    public int[] getCombo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
