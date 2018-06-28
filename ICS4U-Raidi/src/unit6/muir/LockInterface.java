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
public interface LockInterface {
    
    public boolean isOpen();
    
    public int[] getCombo();
    
    public void lock();
    
    public int unlock( int[] combo );
    
    public int getSerialNumber();
    
    
}
