package Component;

import java.awt.Graphics;
import java.awt.Point;

public class Pencil {

    private int pointX, pointY, currentPointX, currentPointY;
    private int mouseX, mouseY;
    private Graphics g;

    public Pencil() {
        mouseX = 5;
        mouseY = 25;
    }

    public Pencil(Point point, Graphics g) {
        this.pointX = point.x;
        this.pointY = point.y;
        this.g = g;
    }

    public Pencil(int pointX, int pointY, int currentPointX, int currentPointY, Graphics g) {
        this.pointX = pointX;
        this.pointY = pointY;
        this.currentPointX = currentPointX;
        this.currentPointY = currentPointY;
        this.g = g;
    }

    public int getPointX() {
        return pointX;
    }

    public void setPointX(int pointX) {
        this.pointX = pointX;
    }

    public int getPointY() {
        return pointY;
    }

    public void setPointY(int pointY) {
        this.pointY = pointY;
    }

    public int getCurrentPointX() {
        return currentPointX;
    }

    public void setCurrentPointX(int currentPointX) {
        this.currentPointX = currentPointX;
    }

    public int getCurrentPointY() {
        return currentPointY;
    }

    public void setCurrentPointY(int currentPointY) {
        this.currentPointY = currentPointY;
    }

    public void draw(Point point, Graphics g) {
        if (currentPointX == 0 && currentPointY == 0) {
            g.drawLine(point.x + mouseX, point.y + mouseY, point.x + mouseX, point.y + mouseY);
        } else {
            g.drawLine(point.x + mouseX, point.y + mouseY, currentPointX + mouseX, currentPointY + mouseY);
        }
        g.dispose();
        currentPointX = point.x;
        currentPointY = point.y;
    }
}
