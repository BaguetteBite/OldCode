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
public class Fish extends Animal{

    @Override
    public String speak() {
        return super.speak() + "silence";
    }

}
