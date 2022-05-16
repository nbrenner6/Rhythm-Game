import java.io.File;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import javazoom.jl.player.Player;

public class Music extends Thread
{
   private Player player;
   private boolean loop;
   private File file;
   private FileInputStream fis;
   private BufferedInputStream bis;
   
   public Music(String n, boolean l)
   {
      try
      {
         loop = l;
         file = new File(Menu.class.getResource("music/" + n).toURI());
         fis = new FileInputStream(file);
         bis = new BufferedInputStream(fis);
         player = new Player(bis);
      }
      catch(Exception e)
      {
         System.out.println(e.getMessage()); 
      }
   }
   
   public int getTime()
   {
      if(player == null)
      {
         return 0;
      }
      
      return player.getPosition();
   }
   
   public void close()
   {
      loop = false;
      player.close();
      this.interrupt();
   }
   
   public void run()
   {
      try
      {
         while(loop)
         {
            player.play();
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            player = new Player(bis);
         }
      }
      catch(Exception e)
      {
         System.out.println(e.getMessage());
      }
   }
   
}