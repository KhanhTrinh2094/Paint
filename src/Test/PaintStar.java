
package Test;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import javax.swing.JComponent;
import javax.swing.JFrame;

class MyCanvas extends JComponent {
  public void paint(Graphics g) {
    Graphics2D g2D = (Graphics2D) g;
    Point2D.Float point = new Point2D.Float(100, 100);                     // store start point
    GeneralPath p = new GeneralPath(GeneralPath.WIND_NON_ZERO);
    p.moveTo(point.x, point.y);
    p.lineTo(point.x + 20.0f, point.y - 5.0f);           // Line from start to A
    point = (Point2D.Float)p.getCurrentPoint();
    p.lineTo(point.x + 5.0f, point.y - 20.0f);           // Line from A to B
    point = (Point2D.Float)p.getCurrentPoint();
    p.lineTo(point.x + 5.0f, point.y + 20.0f);           // Line from B to C
    point = (Point2D.Float)p.getCurrentPoint();
    p.lineTo(point.x + 20.0f, point.y + 5.0f);           // Line from C to D
    point = (Point2D.Float)p.getCurrentPoint();
    p.lineTo(point.x - 20.0f, point.y + 5.0f);           // Line from D to E
    point = (Point2D.Float)p.getCurrentPoint();
    p.lineTo(point.x - 5.0f, point.y + 20.0f);           // Line from E to F
    point = (Point2D.Float)p.getCurrentPoint();
    p.lineTo(point.x - 5.0f, point.y - 20.0f);           // Line from F to g
    p.closePath();                                       // Line from G to start
    g2D.draw(p);
  }
}
public class PaintStar {
  public static void main(String[] a) {
    JFrame window = new JFrame();
    window.setBounds(30, 30, 300, 300);
    window.getContentPane().add(new MyCanvas());
    window.setVisible(true);
  }
}