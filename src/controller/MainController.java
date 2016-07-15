package controller;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import pieces.Chaser;
import pieces.Gol;
import pieces.Player;

public class MainController
{
  public Player player;
  public ArrayList<Chaser> chasers;
  public Gol gol;
  public int counter;
  public int score;
  public int highscore;
  
  public void go() throws InterruptedException, IOException
  {
    System.out.println("\nMove using WASD. Collect as many \n"
    		+ "pellets as you can, but don't get \"cornered\"!\n");
    this.highscore = 0;
    while (true)
    {
      this.counter = 15;
      this.score = 0;
      this.player = new Player();
      this.chasers = new ArrayList();
      this.chasers.add(new Chaser(4, 8));
      this.gol = new Gol();
      display();
      Boolean alive = Boolean.valueOf(true);
      while (alive.booleanValue())
      {
        
        for (Chaser chaser : this.chasers) {
        	this.player.move();
            chaser.move(this.player);
          
        }
        alive = display();
      }
      if (this.score > this.highscore)highscore = score;
      Scanner scanner = new Scanner(System.in);
      scanner = new Scanner(System.in);
      String v = scanner.nextLine();
      if (v.equals("exit") || v.equals("EXIT") ) System.exit(0);
      System.out.println("Score: " + this.score);
      System.out.println("Your record: " + this.highscore);
      System.out.println("Press ENTER");
      scanner = new Scanner(System.in);
      v = scanner.nextLine();
      if (v.equals("exit") || v.equals("EXIT") ) System.exit(0);
    }
  }
  
  public Boolean display()
  {
    Boolean alive = Boolean.valueOf(true);
    Location cur = new Location(0, 8);
    Location playerLocation = new Location(this.player.x, this.player.y);
    ArrayList<Location> chaserLocations = new ArrayList();
    Location golLocation = new Location(this.gol.x, this.gol.y);
    if ((playerLocation.x == golLocation.x) && (playerLocation.y == golLocation.y))
    {
      this.gol.move();
      this.counter += 6;
      this.score += 1;
    }
    golLocation = new Location(this.gol.x, this.gol.y);
    for (Chaser chaser : this.chasers) {
      chaserLocations.add(new Location(chaser.x, chaser.y));
    }
    System.out.println("Moves Left:" + this.counter + 
    		         "\nScore:     " + this.score);
    String line = "";
    while (cur.y >= 0)
    {
      if ((cur.x == playerLocation.x) && (cur.y == playerLocation.y)) {
        line = line + "@";
      } else if ((cur.x == ((Location)chaserLocations.get(0)).x) && (cur.y == ((Location)chaserLocations.get(0)).y)) {
        line = line + "X";
      } else if ((cur.x == golLocation.x) && (cur.y == golLocation.y)) {
        line = line + "o";
      } else {
        line = line + "-";
      }
      cur.x += 1;
      if (cur.x == 9)
      {
        line = line + "\n";
        cur.x = 0;
        cur.y -= 1;
      }
    }
    System.out.println(line);
    this.counter -= 1;
    for (Chaser chaser : this.chasers) {
      if ((Math.abs(chaser.diffx) == 1) && (Math.abs(chaser.diffy) == 1))
      {
        System.out.println("You got \"cornered\"! \nPress ENTER");
        alive = Boolean.valueOf(false);
      }
      else if (this.counter < 0)
      {
        System.out.println("Out of moves! \nPress ENTER");
        alive = Boolean.valueOf(false);
      }
      else
      {
        alive = Boolean.valueOf(true);
      }
    }
    return alive;
  }
  
  public class Location
  {
    public int x;
    public int y;
    
    public Location(int xx, int yy)
    {
      this.x = xx;
      this.y = yy;
    }
  }
}
