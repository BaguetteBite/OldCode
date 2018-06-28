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
public class Pacman {

    /**
     * @param args the command line arguments
     */
    
    // CLASS CONSTANTS - must be final static
    // CLASS VARIABLES
    // OBJECT VARIABLES - should be private
    
    private boolean normalState;
    private int lives;
    
    private int goLeft;
    private int goRight;
    private int goUp;
    private int goDown;
    
    private int eatPellet;
    
    
    
    
    public static void main(String[] args) {
        //Pacman pacman = new Pacman();
        
        
    }

    public boolean isNormalState() {
        return normalState;
    }

    public void setNormalState(boolean normalState) {
        this.normalState = normalState;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getGoLeft() {
        return goLeft;
    }

    public void setGoLeft(int goLeft) {
        this.goLeft = goLeft;
    }

    public int getGoRight() {
        return goRight;
    }

    public void setGoRight(int goRight) {
        this.goRight = goRight;
    }

    public int getGoUp() {
        return goUp;
    }

    public void setGoUp(int goUp) {
        this.goUp = goUp;
    }

    public int getGoDown() {
        return goDown;
    }

    public void setGoDown(int goDown) {
        this.goDown = goDown;
    }

    public int getEatPellet() {
        return eatPellet;
    }

    public void setEatPellet(int eatPellet) {
        this.eatPellet = eatPellet;
    }


    
    //Start
    //Pacman spawns near middle of room, not on a wall
    //Pacman is normal
    //Pacman has 3 lives
    //Make objects - Pacman, Ms Pacman, 4 ghosts

    public Pacman(boolean normalState, int lives, int goLeft, int goRight, int goUp, int goDown, int eatPellet) {
        this.normalState = normalState;
        this.lives = lives;
        this.goLeft = goLeft;
        this.goRight = goRight;
        this.goUp = goUp;
        this.goDown = goDown;
        this.eatPellet = eatPellet;
    }

}
