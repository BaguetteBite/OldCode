/*
 *Name: Raidi Ding
 *Date: Feb 8, 2018
 *Description: Finds the distance between two locations on earth based on latitude
    and longitude.
 */
package unit1;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import java.util.Scanner;

public class DistanceCalculator {

    public static void main(String[] args) {
        // CONSTANTS
        // VARIABLES
        double lat1, lon1, lat2, lon2, formula;
        // OBJECTS        
        Scanner input = new Scanner(System.in);
        // INTRO
        System.out.println("This program finds the distance between two places on"
                + "earth.");
        System.out.println("Please enter all values in radians.");
        System.out.println("Use positive values for north and west latitudes");
        System.out.println("Use negative values for south and east latitudes");

        // INPUT    
        System.out.println("Please enter the latitude of location 1.");
        lat1 = input.nextDouble();
        System.out.println("Please enter the longitude of location 1.");
        lon1 = input.nextDouble();
        System.out.println("Please enter the latitude of location 2.");
        lat2 = input.nextDouble();
        System.out.println("Please enter the longitude of location 2.");
        lon2 = input.nextDouble();
        // PROCESSING
        formula = 6378.8 * Math.acos(sin(lat1) * sin(lat2) + cos(lat1) * cos(lat2) * cos(lon2 - lon1));

        /*System.out.println(lat1);
        System.out.println(lat2);
        System.out.println(lon1);
        System.out.println(lon2);
         */
        // OUTPUT
        System.out.println("Distance is " + formula);
    }
}

//Intro
//Get info from user
//Initialize the latitudes and longitudes
//Initialize each formula
//Make positives and negatives known
//Print all known info on screen
//Calculate the distance
//Print distance
