package pieces;

import java.io.Console;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Reader;
import java.util.Scanner;

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
  
  public void move() throws InterruptedException, IOException
  {
	String[] cmd = {"/bin/sh", "-c", "stty raw </dev/tty"};
	Runtime.getRuntime().exec(cmd).waitFor();
	
	Console console = System.console();
	Reader reader = console.reader();
    System.out.println("");
    
    input = (char)reader.read();
    cmd = new String[] {"/bin/sh", "-c", "stty sane </dev/tty"};
	Runtime.getRuntime().exec(cmd).waitFor();
	
    if (input == 'w' || input == 'W') {
      this.y += 1;
    } else if (input == 'a' || input == 'A') {
      this.x -= 1;
    } else if (input == 's' || input == 'S') {
      this.y -= 1;
    } else if (input == 'd' || input == 'D') {
      this.x += 1;
    }
    if (this.x > 8) {
      this.x = 8;
    }
    if (this.x < 0) {
      this.x = 0;
    }
    if (this.y > 8) {
      this.y = 8;
    }
    if (this.y < 0) {
      this.y = 0;
    }
  }
}
