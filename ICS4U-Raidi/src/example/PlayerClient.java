/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author 1dingrai
 */
public class PlayerClient implements Serializable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
//        String[] sponsors = {"abc", "def"};
//        Player a = new Player("Fred", 20, sponsors);
//
//        File file = new File("players.dat");
//        FileOutputStream fos = new FileOutputStream(file);
//
//        ObjectOutputStream out = new ObjectOutputStream(fos);
//
//        out.writeObject(a);
//        
//        out.close();
//        
//        FileInputStream fis = new FileInputStream(file);
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        
//        Player aa = (Player) ois.readObject();
//        ois.close();

        Scanner i = new Scanner(System.in);
        
        try{
          int x = i.nextInt();
            double y = i.nextDouble();  
        } catch(InputMismatchException e)
        {
            System.out.println("What to do?");
        }
        
    }

}
