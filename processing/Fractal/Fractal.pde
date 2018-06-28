 void setup()
{
  //Sets size of screen and background to white
  size(600, 600);
  background(255, 255, 255);
  
  //Calls upon the method
  fracture(width/2, height/2, 200, 200);
}

void draw()
{
  
}

//Defines method
void fracture(int x, int y, int w, int h)
{
  
  //Only draws shapes when width is more than 6
  if ( w > 6)
  {
    //Draws each object with recursion
    fracture( x - w, y - h/2, w/2, h/2 );
    fracture( x + w, y - h/2, w/2, h/2 );
    fracture( x - w, y + h/2, w/2, h/2 );
    fracture( x + w, y + h/2, w/2, h/2 );
    fracture( x, y - h/2, w/2, h/2 );
    fracture( x, y - h/2, w/2, h/2 );
    fracture( x, y + h/2, w/2 - 100, h/2 ); //Do w/2 - 100 on this one
    fracture( x, y + h/2, w/2, h/2 );
  }
  //Colours each shape a shade of blue
  fill( (int) (Math.random() * 50), 0, (int) (Math.random() * 255));
  
  //Sets shape drawn as an ellipse
  ellipse( x , y*2 - 250, w - 10, h );
}
//Make there less of a jump between each image line