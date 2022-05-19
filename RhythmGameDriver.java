import javax.swing.JFrame;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Dimension;
import javax.swing.JLabel;


public class RhythmGameDriver
{
   public static Menu screen;
   public static  JLabel scoreLabel = new JLabel("000");
   public static  JLabel healthLabel = new JLabel("200");
      
   public static void main(String args[]){
      Menu screen = new Menu();
      JFrame MainFrame = new JFrame("RHYTHM-GAME");
     
      
      MainFrame.setSize(1100, 1100);
      MainFrame.setLocation(155, 30);
      MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

/*
      //////////////////////////////////////////////////////
      screen.setLayout(null);
      screen.add(scoreLabel);
      Dimension size = scoreLabel.getPreferredSize();
      scoreLabel.setBounds(100, 300, size.width, size.height);
      screen.add(healthLabel);
      size = healthLabel.getPreferredSize();
      healthLabel.setBounds(900, 300, size.width, size.height);
      ////////////////////////////////////////////////////////  
      */
      
      MainFrame.setContentPane(screen);
      
      MainFrame.setVisible(true);
      KeyListener keyListener = new GameKeyListener();
      //MainFrame.addKeyListener(screen);
      //screen.addKeyListener(keyListener);
      //screen.setFocusable(true);
      //screen.requestFocus(); 
   
      MainFrame.addKeyListener(screen);

   }
}
