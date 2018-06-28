/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit6;

/**
 *
 * @author 1dingrai
 */
public class AnimalClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Animal a  = new Animal() {
            @Override
            public String speak() {
                return "silence";
            }
        };

        Cat c = new Cat();
        Dog d = new Dog();
        Fish f = new Fish();
        
        System.out.println(c.isAlive());
        System.out.println(d.isAlive());
        System.out.println(f.isAlive());
        
        System.out.println(a.speak());
        System.out.println(d.speak());
        System.out.println(f.speak());
                
    }
    
}
