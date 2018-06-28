/*
 *
 */
package edu.hdsb.gwss.muir.ics4u.u1.moviereviews;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;

/**
 * Movie Review Assignment
 *
 * @author Wm.Muir
 * @version 2017-18.S2
 */
public class MovieReviewTester {

    public static void main(String[] args) throws Exception {

        // MOVIE REVIEW FILE
        File reviews = new File(".\\data\\movie.review\\MovieReviews.txt");
        File wordList;

        //Scanner and BufferedReader
        Scanner input = new Scanner(System.in);
        BufferedReader br = null;

        //Asking user what they wish to do
        System.out.println("What would you like to do?");
        System.out.println("1. Get the score of a word");
        System.out.println("2. Get the average score of words in a file (one word per line)");
        System.out.println("3. Find the highest/lowest scoring words in a file");
        System.out.println("4. Sort words from a file into positive.txt and negative.txt");
        System.out.println("5. Exit the program");
        String option = input.nextLine();

        //Initialization of variables
        String word;
        int wordCount = 0;
        int wordTotalScore = 0;
        double wordAverage = 0;

        // ********************************************************************
        // PART 1: Word Review
        if (option.equals("1")) {
            System.out.println("********************************");

            //User input for word and introduction
            System.out.println("Enter a word.");
            word = input.nextLine();
            System.out.println("PART 1: Word Review - " + word);

            // Execution of methods - More detail in main class containing each method           
            wordCount += MovieReview.wordCount(word, reviews);
            wordTotalScore += MovieReview.wordTotalScore(word, reviews);
            wordAverage += MovieReview.wordAverage(word, reviews, wordCount,
                    wordTotalScore);

            //Display of information to the user
            System.out.println(word.toLowerCase() + " appears " + wordCount + " times.");
            System.out.println("The average rating for reviews containing the word " + word.toLowerCase()
                    + " is " + wordAverage + ".");
        } // ********************************************************************
        // PART 2: Sentence Review
        else if (option.equals("2")) {
            //File retrieval from user input
            System.out.println("********************************");
            System.out.println("Enter the name of the file with words you want to find"
                    + " the average score for: ");

            //Initialization of file
            String filename = input.nextLine();
            wordList = new File(filename);

            //Try/catch for checking whether file is readable
            try {
                //Bufferedreader for reading file until there are no lines left
                br = new BufferedReader(new FileReader(wordList));
                while ((word = br.readLine()) != null) {
                    //Method execution and collection of SUM of word count and score.
                    wordCount += MovieReview.wordCount(word, reviews);
                    wordTotalScore += MovieReview.wordTotalScore(word, reviews);
                }

                //Calculating and displaying the average sentence score 
                double sentenceAverage = MovieReview.sentenceAverage(wordList, reviews,
                         wordCount, wordTotalScore);
                System.out.println("The average score of words in " + filename
                        + " is " + sentenceAverage);

                //Displays overall file sentiment from its score.
                if (sentenceAverage < 2) {
                    System.out.println("The overall sentiment is negative.");
                } else if (sentenceAverage > 2) {
                    System.out.println("The overall sentiment is positive.");
                } else {
                    System.out.println("The overall sentiment is neutral.");
                }
            } catch (IOException e) {
            } finally {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
        } // ********************************************************************
        // PART 3: Multiple Word Score
        else if (option.equals("3")) {
            //File retrieval from user input
            System.out.println("********************************");
            System.out.println("Enter the name of the file with words you want to find"
                    + " the average score for: ");

            //Initialization of file
            String filename = input.nextLine();
            wordList = new File(filename);

            //Variable declaration.
            double mostPositive = 0;
            double mostNegative = 0;
            String positiveWord = "";
            String negativeWord = "";

            //Try/catch for checking whether file is readable
            try {
                //This counter is used so that the only the first word in the file is 
                //set as the most positive and negative.
                int counter = 0;

                //BufferedReader for reading the file
                br = new BufferedReader(new FileReader(wordList));
                while ((word = br.readLine()) != null) {
                    //Executes methods in order to find the average score
                    wordCount = MovieReview.wordCount(word, reviews);
                    wordTotalScore = MovieReview.wordTotalScore(word, reviews);
                    wordAverage = MovieReview.wordAverage(word, reviews, wordCount,
                            wordTotalScore);

                    //If the new word is larger/smaller than the previously established
                    //most positive/negative, the new word replaces the old in the
                    //variable.
                    if (wordAverage > mostPositive) {
                        positiveWord = word;
                        mostPositive = wordAverage;
                    }

                    if (wordAverage < mostNegative) {
                        negativeWord = word;
                        mostNegative = wordAverage;
                    }

                    //Because do-while would be difficult to implement with a BufferedReader,
                    //a counter is used to set the first word as the most positive and negative.
                    if (counter == 0) {
                        mostPositive = wordAverage;
                        mostNegative = wordAverage;
                        positiveWord = word;
                        negativeWord = word;
                    }

                    //Ensures that only the first word goes through above 'if' statement
                    counter += 1;
                }

                //Displays calculations
                System.out.println("The most positive word, with a"
                        + " score of " + mostPositive + " is " + positiveWord);
                System.out.println("The most negative word, with a"
                        + " score of " + mostNegative + " is " + negativeWord);
            } catch (IOException e) {
            } finally {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
        } // ********************************************************************
        // PART 4: Multiple Word Score Sort
        else if (option.equals("4")) {

            //Initialization of file
            String filename = input.nextLine();
            wordList = new File(filename);

            //Try/catch for checking whether file is readable
            try {
                //BufferedReader for reading the file
                br = new BufferedReader(new FileReader(wordList));
                while ((word = br.readLine()) != null) {
                    //Executes all 3 methods to find the average score of each word
                    wordCount = MovieReview.wordCount(word, reviews);
                    wordTotalScore = MovieReview.wordTotalScore(word, reviews);
                    wordAverage = MovieReview.wordAverage(word, reviews, wordCount,
                            wordTotalScore);

                    //Creates and writes to positive.txt if the word is positive
                    if (wordAverage > 2) {
                        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                                new FileOutputStream("positive.txt"), "utf-8"))) {
                            writer.write(word);
                        }
                    } //Creates and writes to negative.txt if the word is negative
                    else if (wordAverage < 2) {
                        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                                new FileOutputStream("negative.txt"), "utf-8"))) {
                            writer.write(word);
                        }
                    }
                }
            } catch (IOException e) {
            } finally {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
        } // ********************************************************************
        // PART 5: Exit the program
        else if (option.equals("5")) {
            //This exits the program.
            System.exit(0);
        }
    }
}
