import javax.swing.JFrame;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class RhythmGameDriver
{
   public static Menu screen;
   
   public static void main(String args[]){
      Menu screen = new Menu();
      JFrame MainFrame = new JFrame("RHYTHM-GAME");
      MainFrame.setSize(1100, 1100);
      MainFrame.setLocation(155, 30);
      MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      MainFrame.setContentPane(screen);
      MainFrame.setVisible(true);
      MainFrame.addKeyListener(screen);

   }
}
