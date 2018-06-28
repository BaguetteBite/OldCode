/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit5;

/**
 *
 * @author Raidi
 */
public class Stack implements StackInterface {

    /**
     * @param args the command line arguments
     */
    int top;
    int arr[];

    //n = stack size
    //Creates the stack
    public Stack(int n) {
        arr = new int[n];

        //top acts as an index
        top = -1;
    }

    public Stack() {
        this(10);
    }

    @Override
    public int top() {
        //Looks at the top of the stack 
        //Code only runs if stack isn't empty
        if (this.isEmpty() == false) {
            return arr[top];
        }
        return -1;
    }

    @Override
    public int pop() {
        //Code only runs if stack isn't empty
        //Removes top and returns its value
        if (!this.isEmpty()) {
            int temp = this.top();

            top--;
            return temp;
        }
        return -1;

    }

    @Override
    public void push(int x) {
        //Adds a value to the top of the stack
        //Will only do so up to the max size of the stack
        if (!isFull()) {
            top++;
            arr[top] = x;

        } //If more values are pushed than stack can contain, it will overflow
        else {
            System.out.println("There will be a stack overflow.");
        }

    }

    //The amount of integers in the stack
    @Override
    public int size() {
        return top + 1;
    }

    //The amount of integers the stack can hold
    @Override
    public int capacity() {
        return arr.length;
    }

    //Checks whether the stack is empty
    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    //Checks whether the stack is full
    @Override
    public boolean isFull() {
        return this.size() == this.capacity();
    }

    //Clears the stack
    @Override
    public void makeEmpty() {
        top = -1;
    }

    //Converts the array to a string
    @Override
    public String toString() {

        String s = "--------------\n";
        s = s + "TOP\n";
        for (int i = top; i > -1; i--) {
            s = s + arr[i] + "\n";
        }
        s = s + "BOTTOM\n --------------\n";

        return s;
    }

}
