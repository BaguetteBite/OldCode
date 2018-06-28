/*
 *Name: Raidi Ding
 *Date: Feb 8, 2018
 *Description: Determines when Easter Sunday was on an inputted year
 */
package unit1;
import java.util.Scanner;


public class EasterComes {
    
    public static void main(String[] args) 
    {
        // CONSTANTS
        // VARIABLES
        int year, month, day;
        double a, b, c, d, e, f, g, h, i, k, j, m, p;
        // OBJECTS
        Scanner input = new Scanner(System.in);
        // INTRO
        // INPUT
        System.out.println("This program determines when Easter Sunday will"
                + "occur on a given year.");
        System.out.println("Please enter a year.");       
        // PROCESSING
        year = input.nextInt();
        a = year % 19;
        b = year / 100;
        c = year % 100;
        d = b / 4;
        e = b % 4;
        f = (b+8) / 25;
        g = (b - f + 1) / 3;
        h = (19*a + b - d - g + 15) % 30; //Correct
        i = c / 4; //Correct
        k = c % 4; //Correct
        j = (32 + 2*e + 2*i - h - k) / 7; //Correct
        m = (a + 11*h + 22*j) / 451; //Correct
        month = (int) ((h + j - 7*m + 114) / 31); //Correct
        p = (h + j - 7*m + 114) % 31; //Wrong?
        day = (int) (p + 1); //Wrong?
        // OUTPUT
      System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("d = " + d);
        System.out.println("e = " + e);
        System.out.println("f = " + f);
        System.out.println("g = " + g);
        System.out.println("h = " + h);
        System.out.println("i = " + i);
        System.out.println("j = " + j);
        System.out.println("k = " + k);
        System.out.println("m = " + m);
        System.out.println("month = " + month);
        System.out.println("p = " + p);
        System.out.println("day = " + day);
      //Day incorrect, month correct
    }
}

//Intro
//Get scanner to get year from user
//Finish the first 2
//Finish the first 4
//Finish the first 6
//Finish the first 8
//Finish the first 10

//Fix day

//Tell user answer

