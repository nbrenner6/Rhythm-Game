import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Game
{
   private String gameTitle;
   ArrayList<Note> notes = new ArrayList<Note>();
   private Image notePath = new ImageIcon(Menu.class.getResource("../images/notePath.png")).getImage();
   
   private Image accuracyImage;
   private int score = 0;
   private int combo = 0;

   public Game(String title)
   {
      gameTitle = title;
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
      g.drawImage(notePath, 200, 20, null);
      g.drawImage(notePath, 250, 20, null);
      g.drawImage(notePath, 300, 20, null);
      g.drawImage(notePath, 350, 20, null);
   }
   

}
