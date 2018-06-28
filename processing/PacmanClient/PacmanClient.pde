Pacman p;
void setup()
{
  p = new Pacman();
  size(600, 600);
}

void draw()
{
  p.draw();
  
  if (p.getXLocation() < width - 40)
  {
    p.move();
  }
  
}
