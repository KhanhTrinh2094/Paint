package Test;

import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;

public class DrawTriangles extends Applet {

    private Graphics g;
    private Triangle redTriangle;

    public void init() {
        g = getGraphics();
        addMouseListener(new PointListener());
    } // method init 

    // PointListener is an inner class that listens for the mouse to be pressed. 
    class PointListener implements MouseListener {

        public void mousePressed(MouseEvent e) {
            int xval, yval;
            xval = e.getX();
            yval = e.getY();
            redTriangle = new Triangle(Color.red, xval, yval);
            redTriangle.drawTriangle(g);
        } // mousePressed 

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseClicked(MouseEvent e) {
        }
    } // class PointListener 
} // class DrawTriangles

// Triangle draws triangles wherever the mouse has been pressed. 
class Triangle {

    private int x, y;
    private Polygon poly;
    private Color color;

    Triangle(Color c, int xPosition, int yPosition) {
        color = c;
        x = xPosition;
        y = yPosition;
    } // constructor 

    /* drawTriangle creates two lists of points centered around x and y. 
     It then creates a new polygon and draws it. */
    public void drawTriangle(Graphics g) {
        g.setColor(color);
        int[] xList = {x - 20, x, x + 20};
        int[] yList = {y, y - 20, y};
        poly = new Polygon(xList, yList, 3);
        g.fillPolygon(poly);
    } // method drawTriangle 
} // class Triangle 

