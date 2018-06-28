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
public abstract class Lock implements LockInterface {
    
    // OBJECT VARIABLES
    protected boolean revealed;
    protected int[] combo;
    private int serialNumber;
    protected boolean open;
    private int attempts;

    public Lock() {
        System.out.println("Lock() : Lock Constructor");
        this.attempts = 0;
        this.open = true;
        this.combo = new int[3];
    }        

    @Override
    public boolean isOpen() {
        return open;
    }

    @Override
    public abstract int[] getCombo();

    public abstract void lock();

    @Override
    public int unlock(int[] combo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getSerialNumber() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
