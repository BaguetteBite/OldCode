package unit5;

/**
 *
 * @author 1dingrai
 */
public class Queue implements QueueInterface {

    //Initializes the array, as well as a front and back pointer
    int front, back;
    int arr[];

    //Constructor for an empty array
    public Queue(int n) {
        arr = new int[n];
        front = -1;
        back = -1;
    }

    //Second constructor, creates an array of length 10
    public Queue() {
        this(10);
    }

    //Returns the front of the queue
    @Override
    public Integer front() {

        //Integer only returned if queue isn't empty
        if (this.isEmpty() == false) {
            return arr[front];
        }

        //Returns -1 is queue is empty
        return -1;
    }

    //Returns the back of the queue
    @Override
    public Integer back() {

        //Integer only returned if queue isn't empty
        if (this.isEmpty() == false) {
            return arr[back];
        }

        //Returns -1 is queue is empty
        return -1;
    }

    //Adds an Integer to the back of the queue
    @Override
    public void enqueue(Integer value) {

        //Moves pointers into the queue if value is first Integer in queue
        if (isEmpty()) {
            front = 0;
            back = 0;
            arr[back] = value;
        } else if (!this.isFull()) {

            //Code only runs if queue isn't full
            //Adds value to back of queue, done with a formula.
            back = (back + 1) % capacity();
            arr[back] = value;
        } else {
            System.out.println("Cannot enque, queue is full.");
        }
    }

    //Removes an Integer from the front of the queue
    @Override
    public Integer dequeue() {

        //Cannot deque if nothing is in queue
        if (isEmpty()) {
            System.out.println("Cannot deque, queue is empty");
            return null;
        }
        //Returns the original front and moves front pointer to next Integer in queue
        int frontTemp = arr[front];
        front++;
        return frontTemp;
    }

    //Formula credit to Ahmed, permission received
    //Returns the amount of Integers in the queue
    @Override
    public int size() {

        //Returns 0 if the queue is empty
        if (this.isEmpty()) {
            return 0;
        }

        //Formulas to determine size of queue when not empty
        if (front > back) {
            return (this.capacity() - front) + back + 1;
        } else {
            return back - front + 1;
        }

    }

    //Returns the amount of Integers the queue can hold
    @Override
    public int capacity() {
        return arr.length;
    }

    //Checks to see if the queue is empty
    @Override
    public boolean isEmpty() {

        //When queue is empty, pointers are outside of the queue
        return this.front == -1 && this.back == -1;
    }

    //Checks to see if the queue is full
    @Override
    public boolean isFull() {
        return this.size() == this.capacity();
    }

    //Empties the queue by moving the pointers. This allows overwriting of existing content.
    @Override
    public void makeEmpty() {
        front = -1;
        back = -1;
    }

    //Converts the array to a string
    @Override
    public String toString() {

        String s = "--------------------------\n";

        for (int i = 0; i < this.capacity(); i++) {
            if (i == front && i == back) {
                s = s + String.format("%4s", "FB");
            } else if (i == front) {
                s = s + String.format("%4s", "F");
            } else if (i == back) {
                s = s + String.format("%4s", "B");
            } else {
                s = s + String.format("%4s", "");
            }
        }
        s = s + "\n";
        for (int i = 0; i < this.capacity(); i++) {
            s = s + String.format("%4s", arr[i]);
        }

        return s;

    }

}
