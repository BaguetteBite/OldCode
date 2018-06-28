/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit5;

/**
 *
 * @author 1dingrai
 */
public class NewHashTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         
        HasthTableLP h = new HasthTableLP( 20 );
        
        assert( h.size() == 0 );
        assert( h.capacity() == 23 );
        assert( !h.contains( new Student(0) ) );
        assert( !h.containsKey( 0 ) );
        
        // ADD ONE THING
        Student s = new Student( 0 );    
        System.out.println( s.getStudentNumber() );
        h.put( 0, s );        
        assert( h.size() == 1 );
        assert( h.capacity() == 23 );
        assert( h.contains( s ) );
       assert( h.containsKey( 0 ) );
        
        Student g = h.get(0);
        assert( s.equals(g) );

//        // FORCE A COLLISSION
        s = new Student( h.capacity() );        
        h.put( h.capacity(), s );
        
        assert( h.size() == 2 );
        assert( h.capacity() == 23 );
        assert( h.contains( s ) );
        assert( h.containsKey( h.capacity() ) );
        
        g = h.get(h.capacity());
        assert( s.equals(g) );

        
        
        
    }
    
}
