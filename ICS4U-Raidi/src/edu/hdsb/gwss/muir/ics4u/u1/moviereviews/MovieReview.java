/*
 *
 */
package edu.hdsb.gwss.muir.ics4u.u1.moviereviews;

import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;


/**
 * Movie Review Assignment
 *
 * @author Wm.Muir
 * @version 2017-18.S2
 */
public class MovieReview {

    public static void main( String[] args ) throws Exception {

        // MOVIE REVIEW FILE
        File reviews = new File( ".\\data\\movie.review\\MovieReviews.txt" );
   
    }

    /**
     * This method will count the number of reviews that contain the key word.
     *
     * @param word the key word the review must contain.
     * @param reviews the file that contains the movie reviews.

     * @return the number of reviews that contain the key work at least once.
     * @throws java.lang.Exception
     */
    
    //Calculates how many lines contain the inputted word.
    public static int wordCount( String word, File reviews) throws Exception {

        //Initializing variables and objects.
        int wordCount = 0;
        Scanner sc = new Scanner(reviews);
        String line;
        StringTokenizer st;
        
        //While loop for each line
        while (sc.hasNextLine())   
        {         
            line = sc.nextLine();
            st = new StringTokenizer( line );
            
            //While loop for each word in a line
            while( st.hasMoreTokens() ) 
            {
                //Ensures that repeated words in a line are only added once.
                if ( st.nextToken().equalsIgnoreCase(word))
                {
                   wordCount += 1;
                   break;
                }
            } 
        }
        //Returns the value to MovieReviewTester.java . 
        return wordCount;  
    }

    /**
     * This method will accumulate the the movie review scores that contain the
     * key word.
     *
     * @param word the key word the review must contain.
     * @param reviews the file that contains the movie reviews.
     * @return the sum of the scores for reviews that contain the key work at
     * least once.
     * @throws java.lang.Exception
     */
    
    //Calculates the sum of ratings in each review the word is found
    public static int wordTotalScore( String word, File reviews) throws Exception 
    {
        //Initializing variables and objects.
        int wordTotalScore = 0;
        Scanner sc = new Scanner(reviews);
        String line;
        StringTokenizer st;
        
        //While loop for each line
        while (sc.hasNextLine())   
        {         
            boolean wordAppeared = false;
            line = sc.nextLine();
            st = new StringTokenizer( line );
            String[] lineTokenizer = line.split(" ");
            
            //While loop for each word in a line
            while( st.hasMoreTokens() ) 
            {
                //Checks whether word appears in a line
                if ( st.nextToken().equalsIgnoreCase(word))
                {
                   wordAppeared = true;
                   break;
                }
            }
            
            //If word appeared in the line, the rating of the review is recorded.
            if (wordAppeared)
            {
                wordTotalScore += Integer.parseInt( lineTokenizer[0] );
            } 
        }
        
        //Returns the value to MovieReviewTester.java . 
        return wordTotalScore;
    }

    /**
     * Average score of reviews containing that word, given the specified file.
     *
     * @param word the key word the review must contain.
     * @param reviews reviews the file that contains the movie reviews.
     * @param wordCount
     * @param wordTotalScore
     * @return the average score for the key word. Word Total Score / Word Count
     * @throws java.lang.Exception
     */
    
    //Calculates the average score/positivity of the given word
    public static double wordAverage( String word, File reviews, int wordCount,
            int wordTotalScore) throws Exception 
    {
        //Returns the sum of ratings / amount of times it appears (definition of average)        
        double wordAverage = (double) wordTotalScore/wordCount;
        
        //Returns the value to MovieReviewTester.java . 
        return wordAverage;
    }

    /**
     * This method returns the average movie review score of the words in the
     * file, given th specified movie review file.
     * @param wordList
     * @param reviews
     * @param wordCount
     * @param wordTotalScore
     * @return 
     * @throws java.lang.Exception
     */
    public static double sentenceAverage( File wordList, File reviews, int wordCount,
            int wordTotalScore) throws Exception 
    {

        double sentenceAverage = (double) wordTotalScore / wordCount;
        return sentenceAverage;
    }
}
