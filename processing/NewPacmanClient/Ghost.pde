public class Ghost extends PacmanCharacter{
  
    private int xLoc;
    private int yLoc;
  
    public Ghost() {
      this.xLoc = (int) (Math.random() * width);
      this.yLoc = (int) (Math.random() * height);
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
      fill( 0, 255, 255 );
      rect( xLoc, yLoc, 20, 20 );
  }
}
