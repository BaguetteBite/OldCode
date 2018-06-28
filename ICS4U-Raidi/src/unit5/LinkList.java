package unit5;

import java.util.Objects;

/**
 *
 * @author Raidi
 */
public class LinkList implements LinkListInterface {

    //Creates a head and tail pointer for a LinkList
    Node head;
    Node tail;

    //Constructor: The LinkList is initially empty
    public LinkList() {
        this.head = null;
        this.tail = null;
    }

    //Second constructor: Adds a single node to the LinkList
    public LinkList(String s) {
        this.addAtFront(s);
    }

    //Gets the size of the linklist.
    @Override
    public int size() {

        int listSize;

        //The size is 0 if the LinkList is empty
        if (this.isEmpty()) {
            listSize = 0;
        } else {

            //Starts at the head and counts each node in LinkList
            //Amount of nodes = size
            Node temp = this.head;
            int counter = 1;

            while (temp.getNext() != null) {
                counter++;
                temp = temp.getNext();
            }
            listSize = counter;
        }
        return listSize;
    }

    //Makes the LinkList empty by moving the pointers
    @Override
    public void makeEmpty() {
        this.head = null;
        this.tail = null;
    }

    //Checks to see whether the LinkList is empty by checking the pointer location
    @Override
    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        } else {
            return false;
        }
    }

    //Adds a node at the front of the LinkList
    @Override
    public void addAtFront(String str) {
        if (this.isEmpty()) {
            //If this is the only node in the List, it is both head and tail
            //Sets the space after the head to 'null'
            head = new Node(str);
            tail = head;
            tail.setNext(null);
        } else {
            //Makes the new node the head, and it points to the previous head
            Node newNode = new Node(str);
            newNode.setNext(head);
            this.head = newNode;
        }
    }

    //Adds a node at the end of the LinkList
    @Override
    public void addAtEnd(String str) {
        if (this.isEmpty()) {
            //If this is the only node in the List, it is both head and tail
            //Sets the space after the head to 'null'
            head = new Node(str);
            tail = head;
            tail.setNext(null);
        } else {
            //Makes the new node the tail, previous tail points to it
            //Sets a null after the tail
            Node newNode = new Node(str);
            tail.setNext(newNode);
            this.tail = newNode;
            tail.setNext(null);
        }

    }

    //Removes any node in the LinkList
    @Override
    public void remove(String str) {
        
        boolean found = false;
        
        //Code runs only if the LinkList isn't empty
        if (!this.isEmpty()) {
            if(this.size() == 1)
            {
                makeEmpty();
            }
            //Sets the current location and the node before and after
            //The current location, where the search starts, is the head
            Node currentNode = head;
            Node after;
            Node before;

            //Runs only if there are nodes left in the LinkList and while target hasn't been found
            //The found condition ensures that only the first occurence is removed
            while (currentNode.getNext() != null && found == false) {

                //Checks to see if the node after the pointer contains the target value
                if (((currentNode.getNext()).getValue()).equals(str)) {
                    
                    //Sets found to true so that loop ends because target found
                    found = true;
                    
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
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    //Checks if one object equals another by seeing if they reference the same memory
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LinkList other = (LinkList) obj;
        if (!Objects.equals(this.head, other.head)) {
            return false;
        }
        return true;
    }

    //Removes the head of the LinkList
    @Override
    public String removeHead() {
        
        //Code runs only if the LinkList isn't empty
        if (!this.isEmpty()) {
            
            //Stores the head value before it is removed
            String value = this.head.getValue();
            
            if (size() == 1) {
                //Easily removes a single element
                makeEmpty();
            } else {
                //Sets the new head to the node after the original head
                //This removes the original head
                this.head = this.head.getNext();
            }
            return value;
        }
        
        //LinkList is empty
        System.out.println("LinkList is empty, can't remove.");
        return null;
    }

    //Removes the tail of the LinkList
    @Override
    public String removeTail() {
        
        //Code runs only if the LinkList isn't empty
        if (!this.isEmpty()) {
            
            //Stores the tail value before it is removed
            String value = this.tail.getValue();

            //Easily removes a single element
            if (size() == 1) {
                makeEmpty();
            } else {

                //Sets a pointer to the head
                Node currentNode = head;

                //This loop finds and sets the pointer to the node before the tail
                while (currentNode.getNext() != tail) {
                    currentNode = currentNode.getNext();
                }

                //Sets tail to pointer, which removes the original tail
                this.tail = currentNode;
                this.tail.setNext(null);
            }
            return value;
        }
        
        System.out.println("LinkList is empty, can't remove.");
        return null;
    }

    //Returns the first node of the LinkList
    @Override
    public String head() {
        
        if (this.isEmpty()) {
            System.out.println("No head, LinkList is empty");
            return null;
        }
        
        //Head and tail are the same node if LinkList contains 1 node
        if (this.size() == 1) {
            tail = head;
        }
        
        //Returns first node if LinkList not empty
        return this.head.getValue();
    }

    @Override
    public String tail() {

        if (this.isEmpty()) {
            System.out.println("No tail, LinkList is empty");
            return null;
        }
        
        //Head and tail are the same node if LinkList contains 1 node
        if (this.size() == 1) {
            tail = head;
        }
        
        //Returns first node if LinkList not empty
        return tail.getValue();
    }

    //Converts LinkList to string
    @Override
    public String toString() {

        String s = "Head -->";

        Node n = head;
        while (n != null) {
            s = s + n.getValue() + "-->";
            n = n.getNext();
        }

        s = s + "Tail";

        return s;

    }
}
