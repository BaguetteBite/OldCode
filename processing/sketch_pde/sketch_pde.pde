void setup()
{
  size(600, 600);
  background(255, 255, 255);
  rectMode(CENTER);
  
  fill( (int) (Math.random() * 255), 0, (int) (Math.random() * 255));
  fractureSquare( width/2, height/2, 200, 200);
  //fracTri(width/2, 0, width);
}

void draw()
{
  
}

void fractureSquare( int x, int y, int w, int h )
{
  // BIG RECTANGLE
  
  
  //FRACTURE
  if ( w/3 > 2)
  {
    fractureSquare( x - w/2, y - h/2, w/2, h/2 );
    fractureSquare( x + w/2, y - h/2, w/2, h/2 );
    fractureSquare( x - w/2, y + h/2, w/2, h/2 );
    fractureSquare( x + w/2, y + h/2, w/2, h/2 );
  }
  
  fill( (int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
  rect( x, y, w, h );
}

void fracTri(int x, int y, int sL)
{
  int h = (int) Math.sqrt ( (sL)*(sL) - (sL/2)*(sL/2));
  
  triangle(
    x, y,
    x - (sL/2), h,
    x + (sL/2), h
  );
  
  if (sL > 3)
  {
    int newH = (int) Math.sqrt ( (sL/2)*(sL/2) - (sL/4)*(sL/4));
    fracTri(x, y, newH);
    fracTri(x - sL/2, y + newH, newH);
  }
}