import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Game extends Thread
{
   private String gameTitle;
   private String musicTitle;
   private Music gameMusic;
   ArrayList<Note> notes = new ArrayList<Note>();
   
   private Image accuracyImage;
   private int score = 0;
   private int combo = 0;


   public Game(String t, String m)
   {
      gameTitle = t;
      musicTitle = m;
      gameMusic = new Music(musicTitle, false);
   }
   
   public int getScore()
   {
      return score;
   }
   
   public int getCombo()
   {
      return combo;
   }
   
   public void pressW()
   {
      accuracyCheck("W");
   }
   
   public void releaseW()
   {

   }
   
   public void pressA()
   {
      accuracyCheck("A");
   }
   
   public void releaseA()
   {

   }
   
   public void pressS()
   {
      accuracyCheck("S");
   }
   
   public void releaseS()
   {

   }
   
   public void pressD()
   {
      accuracyCheck("D");
   }
   
   public void releaseD()
   {

   }
   
   public void noteFall()
   {
      ArrayList<Beat> beats = null;
      
      if(gameTitle.equals("twinkle"))
      {
         //int startTime = 7500 - Menu.reachTime*1000;
         int startTime = 0;
         int gapTime = 120;
         beats = new ArrayList<Beat>();
         beats.add(new Beat(startTime, "W"));
         beats.add(new Beat(startTime+gapTime*4, "W"));
         beats.add(new Beat(startTime+gapTime*8, "A"));
         beats.add(new Beat(startTime+gapTime*12, "A"));
         beats.add(new Beat(startTime+gapTime*16, "S"));
         beats.add(new Beat(startTime+gapTime*20, "S"));
         beats.add(new Beat(startTime+gapTime*24, "A"));
         beats.add(new Beat(startTime+gapTime*28, "D"));
         beats.add(new Beat(startTime+gapTime*32, "D"));
         beats.add(new Beat(startTime+gapTime*36, "A"));
         beats.add(new Beat(startTime+gapTime*40, "A"));
      }
      
      int i = 0;
      gameMusic.start();
      
      while(i<beats.size() && !isInterrupted())
      {
         boolean falling = false;
         if(beats.get(i).getTime() <= gameMusic.getTime())
         {
            Note n = new Note(beats.get(i).getName());
            n.start();
            notes.add(n);
            falling = true;
            i++;
         }
         
         if(!falling)
         {
            try
            {
               Thread.sleep(5);
            }
            catch(Exception e)
            {
               e.printStackTrace();
            }
         }
      }
   }
   
   public void accuracyCheck(String p)
   {
      for(int i = 0; i<notes.size(); i++)
      {
         if(p.equals(notes.get(i).getLetter()))
         {
            timingCheck(notes.get(i).noteTiming());
            break;
         }      
      }
   }
   
   public void run()
   {
      noteFall();
   }
   
   public void close()
   {
      gameMusic.close();
      this.interrupt();
   }
   
   public void timingCheck(String p)
   {
      if(p.equals("Too Early"))
      {
         combo = 0;
         score += 10;
        // accuracyImage = new ImageIcon(Menu.class.getResource("../images/early.png")).getImage();
      }
      else if(p.equals("Good"))
      {
         combo = 0;
         score += 20;
      }
      else if(p.equals("Perfect"))
      {
         combo += 1;
         score += 50;
      }
      else if(p.equals("Too Late"))
      {
         combo = 0;
         score += 10;
      }
      
      //System.out.println("score = "+score);
   }
   
   public void screenDraw(Graphics g)
   {
      
      for(int i = 0; i<notes.size(); i++)
      {
         Note n = notes.get(i);
         
         if(n.getY() > 900)
         {
            accuracyImage = new ImageIcon(Menu.class.getResource("images/miss.png")).getImage();
         }
         
         if(!n.isMoving())
         {
            notes.remove(i);
            i--;
         }
         else
         {
            n.screenDraw(g);
         }
      }
   }
   

}
 
