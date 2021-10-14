import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.geom.*;
import java.util.Timer;


public class Menu extends JPanel implements MouseListener, MouseMotionListener, ActionListener
{
   private static final int SIZE = 500;
   private static final int textSize = 25;
   private static final int DELAY = 0;
   private static Timer t;
   private static int frame;  
   private Button [] buttons = new Button[2];
   protected static int mouseX;
   protected static int mouseY;

   public Menu()
   {
      addMouseListener( this );
      addMouseMotionListener( this );
      mouseX = SIZE/2;
      mouseY = SIZE/2;
      Rectangle r1 = new Rectangle(50,SIZE-100,75, 50);
      buttons[0] = new Button(r1, "reset", Color.CYAN, Color.YELLOW, Color.BLACK);
      Ellipse2D.Float r2 = new Ellipse2D.Float(150, SIZE-100,75, 50);
      buttons[1] = new Button(r2, "quit", Color.CYAN, Color.YELLOW, Color.BLACK);
      //Sound.initialize();
//       t = new Timer(DELAY, new Listener());
//       t.start();
//       frame = 0;
   }
   
   public void showBoard(Graphics g)
   {
      for(Button b: buttons)
      {
          int x = (int)(b.getShape().getBounds().getX());
          int y = (int)(b.getShape().getBounds().getY());
          int width = (int)(b.getShape().getBounds().getWidth());            
          int height = (int)(b.getShape().getBounds().getHeight());
          g.setColor(b.getColor());                
          if(b.getShape() instanceof Rectangle)                       
             g.fillRect(x, y, width, height);            
          else
             g.fillOval(x, y, width, height);            
             g.setColor(b.getTextColor());                        
             g.drawString(b.getTitle(), x, y+(height/2));     
      }
   }
   
   public void mouseClicked( MouseEvent e )
   {      
       int button = e.getButton();      
       if(button == MouseEvent.BUTTON1)      
       {         
          for(Button b:buttons)         
          {           
             if(b.getShape().contains(mouseX, mouseY))           
             {              
                if(b.getTitle().equals("quit")) {             
                   System.exit(0);  
                }             
                else if(b.getTitle().equals("reset")) {              
                  //resetEnemies();
                }       
             }
          }
       }       
       else if(button == MouseEvent.BUTTON3)      
       { 
                     
       }      
       repaint();
   }
   
   public void mouseMoved( MouseEvent e)
   {
      mouseX = e.getX();
      mouseY = e.getY();
      for (Button b:buttons)
      {
         if (b.getShape().contains(mouseX, mouseY))
         b.highlight();
         else
         b.unHighlight();
      }
      repaint();
   }
   
   public void mouseExited(MouseEvent e) {
   }
   
   public void mouseEntered(MouseEvent e) {
   }
   
   public void mouseReleased(MouseEvent e) {
   }
   
   public void mousePressed(MouseEvent e) {
   }
   
   public void mouseDragged(MouseEvent e) {
   }
   
   public static void main(String args[]){
      Menu test = new Menu();
   }
    
}
