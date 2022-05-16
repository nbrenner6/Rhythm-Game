import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.geom.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.ArrayList;


public class Menu extends JPanel implements MouseListener, MouseMotionListener
{
   public static final int noteSpeed = 3;
   public static final int reachTime = 3;
   public static final int sleepTime = 6;

   private static final int SIZE = 500;
//    private static final int screenWidth = 500;
//    private static final int screenHeight = 500;
   private static final int SIZEX = 1100;
   private static final int SIZEY = 1100;
   private static final int screenWidth = 500;
   private static final int screenHeight = 500;
   private static final int textSize = 25;
   private static final int DELAY = 0;
   private static Timer t;
   private static int frame;  
   private Button [] startButtons = new Button[3];
   private Button [] trackButtons = new Button[1];
   private Button [] mainButtons = new Button[4];
   protected static int mouseX;
   protected static int mouseY;
   private Image screenImage;
//    private Image background = new ImageIcon(Menu.class.getResource("images/background.jpg")).getImage();
   private Graphics screenGraphic;
   ArrayList<Track> trackList = new ArrayList<Track>();
   
   public static Game game;
   public static final int STARTSCREEN = 0, TRACKSELECT = 1, MAINGAME = 2, INSTRUCTIONS = 3;
   public static int gameMode; 

   public Menu()
   {
      gameMode = STARTSCREEN;
      addMouseListener( this );
      addMouseMotionListener( this );
      mouseX = SIZE/2;
      mouseY = SIZE/2;
      Rectangle r1 = new Rectangle(450,550,150, 50);
      startButtons[0] = new Button(r1, "how to play", Color.CYAN, Color.YELLOW, Color.BLACK);
      startButtons[0] = new Button(r1, "how to play", Color.CYAN, Color.YELLOW, Color.BLACK);
      Ellipse2D.Float r2 = new Ellipse2D.Float(450, 700,75, 50);
      startButtons[1] = new Button(r2, "quit", Color.CYAN, Color.YELLOW, Color.BLACK);
      Rectangle r3 = new Rectangle(450, 400, 75, 50);
      startButtons[2] = new Button(r3, "start", Color.CYAN, Color.YELLOW, Color.BLACK);
      Rectangle t1 = new Rectangle(450, 550, 150, 50);
      trackButtons[0] = new Button(t1, "twinkle", Color.CYAN, Color.YELLOW, Color.BLACK);
      //Sound.initialize();
//       t = new Timer(DELAY, new Listener());
//       t.start();
//       frame = 0;

      trackList.add(new Track("twinkle.png", "twinkle.mid"));
   }
   
