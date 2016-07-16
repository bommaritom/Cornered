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
  public String floor;
  public int upwards;
  public String curMes;
  
  public void go()
    throws InterruptedException, IOException
  {
    System.out.println(""
    		+ "\nMove using WASD. Collect the Froot Loops to replenish "
    		+ "\nyour moves, but watch out!  The Chaser is after you!"
    		+ "\nUse your fine-tuned instincts to remain alive and out of "
    		+ "\nthe jaws of the enemy."
    		+ "\n"
    		+ "\nPress ENTER to start."
    		+ "\n"
    		+ "\nPro tip: Don't bother looking into"
    		+ "\nthe source code. It's way worse than"
    		+ "\nyou think.");
    //See, dude?  What did I tell you?  Have fun with this one.
    Scanner scanner = new Scanner(System.in);
    scanner = new Scanner(System.in);
    String v = scanner.nextLine();
    if ((v.equals("exit")) || (v.equals("EXIT"))) {
      System.exit(0);
    }
    this.highscore = 0;
    for (;;)
    {
      curMes = "";
      this.upwards = 0;
      this.counter = 15;
      this.score = 0;
      this.player = new Player();
      this.chasers = new ArrayList<Chaser>();
      this.chasers.add(new Chaser(4, 9));
      this.gol = new Gol();
      this.floor = "-";
      display();
      Boolean alive = Boolean.valueOf(true);
      while (alive.booleanValue())
      {
        for (Chaser chaser : this.chasers)
        {
          this.player.move(1);
          chaser.move(this.player, this.score);
        }
        this.floor = "-";
        
        this.upwards += 1;
        alive = display();
      }
      if (this.score > this.highscore) {
        this.highscore = this.score;
      }
      
      scanner = new Scanner(System.in);
      v = scanner.nextLine();
      if ((v.equals("exit")) || (v.equals("EXIT"))) {
        System.exit(0);
      }
      System.out.println("Score: " + this.score);
      String [] scoreComments = {
    		  "Wow! You got literally nothing.",
    		  "But, hey. It's something.",
    		  "That's a terrible score.",
    		  "I wouldn't exactly call that \"a charm\".",
    		  "Just awful.",
    		  "What a bad score.", //5
    		  "Don't worry, you'll do better next time.",
    		  "You're not that good at this.",
    		  "That's an okay score.",
    		  "Almost a 10! Next time.",
    		  "Good effort!", //10
    		  "That's not bad.",
    		  "You're doing okay.",
    		  "Keep trying!",
    		  "Mediocre; I'll give you that.",
    		  "Nice score.", //15
    		  "That's respectable.",
    		  "Nice job, buddy!",
    		  "Pretty good!",
    		  "Nice one, dude!",
    		  "That's literally a score!", //20
    		  "That's great!",
    		  "Nice work!",
    		  "Pretty cool stuff!",
    		  "Awesome score!",
    		  "A-mazing!", //25
    		  "WoW!",
    		  "Astounding!",
    		  "Superb!",
    		  "Magnifico!",
    		  "30?! How?!", //30
    		  "How does he do it?!",
    		  "Unbelievable!",
    		  "Incredible!",
    		  "You rock!",
    		  "That's insane!", //35
    		  "Seriously impressive!",
    		  "That's impossible!",
    		  "There's no way!",
    		  "Jesus, man! How do you do it?! I've never gotten past 30!",
    		  "40!!!! Dude, I will personally buy you a round!", //40
      };
      if (score > 40) System.out.println("YOU ARE A LEGEND!!!");
      else System.out.println(scoreComments[score]);
      
      System.out.println("\nYour record: " + this.highscore);
      System.out.println("\nPress ENTER");
      scanner = new Scanner(System.in);
      v = scanner.nextLine();
      if ((v.equals("exit")) || (v.equals("EXIT"))) {
        System.exit(0);
      }
    }
  }
  
  public Boolean display()
  {
    Boolean alive = Boolean.valueOf(true);
    Location cur = new Location(0, 9);
    Location playerLocation = new Location(this.player.x, this.player.y);
    ArrayList<Location> chaserLocations = new ArrayList();
    Location golLocation = new Location(this.gol.x, this.gol.y);
    if ((playerLocation.x == golLocation.x) && (playerLocation.y == golLocation.y))
    {
      this.gol.move();
      this.counter += 11;
      this.score += 1;

      String[] messages = {
	  		  "Great job!",
	  		  "You're doing great!",
	  		  "Well done!",
	  		  "Awesome job!",
	  		  "Smooth moves!",
	  		  "Cool beans!",
	  		  "Perfectly executed.",
	  		  "Nice one!",
	  		  "You rock!",
	  		  "You got this!",
	  		  "Sweet one, bro!",
	  		  "In the bag!",
	  		  "What a move!",
	  		  "Keep it up!",
	  		  "You can do this!",
	  		  "Keep going!",
	  		  "Don't give up now!",
	  		  "You are awesome!",
	  		  "Go, go, go!",
	  		  "Yee, boi!",
	  		  "They don't think it be like it is, but it do.",
	  		  "Incredible!",
	  		  "Unbelievable!",
	  		  "My savior!",
	  		  "Rockin' it, man!",
	  		  "Wow, Ethan, great moves! Keep it up! Proud of you!",
	  		  "The Dude abides.",
	  		  "Nice, nice.",
	  		  "Stunning.",
	  		  "You're gonna do great!",
	  		  "*Swish*",
	  		  "Boom!",
	  		  "Calculated.",
	  		  "What a play!",
	  		  "Well played!",
	  		  "Inconceivable!",
	  		  "Wubbalubbadubdub!",
	  		  "Cool!",
	  		  "My man!",
	  		  "I like your style.",
	  		  "Sweet!",
	  		  "Give 'em hell!",
	  		  "You show 'em!",
	  		  "This is how we do it!",
	  		  "Great one!",
	  		  "You're an awesome guy!",
	  		  "You are beautiful.",
	  		  "This is where the magic happens.",
	  		  "You must be a pro!",
	  		  "Flawless!",
	  		  "Now *that's* what I call a good move!",
	  		  "Keep up the good work!",
	  		  "You bring joy to all of us!",
	  		  "Peace, bro.",
	  		  "Peace out.",
	  		  "Sweet moves!",
	  		  "Totally owning it!",
	  		  "You are destroying this game! (In a good way.)",
	  		  "I think I love you!",
	  		  "Don't stop now!",
	  		  "Aren't you having a good time?",
	  		  "Having a ball?",
	  		  "You are the bomb!",
	  		  "You're kind of a big deal.",
	  		  "Do you like pickles? Because you're kind of a big dill.",
	  		  "Killing it!",
	  		  "Break a leg!",
	  		  "You're kind of stealing the show here!",
	  		  "En fuego!",
	  		  "Winning!",
	  		  "Slow down!",
	  		  "My man!",
	  		  "Owning it!",
	  		  "The legend!",
	  		  "Legendary!",
	  		  "Get outta here!",
	  		  "You're my hero!",
	  		  "I will never let go, Jack. I’ll never let go.",
	  		  "You've got class!",
	  		  "Someone's getting laid tonight!",
	  		  "God bless.",
	  		  "Respect.",
	  		  "Cowabunga!",
	  		  "Hey, that's pretty good.",
	  		  "Yes!",
	  		  "Yeah, baby!",
	  		  "Ka-ching!",
	  		  "What a player!",
	  		  "Make it rain!",
	  		  "Dominating!",
	  		  "It's Wednesday, my dudes."
	    };
      curMes = messages[(int) Math.floor(messages.length * Math.random())];
    }
    golLocation = new Location(this.gol.x, this.gol.y);
    for (Chaser chaser : this.chasers) {
      chaserLocations.add(new Location(chaser.x, chaser.y));
    }
    int vvv = Integer.valueOf(this.score).intValue() - ((Chaser)this.chasers.get(0)).diagCounter;
    if (vvv < 0) {
      vvv = 0;
    }
    System.out.println("Moves Left:" + this.counter);
    System.out.println(vvv);
    String line = "";
    while (cur.y >= 0)
    {
      if ((cur.x == playerLocation.x) && (cur.y == playerLocation.y)) {
        line = line + this.player.symbol;
      } else if ((cur.x == ((Location)chaserLocations.get(0)).x) && (cur.y == ((Location)chaserLocations.get(0)).y)) {
        line = line + ((Chaser)this.chasers.get(0)).symbol;
      } else if ((cur.x == golLocation.x) && (cur.y == golLocation.y)) {
        line = line + this.gol.symbol;
      } else {
        line = line + this.floor;
      }
      cur.x += 1;
      if (cur.x == 10)
      {
        line = line + "\n";
        cur.x = 0;
        cur.y -= 1;
      }
    }
    System.out.println(line);
    
    this.counter -= 1;
    for (Chaser chaser : this.chasers) {
      if ((chaser.x == this.player.x) && (chaser.y == this.player.y))
      {
        if (!chaser.diag.booleanValue()) {
          System.out.println("Oh, Jesus. You got double-crossed! \nPress ENTER");
        } else {
          System.out.println("Oh, Jesus. You got lanced! \nPress ENTER");
        }
        alive = Boolean.valueOf(false);
      }
      else if ((Math.abs(chaser.diffx) == 1) && (Math.abs(chaser.diffy) == 1))
      {
        if (!chaser.diag.booleanValue())
        {
          System.out.println("Oh, Jesus. You got jabbed! \nPress ENTER");
          alive = Boolean.valueOf(false);
        }
        else
        {
            if (chaser.dir == "ne") {
            	if (((chaser.diffx == 1) && (chaser.diffy == 1 ))) {
            		System.out.println("Oh, Jesus. You got lanced! \nPress ENTER");
                    alive = Boolean.valueOf(false);
            }
          
            }else if (chaser.dir == "nw") {
            if (((chaser.diffx == -1) && (chaser.diffy == 1 ))) {
            	System.out.println("Oh, Jesus. You got lanced! \nPress ENTER");
                alive = Boolean.valueOf(false);
            }
          }else if (chaser.dir == "sw") {
            if (((chaser.diffx == -1) && (chaser.diffy == -1 ))) {
            	System.out.println("Oh, Jesus. You got lanced! \nPress ENTER");
                alive = Boolean.valueOf(false);
            }
          }else if (chaser.dir == "se") {
                if (((chaser.diffx == 1) && (chaser.diffy == -1 ))) {
                	System.out.println("Oh, Jesus. You got lanced! \nPress ENTER");
                    alive = Boolean.valueOf(false);
                }
          }
        }
      }
      else if (this.counter < 0)
      {
        System.out.println("Oh, Jesus. You ran out of moves! \nPress ENTER");
        alive = Boolean.valueOf(false);
      }
      else
      {
        alive = Boolean.valueOf(true);
      }
    }
    
    if (alive){
    System.out.println(curMes);
    System.out.println("Score:" + this.score + "\n");
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
