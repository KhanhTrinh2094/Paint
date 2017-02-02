package Test;

import java.lang.*;
import java.util.*;
import java.util.List;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class DrawTriangle extends Frame {

    public Polygon mypolygon = new Polygon();

    public void paint(Graphics g) {
        Graphics2D ga = (Graphics2D) g;
        ga.setPaint(Color.red);
        ga.drawPolygon(mypolygon);
    }

    public static void main(String args[]) {
        List< Integer> srcpoints = new ArrayList< Integer>();
        srcpoints.add(200);
        srcpoints.add(200);
        srcpoints.add(75);
        srcpoints.add(75);
        srcpoints.add(100);
        srcpoints.add(200);
        srcpoints.add(srcpoints.get(0));
        srcpoints.add(srcpoints.get(1));

        DrawTriangle frame = new DrawTriangle();
        for (int i = 0; i < srcpoints.size(); i++) {
            int x = srcpoints.get(i++);
            int y = srcpoints.get(i);
            frame.mypolygon.addPoint(x, y);
        }

        frame.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent we) {
                        System.exit(0);
                    }
                }
        );

        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
