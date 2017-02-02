package Test;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.GeneralPath;

public class BezLab extends Frame implements MouseListener, MouseMotionListener {

    private int[] xs = {75, 150, 300, 375};

    private int[] ys = {250, 100, 350, 250};

    private int dragIndex = NOT_DRAGGING;

    private final static int NEIGHBORHOOD = 15;

    private final static int NOT_DRAGGING = -1;

    public static void main(String[] args) {
        (new BezLab()).setVisible(true);
    }

    BezLab() {
        setSize(500, 450);
        addMouseListener(this);
        addMouseMotionListener(this);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        for (int i = 0; i < 4; i++) {
            if (i == 0 || i == 3) {
                g.setColor(Color.blue);
            } else {
                g.setColor(Color.red);
            }
            g.fillOval(xs[i] - 6, ys[i] - 6, 12, 12);
        }
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        GeneralPath path = new GeneralPath();
        path.moveTo(xs[0], ys[0]);
        path.curveTo(xs[1], ys[1], xs[2], ys[2], xs[3], ys[3]);
        g2d.draw(path);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        dragIndex = NOT_DRAGGING;
        System.out.println("a");
        int minDistance = Integer.MAX_VALUE;
        int indexOfClosestPoint = -1;
        for (int i = 0; i < 4; i++) {
            int deltaX = xs[i] - e.getX();
            int deltaY = ys[i] - e.getY();
            int distance = (int) (Math.sqrt(deltaX * deltaX + deltaY * deltaY));
            if (distance < minDistance) {
                minDistance = distance;
                indexOfClosestPoint = i;
            }
        }
        if (minDistance > NEIGHBORHOOD) {
            return;
        }

        dragIndex = indexOfClosestPoint;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (dragIndex == NOT_DRAGGING) {
            return;
        }
        xs[dragIndex] = e.getX();
        ys[dragIndex] = e.getY();
        dragIndex = NOT_DRAGGING;
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (dragIndex == NOT_DRAGGING) {
            return;
        }

        xs[dragIndex] = e.getX();
        ys[dragIndex] = e.getY();
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
