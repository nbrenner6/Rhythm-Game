import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Game extends Thread
{
   private String gameTitle;
   private Music musicTitle;
   ArrayList<Note> notes = new ArrayList<Note>();
   //private Image notePath = new ImageIcon(Menu.class.getResource("images/notePath.png")).getImage();
   private Image noteImageW = new ImageIcon(Menu.class.getResource("images/notePath.png")).getImage();
   private Image noteImageA = new ImageIcon(Menu.class.getResource("images/notePath.png")).getImage();
   private Image noteImageS = new ImageIcon(Menu.class.getResource("images/notePath.png")).getImage();
   private Image noteImageD = new ImageIcon(Menu.class.getResource("images/notePath.png")).getImage();
   
   private Image accuracyImage;
   private int score = 0;
   private int combo = 0;


   public Game(String t, Music m)
   {
      gameTitle = t;
      musicTitle = m;
   }
   
   public void pressW()
   {
      accuracyCheck("W");
      noteImageW = new ImageIcon(Menu.class.getResource("images/notePressed.png")).getImage();
   }
   
   public void releaseW()
   {
      noteImageW = new ImageIcon(Menu.class.getResource("images/notePath.png")).getImage();
   }
   
   public void pressA()
   {
      accuracyCheck("A");
      noteImageA = new ImageIcon(Menu.class.getResource("images/notePressed.png")).getImage();
   }
   
   public void releaseA()
   {
      noteImageA = new ImageIcon(Menu.class.getResource("images/notePath.png")).getImage();
   }
   
   public void pressS()
   {
      accuracyCheck("S");
      noteImageS = new ImageIcon(Menu.class.getResource("images/notePressed.png")).getImage();
   }
   
   public void releaseS()
   {
      noteImageS = new ImageIcon(Menu.class.getResource("images/notePath.png")).getImage();
   }
   
   public void pressD()
   {
      accuracyCheck("D");
      noteImageD = new ImageIcon(Menu.class.getResource("images/notePressed.png")).getImage();
   }
   
   public void releaseD()
   {
      noteImageD = new ImageIcon(Menu.class.getResource("images/notePath.png")).getImage();
   }
   
   public void noteFall()
   {
      ArrayList<Beat> beats = null;
      
      if(gameTitle.equals("twinkle"))
      {
         int startTime = 7500 - Menu.reachTime*1000;
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
      musicTitle.start();
      
      while(i<beats.size() && !isInterrupted())
      {
         boolean falling = false;
         if(beats.get(i).getTime() <= musicTitle.getTime())
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
      musicTitle.close();
      this.interrupt();
   }
   
   public void timingCheck(String p)
   {
      if(p.equals("Too Early"))
      {
         combo = 0;
         score += 10;
         accuracyImage = new ImageIcon(Menu.class.getResource("../images/early.png")).getImage();
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
   }
   
   public void screenDraw(Graphics2D g)
   {
      g.drawImage(noteImageW, 200, 20, null);
      g.drawImage(noteImageA, 250, 20, null);
      g.drawImage(noteImageS, 300, 20, null);
      g.drawImage(noteImageD, 350, 20, null); 
   }
   

}
