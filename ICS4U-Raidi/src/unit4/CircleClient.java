/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit4;

/**
 *
 * @author 1dingrai
 */
public class CircleClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        Circle a = new Circle();
        Circle b = new Circle();
        Circle c = new Circle();
        
        a.radius = 1;
        b.radius = 2;
        c.radius = 3;
        
        a.SHAPE_NAME = "A";
        b.SHAPE_NAME = "B";
        c.SHAPE_NAME = "C";
        
        System.out.println( a.radius );
        System.out.println( b.radius );
        System.out.println( c.radius );
        
    }
    
}
