package unit6;

/**
 *
 * @author 1dingrai
 */
public class FixedLock extends Locks {

    boolean lockGenerated = false;

    //Constructor for initialization
    public FixedLock() {
        System.out.println("FixedLock() : Fixed Lock Constructor");

        //Revealed is false since user has not called getCombo()
        this.revealed = false;
    }

    //Gets the combo that was unlocks the lock. Only works once.
    @Override
    public int[] getCombo() {

        //Only gets combo if not locked out
        if (!lockedOut) {
            //Checks for reveal status to determine whether or not to return combo
            if (!this.revealed) {

                //Sets revealed to false so that method can only be used once
                System.out.println("FixedLock.getCombo() : Combo Revealed!");
                this.revealed = true;
            } else {

                //Returns a null array instead of the actual combo
                System.out.println("FixedLock.getCombo() : Combo Already Revealed!");
                combo = null;
            }

        } else {

            //No action can be taken if locked out.
            System.out.println("Unable to access, you are locked out.");
            combo = null;
        }
        return combo;
    }

    //Generates a random value combo a fixed value lock
    protected int[] generateCombo(int minValue, int maxValue) {

        //Combo only generated when lock is initialized
        if (!lockGenerated) {

            //Generates random digits within a range to create a combo
            for (int i = 0; i < combo.length; i++) {
                combo[i] = (int) (Math.random() * (maxValue - minValue + 1));
            }

            //Ensures that combo is only generated once upon creation
            lockGenerated = true;

            //Combo for fixed lock cannot be generated outside of constructor.    
        } else {
            System.out.println("FixedLock.generateCombo(int minValue, int maxValue) : You cannot set a combo for a fixed lock.");
        }
        return combo;
    }
}
