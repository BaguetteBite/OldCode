package edu.hdsb.gwss.ics4u.pt;

/**
 * Linked List of Students
 *
 * @version v2018.S2
 */
public class LinkedListPT {

    private NodePT head;
    private NodePT tail;

    /**
     * Constructor: Empty Linked List
     */
    public LinkedListPT() {
        this.head = null;
        this.tail = null;
    }

    /**
     * @return returns the size (# of students) in the linked list.
     */
    public int size() {
        int listSize;

        //The size is 0 if the LinkList is empty
        if (this.isEmpty()) {
            listSize = 0;
        } else {
            //Starts at the head and counts each node in LinkList
            //Amount of nodes = size
            NodePT temp = this.head;
            int counter = 1;

            while (temp.getNext() != null) {
                counter++;
                temp = temp.getNext();
            }
            listSize = counter;
        }
        return listSize;
    }

    /**
     * This method makes the linked list empty.
     */
    public void makeEmpty() {
        this.head = null;
        this.tail = null;
    }

    /**
     * This method returns true if the linked list is empty
     *
     * @return returns true if there are no student objects in the linked list
     */
    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;

    }

    /**
     * This method adds a student object to the end of the linked list.
     *
     * @param student
     */
    public void addAtEnd(CSStudent student) {
        if (this.isEmpty()) {
            //If this is the only node in the List, it is both head and tail
            //Sets the space after the head to 'null'
            head = new NodePT(student);
            tail = head;
            tail.setNext(null);
        } else {
            //Makes the new node the tail, previous tail points to it
            //Sets a null after the tail
            NodePT newNode = new NodePT(student);
            tail.setNext(newNode);
            this.tail = newNode;
            tail.setNext(null);
        }
    }

    /**
     * This method will get a student object from the linked list, given the
     * student number
     *
     * @param key student number (key)
     * @return returns the student object for the given key, or null if it
     * doesn't exist.
     */
    public CSStudent get(int key) {
        boolean found = false;
        CSStudent s = null;

        NodePT currentNode = head;
        NodePT after;
        NodePT before;
        //Code runs only if the LinkList isn't empty
        if (!this.isEmpty()) {
            if (this.size() == 1 && this.head.getData().getKey() == key) {
                s = this.head.getData();
            } else if (this.size() == 2) {
                if (this.head.getData().getKey() == key) {
                    s = this.head.getData();
                } else if (this.head.getNext().getData().getKey() == key) {
                    s = this.head.getNext().getData();
                }
            }
            //Runs only if there are nodes left in the LinkList and while target hasn't been found
            //The found condition ensures that only the first occurence is removed
            while (currentNode.getNext() != null && found == false) {
                //Checks to see if the node after the pointer contains the target value
                if (currentNode.getNext().getData().getKey() == key) {
                    //Sets found to true so that loop ends because target found
                    found = true;
                    s = currentNode.getData();
                }

                //Moves the pointer to the next node
                currentNode = currentNode.getNext();
            }
            if (!found) {

                //End of LinkList reached, value not found
                System.out.println("The given value was not found.");
            }
        } else {

            //Can't remove from empty LinkList
            System.out.println("LinkList is empty, can't remove.");
        }
        return s;
    }

    /**
     * This method will remove a student object from the linked list, given the
     * student number.
     *
     * @param key student number (key)
     * @return returns the removed student object, or null if the key is not
     * found
     */
    public CSStudent remove(int key) {
        boolean found = false;
        CSStudent s = null;

        NodePT currentNode = head;
        NodePT after;
        NodePT before;
        //Code runs only if the LinkList isn't empty
        if (!this.isEmpty()) {
            if (this.size() == 1 && this.head.getData().getKey() == key) {
                s = this.head.getData();
                makeEmpty();
            } else if (this.size() == 2) {
                if (this.head.getData().getKey() == key) {
                    s = this.head.getData();
                    head = head.getNext();
                } else if (this.head.getNext().getData().getKey() == key) {
                    s = this.head.getNext().getData();
                    tail = head;
                }

            }

            //Runs only if there are nodes left in the LinkList and while target hasn't been found
            //The found condition ensures that only the first occurence is removed
            while (currentNode.getNext() != null && found == false) {
                //Checks to see if the node after the pointer contains the target value
                if (currentNode.getNext().getData().getKey() == key) {
                    //Sets found to true so that loop ends because target found
                    found = true;
                    s = currentNode.getData();

                    //Sets the pointer of node before target to node after target
                    //This removes the target node because it's no longer pointed to
                    before = currentNode;
                    after = (currentNode.getNext()).getNext();

                    before.setNext(after);
                }

                //Moves the pointer to the next node
                currentNode = currentNode.getNext();
            }
            if (!found) {

                //End of LinkList reached, value not found
                System.out.println("The given value was not found.");
            }
        } else {

            //Can't remove from empty LinkList
            System.out.println("LinkList is empty, can't remove.");
        }

        return s;
    }

    /**
     * DONE FOR YOU
     */
    @Override
    public String toString() {
        return "HEAD: " + toString(this.head);
    }

    /**
     * DONE FOR YOU
     */
    private String toString(NodePT n) {
        String s = "";
        if (n != null) {
            s = n.getData() + " --> " + this.toString(n.getNext());
        }
        return s;
    }

}
