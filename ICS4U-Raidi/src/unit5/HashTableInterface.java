package unit5;

/**
 * Lesson: 6.04 - (Closed) Hash Table
 */
public interface HashTableInterface {


    /**
     * @return Returns the number of keys in this hashtable.
     */
    public int size();
    
    /**
     * @return Returns the capacity of this hash table.
     */
    public int capacity();
    
    /**
     * @return The load factor of the hashtable.
     */
    public double loadFactor();
    
    /**
     * Clears this hashtable so that it contains no keys.
     */
    public void makeEmpty();
    
    /**
     * Tests if this hashtable maps no keys to values.
     * @return 
     */
    public boolean isEmpty();
   
    /**
     *
     * @param key
     * @param value
     */
    public void put( int key, Student value);
    
    /**
     *
     * @param value
     * @return
     */
    public boolean contains( Student value );
    
    /**
     *
     * @param key
     * @return
     */
    public boolean containsKey( int key );
    
    /**
     *
     * @param key
     * @return
     */
    public int hash( int key );

}
