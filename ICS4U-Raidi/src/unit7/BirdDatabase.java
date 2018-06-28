/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit7;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1dingrai
 */
public class BirdDatabase {

    private static RandomAccessFile raf;
    private static String birdsFile = "birds_info.txt";

    public static void open() {
        try {
            raf = new RandomAccessFile(birdsFile, "rw");

        } catch (IOException ex) {
            Logger.getLogger(BirdDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void close() {
        try {
            raf.close();
        } catch (IOException ex) {
            Logger.getLogger(BirdDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static BirdsRecord save(BirdsRecord b) {

        if (b.isValid()) {

            // ADD vs UPDATE
            if (b.getId() == -1) {
                try {
                    raf.seek(raf.length());
                    b.setId((int) (raf.length() / BirdsRecord.FILE_RECORD_SIZE) + 1);
                } catch (IOException ex) {
                    Logger.getLogger(BirdDatabase.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    raf.seek((long) (b.getId() - 1) * BirdsRecord.FILE_RECORD_SIZE);
                    // (id-1)*REC_SIZE
                } catch (IOException ex) {
                    Logger.getLogger(BirdDatabase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                System.out.println("---" + b.getCommonName() + " saved.");
                raf.writeChars(b.getCommonName());
                raf.writeChars(b.getScientificName());
                raf.writeDouble(b.getPopulationInMillions());
                raf.writeInt(b.getWingspan());
                raf.writeInt(b.getLongestLifespan());
                raf.writeBoolean(b.isBirdOfPrey());
                raf.writeChar(b.getInAmerica());
                System.out.println( raf.length() );
            } catch (IOException ex) {
                Logger.getLogger(BirdDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        return b;
    }

    public static BirdsRecord get(int id) {
         BirdsRecord br = null;
        try {
            //        Scanner input = new Scanner(System.in);
//        long fileLength = raf.length();
//        final long RECORD_SIZE = 97;
//        long numRecords = fileLength / RECORD_SIZE;
//        
//        System.out.println("\nThere are " + numRecords + " records currently in the file.");
//        System.out.println("Which record do you want [1 - " + numRecords + "] or 0 to exit?");
//        
//        long chosenRecord;
//        long position;
//        chosenRecord = Long.parseLong( input.nextLine() );
            raf.seek((id - 1) * BirdsRecord.FILE_RECORD_SIZE);

            br = new BirdsRecord();
            br.setId(id);
            char commonName[] = new char[BirdsRecord.COMMON_RECORD_SIZE];
            for (int i = 0; i < BirdsRecord.COMMON_RECORD_SIZE; i++) {
                commonName[i] = raf.readChar();
            }
            br.setCommonName(new String(commonName));

            char scientificName[] = new char[BirdsRecord.SCIENTIFIC_RECORD_SIZE];
            for (int i = 0; i < BirdsRecord.SCIENTIFIC_RECORD_SIZE; i++) {
                scientificName[i] = raf.readChar();
            }
            br.setScientificName(new String(scientificName));

            br.setPopulationInMillions(raf.readDouble());
            br.setWingspan(raf.readInt());
            br.setLongestLifespan(raf.readInt());
            br.setBirdOfPrey(raf.readBoolean());
            br.setInAmerica(raf.readChar());

            System.out.println(br.toString());
        } catch (IOException ex) {
            Logger.getLogger(BirdDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }

        return br;
    }
    
}
