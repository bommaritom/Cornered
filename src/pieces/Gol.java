package pieces;

public class Gol
{
  public int x;
  public int y;
  
  public Gol()
  {
    this.x = ((int)Math.round(8.0D * Math.random()));
    this.y = ((int)Math.round(8.0D * Math.random()));
  }
  
  public void move()
  {
    this.x = ((int)Math.round(8.0D * Math.random()));
    this.y = ((int)Math.round(8.0D * Math.random()));
  }
}
