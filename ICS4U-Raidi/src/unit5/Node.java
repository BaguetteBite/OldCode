/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit5;

/**
 *
 * @author Wm.Muir
 */
public class Node implements NodeInterface {

    //Initializes string data to put into a node and a node after a selected node
    private String data;
    Node next;

    //Constructor for a node with nothing inside
    public Node() {
        this(null);
    }

    //Second constructor to create a single node containing given data
    Node(String data) {
        this.data = data;
        this.next = null;
    }

    //Gets the node after the current node
    @Override
    public Node getNext() {
        return this.next;
    }

    //Sets a new node after the current node
    @Override
    public void setNext(Node newNode) {
        this.next = newNode;
    }

    //Gets the string data inside of the selected node
    @Override
    public String getValue() {
        return this.data;
    }

}
