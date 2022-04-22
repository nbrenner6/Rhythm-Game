import java.awt.Image;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

public class Note extends Thread{
   private String letter;
   private double time;
   private int x;
   private int y = 250 - (1000/Menu.sleepTime*Menu.noteSpeed)*Menu.reachTime;;
   private Image arrowImage = new ImageIcon(Menu.class.getResource("images/downarrow.png")).getImage();
   
   
   public Note(String l, int t){
      letter = l;
      time = t;
      
      if(letter.equals("A"))
      {
         x = 200;
      }
      
      if(letter.equals("W"))
      {
         x = 250;
      }
      
      if(letter.equals("S"))
      {
         x = 300;
      }
      
      if(letter.equals("D"))
      {
         x = 350;
      }
   }
   
   public String getLetter(){
      return letter;
   }
   
   public void setLetter(String l){
      letter = l;
   }
   
   public double getTime(){
      return time;
   }
   
   public void setTime(double t){
      time = t;  
   }
   
   public void createNote(Graphics2D g)
   {
      g.drawImage(arrowImage, x, y, null);
   }
   
   public String noteTiming()
   {
      if(y <= 200)
      {
         System.out.println("Too Early");
         return "Too Early";
      }
      else if(y <= 225)
      {
         System.out.println("Good");
         return "Good";
      }
      else if(y <= 275)
      {
         System.out.println("Perfect");
         return "Perfect";
      }
      else if(y <= 325)
      {
         System.out.println("Good");
         return "Good";
      }
      else if(y <= 375)
      {
         System.out.println("Too Late");
         return "Too Late";
      }
      else
      {
         return "None";
      }
      
   }
   
   
}


