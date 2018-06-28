/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit3;

import java.util.Scanner;

/**
 *
 * @author Raidi
 */
public class FiveTerms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        int t = 5;
        
        
        int x = sequence1(t);
        int y = sequence2(t);
        System.out.println("X = " + x);
        System.out.println("Y = " + y);
    }
    
    public static int sequence1(int t)
    {
        if (t == 1)
        {
            return 1;
        }
        if (t == 2)
        {
            return 3;
        }
        
        return sequence1(t-1) + sequence1(t-2);
        
    }
    
    public static int sequence2(int t)
    {
        if (t == 1)
        {
            return 2;
        }
        
        
    }
    
}
