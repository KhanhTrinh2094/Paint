
package Test;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.geom.Line2D;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderControlPaintLine extends JFrame {
  DrawingCanvas canvas = new DrawingCanvas();

  JSlider slider1, slider2, slider3, slider4, slider5, slider6, slider7, slider8;

  double transX = 0.0;

  double transY = 0.0;

  double rotateTheta = 0.0;

  double rotateX = 150.0;

  double rotateY = 150.0;

  double scaleX = 1.0;

  double scaleY = 1.0;

  float width = 1.0f;

  public SliderControlPaintLine() {
    JPanel controlPanel = new JPanel();
    controlPanel.setLayout(new GridLayout(3, 3));
    getContentPane().add(controlPanel, BorderLayout.NORTH);

    JLabel label1 = new JLabel("Translate(dx,dy): ");
    JLabel label2 = new JLabel("Rotate(Theta,ox,oy): ");
    JLabel label3 = new JLabel("Scale(sx,sy)x10E-2:");

    controlPanel.add(label1);
    
    slider1 = createSlider(controlPanel, JSlider.HORIZONTAL, 0, 300, 150, 100, 50);
    slider2 = createSlider(controlPanel, JSlider.HORIZONTAL, 0, 300, 150, 100, 50);

    controlPanel.add(label2);
    
    slider3 = createSlider(controlPanel, JSlider.HORIZONTAL, 0, 360, 0, 90, 45);

    JPanel subPanel = new JPanel();
    subPanel.setLayout(new GridLayout(1, 2));

    slider4 = createSlider(subPanel, JSlider.HORIZONTAL, 0, 300, 150, 150, 50);
    slider5 = createSlider(subPanel, JSlider.HORIZONTAL, 0, 300, 150, 150, 50);
    controlPanel.add(subPanel);

    controlPanel.add(label3);
    
    slider6 = createSlider(controlPanel, JSlider.HORIZONTAL, 0, 200, 100, 100, 10);
    slider7 = createSlider(controlPanel, JSlider.HORIZONTAL, 0, 200, 100, 100, 10);

    JPanel widthPanel = new JPanel();
    JLabel label4 = new JLabel("Width Control:", JLabel.RIGHT);
    slider8 = createSlider(widthPanel, JSlider.HORIZONTAL, 0, 200, 100, 100, 10);
    slider8.addChangeListener(new SliderListener());
    
    widthPanel.setLayout(new GridLayout(1, 2));
    widthPanel.add(label4);
    widthPanel.add(slider8);
    getContentPane().add(widthPanel, BorderLayout.SOUTH);

    getContentPane().add(canvas);
    
    setSize(500,500);
    setVisible(true);
  }
  public static void main(String arg[]) {
    new SliderControlPaintLine();
  }
  public JSlider createSlider(JPanel panel, int orientation, int minimumValue, int maximumValue,
      int initValue, int majorTickSpacing, int minorTickSpacing) {
    JSlider slider = new JSlider(orientation, minimumValue, maximumValue, initValue);
    slider.setPaintTicks(true);
    slider.setMajorTickSpacing(majorTickSpacing);
    slider.setMinorTickSpacing(minorTickSpacing);
    slider.setPaintLabels(true);
    slider.addChangeListener(new SliderListener());
    panel.add(slider);
    return slider;
  }

  class SliderListener implements ChangeListener {
    public void stateChanged(ChangeEvent e) {
      JSlider tempSlider = (JSlider) e.getSource();

      if (tempSlider.equals(slider1)) {
        transX = slider1.getValue() - 150.0;
        canvas.repaint();
      } else if (tempSlider.equals(slider2)) {
        transY = slider2.getValue() - 150.0;
        canvas.repaint();
      } else if (tempSlider.equals(slider3)) {
        rotateTheta = slider3.getValue() * Math.PI / 180;
        canvas.repaint();
      } else if (tempSlider.equals(slider4)) {
        rotateX = slider4.getValue();
        canvas.repaint();
      } else if (tempSlider.equals(slider5)) {
        rotateY = slider5.getValue();
        canvas.repaint();
      } else if (tempSlider.equals(slider6)) {
        if (slider6.getValue() != 0.0) {
          scaleX = slider6.getValue() / 100.0;
          canvas.repaint();
        }
      } else if (tempSlider.equals(slider7)) {
        if (slider7.getValue() != 0.0) {
          scaleY = slider7.getValue() / 100.0;
          canvas.repaint();
        }
      } else if (tempSlider.equals(slider8)) {
        width = slider8.getValue();
        canvas.repaint();
      }
    }
  }

  class DrawingCanvas extends Canvas {
    public DrawingCanvas() {
      setSize(300, 300);
    }

    public void paint(Graphics g) {
      Graphics2D g2D = (Graphics2D) g;

      g2D.translate(transX, transY);
      g2D.rotate(rotateTheta, rotateX, rotateY);
      g2D.scale(scaleX, scaleY);
      BasicStroke stroke = new BasicStroke(width);
      g2D.setStroke(stroke);
      Line2D line1 = new Line2D.Float(100f, 200f, 200f, 200f);
      g2D.draw(line1);
    }
  }
}