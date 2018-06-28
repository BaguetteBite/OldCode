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
public class BookClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        //EMPTY BOOK
        Book a = new Book();
        a.setAuthor( "Muir" );
        a.setTitle( "Computer Science for Dummies" );
        a.setNumOfPages( 1000 );
        System.out.println( a );        
        
        //BOOK BY ID - PRIMARY KEY
        Book b = new Book(123);
        System.out.println(b);
        
        Book c = new Book( 1, "Math for Dummies", "Muir" )
        {
            this.edition = edition;
            this.title = title;
            this.author = author;
            this.Id = ++lastId;
        }
    }
    
    if ( a==b)
    {
        
    }
    
}
