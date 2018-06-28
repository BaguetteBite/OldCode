package unit6;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author 1dingrai
 */
public abstract class Locks implements LockInterface {

    //Arraylist to store serial numbers to ensure each is unique
    private static ArrayList<Integer> sns = new ArrayList<Integer>();

    //Instance variables
    protected boolean revealed;
    private boolean serialRevealed = false;
    protected int[] combo;
    protected boolean open;
    private int serialNumber;
    private int attempts;
    protected boolean lockedOut;
    int[] enteredCombo;
    int serialSize = 100;

    //Class variables
    public static int size;

    //Constructor, setting of initial conditions
    public Locks() {
        generateSerialNumber();
        combo = new int[3];
        open = true;
        attempts = 0;
        lockedOut = false;
    }

    //Generates a serial number - only works once
    protected int generateSerialNumber() {

        //Generates random serial numbers until an unique one is created.
        if (!serialRevealed) {
            do {
                serialNumber = (int) (Math.random() * (serialSize + 1));
            } while (sns.contains(serialNumber));
            serialRevealed = true;
            return serialNumber;

            //Serial numbers can only be generated in the constructor when a lock is first created.
        } else {
            System.out.println("Cannot generate new serial numbers.");
            return -1;
        }
    }

    //Gets the combo that the user passes to unlock the lock
    private int[] getEnteredCombo(int[] eCombo) {
        enteredCombo = eCombo;
        return enteredCombo;
    }

    //Checks whether or not lock is open
    @Override
    public boolean isOpen() {
        return open;
    }

    //Locks the lock, but only if lock is open and user isn't locked out.
    protected void lock() {
        if (open && !lockedOut) {
            open = false;
        } else {
            System.out.println("You cannot lock an already locked lock");
        }
    }

    //Locks out user due to multiple failed attempts, limits action
    protected void lockOut() {
        if (attempts == 3) {
            System.out.println("You are out of attempts, and have been locked out.");
            open = false;
            lockedOut = true;
        } else {
            lockedOut = false;
        }
    }

    //Gets the size of the array, or amount of digits the lock uses.
    public int getSize(int arrSize) {
        size = arrSize;
        return size;
    }

    //Gets the unique serial number of a given lock.
    @Override
    public int getSerialNumber() {
        System.out.println("Serial number is " + serialNumber);
        return serialNumber;
    }

    //Gets the combo. Abstract method, differs between child classes (fixed and configurable)
    @Override
    public abstract int[] getCombo();

    //Converts information (lock digits) into a string that can be read by the user.
    public String toString() {
        String s = "";

        //Loops through entire array and adds integer contents to a string
        for (int i = 0; i < combo.length; i++) {
            s += combo[i];
            if (i < size - 1) {
                s += "-";
            }
        }
        return s;
    }

    //Unlocks the lock
    @Override
    public void unlock(int[] eCombo) {

        //Cannot open an unlocked lock, and cannot open when locked out
        if (!open && !lockedOut) {

            //Gets a combo from the user
            this.getEnteredCombo(eCombo);

            //Checks whether user's combo has the same value as the actual combo.
            if (Arrays.equals(combo, enteredCombo)) {
                System.out.println("Lock opened.");
                open = true;

                //Resets attempts if lock opened.
                attempts = 0;
            } else {

                //Tracks attempts made to open the lock.
                System.out.println("You have " + (3 - attempts) + " attempt(s) left.");
                attempts++;
                System.out.println("Incorrect combo");

            }
        } else if (open && !lockedOut) {
            System.out.println("The lock is already open.");
        }

        //Locks out user if they consequtively enter 3 incorrect combos.
        lockOut();
    }

    //hashCode for .equals()
    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    //Comparison of serial number to ensure that each is unique
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Locks other = (Locks) obj;
        if (this.serialNumber != other.serialNumber) {
            return false;
        }
        return true;
    }

}
