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
public abstract class Animal {
    
    private String name;
    private String habitat;
    public String classification;
    private boolean alive;
    
    public Animal()
    {
        alive = true;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    
    public abstract String speak()
    {
       return "... takes a breath... ";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
