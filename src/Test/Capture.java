package Test;

import java.awt.AWTException;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Capture {

    public static void main(String[] args) {
        JFrame capture = new JFrame();
        capture.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Toolkit kit = Toolkit.getDefaultToolkit();
        final Dimension d = kit.getScreenSize();
        capture.setSize(d);

        Rectangle rect = new Rectangle(d);
        try {
            Robot robot = new Robot();
            final BufferedImage image = robot.createScreenCapture(rect);
//      robot.keyPress(KeyEvent.VK_B);

            image.flush();
            JPanel panel = new JPanel() {
                public void paintComponent(Graphics g) {
                    g.drawImage(image, 0, 0, d.width, d.height, this);
                }
            };
            panel.setOpaque(false);
            panel.prepareImage(image, panel);
            panel.repaint();
            capture.getContentPane().add(panel);

//      robot.mousePress(InputEvent.BUTTON1_MASK);
            capture.setVisible(true);
            robot.mouseMove(1890, 10);
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.mouseRelease((InputEvent.BUTTON1_MASK));
        } catch (AWTException e) {
        }
    }
}
