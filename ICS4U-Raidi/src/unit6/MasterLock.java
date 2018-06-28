package unit6;

/**
 *
 * @author 1dingrai
 */
public class MasterLock extends FixedLock {

    //Generates a unique serial number
    int serialNumber = generateSerialNumber();

    //Initializes the maximum possible value on this lock
    public static final int MAX_COMBO_VALUE = 39;

    //Sets the lock's amount of digits
    int arrLength = 3;

    //Constructor for initialization
    public MasterLock() {

        //Calls upon a method of the parent class (FixedLock.java)
        //This generates a combo by passing a range of values and saves returned value
        combo = super.generateCombo(0, MAX_COMBO_VALUE);

        //Sets the size of the array to the amount of digits the lock has
        super.getSize(arrLength);

        //Because combo is now set, the lock is locked.
        super.lock();
    }

}
