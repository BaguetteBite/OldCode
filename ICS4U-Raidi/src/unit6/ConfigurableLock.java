package unit6;

import java.util.Scanner;

/**
 *
 * @author Raidi
 */
public class ConfigurableLock extends Locks {

    //Creates a scanner object
    Scanner input = new Scanner(System.in);

    //Constructor for initialization
    public ConfigurableLock() {
        System.out.println("ConfigurableLock() : Configurable Lock Constructor");

        //Creates an empty array of a given size
        for (int i = 0; i < this.combo.length; i++) {
            this.combo[i] = -1;
        }
    }

    //Gets the combo of the lock. Only works once for each set combination
    @Override
    public int[] getCombo() {

        if (!lockedOut) {
            //Conditions for whether user or not user has already called method
            if (!this.revealed) {

                //Returns the lock's combo, but cannot do it again for the same combo.
                System.out.println("ConfigurableLock.getCombo() : Combo Revealed!");
                this.revealed = true;
            } else {

                //Does not return the combo, since it was already revealed.
                System.out.println("ConfigurableLock.getCombo() : Combo Already Revealed!");
                combo = null;
            }
        } else {
            System.out.println("Cannot get combo, you are locked out.");
            combo = null;
        }

        return combo;
    }

    //Generates a combo for a configurable lock. Can be called multiple times.
    int[] generateCombo(int minValue, int maxValue, int[] newCombo) {

        //Combo only generated if not locked out.
        if (!lockedOut) {

            //Only accepts combo if within minValue and maxValue. Otherwise locks out.
            for (int i = 0; i < size; i++) {
                if (newCombo[i] > maxValue || newCombo[i] < minValue) {
                    System.out.println("Each combo digit must be between 0 and 9.");
                    lockOut();
                    return null;
                }
            }

            if (open) {
                //Only changes combination when lock is open.
                System.out.println("Your combination has been changed.");
                combo = newCombo;

                //Allows usage of getCombo() again.
                revealed = false;
            } else {
                System.out.println("Cannot generate, lock isn't open.");
            }

        } else {
            //Does not return the combo if locked out.
            System.out.println("Cannot generate combo when locked out.");
            combo = null;
        }
        return combo;
    }

}
