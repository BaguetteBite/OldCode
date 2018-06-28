public class Pacman
{
  //CLASS CONSTANTS
  
  private static final STEP_SIZE = 10;
  
  //CLASS VARIABLES
  //OBJECT VARIABLES
  
  int xLoc = 12;
  int yLoc = 13;
  
  //Three constructors: Empty, primary key, secondary key
  
  //Getters/Setters
  public int getXLocation()
  {
    
  }
  //.toString()
  
  //.equals()
}

public void draw()
{
  Rect( xLoc, yLoc, 30, 30);
}

public void move()
{
  this.xLoc = this.nLoc + STEP_SIZE;
}
