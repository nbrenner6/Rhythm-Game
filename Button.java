import java.awt.Shape;
import java.awt.Color;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D;
import java.awt.Rectangle;

public class Button implements Shape 
{
private Shape shape; 
private String title; 
private Color color, regularColor, highlightColor, textColor; 
   
   public Button(Shape s, String t, Color rc, Color hc, Color tc)
   {
      shape = s;
      title = t;
      regularColor = rc;
      highlightColor = hc;
      textColor = tc;
      color = regularColor;
   }
   
   public void highlight() { 
      color = highlightColor;  
   }
   
   public void unHighlight() {
      color = regularColor;
   }
   
   public Shape getShape() {
      return shape;
   }
   
   public Color getColor() {
      return color;
   }
   
   public Color getTextColor() {
      return textColor;
   }
   
   public String getTitle() { 
      return title;
   }
   
   public PathIterator getPathIterator(AffineTransform at, double flatness) {
      return null;
   }
   
   public PathIterator getPathIterator(AffineTransform at) {
      return null;
   }
   
   public boolean contains(Rectangle2D r) {
      return true;
   }
   
   public boolean contains(double x, double y, double w, double h) {
      return true;
   }
   
   public boolean intersects(double x, double y, double w, double h) {
      return true;
   }
   
   public boolean intersects(Rectangle2D r) {
      return true;
   }
   
   public boolean contains(Point2D p) {
      return true;
   }
   
   public boolean contains(double x, double y) {
      return true;
   }
   
   public Rectangle2D getBounds2D() {
      return null;
   }
   
   public Rectangle getBounds() {
      return null;
   }
   
   public void testHELLOGITHUB() {
   }
}