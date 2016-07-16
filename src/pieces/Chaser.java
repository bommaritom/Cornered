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
  public Boolean diag;
  public Boolean piag;
  public String dir;
  public int diagCounter;
  
  public Chaser(int xx, int yy)
  {
    this.symbol = "x";
    
    this.x = xx;
    this.y = yy;
    this.h = 1;
    
    this.tick = 0;
    this.diag = Boolean.valueOf(false);
    this.piag = Boolean.valueOf(false);
  }
  
  public void move(Player player, int score)
  {
    if (!this.piag.booleanValue()) {
      this.diag = Boolean.valueOf(false);
    }
    int k = 2;
    
    this.tick += 1;
    this.diagCounter += 1;
    this.diffx = (player.x - this.x);
    this.diffy = (player.y - this.y);
    if (this.diag.booleanValue())
    {
      if (this.dir == "se")
      {
        this.x += 1;this.y -= 1;
      }
      if (this.dir == "ne")
      {
        this.x += 1;this.y += 1;
      }
      if (this.dir == "sw")
      {
        this.x -= 1;this.y -= 1;
      }
      if (this.dir == "nw")
      {
        this.x -= 1;this.y += 1;
      }
      if (this.x <= 0)
      {
        this.x = 0;this.piag = Boolean.valueOf(false);this.diagCounter = 0;this.tick = 0;
      }
      if (this.x >= 9)
      {
        this.x = 9;this.piag = Boolean.valueOf(false);this.diagCounter = 0;this.tick = 0;
      }
      if (this.y <= 0)
      {
        this.y = 0;this.piag = Boolean.valueOf(false);this.diagCounter = 0;this.tick = 0;
      }
      if (this.y >= 9)
      {
        this.y = 9;this.piag = Boolean.valueOf(false);this.diagCounter = 0;this.tick = 0;
      }
      this.diffx = (player.x - this.x);
      this.diffy = (player.y - this.y);
      return;
    }
    this.symbol = "x";
    if (this.tick == k)
    {
      this.symbol = "X";
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
      else if ((Math.abs(this.diffx) == Math.abs(this.diffy)) && (Math.abs(this.diffx) > 1) && (this.diagCounter > score - 1))
      {
        this.diag = Boolean.valueOf(true);
        this.piag = Boolean.valueOf(true);
        if ((this.diffy > 0) && (this.diffx > 0))
        {
          this.symbol = "/";this.dir = "ne";
        }
        if ((this.diffy < 0) && (this.diffx < 0))
        {
          this.symbol = "/";this.dir = "sw";
        }
        if ((this.diffy > 0) && (this.diffx < 0))
        {
          this.symbol = "\\";this.dir = "nw";
        }
        if ((this.diffy < 0) && (this.diffx > 0))
        {
          this.symbol = "\\";this.dir = "se";
        }
      }
      else if (Math.abs(this.diffx) == Math.abs(this.diffy))
      {
        if ((player.input == 'a') || (player.input == 'A') || (player.input == 'd') || (player.input == 'D'))
        {
          if (this.diffy > 0) {
            this.y += 1;
          }
          if (this.diffy < 0) {
            this.y -= 1;
          }
        }
        if ((player.input == 's') || (player.input == 'S') || (player.input == 'w') || (player.input == 'W'))
        {
          if (this.diffx > 0) {
            this.x += 1;
          }
          if (this.diffx < 0) {
            this.x -= 1;
          }
        }
      }
      this.tick = 0;
    }
    this.diffx = (player.x - this.x);
    this.diffy = (player.y - this.y);
    if ((Math.abs(this.diffx) == Math.abs(this.diffy)) && (Math.abs(this.diffx) > 1) && (this.diagCounter > score - 1))
    {
      this.diag = Boolean.valueOf(true);
      this.piag = Boolean.valueOf(true);
      if ((this.diffy > 0) && (this.diffx > 0))
      {
        this.symbol = "/";this.dir = "ne";
      }
      if ((this.diffy < 0) && (this.diffx < 0))
      {
        this.symbol = "/";this.dir = "sw";
      }
      if ((this.diffy > 0) && (this.diffx < 0))
      {
        this.symbol = "\\";this.dir = "nw";
      }
      if ((this.diffy < 0) && (this.diffx > 0))
      {
        this.symbol = "\\";this.dir = "se";
      }
    }
  }
  
  public void hit()
  {
    this.h = 0;
  }
}
