package Panel;

import Component.ToolVariable;
import Dialog.TextDialog;
import Frame.MainFrame;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class DrawPanel extends JPanel {

    private int imageWidth, imageHeight;
    private boolean imageTransparent;
    private MainFrame mainFrame;
    public BufferedImage playImage, tempImage;
    private JScrollPane scrollPane;
    private String filePath, fileName;
    private Point currentPoint;
    private KeyAdapter keyEvent = null;
    private Rectangle2D rect;
    public JLabel lbImage;
    private ArrayList<Raster> listImage;
    private int indexImage = -1;

    public int getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        if (fileName.equals("")) {
            fileName = "Untitled.png";
        }
        this.fileName = fileName;
    }

    public boolean isImageTransparent() {
        return imageTransparent;
    }

    public void setImageTransparent(boolean imageTransparent) {
        this.imageTransparent = imageTransparent;
    }

    public DrawPanel(MainFrame mainFrame) {
        super();
        this.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        this.setPreferredSize(new java.awt.Dimension(1180, 475));
        this.setLayout(null);
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnImageMousePressed(evt, null);
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pnImageMouseReleased(evt, null);
            }
        });
        this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnImageMouseDragged(evt, null);
            }
        });
        this.mainFrame = mainFrame;
        lbImage = new JLabel();
        lbImage.setBackground(new java.awt.Color(51, 51, 0));
        lbImage.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbImage.setBounds(2, 2, mainFrame.getPnWidth(), mainFrame.getPnHeight());
        this.add(lbImage);
        listImage = new ArrayList<>();
    }

    public void addImageList() {
        if (listImage.size() >= 9) {
            listImage.remove(0);
        }
        listImage.add(playImage.getData());
        indexImage = listImage.size() - 1;
        setUndoRedo();
    }

    public void imageUndo() {
        if (indexImage > 0) {
            indexImage--;
            playImage.setData(listImage.get(indexImage));
            lbImage.setIcon(new ImageIcon(playImage));
        }
        setUndoRedo();
    }

    public void setUndoRedo() {
        if (indexImage > 0) {
            mainFrame.pnMenu.mnUndo.setEnabled(true);
        }
        if (indexImage < listImage.size() - 1) {
            mainFrame.pnMenu.mnRedo.setEnabled(true);
        }
        if (indexImage <= 0) {
            mainFrame.pnMenu.mnUndo.setEnabled(false);
        }
        if (indexImage >= listImage.size() - 1) {
            mainFrame.pnMenu.mnRedo.setEnabled(false);
        }
    }

    public void imageRedo() {
        if (indexImage < 10) {
            indexImage++;
            playImage.setData(listImage.get(indexImage));
            lbImage.setIcon(new ImageIcon(playImage));
        }
        setUndoRedo();
    }

    public boolean canUndo() {
        if (listImage.isEmpty()) {
            return false;
        } else {
            return indexImage != 0;
        }
    }

    public boolean canRedo() {
        if (listImage.isEmpty()) {
            return false;
        } else if (indexImage >= listImage.size() - 1) {
            return false;
        } else {
            return indexImage != 9;
        }
    }

    public void clear(BufferedImage newImage) {
        Graphics2D g2d = newImage.createGraphics();
        g2d.setRenderingHints(mainFrame.pnTool.getRenderingHints());
        g2d.setColor(mainFrame.pnTool.getColor());
        g2d.fillRect(0, 0, newImage.getWidth(), newImage.getHeight());
        g2d.dispose();
        lbImage.repaint();
    }

    public void setAction(ToolVariable setAction) {
        mainFrame.pnTool.setActionTool(setAction);
    }

    private void pnImageMouseReleased(java.awt.event.MouseEvent evt, Point point) {
        if (playImage != null) {
            Point actionPoint = new Point();
            if (point != null) {
                actionPoint = point;
            } else {
                actionPoint = evt.getPoint();
            }

            switch (mainFrame.pnTool.getActionTool()) {
                case DEFAULT:
                    break;
                case SELECT_TOOL:
                    break;
                case DRAW_TOOL:
                    break;
                case TEXT_TOOL:
                    break;
                case FILL_TOOL:
                    break;
                case ERASE_TOOL:
                    break;
                case PICKER_TOOL:
                    break;
                case CROP_TOOL:
                    if (keyEvent == null) {
                        keyEvent = new KeyAdapter() {
                            @Override
                            public void keyPressed(KeyEvent e) {
                                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                                    if (mainFrame.pnTool.getActionTool() == ToolVariable.CROP_TOOL && rect != null) {
                                        BufferedImage cropImage = playImage.getSubimage((int) rect.getX(), (int) rect.getY(), (int) rect.getWidth(), (int) rect.getHeight());
                                        setImage(cropImage);
                                        rect = null;
                                    }
                                }
                            }
                        };
                        this.requestFocus();
                        this.addKeyListener(keyEvent);
                    }
                    break;
                case GRADIENT_TOOL:
                    playImage.setData(tempImage.getData());
                    lbImage.setIcon(new ImageIcon(playImage));
                    break;
                case DRAW_LINE:
                    playImage.setData(tempImage.getData());
                    lbImage.setIcon(new ImageIcon(playImage));
                    break;
                case DRAW_RECT:
                    playImage.setData(tempImage.getData());
                    lbImage.setIcon(new ImageIcon(playImage));
                    break;
                case DRAW_ROUNDRECT:
                    playImage.setData(tempImage.getData());
                    lbImage.setIcon(new ImageIcon(playImage));
                    break;
                case DRAW_CIRCLE:
                    break;
                case DRAW_TRIANGLE:
                    break;
            }
        }
        currentPoint = null;
        addImageList();
    }

    private void pnImageMousePressed(java.awt.event.MouseEvent evt, Point point) {
        if (playImage != null) {
            Point actionPoint = new Point();
            if (point != null) {
                actionPoint = point;
            } else {
                actionPoint = evt.getPoint();
            }

            switch (mainFrame.pnTool.getActionTool()) {
                case DEFAULT:
                    break;
                case SELECT_TOOL:
                    currentPoint = actionPoint;
                    break;
                case DRAW_TOOL:
                    draw(actionPoint);
                    break;
                case TEXT_TOOL:
                    drawText(actionPoint);
                    break;
                case FILL_TOOL:
                    fill(actionPoint);
                    break;
                case ERASE_TOOL:
                    erase(actionPoint);
                    break;
                case PICKER_TOOL:
                    picker(actionPoint);
                    break;
                case CROP_TOOL:
                    currentPoint = actionPoint;
                    break;
                case GRADIENT_TOOL:
                    currentPoint = actionPoint;
                    break;
                case DRAW_LINE:
                    currentPoint = actionPoint;
                    break;
                case DRAW_RECT:
                    currentPoint = actionPoint;
                    break;
                case DRAW_ROUNDRECT:
                    currentPoint = actionPoint;
                    break;
                case DRAW_CIRCLE:
                    break;
                case DRAW_TRIANGLE:
                    break;
            }
        }
    }

    private void pnImageMouseDragged(java.awt.event.MouseEvent evt, Point point) {
        if (playImage != null) {
            Point actionPoint = new Point();
            if (point != null) {
                actionPoint = point;
            } else {
                actionPoint = evt.getPoint();
            }
            switch (mainFrame.pnTool.getActionTool()) {
                case DEFAULT:
                    break;
                case SELECT_TOOL:
                    tempImage.setData(playImage.getData());
                    selectionDraw(actionPoint);
                    break;
                case DRAW_TOOL:
                    draw(actionPoint);
                    break;
                case TEXT_TOOL:
                    break;
                case FILL_TOOL:
                    break;
                case ERASE_TOOL:
                    erase(actionPoint);
                    break;
                case PICKER_TOOL:
                    break;
                case CROP_TOOL:
                    tempImage.setData(playImage.getData());
                    cropSelection(actionPoint);
                    break;
                case GRADIENT_TOOL:
                    tempImage.setData(playImage.getData());
                    drawGradient(actionPoint);
                    break;
                case DRAW_LINE:
                    tempImage.setData(playImage.getData());
                    drawLine(actionPoint);
                    break;
                case DRAW_RECT:
                    tempImage.setData(playImage.getData());
                    drawRect(actionPoint);
                    break;
                case DRAW_ROUNDRECT:
                    tempImage.setData(playImage.getData());
                    drawRoundRect(actionPoint);
                    break;
                case DRAW_CIRCLE:
                    break;
                case DRAW_TRIANGLE:
                    break;
            }
        }
    }

    private void draw(Point point) {
        if (playImage != null) {
            Graphics2D g = playImage.createGraphics();
            g.setRenderingHints(mainFrame.pnTool.getRenderingHints());
            if (mainFrame.pnTool.getActionColor() == ToolVariable.TEXTURE_COLOR) {
                g.setPaint(mainFrame.pnTool.texturePaint);
            } else if (mainFrame.pnTool.getActionColor() == ToolVariable.GRADIENT_COLOR) {
                g.setPaint(mainFrame.pnTool.gradientPaint);
            } else {
                g.setColor(mainFrame.pnTool.getColor());
            }
            g.setStroke(mainFrame.pnTool.getStroke());
            int n = 0;
            if (currentPoint == null) {
                g.drawLine(point.x + 5, point.y + 25, point.x + n + 5, point.y + n + 25);
            } else {
                g.drawLine(point.x + 5, point.y + 25, currentPoint.x + n + 5, currentPoint.y + n + 25);
            }
            g.dispose();

            lbImage.setIcon(new ImageIcon(playImage));
            currentPoint = point;
        }
    }

    private void fill(Point actionPoint) {
        if (playImage != null) {
            Graphics2D g = playImage.createGraphics();
            g.setRenderingHints(mainFrame.pnTool.getRenderingHints());
            if (mainFrame.pnTool.getActionColor() == ToolVariable.TEXTURE_COLOR) {
                g.setPaint(mainFrame.pnTool.texturePaint);
            } else if (mainFrame.pnTool.getActionColor() == ToolVariable.GRADIENT_COLOR) {
                g.setPaint(mainFrame.pnTool.gradientPaint);
            } else {
                g.setColor(mainFrame.pnTool.getColor());
            }
            g.setStroke(mainFrame.pnTool.getStroke());
            if (rect != null) {
                if (actionPoint.x > rect.getX() && actionPoint.x < (rect.getX() + rect.getWidth()) && actionPoint.y > rect.getY() && actionPoint.y < (rect.getY() + rect.getHeight())) {
                    g.fillRect((int) rect.getX(), (int) rect.getY(), (int) rect.getWidth(), (int) rect.getHeight());
                } else {
                    g.fillRect(0, 0, imageWidth, imageHeight);
                }
            } else {
                g.fillRect(0, 0, imageWidth, imageHeight);
            }

            g.dispose();
            lbImage.setIcon(new ImageIcon(playImage));
        }
    }

    private void selectionDraw(Point actionPoint) {
        if (playImage != null && currentPoint != null) {
            rect = null;
            Graphics2D g = tempImage.createGraphics();
            g.setRenderingHints(mainFrame.pnTool.getRenderingHints());
            g.setColor(Color.BLACK);
            currentPoint.x = (currentPoint.x > imageWidth) ? imageWidth - 1 : currentPoint.x;
            currentPoint.y = (currentPoint.y > imageHeight) ? imageHeight - 1 : currentPoint.y;
            actionPoint.x = (actionPoint.x > imageWidth) ? imageWidth - 1 : actionPoint.x;
            actionPoint.y = (actionPoint.y > imageHeight) ? imageHeight - 1 : actionPoint.y;

            currentPoint.x = (currentPoint.x < 0) ? 1 : currentPoint.x;
            currentPoint.y = (currentPoint.y < 0) ? 1 : currentPoint.y;
            actionPoint.x = (actionPoint.x < 0) ? 1 : actionPoint.x;
            actionPoint.y = (actionPoint.y < 0) ? 1 : actionPoint.y;
            if (currentPoint.x > actionPoint.x) {
                if (currentPoint.y > actionPoint.y) {
                    rect = new Rectangle2D.Float(actionPoint.x, actionPoint.y, currentPoint.x - actionPoint.x, currentPoint.y - actionPoint.y);
                } else {
                    rect = new Rectangle2D.Float(actionPoint.x, currentPoint.y, currentPoint.x - actionPoint.x, actionPoint.y - currentPoint.y);
                }
            } else {
                if (currentPoint.y > actionPoint.y) {
                    rect = new Rectangle2D.Float(currentPoint.x, actionPoint.y, actionPoint.x - currentPoint.x, currentPoint.y - actionPoint.y);
                } else {
                    rect = new Rectangle2D.Float(currentPoint.x, currentPoint.y, actionPoint.x - currentPoint.x, actionPoint.y - currentPoint.y);
                }
            }
            float[] dash = {5F, 5F};
            Stroke dashedStroke = new BasicStroke(1F, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 3F, dash, 0F);
            g.fill(dashedStroke.createStrokedShape(rect));
            g.setStroke(mainFrame.pnTool.getStroke());
            g.dispose();
            lbImage.setIcon(new ImageIcon(tempImage));
        }
    }

    private void drawText(Point actionPoint) {
        if (playImage != null) {
            TextDialog textDialog = new TextDialog(null, true);
            textDialog.setLocationRelativeTo(this);
            textDialog.setVisible(true);
            GradientPaint gradientPaint;
            if (textDialog.isVisible() == false && textDialog.isSubmit) {
                Graphics2D g = playImage.createGraphics();
                g.setRenderingHints(mainFrame.pnTool.getRenderingHints());
                if (mainFrame.pnTool.getActionColor() == ToolVariable.TEXTURE_COLOR) {
                    g.setPaint(mainFrame.pnTool.texturePaint);
                } else if (mainFrame.pnTool.getActionColor() == ToolVariable.GRADIENT_COLOR) {
                    if (mainFrame.pnTool.gradientColor.Orizon == 0) {
                        if (mainFrame.pnTool.gradientColor.Vector == 0) {
                            gradientPaint = new GradientPaint(actionPoint.x, 0, mainFrame.pnTool.gradientColor.from, actionPoint.x + textDialog.textWidth, 0, mainFrame.pnTool.gradientColor.to);
                        } else {
                            gradientPaint = new GradientPaint(actionPoint.x + textDialog.textWidth, 0, mainFrame.pnTool.gradientColor.from, actionPoint.x, 0, mainFrame.pnTool.gradientColor.to);
                        }
                    } else {
                        if (mainFrame.pnTool.getGradientColor().Vector == 0) {
                            gradientPaint = new GradientPaint(0, actionPoint.y - textDialog.textHeight, mainFrame.pnTool.gradientColor.from, 0, actionPoint.y + textDialog.textHeight, mainFrame.pnTool.gradientColor.to);
                        } else {
                            gradientPaint = new GradientPaint(0, actionPoint.y + textDialog.textHeight, mainFrame.pnTool.gradientColor.from, 0, actionPoint.y - textDialog.textHeight, mainFrame.pnTool.gradientColor.to);
                        }
                    }
                    g.setPaint(gradientPaint);
                } else {
                    g.setColor(mainFrame.pnTool.getColor());
                }
                g.setStroke(mainFrame.pnTool.getStroke());
                g.setFont(textDialog.txtText.getFont());
                g.drawString(textDialog.strText, actionPoint.x, actionPoint.y);
                g.dispose();
                lbImage.setIcon(new ImageIcon(playImage));
                addImageList();
            }
        }
    }

    private void erase(Point actionPoint) {
        if (playImage != null) {
            Graphics2D g = playImage.createGraphics();
            g.setRenderingHints(mainFrame.pnTool.getRenderingHints());
            g.setColor(Color.WHITE);
            g.setStroke(mainFrame.pnTool.getStroke());
            int n = 0;
            if (currentPoint == null) {
                g.drawLine(actionPoint.x + 5, actionPoint.y + 25, actionPoint.x + n + 5, actionPoint.y + n + 25);
            } else {
                g.drawLine(actionPoint.x + 5, actionPoint.y + 25, currentPoint.x + n + 5, currentPoint.y + n + 25);
            }
            g.dispose();

            lbImage.setIcon(new ImageIcon(playImage));
            currentPoint = actionPoint;
        }
    }

    private void picker(Point actionPoint) {
        if (playImage != null) {
            mainFrame.pnTool.setColor(new Color(playImage.getRGB(actionPoint.x + 3, actionPoint.y + 25)));
            if (mainFrame.pnTool.pnColorOne.getBackground() == Color.WHITE) {
                mainFrame.pnTool.setBackgroundColorTwo(mainFrame.pnTool.getColor());
            } else {
                mainFrame.pnTool.setBackgroundColorOne(mainFrame.pnTool.getColor());
            }
            lbImage.setIcon(new ImageIcon(playImage));
        }
    }

    private void cropSelection(Point actionPoint) {
        if (playImage != null && currentPoint != null) {
            rect = null;
            Graphics2D g = tempImage.createGraphics();
            g.setRenderingHints(mainFrame.pnTool.getRenderingHints());
            g.setColor(Color.BLACK);
            currentPoint.x = (currentPoint.x > imageWidth) ? imageWidth - 1 : currentPoint.x;
            currentPoint.y = (currentPoint.y > imageHeight) ? imageHeight - 1 : currentPoint.y;
            actionPoint.x = (actionPoint.x > imageWidth) ? imageWidth - 1 : actionPoint.x;
            actionPoint.y = (actionPoint.y > imageHeight) ? imageHeight - 1 : actionPoint.y;

            currentPoint.x = (currentPoint.x < 0) ? 1 : currentPoint.x;
            currentPoint.y = (currentPoint.y < 0) ? 1 : currentPoint.y;
            actionPoint.x = (actionPoint.x < 0) ? 1 : actionPoint.x;
            actionPoint.y = (actionPoint.y < 0) ? 1 : actionPoint.y;

            if (currentPoint.x > actionPoint.x) {
                if (currentPoint.y > actionPoint.y) {
                    rect = new Rectangle2D.Float(actionPoint.x, actionPoint.y, currentPoint.x - actionPoint.x, currentPoint.y - actionPoint.y);
                } else {
                    rect = new Rectangle2D.Float(actionPoint.x, currentPoint.y, currentPoint.x - actionPoint.x, actionPoint.y - currentPoint.y);
                }
            } else {
                if (currentPoint.y > actionPoint.y) {
                    rect = new Rectangle2D.Float(currentPoint.x, actionPoint.y, actionPoint.x - currentPoint.x, currentPoint.y - actionPoint.y);
                } else {
                    rect = new Rectangle2D.Float(currentPoint.x, currentPoint.y, actionPoint.x - currentPoint.x, actionPoint.y - currentPoint.y);
                }
            }
            float[] dash = {5F, 5F};
            Stroke dashedStroke = new BasicStroke(1F, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 3F, dash, 0F);
            g.fill(dashedStroke.createStrokedShape(rect));
            g.setStroke(mainFrame.pnTool.getStroke());
            g.dispose();
            lbImage.setIcon(new ImageIcon(tempImage));
        }
    }

    private void drawGradient(Point actionPoint) {
        if (playImage != null && currentPoint != null) {
            if (mainFrame.pnTool.getGradientFill() != null && mainFrame.pnTool.getGradientFill().isVisible() == false) {
                rect = null;
                GradientPaint gradientDraw = null;
                Graphics2D g = tempImage.createGraphics();
                g.setRenderingHints(mainFrame.pnTool.getRenderingHints());
                currentPoint.x = (currentPoint.x > imageWidth) ? imageWidth - 1 : currentPoint.x;
                currentPoint.y = (currentPoint.y > imageHeight) ? imageHeight - 1 : currentPoint.y;
                actionPoint.x = (actionPoint.x > imageWidth) ? imageWidth - 1 : actionPoint.x;
                actionPoint.y = (actionPoint.y > imageHeight) ? imageHeight - 1 : actionPoint.y;

                currentPoint.x = (currentPoint.x < 0) ? 1 : currentPoint.x;
                currentPoint.y = (currentPoint.y < 0) ? 1 : currentPoint.y;
                actionPoint.x = (actionPoint.x < 0) ? 1 : actionPoint.x;
                actionPoint.y = (actionPoint.y < 0) ? 1 : actionPoint.y;
                if (currentPoint.x > actionPoint.x) {
                    if (currentPoint.y > actionPoint.y) {
                        rect = new Rectangle2D.Float(actionPoint.x, actionPoint.y, currentPoint.x - actionPoint.x, currentPoint.y - actionPoint.y);
                    } else {
                        rect = new Rectangle2D.Float(actionPoint.x, currentPoint.y, currentPoint.x - actionPoint.x, actionPoint.y - currentPoint.y);
                    }
                } else {
                    if (currentPoint.y > actionPoint.y) {
                        rect = new Rectangle2D.Float(currentPoint.x, actionPoint.y, actionPoint.x - currentPoint.x, currentPoint.y - actionPoint.y);
                    } else {
                        rect = new Rectangle2D.Float(currentPoint.x, currentPoint.y, actionPoint.x - currentPoint.x, actionPoint.y - currentPoint.y);
                    }
                }

                if (mainFrame.pnTool.getGradientFill().Orizon == 0) {
                    if (mainFrame.pnTool.getGradientFill().Vector == 0) {
                        gradientDraw = new GradientPaint(0, 0, mainFrame.pnTool.getGradientFill().from, (int) rect.getWidth(), 0, mainFrame.pnTool.getGradientFill().to);
                    } else {
                        gradientDraw = new GradientPaint((int) rect.getWidth(), 0, mainFrame.pnTool.getGradientFill().from, 0, 0, mainFrame.pnTool.getGradientFill().to);
                    }
                } else {
                    if (mainFrame.pnTool.getGradientFill().Vector == 0) {
                        gradientDraw = new GradientPaint(0, (int) rect.getHeight(), mainFrame.pnTool.getGradientFill().from, 0, 0, mainFrame.pnTool.getGradientFill().to);
                    } else {
                        gradientDraw = new GradientPaint(0, 0, mainFrame.pnTool.getGradientFill().from, 0, (int) rect.getHeight(), mainFrame.pnTool.getGradientFill().to);
                    }
                }
                g.setPaint(gradientDraw);
                g.fillRect((int) rect.getX(), (int) rect.getY(), (int) rect.getWidth(), (int) rect.getHeight());
                g.dispose();
                lbImage.setIcon(new ImageIcon(tempImage));
            }
        }
    }

    private void drawLine(Point actionPoint) {
        if (playImage != null && currentPoint != null) {
            Graphics2D g = tempImage.createGraphics();
            g.setRenderingHints(mainFrame.pnTool.getRenderingHints());
            if (mainFrame.pnTool.getActionColor() == ToolVariable.TEXTURE_COLOR) {
                g.setPaint(mainFrame.pnTool.texturePaint);
            } else if (mainFrame.pnTool.getActionColor() == ToolVariable.GRADIENT_COLOR) {
                g.setPaint(mainFrame.pnTool.gradientPaint);
            } else {
                g.setColor(mainFrame.pnTool.getColor());
            }
            g.setStroke(mainFrame.pnTool.getStroke());
            g.drawLine(currentPoint.x, currentPoint.y, actionPoint.x, actionPoint.y);
            g.dispose();
            lbImage.setIcon(new ImageIcon(tempImage));
        }
    }

    private void drawRect(Point actionPoint) {
        if (playImage != null && currentPoint != null) {
            rect = null;
            Graphics2D g = tempImage.createGraphics();
            g.setRenderingHints(mainFrame.pnTool.getRenderingHints());
            if (mainFrame.pnTool.getActionColor() == ToolVariable.TEXTURE_COLOR) {
                g.setPaint(mainFrame.pnTool.texturePaint);
            } else if (mainFrame.pnTool.getActionColor() == ToolVariable.GRADIENT_COLOR) {
                g.setPaint(mainFrame.pnTool.gradientPaint);
            } else {
                g.setColor(mainFrame.pnTool.getColor());
            }
            g.setStroke(mainFrame.pnTool.getStroke());
            currentPoint.x = (currentPoint.x > imageWidth) ? imageWidth - 1 : currentPoint.x;
            currentPoint.y = (currentPoint.y > imageHeight) ? imageHeight - 1 : currentPoint.y;
            actionPoint.x = (actionPoint.x > imageWidth) ? imageWidth - 1 : actionPoint.x;
            actionPoint.y = (actionPoint.y > imageHeight) ? imageHeight - 1 : actionPoint.y;

            currentPoint.x = (currentPoint.x < 0) ? 1 : currentPoint.x;
            currentPoint.y = (currentPoint.y < 0) ? 1 : currentPoint.y;
            actionPoint.x = (actionPoint.x < 0) ? 1 : actionPoint.x;
            actionPoint.y = (actionPoint.y < 0) ? 1 : actionPoint.y;
            if (currentPoint.x > actionPoint.x) {
                if (currentPoint.y > actionPoint.y) {
                    rect = new Rectangle2D.Float(actionPoint.x, actionPoint.y, currentPoint.x - actionPoint.x, currentPoint.y - actionPoint.y);
                } else {
                    rect = new Rectangle2D.Float(actionPoint.x, currentPoint.y, currentPoint.x - actionPoint.x, actionPoint.y - currentPoint.y);
                }
            } else {
                if (currentPoint.y > actionPoint.y) {
                    rect = new Rectangle2D.Float(currentPoint.x, actionPoint.y, actionPoint.x - currentPoint.x, currentPoint.y - actionPoint.y);
                } else {
                    rect = new Rectangle2D.Float(currentPoint.x, currentPoint.y, actionPoint.x - currentPoint.x, actionPoint.y - currentPoint.y);
                }
            }
            g.drawRect((int) rect.getX(), (int) rect.getY(), (int) rect.getWidth(), (int) rect.getHeight());
            g.dispose();
            lbImage.setIcon(new ImageIcon(tempImage));
        }
    }

    private void drawRoundRect(Point actionPoint) {
        if (playImage != null && currentPoint != null) {
            rect = null;
            Graphics2D g = tempImage.createGraphics();
            g.setRenderingHints(mainFrame.pnTool.getRenderingHints());
            if (mainFrame.pnTool.getActionColor() == ToolVariable.TEXTURE_COLOR) {
                g.setPaint(mainFrame.pnTool.texturePaint);
            } else if (mainFrame.pnTool.getActionColor() == ToolVariable.GRADIENT_COLOR) {
                g.setPaint(mainFrame.pnTool.gradientPaint);
            } else {
                g.setColor(mainFrame.pnTool.getColor());
            }
            g.setStroke(mainFrame.pnTool.getStroke());
            currentPoint.x = (currentPoint.x > imageWidth) ? imageWidth - 1 : currentPoint.x;
            currentPoint.y = (currentPoint.y > imageHeight) ? imageHeight - 1 : currentPoint.y;
            actionPoint.x = (actionPoint.x > imageWidth) ? imageWidth - 1 : actionPoint.x;
            actionPoint.y = (actionPoint.y > imageHeight) ? imageHeight - 1 : actionPoint.y;

            currentPoint.x = (currentPoint.x < 0) ? 1 : currentPoint.x;
            currentPoint.y = (currentPoint.y < 0) ? 1 : currentPoint.y;
            actionPoint.x = (actionPoint.x < 0) ? 1 : actionPoint.x;
            actionPoint.y = (actionPoint.y < 0) ? 1 : actionPoint.y;
            if (currentPoint.x > actionPoint.x) {
                if (currentPoint.y > actionPoint.y) {
                    rect = new Rectangle2D.Float(actionPoint.x, actionPoint.y, currentPoint.x - actionPoint.x, currentPoint.y - actionPoint.y);
                } else {
                    rect = new Rectangle2D.Float(actionPoint.x, currentPoint.y, currentPoint.x - actionPoint.x, actionPoint.y - currentPoint.y);
                }
            } else {
                if (currentPoint.y > actionPoint.y) {
                    rect = new Rectangle2D.Float(currentPoint.x, actionPoint.y, actionPoint.x - currentPoint.x, currentPoint.y - actionPoint.y);
                } else {
                    rect = new Rectangle2D.Float(currentPoint.x, currentPoint.y, actionPoint.x - currentPoint.x, actionPoint.y - currentPoint.y);
                }
            }
            g.drawRoundRect((int) rect.getX(), (int) rect.getY(), (int) rect.getWidth(), (int) rect.getHeight(), 20, 15);
            g.dispose();
            lbImage.setIcon(new ImageIcon(tempImage));
        }
    }

    public void changeOpacity(float opacityValue) {
        if (playImage != null && tempImage != null) {
            playImage.setData(tempImage.getData());
            Graphics2D g2d = playImage.createGraphics();
            g2d.setRenderingHints(mainFrame.pnTool.getRenderingHints());
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_IN, opacityValue));
            g2d.drawImage(tempImage, 0, 0, imageWidth, imageHeight, this);
            g2d.dispose();
            lbImage.setIcon(new ImageIcon(playImage));
        }
    }

    public void rotateImage(int type) {
        if (playImage != null) {
            int rotateWidth = playImage.getWidth(), rotateHeight = playImage.getHeight();
            double rotationRequired, locationX, locationY;
            BufferedImage imageResize, rotateImage;
            Graphics2D g2d;
            switch (type) {
                case 0:
                    if (rotateWidth < rotateHeight) {
                        rotationRequired = Math.toRadians(90);
                        locationX = (rotateWidth + rotateHeight - rotateWidth) / 2;
                        locationY = rotateHeight / 2;

                        imageResize = new BufferedImage(rotateWidth + rotateHeight - rotateWidth, rotateHeight, BufferedImage.TYPE_INT_ARGB);
                        g2d = imageResize.createGraphics();
                        g2d.drawImage(playImage, 0, 0, null);
                        g2d.dispose();
                    } else {
                        rotationRequired = Math.toRadians(90);
                        locationX = rotateWidth / 2;
                        locationY = (rotateHeight + rotateWidth - rotateHeight) / 2;

                        imageResize = new BufferedImage(rotateWidth, rotateHeight + rotateWidth - rotateHeight, BufferedImage.TYPE_INT_ARGB);
                        g2d = imageResize.createGraphics();
                        g2d.drawImage(playImage, 0, rotateWidth - rotateHeight, null);
                        g2d.dispose();
                    }
                    rotateImage = new BufferedImage(rotateHeight, rotateWidth, BufferedImage.TYPE_INT_ARGB);
                    g2d = rotateImage.createGraphics();
                    g2d.rotate(rotationRequired, locationX, locationY);
                    g2d.drawImage(imageResize, 0, 0, null);

                    setImage(rotateImage);
                    mainFrame.pnMsg.displayResolution(playImage.getWidth() + " x " + playImage.getHeight());
                    break;
                case 1:
                    if (rotateWidth < rotateHeight) {
                        rotationRequired = Math.toRadians(-90);
                        locationX = (rotateWidth + rotateHeight - rotateWidth) / 2;
                        locationY = rotateHeight / 2;

                        imageResize = new BufferedImage(rotateWidth + rotateHeight - rotateWidth, rotateHeight, BufferedImage.TYPE_INT_ARGB);
                        g2d = imageResize.createGraphics();
                        g2d.drawImage(playImage, rotateHeight - rotateWidth, 0, null);
                        g2d.dispose();
                    } else {
                        rotationRequired = Math.toRadians(-90);
                        locationX = rotateWidth / 2;
                        locationY = (rotateHeight + rotateWidth - rotateHeight) / 2;

                        imageResize = new BufferedImage(rotateWidth, rotateHeight + rotateWidth - rotateHeight, BufferedImage.TYPE_INT_ARGB);
                        g2d = imageResize.createGraphics();
                        g2d.drawImage(playImage, 0, 0, null);
                        g2d.dispose();
                    }
                    rotateImage = new BufferedImage(rotateHeight, rotateWidth, BufferedImage.TYPE_INT_ARGB);
                    g2d = rotateImage.createGraphics();
                    g2d.rotate(rotationRequired, locationX, locationY);
                    g2d.drawImage(imageResize, 0, 0, null);

                    setImage(rotateImage);
                    mainFrame.pnMsg.displayResolution(playImage.getWidth() + " x " + playImage.getHeight());
                    break;
                case 2:
                    rotationRequired = Math.toRadians(180);
                    locationX = rotateWidth / 2;
                    locationY = rotateHeight / 2;
                    
                    rotateImage = new BufferedImage(rotateWidth, rotateHeight, BufferedImage.TYPE_INT_ARGB);
                    g2d = rotateImage.createGraphics();
                    g2d.rotate(rotationRequired, locationX, locationY);
                    g2d.drawImage(playImage, 0, 0, null);

                    setImage(rotateImage);
                    mainFrame.pnMsg.displayResolution(playImage.getWidth() + " x " + playImage.getHeight());
                    break;
                default:
                    break;
            }
        }
    }

    public void flipImage(boolean type) {
        AffineTransform tx;
        AffineTransformOp op;
        if (!type) {
            tx = AffineTransform.getScaleInstance(1, -1);
            tx.translate(0, -imageHeight);
            op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
            setImage(op.filter(playImage, null));
        } else {
            tx = AffineTransform.getScaleInstance(-1, 1);
            tx.translate(-imageWidth, 0);
            op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
            setImage(op.filter(playImage, null));
        }
    }
    
    public void resizeImage(int width, int height){
        BufferedImage bi;
        bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = bi.createGraphics();
        g.setRenderingHints(mainFrame.pnTool.getRenderingHints());
        g.drawImage(playImage, 0, 0, width, height, null);
        setImage(bi);
        mainFrame.pnMsg.displayResolution(playImage.getWidth() + " x " + playImage.getHeight());
    }
    
    public void setBorder(String image){
        Graphics2D g2d = playImage.createGraphics();
        try {
            g2d.drawImage(ImageIO.read(new File(getClass().getResource("/BorderPaint/" + image + ".png").getPath())), 0, 0, imageWidth, imageHeight, null);
        } catch (IOException ex) {
        }
        lbImage.setIcon(new ImageIcon(playImage));
        addImageList();
    }

    public void setImage(BufferedImage newImage) {
        imageWidth = newImage.getWidth();
        imageHeight = newImage.getHeight();
        playImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
        tempImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = (Graphics2D) playImage.createGraphics();
        g2d.setRenderingHints(mainFrame.pnTool.getRenderingHints());
        g2d.drawImage(newImage, 0, 0, imageWidth, imageHeight, null);
        g2d.dispose();

        lbImage.setIcon(new ImageIcon(playImage));
        lbImage.setSize(imageWidth, imageHeight);
        lbImage.setBounds(2, 2, imageWidth, imageHeight);
        this.setLayout(null);
        if (imageWidth > mainFrame.getPnWidth() || imageHeight > mainFrame.getPnHeight()) {
            if (scrollPane == null) {
                scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                scrollPane.getViewport().add(lbImage);
                scrollPane.setBounds(2, 2, mainFrame.getPnWidth(), mainFrame.getPnHeight());
                scrollPane.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        pnImageMousePressed(e, new Point(e.getPoint().x + scrollPane.getHorizontalScrollBar().getValue(), e.getPoint().y + scrollPane.getVerticalScrollBar().getValue()));
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        pnImageMouseReleased(e, new Point(e.getPoint().x + scrollPane.getHorizontalScrollBar().getValue(), e.getPoint().y + scrollPane.getVerticalScrollBar().getValue()));
                    }
                });

                scrollPane.addMouseMotionListener(new MouseAdapter() {
                    @Override
                    public void mouseDragged(MouseEvent e) {
                        pnImageMouseDragged(e, new Point(e.getPoint().x + scrollPane.getHorizontalScrollBar().getValue(), e.getPoint().y + scrollPane.getVerticalScrollBar().getValue()));
                    }
                });
                this.remove(lbImage);
                this.add(scrollPane);
            }
        } else {
            if (scrollPane != null) {
                this.remove(scrollPane);
                scrollPane = null;
            }
            this.add(lbImage);
        }
        this.repaint();
        listImage.clear();
        addImageList();
    }

    public void setCursor(String path) {
        if ("".equals(path)) {
            lbImage.setCursor(Cursor.getDefaultCursor());
        } else {
            lbImage.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(Toolkit.getDefaultToolkit().getImage(getClass().getResource(path)), new Point(0, 0), "customCursor"));
        }
    }
}
