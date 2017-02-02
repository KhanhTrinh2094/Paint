
package Test;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ScreenCapture extends JFrame {
  ImageArea ia = new ImageArea();

  Rectangle rectScreenSize = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

  static Robot robot;

  JScrollPane jsp;

  public ScreenCapture(String title) {
    super(title);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    JMenuBar mb = new JMenuBar();
    JMenu menu = new JMenu("File");
    ActionListener al;

    JMenuItem mi = new JMenuItem("Save");
    al = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        save();
      }
    };

    mi.addActionListener(al);
    menu.add(mi);
    mb.add(menu);

    menu = new JMenu("Capture");

    mi = new JMenuItem("Capture");
    al = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setVisible(false);

        BufferedImage biScreen = robot.createScreenCapture(rectScreenSize);
        setVisible(true);

        ia.setImage(biScreen);

        jsp.getHorizontalScrollBar().setValue(0);
        jsp.getVerticalScrollBar().setValue(0);
      }
    };

    mi.addActionListener(al);
    menu.add(mi);

    mb.add(menu);

    mi = new JMenuItem("Crop");
    al = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (ia.crop()) {
          jsp.getHorizontalScrollBar().setValue(0);
          jsp.getVerticalScrollBar().setValue(0);
        }
      }
    };

    mi.addActionListener(al);
    menu.add(mi);

    mb.add(menu);
    setJMenuBar(mb);
    getContentPane().add(jsp = new JScrollPane(ia));
    setVisible(true);
  }

  private void save() {
    if (ia.getImage() == null) {
      System.out.println("No captured image.");
      return;
    }
    ImageWriter writer = null;
    ImageOutputStream ios = null;

    try {
      Iterator iter = ImageIO.getImageWritersByFormatName("jpeg");

      if (!iter.hasNext()) {
        System.out.println("Unable to save image to jpeg file type.");
        return;
      }
      writer = (ImageWriter) iter.next();
      ios = ImageIO.createImageOutputStream(new File("c:\\a.jpg"));
      writer.setOutput(ios);
      ImageWriteParam iwp = writer.getDefaultWriteParam();
      iwp.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
      iwp.setCompressionQuality(0.95f);
      writer.write(null,
          new IIOImage((BufferedImage) ia.getImage(), null, null), iwp);
    } catch (Exception e2) {
      e2.printStackTrace();
    }

  }

  public static void main(String[] args) throws Exception {
    robot = new Robot();
    new ScreenCapture("Capture");
  }
}

class ImageArea extends JPanel {
  private Image image;

  Point startPoint = new Point(), endPoint = new Point();

  private Rectangle selectedRectangle = new Rectangle();

  public ImageArea() {
    addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        if (image == null)
          return;
        startPoint = endPoint = e.getPoint();
        repaint();
      }
    });

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {
        if (image == null)
          return;

        endPoint = e.getPoint();
        repaint();
      }
    });
  }

  public boolean crop() {
    if (startPoint.equals(endPoint))
      return true;

    boolean succeeded = true;

    int x1 = (startPoint.x < endPoint.x) ? startPoint.x : endPoint.x;
    int y1 = (startPoint.y < endPoint.y) ? startPoint.y : endPoint.y;

    int x2 = (startPoint.x > endPoint.x) ? startPoint.x : endPoint.x;
    int y2 = (startPoint.y > endPoint.y) ? startPoint.y : endPoint.y;

    int width = (x2 - x1) + 1;
    int height = (y2 - y1) + 1;

    BufferedImage biCrop = new BufferedImage(width, height,
        BufferedImage.TYPE_INT_RGB);
    Graphics2D g2d = biCrop.createGraphics();
    BufferedImage bi = (BufferedImage) image;
    BufferedImage bi2 = bi.getSubimage(x1, y1, width, height);
    g2d.drawImage(bi2, null, 0, 0);

    g2d.dispose();

    if (succeeded)
      setImage(biCrop);
    else {
      startPoint.x = endPoint.x;
      startPoint.y = endPoint.y;
      repaint();
    }

    return succeeded;
  }

  public Image getImage() {
    return image;
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (image != null)
      g.drawImage(image, 0, 0, this);

    if (startPoint.x != endPoint.x || startPoint.y != endPoint.y) {
      int x1 = (startPoint.x < endPoint.x) ? startPoint.x : endPoint.x;
      int y1 = (startPoint.y < endPoint.y) ? startPoint.y : endPoint.y;
      int x2 = (startPoint.x > endPoint.x) ? startPoint.x : endPoint.x;
      int y2 = (startPoint.y > endPoint.y) ? startPoint.y : endPoint.y;
      selectedRectangle.x = x1;
      selectedRectangle.y = y1;
      selectedRectangle.width = (x2 - x1) + 1;
      selectedRectangle.height = (y2 - y1) + 1;
      Graphics2D g2d = (Graphics2D) g;
      g2d.draw(selectedRectangle);
    }
  }

  public void setImage(Image image) {
    this.image = image;
    setPreferredSize(new Dimension(image.getWidth(this), image.getHeight(this)));
    revalidate();
    startPoint.x = endPoint.x;
    startPoint.y = endPoint.y;
    repaint();
  }
}