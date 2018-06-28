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
public class LinkListClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        LinkList list = new LinkList();

        // CASE 1: LINKLIST IS EMPTY
        assert (list.size() == 0);
        assert (list.isEmpty());
        assert (list.head() == null);
        assert (list.tail() == null);

        //CASE 2: ADD A HEAD
        list.addAtFront("a");

        assert (list.size() == 1);
        assert (!list.isEmpty());
        assert (list.head().equals("a"));
        assert (list.tail().equals("a"));

        //Adding another head to test removal better     
        list.addAtFront("b");

//        //CASE 3: ADD A TAIL
        list.addAtEnd("c");

        //Adding another tail to test removal better     
        list.addAtEnd("d");

        assert (list.size() == 4);
        assert (!list.isEmpty());
        assert (list.head().equals("b"));
        assert (list.tail().equals("d"));

        //CASE 4: REMOVE THE HEAD
        assert (list.removeHead()).equals("b");

        assert (list.size() == 3);
        assert (!list.isEmpty());
        assert (list.head().equals("a"));
        assert (list.tail().equals("d"));

        //CASE 5: REMOVE THE TAIL
        //Adding more heads to test removal better     
        list.addAtFront("e");
        list.addAtFront("f");
        list.addAtFront("g");

        assert (list.removeTail()).equals("d");
        assert (list.size() == 5);
        assert (!list.isEmpty());
        assert (list.head().equals("g"));
        assert (list.tail().equals("c"));

        //CASE 6: MAKE EMPTY
        list.makeEmpty();

        assert (list.size() == 0);
        assert (list.isEmpty());
        assert (list.head() == null);
        assert (list.tail() == null);
//        
//      
        //CASE 7: REMOVE THE FIRST INSTANCE OF A VALUE TO APPEAR

        list.addAtEnd("b");
        list.addAtEnd("c");
        list.addAtEnd("a");
        list.addAtEnd("d");
        list.addAtEnd("a");
        list.addAtEnd("e");

        list.remove("a");

        assert (list.size() == 5);
        assert (!list.isEmpty());
        assert (list.head().equals("b"));
        assert (list.tail().equals("e"));

        //CASE 8: REMOVE A VALUE THAT DOES NOT EXIST
        list.remove("z");

        assert (list.size() == 5);
        assert (!list.isEmpty());
        assert (list.head().equals("b"));
        assert (list.tail().equals("e"));

        //CASE 9: REMOVE A VALUE FROM AN EMPTY LIST
        list.makeEmpty();

        list.remove("a");
        assert list.removeHead() == null;
        assert list.removeTail() == null;

        assert (list.size() == 0);
        assert (list.isEmpty());
        assert (list.head() == null);
        assert (list.tail() == null);

    }

}
