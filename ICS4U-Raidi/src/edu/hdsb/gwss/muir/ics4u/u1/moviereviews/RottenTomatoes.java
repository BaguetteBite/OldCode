/*
 *Name: Raidi Ding
 *Date: Feb 13, 2018
 *Description: Testing ground for Movie Testing program
 */
package edu.hdsb.gwss.muir.ics4u.u1.moviereviews;
import java.util.Scanner;
import java.util.StringTokenizer;

public class RottenTomatoes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // CONSTANTS
        // VARIABLES
        // OBJECTS
        
        Scanner input = new Scanner(System.in);
        
        // INTRO
        // INPUT
        // PROCESSING
        String str = "Words in a String String";
        String word = "String";
        int count = 0;
        StringTokenizer st = new StringTokenizer( str );
                
        while( st.hasMoreTokens() ) 
        {
            System.out.println( st.nextToken() );
            if( st.nextToken().equalsIgnoreCase(word) )
                {
                    System.out.println("Yes");
                    count +=1;
                }
        }
        System.out.println(count);
        // OUTPUT
    }
    
}
