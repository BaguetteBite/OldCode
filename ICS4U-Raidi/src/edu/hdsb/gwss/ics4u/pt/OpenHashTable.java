package edu.hdsb.gwss.ics4u.pt;

/**
 * Open Hash Table
 * 
 * @version v2018.S2
 */
public class OpenHashTable {

    /**
     * Open Hash Table: an array of Linked Lists
     */
    private LinkedListPT[] data;

    /**
     * Creates an Open Hash Table; default size 11
     */
    public OpenHashTable() {
        this( 11 );
    }

    /**
     * Creates an Open Hash Table
     *
     * @param intialSize the initial capacity, rounded to the next prime.
     */
    public OpenHashTable( int intialSize ) {
        data = new LinkedListPT[nextPrime( intialSize )];
        makeEmpty();
    }

    /**
     * Make that hash table empty.
     */
    public void makeEmpty() {
        this.data = new LinkedListPT[capacity()];
    }

    /**
     * This method returns true if there are no student objects in the hash
     * table.
     *
     * @return true if the hash table contains no student objects.
     */
    public boolean isEmpty() {

        //Checks each index of the table. If all are null, table is empty.
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Gets the student object given the key (student number). This method does
     * NOT remove the object.
     *
     * @param key
     * @return student object for the given key (student number)
     */
    public CSStudent get( int key ) {
        
        //Hashes the key in order to access the table
        int i = hash(key);

        return data[i].get( key );
        
        
    }

    /**
     * Puts a student in the Hash Table. Duplicates are fine, and assume student
     * objects are correct and have unique keys.
     *
     * @param student valid student object
     */
    public void put( CSStudent student ) {

        //Gets index in table for storage of given Student
        int i = hash(student.getKey());

        //A collision occurs if the indexed location is already full
        //Tries next index until a collision does not occur
        
        //Puts Student in empty index location
        data[i].addAtEnd(student);
    }

    /**
     * Determines if a student object exists with the given key (student number)
     *
     * @param key key (student number)
     * @return returns true if the student with the given key (student number) exists
     */
    public boolean containsKey( int key ) {
        return get(key) != null;
    }

    /**
     * The number of student objects in the hash table.
     *
     * @return the number of student objects in the hash table.
     */
    public int size() {
        int size = 0;

        //Counts the amount of non-empty indexes in the array
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                size++;
            }
        }
        return size;
    }

    /**
     * The capacity of the Open Hash Table; THINK! THINK! THINK! TRICK?
     *
     * @return
     */
    public int capacity() {
        return data.length;
    }

    /**
     * COMPLETE!
     *
     * @return returns a graphic of the Open Hash Table
     */
    public String toString() {
        String s = "";
        for ( int i = 0; i < data.length; i++ ) {
            if( data[i] != null )
                s = s + "\n" + "HT[" + i + "] " + data[i].toString();
            else
                s = s + "\n" + "HT[" + i + "] EMPTY";
        }
        return s;
    }

    /**
     * Hash Function; COMPLETE
     *
     * @param key key (student number)
     * @return hash value
     */
    public int hash( int key ) {
        return key % data.length;
    }

    /**
     * COMPLETE
     */
    public static int nextPrime( int n ) {
        while ( !isPrime( n ) ) {
            n++;
        };
        return n;
    }

    /**
     * COMPLETE
     */
    private static boolean isPrime( long n ) {
        // EVEN TEST
        if ( n > 2 && ( n & 1 ) == 0 ) {
            return false;
        }
        // ODD FACTORS
        for ( int i = 3; i * i <= n; i += 2 ) {
            if ( n % i == 0 ) {
                return false;
            }
        }
        return true;
    }

}
