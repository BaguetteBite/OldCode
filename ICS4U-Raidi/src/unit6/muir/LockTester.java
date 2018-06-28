/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit6.muir;

import jdk.nashorn.internal.runtime.regexp.joni.Config;

/**
 *
 * @author 1dingrai
 */
public class LockTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int[] BAD_COMBO = { 1, -2, 3 };
        
        MasterLock master = new MasterLock();
        assert( master.isOpen() );
        int[] combo1 = master.getCombo();
        System.out.println( combo1[0] + "-" + combo1[1] + "-" + combo1[2] );
        master.lock();
        assert( !master.isOpen() );
//        master.unlock(BAD_COMBO);
//        master.unlock(BAD_COMBO);
//        master.unlock(BAD_COMBO);
        
        System.out.println("---------------------");
        
        Dudley dudley = new Dudley();
        assert( dudley.isOpen() );
        int[] combo2 = dudley.getCombo();
        System.out.println( combo2.toString() );
        System.out.println( combo2[0] + "-" + combo2[1] + "-" + combo2[2] );
        dudley.getCombo();
    }
    
}
