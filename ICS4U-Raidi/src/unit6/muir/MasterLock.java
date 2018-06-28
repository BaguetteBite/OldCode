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
public class MasterLock extends FixedLock {

    public static final int MAX_COMBO_VALUE = 39;
    
    public MasterLock() {
        super();
        this.combo = super.generateCombo( 0, MAX_COMBO_VALUE );
    }
    
    
    
}
