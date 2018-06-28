package unit6;

/**
 *
 * @author 1dingrai
 */
public class AndroidLock extends ConfigurableLock {

    //Generates a unique serial number
    int serialNumber = generateSerialNumber();

    //Initializes the maximum possible value on this lock
    public static final int MAX_COMBO_VALUE = 9;

    //Sets the lock's amount of digits
    int arrLength = 3;

    //Constructor for initialization
    //New combo passed as argument as user generates the combo
    public AndroidLock(int[] newCombo) {
        
        //Sets the size of the array to the amount of digits the lock has
        super.getSize(arrLength);
        
        //Calls upon a method of the parent class (ConfiguredLock.java)
        //This generates a combo by passing a range of values and saves returned value
        this.combo = super.generateCombo(0, MAX_COMBO_VALUE, newCombo);
        
        //Because combo is now set, the lock is locked.
        super.lock();
    }

}
