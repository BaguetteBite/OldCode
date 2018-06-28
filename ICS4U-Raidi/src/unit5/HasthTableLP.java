package unit5;

/**
 *
 * @author 1dingrai
 */
public class HasthTableLP implements HashTableInterface {

    //Creates an array for the hashtable and a variable to track collisions
    Student[] table;
    int collisions;

    //Constructor for a hashtable with a user generated capacity
    public HasthTableLP(int n) {
        n = generatePrime(n);
        //Ensures that the new size is a prime number
        table = new Student[n];
        collisions = 0;
    }

    //Constructor that generates a default hashtable
    public HasthTableLP() {
        this(53);
        collisions = 0;
    }

    //Returns the amount of objects currently stored in the hashtable
    @Override
    public int size() {
        int size = 0;

        //Counts the amount of non-empty indexes in the array
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                size++;
            }
        }
        return size;
    }

    //Returns the amount of objects that hashtable can hold
    @Override
    public int capacity() {
        return table.length;
    }

    //Calculates how full the hashtable is
    @Override
    public double loadFactor() {
        return (double) size() / capacity();
    }

    //The hashtable is deleted when it is replaced with a new hashtable of the same capacity.
    @Override
    public void makeEmpty() {
        this.table = new Student[capacity()];
    }

    //Checks whether the hashtable is empty
    @Override
    public boolean isEmpty() {

        //Checks each index of the table. If all are null, table is empty.
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                return false;
            }
        }
        return true;
    }

    //Generates a new table of larger capacity when a load factor of 0.75 is reached.
    private void rehash() {

        //Generates a prime number (new capacity) four times larger than current capacity
        //This will make the load factor around 0.25
        System.out.println("The table has rehashed.");
        int n = this.size() * 4;
        n = generatePrime(n);

        //Temporary variable to hold the old table, which is replaced with the new capacity table
        Student[] old = table;
        table = new Student[n];

        //Hashes every object in the old table into the new table
        for (int i = 0; i < old.length; i++) {
            if (old[i] != null) {

                put(old[i].getStudentNumber(), old[i]);
            }
        }
    }

    //Gets a Student object by searching for its key
    private Student get(int key) {

        //Hashes the key in order to access the table
        int i = hash(key);
        System.out.println("GET" + i + " @ " + i);

        //Reads the entire table
        while (table[i] != null) {

            //Returns the corresponding student if the given key is found
            System.out.println("\tTRY " + i + " @ " + i);
            if (table[i].getStudentNumber() == key) {
                return table[i];
            }

            //Wraps around the table
            i = (i + 1) % capacity();
        }
        return null;
    }

    //Puts a Student into the table according to its key
    @Override
    public void put(int key, Student value) {
        
        //Prints collisions and load factors before putting
        System.out.println("Collisions: " + collisions);
        System.out.println("Load factor: " + this.loadFactor());

        //Gets index in table for storage of given Student
        int i = hash(key);

        //A collision occurs if the indexed location is already full
        //Tries next index until a collision does not occur
        while (table[i] != null) {
            collisions++;
            System.out.println("COLLISION OCCURED");
            i = (i + 1) % capacity();
        }
        
        //Puts Student in empty index location
        table[i] = value;

        // Checks whether load factor has been exceeded, rehashes if it has
        if (loadFactor() >= 0.75) {
            rehash();
        }

    }

    //Checks table to see if given Student exists
    @Override
    public boolean contains(Student value) {
        
        //If Student's key exists, student exists.
        return containsKey(value.getStudentNumber());
    }

    //Checks table to see if given Student key exists
    @Override
    public boolean containsKey(int key) {
        
        //If getting key returns null, key was not found.
        return get(key) != null;
    }

    //Hashes a key to return a table index to store the corresponding Student
    @Override
    public int hash(int key) {
        return key % this.capacity();
    }

    //Displays hashtable in a String format understandable by client
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < this.capacity(); i++) {

            s = s + String.format("%4s |", table[i]);
            s += "\n";
        }

        return s + "\n";
    }

    //Checks whether the capacity of the array is a prime number
    public static boolean checkPrime(int n) {
        for (int i = 2; 2 * i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    //If capacity of array is not a prime number, generate one.
    public static int generatePrime(int n) {
        int prime = n;
        boolean isPrime = false;

        //Increases a number by 1 until it is a prime number.
        while (!isPrime) {
            isPrime = checkPrime(prime);
            if (!isPrime) {
                prime++;
            }
        }
        return prime;
    }

}
