import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Color;

public class BasicGraphics extends JPanel {
    Timer t;
    int tick; //in milliseconds
    int num;
    Conductor c;

    public BasicGraphics(Conductor test) {
        c = test;
        init();
    }
    public void init() {
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                num++;
                repaint();
            }
        };
        tick = (int)(Math.pow(c.getBPM(), -1) * 60000); //convert from minutes to milliseconds
        t = new Timer(tick ,taskPerformer);
        t.start();
    }

    public void paint(Graphics g) {
        setSize(1600,1400);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 1600, 1200);
        g.setColor(Color.RED);
        g.drawLine(0, 1000, 1600, 1000);
        g.setColor(Color.BLUE);
        int initial= 100;
        int increment = 50;
        g.drawLine(200, initial + (increment * num), 1400, initial + (increment * num));
    }
    
    public static void main(String [] args) {
        JFrame MainFrame = new JFrame();
        MainFrame.setSize(600,400);
        Conductor test = new Conductor(1, 1, 1, "twinkle");
        BasicGraphics g = new BasicGraphics(test);
        MainFrame.add(g);
        test.playTrack();
        MainFrame.setVisible(true);

    }
}
