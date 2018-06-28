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
public class FixedLock extends Lock {

    // OBJECT VARIABLE
    //private boolean revealed;
    
    public FixedLock() {
        System.out.println("FixedLock() : Fixed Lock Constructor");
        this.revealed = false;
    }
    

    public void lock() {
        if( isOpen() ) this.open = false;
    }
    
    @Override
    public int[] getCombo() {
        if( !this.revealed ) {
            System.out.println("FixedLock.getCombo() : Combo Revealed!");
            this.revealed = true;
            return this.combo;
        }
        else {
            System.out.println("FixedLock.getCombo() : Combo Alreay Revealed!");
            int[] combo = { -1 };
            return combo;
        }
    }
    
    protected static int[] generateCombo( int minValue, int maxValue ) {
        int[] combo = new int[3];
        for( int i = 0; i < combo.length; i++ ) {
            combo[i] = (int) (Math.random() * ( maxValue-minValue+1) );
        }
        return combo;
    }
    
}
