Pacman p;
Ghost g1;
Ghost g2;
Ghost g3;
Ghost g4;

void setup() {
  size( 400, 400 );
  frameRate( 4 );
  
  p = new Pacman();
  g1 = new Ghost();
  g2 = new Ghost();
  g3 = new Ghost();
  g4 = new Ghost();
  
  p.setxLoc(2);
  
}

void draw() {
  
  clear();
  
  p.draw();
  g1.draw();
  g2.draw();
  g3.draw();
  g4.draw();
  
  g1.moveRight();
 // p.moveRight();
  
  
}

void keyPressed() {
  if (keyCode  == RIGHT ) {
    p.moveRight();
  }
  if (keyCode  == LEFT ) {
    p.moveLeft();
  }
  if (keyCode  == UP ) {
    p.moveUp();
  }
  if (keyCode  == DOWN ) {
    p.moveDown();
  }
  
}
