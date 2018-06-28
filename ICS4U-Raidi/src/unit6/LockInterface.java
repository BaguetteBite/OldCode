package unit6;

/**
 *
 * @author 1dingrai
 */
public interface LockInterface {
    
    public boolean isOpen();
    
    public int[] getCombo();
    
    public void unlock(int[] eCombo);
    
    public int getSerialNumber();
}
