/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit7;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 *
 * @author 1dingrai
 */
public class BirdStoreTester {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        Scanner input = new Scanner(System.in);
        BirdDatabase db = new BirdDatabase();
        db.open();
       
        
        BirdsRecord b1 = new BirdsRecord("osprey", "Pandion haliaetus", 0.46, 180, 25, true, 'Y');

        BirdDatabase.save( b1 );  // ADD
//        
        b1.setPopulationInMillions( 2 );
//        
        db.save(b1);  // UPDATE
//        
        BirdsRecord b2 = new BirdsRecord(" griffon vulture", "Gyps fulvus", 0.50, 280, 41, true, 'Y');
        db.save(b2);  // UPDATE
        
        BirdsRecord b3 = db.get(2);
        
        assert( b3.equals( b2 ) );
        System.out.println(b1.getId());
        System.out.println(b2.getId());
        System.out.println(b3.getId());
        
        db.close();
        
        //Check add, find, and seek a bird out of range of the file
        
        
        
    }
    
}
