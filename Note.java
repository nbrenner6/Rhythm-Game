import java.awt.Image;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Note extends Thread{
   private String letter;
   private int x;
   private int y = 250 - (1000/Menu.sleepTime*Menu.noteSpeed)*Menu.reachTime;;
   private Image arrowImage = new ImageIcon(Menu.class.getResource("images/downarrow.png")).getImage();
   private boolean moving = true;
   
   
   public Note(String l){
      letter = l;
      
      if(letter.equals("A"))
      {
         x = 390;
      }
      
      if(letter.equals("W"))
      {
         x = 225;
      }
      
      if(letter.equals("S"))
      {
         x = 555;
      }
      
      if(letter.equals("D"))
      {
         x = 720;
      }
   }
   
   public String getLetter(){
      return letter;
   }
   
   public void setLetter(String l){
      letter = l;
   }
   
   public boolean isMoving()
   {
      return moving;
   }
   
   public int getY()
   {
      return y;
   }
   
   public void close()
   {
      moving = false;
   }
   
   public void moveNote()
   {
      y += Menu.noteSpeed;
      if(y > 935)
      {
         System.out.println("Miss");
         close();
      }
   }
   
   public void run()
   {
      try
      {
         while(true)
         {
            moveNote();
            if(moving)
            {
               Thread.sleep(Menu.sleepTime);
            }
            else
            {
               interrupt();
               break;
            }
         }
      }
      catch(Exception e)
      {
         System.err.println(e.getMessage());
      }
   }
   
   public void screenDraw(Graphics g)
   {
      //g.drawImage(arrowImage, x, y, null);
      g.setColor(Color.green);
      g.drawRect(x, y, 165, 20);
      g.fillRect(x, y, 165, 20);
   }
   
   public String noteTiming()
   {
   
      if(y < 875)
      {
         System.out.println("Too Early");
         close();
         return "Too Early";
      }
      else if(875 <= y && y < 895)
      {
         System.out.println("Good");
//         System.out.println("Good, y="+y);
         close();
         return "Good";
      }
      else if(895 <= y && y <= 910)
      {
         System.out.println("Perfect");
//         System.out.println("Perfect, y="+y);
         close();
         return "Perfect";
      }
      else if(y > 910 || y <= 935)
      {
         System.out.println("Good");
         close();
         return "Good";
      }
      else if(y > 935)
      {
         System.out.println("Too Late");
         close(); 
         return "Too Late";
      }
      else
      {
         return "None";
      }
      
   }
   
   
}


 
