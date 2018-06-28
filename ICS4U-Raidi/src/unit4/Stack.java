/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit4;

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
    public Stack(int n) {
        arr = new int[n];

        //top acts as an index
        top = -1;
    }

    //Checks whether the stack is empty
    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    //Checks whether the stack is full
    @Override
    public boolean isFull() {
        return top == arr.length-1;
    }

    @Override
    public void push(int x) {
        //Adds a value to the top of the stack
        //Will only do so up to the max size of the stack
        System.out.println(isFull());
        if (!isFull()) {
            top++;
            arr[top] = x;
            
        } //If more values are pushed than stack can contain, it will overflow
        else {
            System.out.println("There will be a stack overflow.");
        }

    }

    public int pop() {
        //Code only runs if stack isn't empty
        //Removes top and returns its value
        if (!this.isEmpty()) {
            int temp = this.top();
            
            top--;
            return temp;
        }
        return 0;

    }

    public int top() {
        //Peek looks at the top of the stack 
        //Code only runs if stack isn't empty
        if (this.isEmpty() == false) {
            return arr[top - 1];
        }
        return 0;
    }

//    public void search( String arr[], int target)
//    {
//        int location = myStack.search(target);
//        
//    }
    public static void main(String[] args) {

        //Pushes values into the stack
        Stack myStack = new Stack(10);

        for (int i = 0; i < 5; i++) {
            myStack.push(i);
            System.out.println("Size: " + myStack.size());
            System.out.println( myStack.toString() );
        }

//        //Prints the top value in the stack
//        System.out.println("The top of the stack is: " + myStack.top());
//
//        //Checks whether the stack is empty or full
//        System.out.println("The stack is full: " + myStack.isFull());
//        System.out.println("The stack is empty: " + myStack.isEmpty());
//
//        //Removes the top of the stack and returns it
//        for (int i = 0; i < 5; i++) {
//            myStack.pop();
//        }
//
//        System.out.println("The top of the stack is: " + myStack.pop());
//
//        System.out.println("The stack is full: " + myStack.isFull());
//        System.out.println("The stack is empty: " + myStack.isEmpty());

    }

//    @Override
//    public int top() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public int capacity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public boolean isEmpty() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    @Override
//    public boolean isFull() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    @Override
    public void makeEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String toString( ) {
        String s = "--------------\n";
        s = s + "TOP\n";
        for( int i = top; i > -1; i-- ) {
            s = s + arr[i] + "\n";
        }
        s = s + "BOTTOM\n --------------\n";
  
        return s;
    }
    
}
