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
public class StackClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Pushes values into the stack
        Stack myStack = new Stack(10);

        System.out.println("TEST 1");
        //TEST 1: EMPTY STACK
        assert myStack.top() == -1;
        assert (myStack.pop() == -1);
        assert myStack.size() == 0;
        assert myStack.capacity() == 10;
        assert myStack.isEmpty();
        assert (!myStack.isFull());

        System.out.println("TEST 2");
        // TEST 2: FILL THE STACK
        fill(myStack);

        System.out.println("TEST 3");
        // TEST 3: OVERFLOW THE STACK
        myStack.push(999);
        assert myStack.top() == 9;
        assert myStack.size() == 10;
        assert myStack.capacity() == 10;
        assert myStack.isEmpty() == false;
        assert myStack.isFull() == true;

        System.out.println("TEST 4");
        // TEST 4: EMPTY THE STACK WITH POP
        for (int i = 9; i >= 0; i--) 
        
        {
            assert myStack.pop() == i;
            assert (!myStack.isFull());
            if (i == 0) {
                assert myStack.isEmpty();          
            } else {
                assert (!myStack.isEmpty());
                //assert (myStack.isFull());
            }
            
            assert myStack.size() == i;
            assert myStack.capacity() == 10;    
            
            //Problem with top: It always calls on the method, where top is 10
        }
        
        System.out.println("TEST 5");
        // TEST 5: EMPTY THE STACK WITH MAKEEMPTY
        
        //Fill the stack first
        fill(myStack);
        
        //Empty the stack
        myStack.makeEmpty();
        assert myStack.top() == -1;
        assert myStack.size() == 0;
        assert myStack.capacity() == 10;
        assert myStack.isEmpty();
        assert myStack.isFull() == false;     
        
        //Check is stack is truly empty
        fill(myStack);
    }

    //Fills the stack
    public static void fill(Stack myStack)
    {
        for (int i = 0; i < 10; i++) {
            myStack.push(i);
            //System.out.println("Top is " + myStack.top());
            assert myStack.top() == i;
            assert myStack.size() == i + 1;
            assert myStack.capacity() == 10;
            assert (!myStack.isEmpty());
            if (i == 9) {
                assert myStack.isFull();
            } else {
                assert (!myStack.isFull());
            }
        } 
    }
    
}
