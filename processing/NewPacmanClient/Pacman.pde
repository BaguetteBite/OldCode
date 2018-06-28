public class Pacman extends PacmanCharacter{
  
  private int xLoc;
  private int yLoc;
  private int lives;
  
  public Pacman() {
      this.xLoc = 100;
      this.yLoc = 100;
      this.lives = 3;
  }
  
  public void moveRight() {
     this.xLoc = this.xLoc + 10; 
  }
  public void moveLeft() {
     this.xLoc = this.xLoc - 10; 
  }
  public void moveUp() {
     this.yLoc = this.yLoc - 10; 
  }
  public void moveDown() {
     this.yLoc = this.yLoc + 10; 
  }
  
  public void draw() {
      fill( 255, 255, 0 );
      rect( xLoc, yLoc, 20, 20 );
  }
  
}

//Extends to MsPacman because they have same code, but diff draw method