   public void showBoard(Graphics g)
   {
      if(gameMode == STARTSCREEN)
      {
         g.setColor(Color.black);
         g.fillRect(0, 0, SIZEX, SIZEY);
         int x = textSize;
         int y = textSize;
         g.setColor(Color.white);
         g.setFont(new Font("Serif", Font.PLAIN, 100));
         g.drawString("RHYTHM", 325, 200);
         g.drawString("GAME", 365, 350);
         
      
         for(Button b: startButtons)
         {
            g.setFont(new Font("Serif", Font.PLAIN, textSize));
            x = (int)(b.getShape().getBounds().getX());
            y = (int)(b.getShape().getBounds().getY());
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
      else if(gameMode == TRACKSELECT)
      {
         g.setColor(Color.black);
         g.fillRect(0, 0, SIZEX, SIZEY);
         g.setColor(Color.white);
         g.setFont(new Font("Serif", Font.PLAIN, 100));
         g.drawString("TRACK SELECT", 425, 200);
         g.drawString("TRACK SELECT", 200, 100);
         int x = textSize;
         int y = textSize;
         
         for(Button b: trackButtons)
         {
            g.setFont(new Font("Serif", Font.PLAIN, textSize));
            x = (int)(b.getShape().getBounds().getX());
            y = (int)(b.getShape().getBounds().getY());
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
      else if(gameMode == MAINGAME)
      {
         g.setColor(Color.black);
         g.fillRect(0, 0, SIZEX, SIZEY);
         g.setColor(Color.white);
         g.drawLine(SIZEX/4-50, 0, SIZEX/4-50, SIZEY);
         g.drawLine(SIZEX/4+115, 0, SIZEX/4+115, SIZEY);
         g.drawLine((SIZEX/4)*2, 0, (SIZEX/4)*2, SIZEY);
         g.drawLine((SIZEX/4)*3-115, 0, (SIZEX/4)*3-115, SIZEY);
         g.drawLine((SIZEX/4)*3+50, 0, (SIZEX/4)*3+50, SIZEY);
         g.drawLine(SIZEX/4-50, 900, (SIZEX/4)*3+50, 900);
         g.setFont(new Font("Serif", Font.PLAIN, 40));
         g.drawString("SCORE: ", 25, 100);
         g.drawString("HEALTH: ", 900, 100);
      }
      else if(gameMode == INSTRUCTIONS)
      {
         g.setColor(Color.black);
         g.fillRect(0, 0, SIZEX, SIZEY);
         g.setColor(Color.white);
         g.setFont(new Font("Serif", Font.PLAIN, 75));
         g.drawString("HOW TO PLAY", 300, 80);
         g.setFont(new Font("Serif", Font.PLAIN, 25));
         g.drawString("Notes will fall down the screen", 200, 300);
         g.drawString("The letters W, S, A, and D correspond to up, down, left, and right respectively", 200, 375);
         g.drawString("Your job is to hit the corresponding keys as close as possible", 200, 450);
         g.drawString("to the instant the notes fall into the frame of the arrows at the bottom", 200, 500);
         //g.drawString("HOW TO PLAY", 425, 80);
      }
   }
   
   public void mouseClicked( MouseEvent e )
   {      
       int button = e.getButton();      
       if(button == MouseEvent.BUTTON1)      
       {         
          for(Button b: startButtons)         
          {           
             if(b.getShape().contains(mouseX, mouseY))           
             {              
                if(b.getTitle().equals("quit")) {             
                   System.exit(0);  
                }             
                else if(b.getTitle().equals("how to play")) {              
                  gameMode = INSTRUCTIONS;
                } 
                else if(b.getTitle().equals("start"))
                {
                  gameMode = TRACKSELECT;
                }      
             }
          }
          
      }
      if(gameMode == STARTSCREEN)
      {  
             for(Button b: startButtons)         
             {           
                if(b.getShape().contains(mouseX, mouseY))           
                {              
                   if(b.getTitle().equals("quit")) {             
                      System.exit(0);  
                   }             
                   else if(b.getTitle().equals("how to play")) {              
                     gameMode = INSTRUCTIONS;
                   } 
                   else if(b.getTitle().equals("start"))
                   {
                     gameMode = TRACKSELECT;
                   }      
                }
             }
         }
         if(gameMode == TRACKSELECT)
         {
             for(Button b: trackButtons)
             {
               if(b.getShape().contains(mouseX, mouseY))
               {
                  if(b.getTitle().equals("twinkle"))
                  {
                     gameMode = MAINGAME;
                  }
               }
             } 
         }    
       else if(button == MouseEvent.BUTTON3)      
       { 
                       
       }      
       repaint();
   }
   
  /* public void screenDraw(Graphics2D g)
   {
    // g.drawImage(background, 0, 0, null);
      
   }
   
   public void paint(Graphics g)
   {
      screenImage = createImage(screenWidth, screenHeight);
      screenGraphic = screenImage.getGraphics();
      screenDraw((Graphics2D) screenGraphic);
      g.drawImage(screenImage, 0, 0, null);
   }*/
   
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      showBoard(g);
   }
   
   public void mouseMoved( MouseEvent e)
   {
      mouseX = e.getX();
      mouseY = e.getY();
      for (Button b: startButtons)
      {
         if (b.getShape().contains(mouseX, mouseY))
            b.highlight();
         else
            b.unHighlight();
      }
      
      for(Button b: trackButtons)
      {
         if(b.getShape().contains(mouseX, mouseY))
         {
            b.highlight();
         }
         else
         {
            b.unHighlight();
         }
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
   
   private class Listener implements ActionListener
   {
      public void actionPerformed(ActionEvent e) {
   
         if(gameMode == STARTSCREEN && (e.getSource() == startButtons[2]))
         {
            gameMode = TRACKSELECT;
         }
         else if(gameMode == TRACKSELECT && (e.getSource() == trackButtons[0]))
         {
            gameMode = MAINGAME;
         }
         else if(gameMode == STARTSCREEN && (e.getSource() == startButtons[0]))
         {
            gameMode = INSTRUCTIONS;
         }
      }
   } 
    
}
