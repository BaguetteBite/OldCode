/*
 * Name: R. Ding
 * Date: Feb 9, 2018
 * Description: This program will determine whether text inputted is a palindrome.
 */
package unit1;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Palindrome2 
{
    public static void main(String[] args)
    {
        // CONSTANTS
        // VARIABLES
        String original;
        String backwards = "";
        int length, palindromes;
        char letter;
        StringTokenizer st;
        // OBJECTS
        Scanner input = new Scanner(System.in);
        // INTRO
        System.out.println("This program can determine whether text inputted is a"
                + " palindrome.");
        System.out.println("Please enter a line of text (No puncuation).");        
        // INPUT
        original = input.nextLine();
        // PROCESSING
        length = original.length();
        
        while (length > 0)
        {                      
            length -= 1;
            letter = original.charAt(length);
            backwards += Character.toString(letter);
        }
        
        // OUTPUT
        System.out.println(original + " backwards is " + backwards);
        if (original.equalsIgnoreCase(backwards))
        {
            System.out.println(original + " is a palindrome");
        }
        else
        {
            System.out.println(original + " is not a palindrome");
        }

    }
}

//Intro
//Get input from user
//Set a variable as the original
//Set variable for length
//Set a variable for the backwards
//Get length of original
//Initialize the while loop
//Use charAt length - 1 starting from the last letter to collect each letter and place in backwards
//Print "[original] backwards is [backwards]"
//Compare the backwards with the original with IgnoreCase
//Tell user whether word is palindrome
//Tell user to enter a sentence

//Create a string tokenizer
//Use tokenizer separate the words
//Take each word and put through the length loop
//Create palindromes variable
//If a word is a palindrome, add 1 to palindromes
//Format code
