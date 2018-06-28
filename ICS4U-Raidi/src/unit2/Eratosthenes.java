/*
 *Name: Raidi Ding
 *Date: Feb 23, 2018
 *Description:
 */
package unit2;
import java.util.Scanner;
import java.util.ArrayList;

public class Eratosthenes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // CONSTANTS
        // VARIABLES
        boolean numbers[] = new boolean[1000];
        int values[] = new int[1000];

        
        // OBJECTS  
        Scanner input = new Scanner(System.in);
 
        // INTRO
        // INPUT
        // PROCESSING
        for (int i = 0; i < 1; i++) 
        {
            if ( values[i] % i == 0)
            {
                numbers[i] = false;
            }
            
        }
        
        // OUTPUT
    }
}

//Create the array
//make a for statement to hold the numbers
//Put boolean[i] in the for loop