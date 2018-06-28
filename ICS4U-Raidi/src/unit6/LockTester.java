package unit6;

/**
 *
 * @author 1dingrai
 */
public class LockTester {

    /**
     * @param args the command line arguments
     */
    //Add isOpen cases for configurable locks
    //Make cases for getCombo
    public static void main(String[] args) {

        //Fixed locks have random combos, nearly impossible to unlock with set combos.
        System.out.println("MASTER LOCK \n");

        //Creates a new locked Master lock, gets and prints its combo.
        MasterLock master = new MasterLock();
        assert (!master.isOpen());
        master.getCombo();
        System.out.println(master.toString());

        //Tries to generate a serial number, which does not work.
        master.getSerialNumber();
        master.generateSerialNumber();
        master.getSerialNumber();

        //Try to get a combo a second time. Should not work.
        master.getCombo();

        //Trying to generate a combo for a fixed lock.
        //This should not work.
        master.generateCombo(0, 59);
        
        //Unlocking lock with incorrect combos
        int[] aMaster = {1, 2, 3};
        master.unlock(aMaster);

        int[] bMaster = {2, 3, 4};
        master.unlock(bMaster);

        assert (!master.isOpen());

        int[] cMaster = {2, 4, 9};
        master.unlock(cMaster);
        
        //At this point, user is locked out and incapable of many functions.

        //Try to unlock again after being locked out
        master.unlock(cMaster);
        assert (!master.isOpen());

        //Unsuccessfully generate a new combo
        master.generateCombo(0, 39);
        assert (!master.isOpen());

        System.out.println("\n ---------------------");

        System.out.println("DUBDLY LOCK \n");

        //Creates a new locked Dubdly lock, gets and prints its combo.
        DubdlyLock dubdly = new DubdlyLock();
        assert (!dubdly.isOpen());
        dubdly.getCombo();
        System.out.println(dubdly.toString());

        //Tries to generate a serial number, which does not work.
        dubdly.getSerialNumber();
        dubdly.generateSerialNumber();
        dubdly.getSerialNumber();

        //Trying to generate a lock before being locked out
        //This should not work.
        dubdly.generateCombo(0, 59);
        assert (!dubdly.isOpen());
        
        //Unlocking lock with incorrect combos
        int[] aDubdly = {1, 2, 3};
        dubdly.unlock(aDubdly);

        int[] bDubdly = {2, 3, 4};
        dubdly.unlock(bDubdly);

        int[] cDubdly = {2, 4, 9};
        dubdly.unlock(cDubdly);
        
        //At this point, user is locked out and incapable of many functions.

        //Try to unlock again after being locked out
        dubdly.unlock(cDubdly);

        //Unsuccessfully generate a new combo
        dubdly.generateCombo(0, 59);
        assert (!dubdly.isOpen());

        System.out.println("\n ---------------------");

        System.out.println("ANDROID LOCK \n");

        //Creates an initial combo to set the lock's combo as
        int[] comboAndroid = {1, 2, 3};

        //Creates a new locked Android lock, gets and prints its combo.
        AndroidLock android = new AndroidLock(comboAndroid);
        assert (!android.isOpen());
        android.getCombo();
        System.out.println(android.toString());

        //Tries to generate a serial number, which does not work.
        android.getSerialNumber();
        android.generateSerialNumber();
        android.getSerialNumber();

        //Opens the lock by passing a correct combo.
        int[] aAndroid = {1, 2, 3};
        android.unlock(aAndroid);
        assert (android.isOpen());

        //Trying to open an already open lock
        int[] bAndroid = {2, 3, 4};
        android.unlock(bAndroid);

        //Checks to see if attempts reset
        android.lock();
        android.unlock(bAndroid);
        android.unlock(bAndroid);
        android.unlock(aAndroid);
        android.lock();
        android.unlock(bAndroid);
        android.unlock(aAndroid);
        
        //Creates a new combo while unlocked
        android.generateCombo(0, 9, bAndroid);
        android.lock();
        android.getCombo();
        System.out.println(android.toString());
        
        //Unlocks lock with new combo
        android.unlock(aAndroid);
        android.unlock(bAndroid);
        android.lock();
        
        //Doesn't generate combo, lock not open
        android.generateCombo(0, 9, bAndroid);

        System.out.println("\n ---------------------");

        System.out.println("MASTERU LOCK \n");

        //Creates a new locked MasterU lock, gets and prints its combo.
        int[] comboMasterU = {1, 2, 3, 9};
        MasterULock masterU = new MasterULock(comboMasterU);
        assert (!masterU.isOpen());
        masterU.getCombo();

        //Tries to generate a serial number, which does not work.
        masterU.getSerialNumber();
        masterU.generateSerialNumber();
        masterU.getSerialNumber();

        //Opens the lock by passing a correct combo.
        int[] aMasterU = {1, 2, 3, 9};
        masterU.unlock(aMasterU);
        assert (masterU.isOpen());

        //Trying to open an already open lock
        int[] bMasterU = {2, 3, 4, 5};
        masterU.unlock(bMasterU);

        masterU.lock();
        assert (!masterU.isOpen());

        //Checks to see if attempts reset
        masterU.lock();
        masterU.unlock(bMasterU);
        masterU.unlock(bMasterU);
        masterU.unlock(aMasterU);
        masterU.lock();
        masterU.unlock(bMasterU);
        masterU.unlock(aMasterU);

        //Creates a new combo while unlocked
        masterU.generateCombo(0, 9, bMasterU);
        masterU.lock();
        masterU.getCombo();
        System.out.println(masterU.toString());
        
        //Unlocks lock with new combo
        masterU.unlock(aMasterU);
        masterU.unlock(bMasterU);
        masterU.lock();
        
        //Doesn't generate combo, lock not open
        masterU.generateCombo(0, 9, bMasterU);
    }

}
