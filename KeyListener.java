import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter
{
   public void keyPressed(KeyEvent x)
   {
      if(Menu.game == null)
      {
         return;
      }
      
      if(x.getKeyCode() == KeyEvent.VK_W)
      {
         Menu.game.pressW();
      }
      
      if(x.getKeyCode() == KeyEvent.VK_A)
      {
         Menu.game.pressA();
      }
      
      if(x.getKeyCode() == KeyEvent.VK_S)
      {
         Menu.game.pressS();
      }
      
      if(x.getKeyCode() == KeyEvent.VK_D)
      {
         Menu.game.pressD();
      }
   }
   
   public void keyReleased(KeyEvent x)
   {
      if(Menu.game == null)
      {
         return;
      }
      
      if(x.getKeyCode() == KeyEvent.VK_W)
      {
         Menu.game.releaseW();
      }
      
      if(x.getKeyCode() == KeyEvent.VK_A)
      {
         Menu.game.releaseA();
      }
      
      if(x.getKeyCode() == KeyEvent.VK_S)
      {
         Menu.game.releaseS();
      }
      
      if(x.getKeyCode() == KeyEvent.VK_D)
      {
         Menu.game.releaseD();
      }

   }
}
