package pieces;

import java.io.Console;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Reader;

public class Player
{
  public String symbol;
  public int x;
  public int y;
  public char input;
  
  public Player()
  {
    this.symbol = "0";
    
    this.x = 4;
    this.y = 0;
  }
  
  public void move(int q)
    throws InterruptedException, IOException
  {
    String[] cmd = { "/bin/sh", "-c", "stty raw </dev/tty" };
    Runtime.getRuntime().exec(cmd).waitFor();
    
    Console console = System.console();
    Reader reader = console.reader();
    System.out.println("");
    
    this.input = ((char)reader.read());
    cmd = new String[] { "/bin/sh", "-c", "stty sane </dev/tty" };
    Runtime.getRuntime().exec(cmd).waitFor();
    if ((this.input == 'w') || (this.input == 'W')) {
      this.y += q;
    } else if ((this.input == 'a') || (this.input == 'A')) {
      this.x -= q;
    } else if ((this.input == 's') || (this.input == 'S')) {
      this.y -= q;
    } else if ((this.input == 'd') || (this.input == 'D')) {
      this.x += q;
    }
    if (this.x > 9) {
      this.x = 9;
    }
    if (this.x < 0) {
      this.x = 0;
    }
    if (this.y > 9) {
      this.y = 9;
    }
    if (this.y < 0) {
      this.y = 0;
    }
  }
}
