package pieces;

public class Chaser
{
  public String symbol;
  public int x;
  public int y;
  public int h;
  public int diffx;
  public int diffy;
  public int tick;
  
  public Chaser(int xx, int yy)
  {
    this.symbol = "X";
    
    this.x = xx;
    this.y = yy;
    this.h = 1;
    
    this.tick = 0;
  }
  
  public void move(Player player)
  {
    this.tick += 1;
    this.diffx = (player.x - this.x);
    this.diffy = (player.y - this.y);
    if (this.tick == 2)
    {
      if (Math.abs(this.diffx) > Math.abs(this.diffy))
      {
        if (this.diffx > 0) {
          this.x += 1;
        }
        if (this.diffx < 0) {
          this.x -= 1;
        }
      }
      else if (Math.abs(this.diffx) < Math.abs(this.diffy))
      {
        if (this.diffy > 0) {
          this.y += 1;
        }
        if (this.diffy < 0) {
          this.y -= 1;
        }
      }
      else if (Math.abs(this.diffx) == Math.abs(this.diffy)){
    	  if (player.input == 'a' || player.input == 'A' || player.input == 'd' || player.input == 'D'){
    		  if (diffy > 0) this.y++;
    		  if (diffy < 0) this.y--;
    	  }
    	  if (player.input == 's' || player.input == 'S' || player.input == 'w' || player.input == 'W'){
    		  if (diffx > 0) this.x++;
    		  if (diffx < 0) this.x--;
    	  }
      }
    	  
      this.tick = 0;
    }
    this.diffx = (player.x - this.x);
    this.diffy = (player.y - this.y);
  }
  
  public void hit()
  {
    this.h = 0;
  }
}
