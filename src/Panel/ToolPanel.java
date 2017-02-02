package Panel;

import Component.ToolVariable;
import Dialog.GradientDialog;
import Dialog.TextureDialog;
import Frame.MainFrame;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.RenderingHints;
import java.awt.TexturePaint;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class ToolPanel extends javax.swing.JPanel {

    private Color color;
    private ToolVariable actionTool, actionColor;
    private BasicStroke stroke;
    private RenderingHints renderingHints;
    public GradientDialog gradientFill, gradientColor;
    private MainFrame mainFrame;
    public TexturePaint texturePaint;
    public GradientPaint gradientPaint;

    public ToolPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
        initData();
    }

    private void initData() {
        stroke = new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.7f);
        Map<RenderingHints.Key, Object> hintsMap = new HashMap<>();
        hintsMap.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        hintsMap.put(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        hintsMap.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        setRenderingHints(new RenderingHints(hintsMap));
        actionTool = ToolVariable.DEFAULT;
    }

    public RenderingHints getRenderingHints() {
        return renderingHints;
    }

    public void setRenderingHints(RenderingHints renderingHints) {
        this.renderingHints = renderingHints;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public ToolVariable getActionTool() {
        return actionTool;
    }

    public void setActionTool(ToolVariable actionTool) {
        this.actionTool = actionTool;
    }

    public BasicStroke getStroke() {
        return stroke;
    }

    public void setStroke(BasicStroke stroke) {
        this.stroke = stroke;
    }

    public ToolVariable getActionColor() {
        return actionColor;
    }

    public void setActionColor(ToolVariable actionColor) {
        this.actionColor = actionColor;
    }

    public GradientDialog getGradientFill() {
        return gradientFill;
    }

    public void setGradientFill(GradientDialog gradientFill) {
        this.gradientFill = gradientFill;
    }

    public GradientDialog getGradientColor() {
        return gradientColor;
    }

    public void setGradientColor(GradientDialog gradientColor) {
        this.gradientColor = gradientColor;
    }

    public void setBackgroundColorOne(Color setColor) {
        actColorOne.setBackground(setColor);
    }

    public void setBackgroundColorTwo(Color setColor) {
        actColorTwo.setBackground(setColor);
    }

    public Color getBackgroundColorOne() {
        return actColorOne.getBackground();
    }

    public Color getBackgroundColorTwo() {
        return actColorTwo.getBackground();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnTool = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        actPen = new javax.swing.JLabel();
        actFill = new javax.swing.JLabel();
        actSelect = new javax.swing.JLabel();
        actText = new javax.swing.JLabel();
        actErase = new javax.swing.JLabel();
        actPicker = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        actRect = new javax.swing.JLabel();
        actLine = new javax.swing.JLabel();
        actTriangle = new javax.swing.JLabel();
        actRoundRect = new javax.swing.JLabel();
        actCircle = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        actSmall = new javax.swing.JLabel();
        actLarger = new javax.swing.JLabel();
        actBig = new javax.swing.JLabel();
        actMedium = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pnColorTwo = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        actColorTwo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pnColorOne = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        actColorOne = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        color1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        color12 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        color2 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        color13 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        color3 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        color14 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        color15 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        color4 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        color5 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        color16 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        color17 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        color6 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        color18 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        color7 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        color8 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        color19 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        colorChoose = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        actCrop = new javax.swing.JLabel();
        actGradient = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        actSingle = new javax.swing.JLabel();
        actGradientColor = new javax.swing.JLabel();
        actTexture = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();

        pnTool.setBackground(new java.awt.Color(255, 255, 255));
        pnTool.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnTool.setPreferredSize(new java.awt.Dimension(1174, 110));
        pnTool.setLayout(null);

        jSeparator4.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        pnTool.add(jSeparator4);
        jSeparator4.setBounds(135, 0, 2, 110);

        actPen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        actPen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Pen.png"))); // NOI18N
        actPen.setToolTipText("Pen");
        actPen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                actPenMousePressed(evt);
            }
        });
        pnTool.add(actPen);
        actPen.setBounds(40, 10, 24, 24);

        actFill.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        actFill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Fill.png"))); // NOI18N
        actFill.setToolTipText("Fill");
        actFill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                actFillMousePressed(evt);
            }
        });
        pnTool.add(actFill);
        actFill.setBounds(70, 10, 24, 24);

        actSelect.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        actSelect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Select.png"))); // NOI18N
        actSelect.setToolTipText("Select");
        actSelect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                actSelectMousePressed(evt);
            }
        });
        pnTool.add(actSelect);
        actSelect.setBounds(10, 10, 24, 24);

        actText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        actText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Text.png"))); // NOI18N
        actText.setToolTipText("Add Text");
        actText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                actTextMousePressed(evt);
            }
        });
        pnTool.add(actText);
        actText.setBounds(100, 10, 24, 24);

        actErase.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        actErase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/EraseTool.png"))); // NOI18N
        actErase.setToolTipText("Erase");
        actErase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                actEraseMousePressed(evt);
            }
        });
        pnTool.add(actErase);
        actErase.setBounds(10, 40, 24, 24);

        actPicker.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        actPicker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ColorPicker.png"))); // NOI18N
        actPicker.setToolTipText("Color Picker");
        actPicker.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                actPickerMousePressed(evt);
            }
        });
        pnTool.add(actPicker);
        actPicker.setBounds(40, 40, 24, 24);

        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tools");
        pnTool.add(jLabel1);
        jLabel1.setBounds(1, 90, 130, 16);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setLayout(null);

        actRect.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        actRect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Rectangle.png"))); // NOI18N
        actRect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                actRectMousePressed(evt);
            }
        });
        jPanel1.add(actRect);
        actRect.setBounds(10, 40, 20, 20);

        actLine.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        actLine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SingleLine.png"))); // NOI18N
        actLine.setPreferredSize(new java.awt.Dimension(20, 20));
        actLine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                actLineMousePressed(evt);
            }
        });
        jPanel1.add(actLine);
        actLine.setBounds(10, 10, 20, 20);

        actTriangle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        actTriangle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Triangle.png"))); // NOI18N
        actTriangle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                actTriangleMousePressed(evt);
            }
        });
        jPanel1.add(actTriangle);
        actTriangle.setBounds(70, 10, 20, 20);

        actRoundRect.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        actRoundRect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/RoundRect.png"))); // NOI18N
        actRoundRect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                actRoundRectMousePressed(evt);
            }
        });
        jPanel1.add(actRoundRect);
        actRoundRect.setBounds(40, 40, 20, 20);

        actCircle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        actCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/CircleIcon.png"))); // NOI18N
        actCircle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                actCircleMousePressed(evt);
            }
        });
        jPanel1.add(actCircle);
        actCircle.setBounds(40, 10, 20, 20);

        pnTool.add(jPanel1);
        jPanel1.setBounds(150, 10, 240, 70);

        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Shapes");
        pnTool.add(jLabel2);
        jLabel2.setBounds(151, 90, 240, 16);

        jSeparator7.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        pnTool.add(jSeparator7);
        jSeparator7.setBounds(405, 0, 2, 110);

        actSmall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SizeSmall.png"))); // NOI18N
        actSmall.setText("jLabel3");
        actSmall.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                actSmallMousePressed(evt);
            }
        });
        pnTool.add(actSmall);
        actSmall.setBounds(420, 10, 100, 16);

        actLarger.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SizeLarger.png"))); // NOI18N
        actLarger.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                actLargerMousePressed(evt);
            }
        });
        pnTool.add(actLarger);
        actLarger.setBounds(420, 70, 100, 16);

        actBig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SizeBig.png"))); // NOI18N
        actBig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                actBigMousePressed(evt);
            }
        });
        pnTool.add(actBig);
        actBig.setBounds(420, 50, 100, 16);

        actMedium.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SizeMedium.png"))); // NOI18N
        actMedium.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                actMediumMousePressed(evt);
            }
        });
        pnTool.add(actMedium);
        actMedium.setBounds(420, 30, 100, 16);

        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Pen Option");
        pnTool.add(jLabel7);
        jLabel7.setBounds(420, 90, 220, 16);

        pnColorTwo.setBackground(new java.awt.Color(255, 255, 255));
        pnColorTwo.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnColorTwo.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(null);

        actColorTwo.setBackground(new java.awt.Color(0, 0, 0));
        actColorTwo.setOpaque(true);
        actColorTwo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                actColorTwoMousePressed(evt);
            }
        });
        jPanel3.add(actColorTwo);
        actColorTwo.setBounds(3, 3, 36, 34);

        pnColorTwo.add(jPanel3);
        jPanel3.setBounds(4, 4, 42, 40);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Color");
        pnColorTwo.add(jLabel4);
        jLabel4.setBounds(0, 50, 50, 16);

        pnTool.add(pnColorTwo);
        pnColorTwo.setBounds(728, 10, 50, 70);

        pnColorOne.setBackground(new java.awt.Color(204, 204, 255));
        pnColorOne.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnColorOne.setLayout(null);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 0)));
        jPanel5.setLayout(null);

        actColorOne.setBackground(java.awt.Color.red);
        actColorOne.setOpaque(true);
        actColorOne.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                actColorOneMousePressed(evt);
            }
        });
        jPanel5.add(actColorOne);
        actColorOne.setBounds(3, 3, 36, 34);

        pnColorOne.add(jPanel5);
        jPanel5.setBounds(4, 4, 42, 40);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Color");
        pnColorOne.add(jLabel6);
        jLabel6.setBounds(0, 50, 50, 16);

        pnTool.add(pnColorOne);
        pnColorOne.setBounds(668, 10, 50, 70);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel6.setLayout(null);

        color1.setBackground(new java.awt.Color(0, 0, 0));
        color1.setOpaque(true);
        color1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                actColorChange(evt);
            }
        });
        jPanel6.add(color1);
        color1.setBounds(4, 4, 25, 25);

        pnTool.add(jPanel6);
        jPanel6.setBounds(798, 10, 33, 33);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel8.setLayout(null);

        color12.setBackground(new java.awt.Color(255, 255, 255));
        color12.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        color12.setOpaque(true);
        color12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                actColorChange(evt);
            }
        });
        jPanel8.add(color12);
        color12.setBounds(4, 4, 25, 25);

        pnTool.add(jPanel8);
        jPanel8.setBounds(798, 50, 33, 33);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel9.setLayout(null);

        color2.setBackground(new java.awt.Color(102, 102, 102));
        color2.setOpaque(true);
        color2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                actColorChange(evt);
            }
        });
        jPanel9.add(color2);
        color2.setBounds(4, 4, 25, 25);

        pnTool.add(jPanel9);
        jPanel9.setBounds(835, 10, 33, 33);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel10.setLayout(null);

        color13.setBackground(new java.awt.Color(204, 204, 204));
        color13.setOpaque(true);
        color13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                actColorChange(evt);
            }
        });
        jPanel10.add(color13);
        color13.setBounds(4, 4, 25, 25);

        pnTool.add(jPanel10);
        jPanel10.setBounds(835, 50, 33, 33);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel11.setLayout(null);

        color3.setBackground(new java.awt.Color(153, 0, 51));
        color3.setOpaque(true);
        color3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                actColorChange(evt);
            }
        });
        jPanel11.add(color3);
        color3.setBounds(4, 4, 25, 25);

        pnTool.add(jPanel11);
        jPanel11.setBounds(872, 10, 33, 33);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel12.setLayout(null);

        color14.setBackground(new java.awt.Color(153, 102, 0));
        color14.setOpaque(true);
        color14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                actColorChange(evt);
            }
        });
        jPanel12.add(color14);
        color14.setBounds(4, 4, 25, 25);

        pnTool.add(jPanel12);
        jPanel12.setBounds(872, 50, 33, 33);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel13.setLayout(null);

        color15.setBackground(new java.awt.Color(255, 153, 102));
        color15.setOpaque(true);
        color15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                actColorChange(evt);
            }
        });
        jPanel13.add(color15);
        color15.setBounds(4, 4, 25, 25);

        pnTool.add(jPanel13);
        jPanel13.setBounds(909, 50, 33, 33);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel14.setLayout(null);

        color4.setBackground(new java.awt.Color(255, 0, 51));
        color4.setOpaque(true);
        color4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                actColorChange(evt);
            }
        });
        jPanel14.add(color4);
        color4.setBounds(4, 4, 25, 25);

        pnTool.add(jPanel14);
        jPanel14.setBounds(909, 10, 33, 33);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel15.setLayout(null);

        color5.setBackground(new java.awt.Color(255, 102, 0));
        color5.setOpaque(true);
        color5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                actColorChange(evt);
            }
        });
        jPanel15.add(color5);
        color5.setBounds(4, 4, 25, 25);

        pnTool.add(jPanel15);
        jPanel15.setBounds(946, 10, 33, 33);

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel16.setLayout(null);

        color16.setBackground(new java.awt.Color(204, 255, 204));
        color16.setOpaque(true);
        color16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                actColorChange(evt);
            }
        });
        jPanel16.add(color16);
        color16.setBounds(4, 4, 25, 25);

        pnTool.add(jPanel16);
        jPanel16.setBounds(946, 50, 33, 33);

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel17.setLayout(null);

        color17.setBackground(new java.awt.Color(0, 153, 255));
        color17.setOpaque(true);
        color17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                actColorChange(evt);
            }
        });
        jPanel17.add(color17);
        color17.setBounds(4, 4, 25, 25);

        pnTool.add(jPanel17);
        jPanel17.setBounds(983, 50, 33, 33);

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel18.setLayout(null);

        color6.setBackground(new java.awt.Color(255, 255, 0));
        color6.setOpaque(true);
        color6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                actColorChange(evt);
            }
        });
        jPanel18.add(color6);
        color6.setBounds(4, 4, 25, 25);

        pnTool.add(jPanel18);
        jPanel18.setBounds(983, 10, 33, 33);

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel19.setLayout(null);

        color18.setBackground(new java.awt.Color(204, 0, 204));
        color18.setOpaque(true);
        color18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                actColorChange(evt);
            }
        });
        jPanel19.add(color18);
        color18.setBounds(4, 4, 25, 25);

        pnTool.add(jPanel19);
        jPanel19.setBounds(1020, 50, 33, 33);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel20.setLayout(null);

        color7.setBackground(new java.awt.Color(0, 153, 0));
        color7.setOpaque(true);
        color7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                actColorChange(evt);
            }
        });
        jPanel20.add(color7);
        color7.setBounds(4, 4, 25, 25);

        pnTool.add(jPanel20);
        jPanel20.setBounds(1020, 10, 33, 33);

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel21.setLayout(null);

        color8.setBackground(new java.awt.Color(102, 255, 51));
        color8.setOpaque(true);
        color8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                actColorChange(evt);
            }
        });
        jPanel21.add(color8);
        color8.setBounds(4, 4, 25, 25);

        pnTool.add(jPanel21);
        jPanel21.setBounds(1057, 10, 33, 33);

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel22.setLayout(null);

        color19.setBackground(new java.awt.Color(0, 153, 153));
        color19.setOpaque(true);
        color19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                actColorChange(evt);
            }
        });
        jPanel22.add(color19);
        color19.setBounds(4, 4, 25, 25);

        pnTool.add(jPanel22);
        jPanel22.setBounds(1057, 50, 33, 33);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel7.setLayout(null);

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 0)));
        jPanel27.setLayout(null);

        colorChoose.setBackground(new java.awt.Color(0, 0, 0));
        colorChoose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/EditColor.PNG"))); // NOI18N
        colorChoose.setOpaque(true);
        colorChoose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                colorChooseMousePressed(evt);
            }
        });
        jPanel27.add(colorChoose);
        colorChoose.setBounds(3, 3, 36, 34);

        jPanel7.add(jPanel27);
        jPanel27.setBounds(4, 4, 42, 40);

        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Choose");
        jPanel7.add(jLabel29);
        jLabel29.setBounds(0, 50, 50, 16);

        pnTool.add(jPanel7);
        jPanel7.setBounds(1110, 10, 50, 73);

        jLabel32.setForeground(new java.awt.Color(204, 204, 204));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Choose Color");
        pnTool.add(jLabel32);
        jLabel32.setBounds(670, 90, 490, 16);

        actCrop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        actCrop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Crop.png"))); // NOI18N
        actCrop.setToolTipText("Crop Image");
        actCrop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                actCropMousePressed(evt);
            }
        });
        pnTool.add(actCrop);
        actCrop.setBounds(70, 40, 24, 24);

        actGradient.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        actGradient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Gradient.png"))); // NOI18N
        actGradient.setToolTipText("Gradient Background");
        actGradient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                actGradientMousePressed(evt);
            }
        });
        pnTool.add(actGradient);
        actGradient.setBounds(100, 40, 24, 24);

        jSeparator9.setOrientation(javax.swing.SwingConstants.VERTICAL);
        pnTool.add(jSeparator9);
        jSeparator9.setBounds(653, 0, 2, 110);

        actSingle.setBackground(new java.awt.Color(255, 255, 255));
        actSingle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        actSingle.setText("Single Color");
        actSingle.setOpaque(true);
        actSingle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                actSingleMousePressed(evt);
            }
        });
        pnTool.add(actSingle);
        actSingle.setBounds(540, 10, 100, 25);

        actGradientColor.setBackground(new java.awt.Color(255, 255, 255));
        actGradientColor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        actGradientColor.setText("Gradient Color");
        actGradientColor.setOpaque(true);
        actGradientColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                actGradientColorMousePressed(evt);
            }
        });
        pnTool.add(actGradientColor);
        actGradientColor.setBounds(540, 35, 100, 25);

        actTexture.setBackground(new java.awt.Color(255, 255, 255));
        actTexture.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        actTexture.setText("Texture Color");
        actTexture.setOpaque(true);
        actTexture.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                actTextureMousePressed(evt);
            }
        });
        pnTool.add(actTexture);
        actTexture.setBounds(540, 60, 100, 25);

        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);
        pnTool.add(jSeparator8);
        jSeparator8.setBounds(530, 25, 2, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnTool, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnTool, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("unchecked")
    private void actPenMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actPenMousePressed
        if (actPen.isEnabled()) {
            if (actPen.getBorder() == null) {
                actionTool = ToolVariable.DRAW_TOOL;
                setActionBorder(actPen);
                setCursor();
            } else {
                mainFrame.pnImage.setCursor("");
                setActionBorder(null);
                actionTool = ToolVariable.DEFAULT;
            }
        }
    }//GEN-LAST:event_actPenMousePressed

    private void actFillMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actFillMousePressed
        if (actFill.isEnabled()) {
            if (actFill.getBorder() == null) {
                actionTool = ToolVariable.FILL_TOOL;

                setActionBorder(actFill);
                setCursor();
            } else {
                mainFrame.pnImage.setCursor("");
                setActionBorder(null);
                actionTool = ToolVariable.DEFAULT;
            }
        }
    }//GEN-LAST:event_actFillMousePressed

    private void actSelectMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actSelectMousePressed
        if (actSelect.isEnabled()) {
            if (actSelect.getBorder() == null) {
                setActionBorder(actSelect);
                actionTool = ToolVariable.SELECT_TOOL;
                mainFrame.pnImage.tempImage.setData(mainFrame.pnImage.playImage.getData());
                setCursor();
            } else {
                mainFrame.pnImage.setCursor("");
                setActionBorder(null);
                actionTool = ToolVariable.DEFAULT;
            }
        }
    }//GEN-LAST:event_actSelectMousePressed

    private void actTextMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actTextMousePressed
        if (actText.isEnabled()) {
            if (actText.getBorder() == null) {
                actionTool = ToolVariable.TEXT_TOOL;
                setActionBorder(actText);
                setCursor();
            } else {
                mainFrame.pnImage.setCursor("");
                setActionBorder(null);
                actionTool = ToolVariable.DEFAULT;
            }
        }
    }//GEN-LAST:event_actTextMousePressed

    private void actEraseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actEraseMousePressed
        if (actErase.isEnabled()) {
            if (actErase.getBorder() == null) {
                actionTool = ToolVariable.ERASE_TOOL;
                setActionBorder(actErase);
                setCursor();
            } else {
                mainFrame.pnImage.setCursor("");
                setActionBorder(null);
                actionTool = ToolVariable.DEFAULT;
            }
        }
    }//GEN-LAST:event_actEraseMousePressed

    private void actPickerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actPickerMousePressed
        if (actPicker.isEnabled()) {
            if (actPicker.getBorder() == null) {
                actionTool = ToolVariable.PICKER_TOOL;
                setActionBorder(actPicker);
                setCursor();
            } else {
                mainFrame.pnImage.setCursor("");
                setActionBorder(null);
                actionTool = ToolVariable.DEFAULT;
            }
        }
    }//GEN-LAST:event_actPickerMousePressed

    private void actRectMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actRectMousePressed
        if (actRect.isEnabled()) {
            if (actRect.getBorder() == null) {
                actionTool = ToolVariable.DRAW_RECT;
                setActionBorder(actRect);
                setCursor();
            } else {
                mainFrame.pnImage.setCursor("");
                setActionBorder(null);
                actionTool = ToolVariable.DEFAULT;
            }
        }
    }//GEN-LAST:event_actRectMousePressed

    private void actLineMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actLineMousePressed
        if (actLine.isEnabled()) {
            if (actLine.getBorder() == null) {
                actionTool = ToolVariable.DRAW_LINE;
                setActionBorder(actLine);
                setCursor();
            } else {
                mainFrame.pnImage.setCursor("");
                setActionBorder(null);
                actionTool = ToolVariable.DEFAULT;
            }
        }
    }//GEN-LAST:event_actLineMousePressed

    private void actSmallMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actSmallMousePressed
        if (actSmall.isEnabled()) {
            if (actSmall.getBorder() == null) {
                stroke = new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.7f);
                setSizeBorder(actSmall);
            } else {
                stroke = new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.7f);
                setSizeBorder(null);
            }
        }
    }//GEN-LAST:event_actSmallMousePressed

    private void actLargerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actLargerMousePressed
        if (actLarger.isEnabled()) {
            if (actLarger.getBorder() == null) {
                stroke = new BasicStroke(15, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.7f);
                setSizeBorder(actLarger);
            } else {
                stroke = new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.7f);
                setSizeBorder(null);
            }
        }
    }//GEN-LAST:event_actLargerMousePressed

    private void actBigMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actBigMousePressed
        if (actBig.isEnabled()) {
            if (actBig.getBorder() == null) {
                stroke = new BasicStroke(8, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.7f);
                setSizeBorder(actBig);
            } else {
                stroke = new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.7f);
                setSizeBorder(null);
            }
        }
    }//GEN-LAST:event_actBigMousePressed

    private void actMediumMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actMediumMousePressed
        if (actMedium.isEnabled()) {
            if (actMedium.getBorder() == null) {
                stroke = new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.7f);
                setSizeBorder(actMedium);
            } else {
                stroke = new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.7f);
                setSizeBorder(null);
            }
        }
    }//GEN-LAST:event_actMediumMousePressed


    private void actColorTwoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actColorTwoMousePressed
        if (actColorOne.isEnabled()) {
            pnColorTwo.setBackground(new Color(204, 204, 255));
            pnColorOne.setBackground(Color.WHITE);
            color = actColorTwo.getBackground();
        }
    }//GEN-LAST:event_actColorTwoMousePressed

    private void actColorOneMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actColorOneMousePressed
        if (actColorOne.isEnabled()) {
            pnColorOne.setBackground(new Color(204, 204, 255));
            pnColorTwo.setBackground(Color.WHITE);
            color = actColorOne.getBackground();
        }
    }//GEN-LAST:event_actColorOneMousePressed

    private void colorChooseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_colorChooseMousePressed
        if (colorChoose.isEnabled()) {
            Color selectColor = JColorChooser.showDialog(this, "Choose Color", color);
            if (selectColor != null) {
                color = selectColor;
                if (pnColorOne.getBackground() == Color.WHITE) {
                    actColorTwo.setBackground(color);
                } else {
                    actColorOne.setBackground(color);
                }
            }
        }
    }//GEN-LAST:event_colorChooseMousePressed

    private void actCropMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actCropMousePressed
        if (actCrop.isEnabled()) {
            if (actCrop.getBorder() == null) {
                actionTool = ToolVariable.CROP_TOOL;

                setActionBorder(actCrop);
                setCursor();
            } else {
                mainFrame.pnImage.setCursor("");
                setActionBorder(null);
                actionTool = ToolVariable.DEFAULT;
            }
        }
    }//GEN-LAST:event_actCropMousePressed

    private void actGradientMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actGradientMousePressed
        if (actGradient.isEnabled()) {
            gradientFill = new GradientDialog(mainFrame, true);
            gradientFill.setLocationRelativeTo(mainFrame);
            gradientFill.setVisible(true);
            actionTool = ToolVariable.GRADIENT_TOOL;
            setActionBorder(actGradient);
            setCursor();
        }
    }//GEN-LAST:event_actGradientMousePressed

    private void actSingleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actSingleMousePressed
        if (actSingle.isEnabled()) {
            actionColor = ToolVariable.SINGLE_COLOR;
            setColorBorder(actSingle);
            texturePaint = null;
            gradientPaint = null;
        }
    }//GEN-LAST:event_actSingleMousePressed

    private void actGradientColorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actGradientColorMousePressed
        if (actGradientColor.isEnabled()) {
            actionColor = ToolVariable.GRADIENT_COLOR;
            gradientColor = new GradientDialog(mainFrame, true);
            gradientColor.setLocationRelativeTo(mainFrame);
            gradientColor.setVisible(true);
            setColorBorder(actGradientColor);
            texturePaint = null;

            if (gradientColor.Orizon == 0) {
                if (gradientColor.Vector == 0) {
                    gradientPaint = new GradientPaint(0, 0, gradientColor.from, mainFrame.pnImage.getImageWidth(), 0, gradientColor.to);
                } else {
                    gradientPaint = new GradientPaint(mainFrame.pnImage.getImageWidth(), 0, gradientColor.from, 0, 0, gradientColor.to);
                }
            } else {
                if (mainFrame.pnTool.getGradientColor().Vector == 0) {
                    gradientPaint = new GradientPaint(0, mainFrame.pnImage.getImageHeight(), gradientColor.from, 0, 0, gradientColor.to);
                } else {
                    gradientPaint = new GradientPaint(0, 0, gradientColor.from, 0, mainFrame.pnImage.getImageHeight(), gradientColor.to);
                }
            }
        }
    }//GEN-LAST:event_actGradientColorMousePressed

    private void actTextureMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actTextureMousePressed
        TextureDialog textureColor;
        if (actGradientColor.isEnabled()) {
            setColorBorder(actTexture);
            actionColor = ToolVariable.TEXTURE_COLOR;
            textureColor = new TextureDialog(mainFrame, true);
            textureColor.setLocationRelativeTo(mainFrame);
            textureColor.setVisible(true);

            gradientPaint = null;
            if (textureColor.selectedFileName.equals("0")) {
                actSingleMousePressed(evt);
            } else {
                BufferedImage textureImage;
                textureImage = new BufferedImage(mainFrame.pnImage.getImageWidth(), mainFrame.pnImage.getImageHeight(), BufferedImage.TYPE_INT_ARGB);
                Graphics ga = textureImage.createGraphics();
                ga.drawImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/TexturePaint/" + textureColor.selectedFileName + ".jpg")), 0, 0, mainFrame.pnImage.getImageWidth(), mainFrame.pnImage.getImageHeight(), null);
                texturePaint = new TexturePaint(textureImage, new Rectangle2D.Float(0, 0, mainFrame.pnImage.getImageWidth(), mainFrame.pnImage.getImageHeight()));
            }
            textureColor = null;
        }
    }//GEN-LAST:event_actTextureMousePressed

    private void actColorChange(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actColorChange
        JLabel labelColor = (JLabel) evt.getSource();
        color = labelColor.getBackground();
        if (labelColor.isEnabled()) {
            if (pnColorOne.getBackground() != Color.WHITE) {
                actColorOne.setBackground(color);
            } else {
                actColorTwo.setBackground(color);
            }
        }
    }//GEN-LAST:event_actColorChange

    private void actTriangleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actTriangleMousePressed
        if (actTriangle.isEnabled()) {
            if (actTriangle.getBorder() == null) {
                actionTool = ToolVariable.DRAW_TRIANGLE;
                setActionBorder(actTriangle);
                setCursor();
            } else {
                mainFrame.pnImage.setCursor("");
                setActionBorder(null);
                actionTool = ToolVariable.DEFAULT;
            }
        }
    }//GEN-LAST:event_actTriangleMousePressed

    private void actRoundRectMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actRoundRectMousePressed
        if (actRoundRect.isEnabled()) {
            if (actRoundRect.getBorder() == null) {
                actionTool = ToolVariable.DRAW_ROUNDRECT;
                setActionBorder(actRoundRect);
                setCursor();
            } else {
                mainFrame.pnImage.setCursor("");
                setActionBorder(null);
                actionTool = ToolVariable.DEFAULT;
            }
        }
    }//GEN-LAST:event_actRoundRectMousePressed

    private void actCircleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actCircleMousePressed
        if (actCircle.isEnabled()) {
            if (actCircle.getBorder() == null) {
                actionTool = ToolVariable.DRAW_CIRCLE;
                setActionBorder(actCircle);
                setCursor();
            } else {
                mainFrame.pnImage.setCursor("");
                setActionBorder(null);
                actionTool = ToolVariable.DEFAULT;
            }
        }
    }//GEN-LAST:event_actCircleMousePressed

    private void setActionBorder(JLabel labelSelect) {
        actSelect.setBorder(null);
        actPen.setBorder(null);
        actFill.setBorder(null);
        actText.setBorder(null);
        actErase.setBorder(null);
        actPicker.setBorder(null);
        actCrop.setBorder(null);
        actGradient.setBorder(null);
        actLine.setBorder(null);
        actRect.setBorder(null);
        if (labelSelect != null) {
            labelSelect.setBorder(new LineBorder(Color.BLACK));
        }
    }

    private void setCursor() {
        String penPath = "";
        switch (actionTool) {
            case SELECT_TOOL:
                penPath = "/Images/SizeCursor.png";
                break;
            case DRAW_TOOL:
                penPath = "/Images/Pencil.png";
                break;
            case TEXT_TOOL:
                penPath = "/Images/TextCursor.png";
                break;
            case FILL_TOOL:
                penPath = "/Images/FillCursor.png";
                break;
            case ERASE_TOOL:
                penPath = "/Images/EraseCursor.png";
                break;
            case PICKER_TOOL:
                penPath = "/Images/PickerCursor.png";
                break;
            case CROP_TOOL:
                penPath = "/Images/Crop.png";
                break;
            case GRADIENT_TOOL:
                penPath = "/Images/SizeCursor.png";
                break;
            default:
                break;
        }
        mainFrame.pnImage.setCursor(penPath);
    }

    private void setSizeBorder(JLabel labelSelect) {
        actSmall.setBorder(null);
        actMedium.setBorder(null);
        actBig.setBorder(null);
        actLarger.setBorder(null);
        if (labelSelect != null) {
            labelSelect.setBorder(new LineBorder(Color.BLACK));
        }
    }

    private void setColorBorder(JLabel labelSelect) {
        actSingle.setBorder(null);
        actGradientColor.setBorder(null);
        actTexture.setBorder(null);
        if (labelSelect != null) {
            labelSelect.setBorder(new LineBorder(Color.BLACK));
        }
    }

    public void setStatus(boolean isLoad) {
        actPen.setEnabled(isLoad);
        actSelect.setEnabled(isLoad);
        actFill.setEnabled(isLoad);
        actText.setEnabled(isLoad);
        actErase.setEnabled(isLoad);
        actPicker.setEnabled(isLoad);
        actSmall.setEnabled(isLoad);
        actMedium.setEnabled(isLoad);
        actBig.setEnabled(isLoad);
        actLarger.setEnabled(isLoad);
        color1.setEnabled(isLoad);
        color2.setEnabled(isLoad);
        color3.setEnabled(isLoad);
        color4.setEnabled(isLoad);
        color5.setEnabled(isLoad);
        color6.setEnabled(isLoad);
        color7.setEnabled(isLoad);
        color8.setEnabled(isLoad);
        color12.setEnabled(isLoad);
        color13.setEnabled(isLoad);
        color14.setEnabled(isLoad);
        color15.setEnabled(isLoad);
        color16.setEnabled(isLoad);
        color17.setEnabled(isLoad);
        color18.setEnabled(isLoad);
        color19.setEnabled(isLoad);
        actColorOne.setEnabled(isLoad);
        actColorTwo.setEnabled(isLoad);
        colorChoose.setEnabled(isLoad);
        actCrop.setEnabled(isLoad);
        actGradient.setEnabled(isLoad);
        actLine.setEnabled(isLoad);
        actRect.setEnabled(isLoad);
        actRoundRect.setEnabled(isLoad);
        actCircle.setEnabled(isLoad);
        actTriangle.setEnabled(isLoad);
        actSingle.setEnabled(isLoad);
        actGradientColor.setEnabled(isLoad);
        actTexture.setEnabled(isLoad);
        if (isLoad) {
            setSizeBorder(actSmall);
            setColorBorder(actSingle);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel actBig;
    private javax.swing.JLabel actCircle;
    private javax.swing.JLabel actColorOne;
    private javax.swing.JLabel actColorTwo;
    private javax.swing.JLabel actCrop;
    private javax.swing.JLabel actErase;
    private javax.swing.JLabel actFill;
    private javax.swing.JLabel actGradient;
    private javax.swing.JLabel actGradientColor;
    private javax.swing.JLabel actLarger;
    private javax.swing.JLabel actLine;
    private javax.swing.JLabel actMedium;
    private javax.swing.JLabel actPen;
    private javax.swing.JLabel actPicker;
    private javax.swing.JLabel actRect;
    private javax.swing.JLabel actRoundRect;
    private javax.swing.JLabel actSelect;
    private javax.swing.JLabel actSingle;
    private javax.swing.JLabel actSmall;
    private javax.swing.JLabel actText;
    private javax.swing.JLabel actTexture;
    private javax.swing.JLabel actTriangle;
    private javax.swing.JLabel color1;
    private javax.swing.JLabel color12;
    private javax.swing.JLabel color13;
    private javax.swing.JLabel color14;
    private javax.swing.JLabel color15;
    private javax.swing.JLabel color16;
    private javax.swing.JLabel color17;
    private javax.swing.JLabel color18;
    private javax.swing.JLabel color19;
    private javax.swing.JLabel color2;
    private javax.swing.JLabel color3;
    private javax.swing.JLabel color4;
    private javax.swing.JLabel color5;
    private javax.swing.JLabel color6;
    private javax.swing.JLabel color7;
    private javax.swing.JLabel color8;
    private javax.swing.JLabel colorChoose;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    public javax.swing.JPanel pnColorOne;
    public javax.swing.JPanel pnColorTwo;
    private javax.swing.JPanel pnTool;
    // End of variables declaration//GEN-END:variables

}
