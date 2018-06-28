package unit7;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Raidi
 */
public class BirdsStore {

    public static void main(String args[]) throws Exception {

        Scanner input = new Scanner(System.in);

        BirdsRecord b1 = new BirdsRecord("osprey", "Pandion haliaetus", 0.46, 180, 25, true, 'Y');

        BirdsRecord b2 = new BirdsRecord(" griffon vulture", "Gyps fulvus", 0.50, 280, 41, true, 'Y');

        BirdsRecord b3 = new BirdsRecord("barn owl", "Tyto alba", 0.15, 95, 25, true, 'Y');

        BirdsRecord b4 = new BirdsRecord("chicken", "Gallus gallus domesticus", 50000, 60, 11, false, 'Y');

        BirdsRecord b5 = new BirdsRecord("Adelie penguin", "Pygoscelis adeliae", 5, 73, 20, false, 'N');

        BirdsRecord b6 = new BirdsRecord("little gull", "Hydrocoloeus minutus", 0.27, 78, 10, false, 'Y');

        BirdsRecord b7 = new BirdsRecord("goldcrest", "Regulus regulus", 200, 15, 2, false, 'Y');

        BirdsRecord b8 = new BirdsRecord("shoebill", "Balaeniceps rex", 0.01, 260, 35, false, 'N');

        String birdFile = "birds_info.txt";
        
        RandomAccessFile birdsFile = new RandomAccessFile(birdFile, "rw");
//        FileOutputStream fos = new FileOutputStream(birdFile);
//        ObjectOutputStream newBird = new ObjectOutputStream(fos);
        
        birdsFile.seek(0);

        // WRITE RECORD
        b1.writeBirds(b1, birdsFile);
        b2.writeBirds(b2, birdsFile);
        b3.writeBirds(b3, birdsFile);
        b4.writeBirds(b4, birdsFile);
        b5.writeBirds(b5, birdsFile);
        b6.writeBirds(b6, birdsFile);
        b7.writeBirds(b7, birdsFile);
        b8.writeBirds(b8, birdsFile);

        long fileLength = birdsFile.length();
        final long RECORD_SIZE = 97;
        long numRecords = fileLength / RECORD_SIZE;

//        System.out.println("There are " + numRecords + " records in the file.");
//        System.out.println("Which record would you like to look at?");
        System.out.println("\nThere are " + numRecords + " records currently in the file.");
        System.out.println("Which record do you want [1 - " + numRecords + "] or 0 to exit?");

        long chosenRecord;
        long position;
        chosenRecord = Long.parseLong( input.nextLine() );
        position = (chosenRecord - 1) * RECORD_SIZE;

        birdsFile.seek(position);

        BirdsRecord br = new BirdsRecord();

        char commonName[] = new char[BirdsRecord.COMMON_RECORD_SIZE];
        for (int i = 0; i < BirdsRecord.COMMON_RECORD_SIZE; i++) {
            commonName[i] = birdsFile.readChar();
        }
        br.setCommonName(new String(commonName));

        char scientificName[] = new char[BirdsRecord.SCIENTIFIC_RECORD_SIZE];
        for (int i = 0; i < BirdsRecord.SCIENTIFIC_RECORD_SIZE; i++) {
            scientificName[i] = birdsFile.readChar();
        }
        br.setScientificName(new String(scientificName));

        br.setPopulationInMillions(birdsFile.readDouble());
        br.setWingspan(birdsFile.readInt());
        br.setLongestLifespan(birdsFile.readInt());
        br.setBirdOfPrey(birdsFile.readBoolean());
        br.setInAmerica(birdsFile.readChar());

        System.out.println(br.toString());

        System.out.println("Enter [new name] or [k]eep current name: ");
        String newCommon = input.nextLine();

        if (!"k".equals(newCommon)) {
            br.setCommonName(newCommon);
        }

        System.out.println("Enter [new name] or [k]eep current name: ");
        String newScientific = input.nextLine();

        if (!"k".equals(newScientific)) {
            br.setScientificName(newScientific);
        }
//        System.out.println(br.toString());
    }
}
