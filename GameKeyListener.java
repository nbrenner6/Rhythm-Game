import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class GameKeyListener implements KeyListener
{
   public boolean upPress;
   public boolean downPress;
   public boolean rightPress;
   public boolean leftPress;

   public void keyTyped(KeyEvent e)
   {
   
   }
   
   public void keyPressed(KeyEvent e)
   {
      int key = e.getKeyCode();
      
      if(key == KeyEvent.VK_UP)
      {
         upPress = true;
      }
      
      if(key == KeyEvent.VK_DOWN)
      {
         downPress = true;
      }
      
      if(key == KeyEvent.VK_RIGHT)
      {
         rightPress = true;
      }
      
      if(key == KeyEvent.VK_LEFT)
      {
         leftPress = true;
      }
   }
   
   public void keyReleased(KeyEvent e)
   {
      int key = e.getKeyCode();
      
      if(key == KeyEvent.VK_UP)
      {
         upPress = false;
      }
      
      if(key == KeyEvent.VK_DOWN)
      {
         downPress = false;
      }
      
      if(key == KeyEvent.VK_RIGHT)
      {
         rightPress = false;
      }
      
      if(key == KeyEvent.VK_LEFT)
      {
         leftPress = false;
      }
   }
}