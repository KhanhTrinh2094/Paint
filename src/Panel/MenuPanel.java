package Panel;

import Component.NativeUtils;
import Dialog.BorderDialog;
import Dialog.CameraDialog;
import Dialog.NewDialog;
import Dialog.OpacityDialog;
import Dialog.ResizeDialog;
import Frame.MainFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MenuPanel extends JMenuBar {

    private MainFrame mainFrame;
    private boolean load;
    private float scaleValue = 1.0f;

    public MenuPanel() {
        initComponents();
    }

    public MenuPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
    }

    public boolean isLoad() {
        return load;
    }

    public void setLoad(boolean load) {
        this.load = load;
        this.setStatus(load);
        mainFrame.pnTool.setStatus(load);
    }

    private void initComponents() {
        mnFile = new javax.swing.JMenu();
        mnEdit = new javax.swing.JMenu();
        mnUndo = new javax.swing.JMenuItem();
        mnRedo = new javax.swing.JMenuItem();
        mnNew = new javax.swing.JMenuItem();
        mnOpen = new javax.swing.JMenuItem();
        mnCamera = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        mnSave = new javax.swing.JMenuItem();
        mnSaveAs = new javax.swing.JMenu();
        mnPNG = new javax.swing.JMenuItem();
        mnJPEG = new javax.swing.JMenuItem();
        mnBMP = new javax.swing.JMenuItem();
        mnGIF = new javax.swing.JMenuItem();
        mnOther = new javax.swing.JMenuItem();
        mnPrint = new javax.swing.JMenuItem();
        mnSetBackround = new javax.swing.JMenuItem();
        mnProperties = new javax.swing.JMenuItem();
        mnAbout = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnExit = new javax.swing.JMenuItem();
        mnView = new javax.swing.JMenu();
        mnZoomIn = new javax.swing.JMenuItem();
        mnZoomOut = new javax.swing.JMenuItem();
        mnFullPreview = new javax.swing.JMenuItem();
        mnDefault = new javax.swing.JMenuItem();
        mnOpacity = new javax.swing.JMenuItem();
        mnRotate = new javax.swing.JMenu();
        mnRotateRight = new javax.swing.JMenuItem();
        mnRotateLeft = new javax.swing.JMenuItem();
        mnRotate180 = new javax.swing.JMenuItem();
        mnFlipHori = new javax.swing.JMenuItem();
        mnFlipVerti = new javax.swing.JMenuItem();
        mnResize = new javax.swing.JMenuItem();
        mnBorder = new javax.swing.JMenuItem();

        mnFile.setText("   Action   ");

        mnNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        mnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Create.png"))); // NOI18N
        mnNew.setText("New");
        mnNew.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnNewActionPerformed(evt);
            }
        });
        mnFile.add(mnNew);

        mnOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        mnOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Folder.png"))); // NOI18N
        mnOpen.setText("Open");
        mnOpen.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnOpenActionPerformed(evt);
            }
        });
        mnFile.add(mnOpen);

        mnCamera.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        mnCamera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Camera.png"))); // NOI18N
        mnCamera.setText("Camera");
        mnCamera.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCameraActionPerformed(evt);
            }
        });
        mnFile.add(mnCamera);
        mnFile.add(jSeparator5);

        mnSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        mnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Save.png"))); // NOI18N
        mnSave.setText("Save");
        mnSave.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSaveActionPerformed(evt);
            }
        });
        mnFile.add(mnSave);

        mnSaveAs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SaveAs.png"))); // NOI18N
        mnSaveAs.setText("Save As");

        mnPNG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PNG.png"))); // NOI18N
        mnPNG.setText("PNG Picture");
        mnPNG.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnPNGActionPerformed(evt);
            }
        });
        mnSaveAs.add(mnPNG);

        mnJPEG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/JPEG.png"))); // NOI18N
        mnJPEG.setText("JPEG Picture");
        mnJPEG.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnJPEGActionPerformed(evt);
            }
        });
        mnSaveAs.add(mnJPEG);

        mnBMP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BMP.png"))); // NOI18N
        mnBMP.setText("BMP Picture");
        mnBMP.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnBMPActionPerformed(evt);
            }
        });
        mnSaveAs.add(mnBMP);

        mnGIF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/GIF.png"))); // NOI18N
        mnGIF.setText("GIF Picture");
        mnGIF.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGIFActionPerformed(evt);
            }
        });
        mnSaveAs.add(mnGIF);

        mnOther.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Other.png"))); // NOI18N
        mnOther.setText("Other Format");
        mnOther.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnOtherActionPerformed(evt);
            }
        });
        mnSaveAs.add(mnOther);

        mnFile.add(mnSaveAs);

        mnPrint.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        mnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Print.png"))); // NOI18N
        mnPrint.setText("Print");
        mnPrint.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnPrintActionPerformed(evt);
            }
        });
        mnFile.add(mnPrint);

        mnSetBackround.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        mnSetBackround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Desktop.png"))); // NOI18N
        mnSetBackround.setText("Set As Desktop Backround");
        mnFile.add(mnSetBackround);

        mnProperties.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        mnProperties.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Yes.png"))); // NOI18N
        mnProperties.setText("Properties");
        mnProperties.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnPropertiesActionPerformed(evt);
            }
        });
        mnFile.add(mnProperties);

        mnAbout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        mnAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/About.png"))); // NOI18N
        mnAbout.setText("About Paint");
        mnAbout.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnAboutActionPerformed(evt);
            }
        });
        mnFile.add(mnAbout);
        mnFile.add(jSeparator6);

        mnExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        mnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Exit.png"))); // NOI18N
        mnExit.setText("Exit");
        mnFile.add(mnExit);

        this.add(mnFile);

        mnView.setText("   View   ");

        mnZoomIn.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ADD, java.awt.event.InputEvent.CTRL_MASK));
        mnZoomIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ZoomIn.png"))); // NOI18N
        mnZoomIn.setText("Zoom In");
        mnZoomIn.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnZoomInActionPerformed(evt);
            }
        });
        mnView.add(mnZoomIn);

        mnZoomOut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_SUBTRACT, java.awt.event.InputEvent.CTRL_MASK));
        mnZoomOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ZoomOut.png"))); // NOI18N
        mnZoomOut.setText("Zoom Out");
        mnZoomOut.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnZoomOutActionPerformed(evt);
            }
        });
        mnView.add(mnZoomOut);

        mnFullPreview.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Preview.png"))); // NOI18N
        mnFullPreview.setText("Full Preview");
        mnFullPreview.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnFullPreviewActionPerformed(evt);
            }
        });
        mnView.add(mnFullPreview);

        mnDefault.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Reset.png"))); // NOI18N
        mnDefault.setText("Default Size");
        mnDefault.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnDefaultActionPerformed(evt);
            }
        });
        mnView.add(mnDefault);
        this.add(mnView);

        mnEdit.setText("   Edit   ");
        mnUndo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        mnUndo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Undo.png")));
        mnUndo.setText("Undo");
        mnUndo.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnUndoActionPerformed(evt);
            }
        });
        mnEdit.add(mnUndo);

        mnRedo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        mnRedo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Redo.png")));
        mnRedo.setText("Redo");
        mnRedo.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnRedoActionPerformed(evt);
            }
        });
        mnEdit.add(mnRedo);
        mnEdit.add(jSeparator1);

        mnOpacity.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Opacity.png")));
        mnOpacity.setText("Change Opacity");
        mnOpacity.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnOpacityActionPerformed(evt);
            }
        });
        mnEdit.add(mnOpacity);

        mnRotate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Rotate.png")));
        mnRotate.setText("Rotate");

        mnRotateRight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Rotate.png")));
        mnRotateRight.setText("   Rotate Right 90°");
        mnRotateRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mnRotateActionPerformed(e, "right45");
            }

        });
        mnRotate.add(mnRotateRight);

        mnRotateLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/RotateLeft.png")));
        mnRotateLeft.setText("   Rotate Left 90°");
        mnRotateLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mnRotateActionPerformed(e, "left45");
            }
        });
        mnRotate.add(mnRotateLeft);

        mnRotate180.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Rotate180.png")));
        mnRotate180.setText("   Rotate 180°");
        mnRotate180.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mnRotateActionPerformed(e, "180");
            }
        });
        mnRotate.add(mnRotate180);

        mnFlipVerti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/FlipVertical.png")));
        mnFlipVerti.setText("   Flip Vertical");
        mnFlipVerti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mnFlipActionPerformed(e, false);
            }
        });
        mnRotate.add(mnFlipVerti);

        mnFlipHori.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/FlipHorizontal.png")));
        mnFlipHori.setText("   Flip Horizontal");
        mnFlipHori.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mnFlipActionPerformed(e, true);
            }
        });
        mnRotate.add(mnFlipHori);
        mnEdit.add(mnRotate);

        mnResize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Resize.png")));
        mnResize.setText("Resize Image");
        mnResize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mnResizeActionPerformed(e);
            }
        });
        mnEdit.add(mnResize);

        mnBorder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Border.png")));
        mnBorder.setText("Border Frame");
        mnBorder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mnBorderActionPerformed(e);
            }
        });
        mnEdit.add(mnBorder);

        this.add(mnEdit);
    }

    private void mnOpenActionPerformed(java.awt.event.ActionEvent evt) {
        if (mainFrame.pnImage.playImage == null) {
            actionOpen();
        } else {
            int result;
            if (!mainFrame.pnImage.getFilePath().equals("")) {
                result = JOptionPane.showConfirmDialog(null, "Do you want to save changes to " + mainFrame.pnImage.getFileName() + " ?", "Paint", JOptionPane.YES_NO_CANCEL_OPTION);
            } else {
                result = JOptionPane.showConfirmDialog(null, "Do you want to save changes to Untitled ?", "Paint", JOptionPane.YES_NO_CANCEL_OPTION);
            }

            if (result == JOptionPane.OK_OPTION) {
                mnSaveActionPerformed(evt);
                actionOpen();
            } else if (result == JOptionPane.NO_OPTION) {
                actionOpen();
            }
        }
    }

    private void actionOpen() {
        JFileChooser ch = new JFileChooser();
        ch.setDialogTitle("Choose Image");
        FileFilter ff = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
        ch.setFileFilter(ff);
        int result = ch.showOpenDialog(mainFrame);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                mainFrame.pnImage.setFilePath(ch.getSelectedFile().getPath());
                mainFrame.pnImage.setFileName(ch.getSelectedFile().getName());
                BufferedImage bi = ImageIO.read(ch.getSelectedFile());
                mainFrame.pnImage.setImageWidth(bi.getWidth());
                mainFrame.pnImage.setImageHeight(bi.getHeight());
                mainFrame.pnImage.setImage(bi);
                setLoad(true);
                mainFrame.pnMsg.displayName(mainFrame.pnImage.getFileName());
                mainFrame.pnMsg.displaySize(readByteCount(ch.getSelectedFile().length()));
                mainFrame.pnMsg.displayResolution(mainFrame.pnImage.getImageWidth() + " x " + mainFrame.pnImage.getImageHeight());
            } catch (IOException e) {
                mainFrame.showError(e);
            }
        }
    }

    private void mnNewActionPerformed(java.awt.event.ActionEvent evt) {
        if (mainFrame.pnImage.playImage == null) {
            actionNew();
        } else {
            int result;
            if (!mainFrame.pnImage.getFilePath().equals("")) {
                result = JOptionPane.showConfirmDialog(null, "Do you want to save changes to " + mainFrame.pnImage.getFileName() + " ?", "Paint", JOptionPane.YES_NO_CANCEL_OPTION);
            } else {
                result = JOptionPane.showConfirmDialog(null, "Do you want to save changes to Untitled ?", "Paint", JOptionPane.YES_NO_CANCEL_OPTION);
            }

            if (result == JOptionPane.OK_OPTION) {
                mnSaveActionPerformed(evt);
                actionNew();
            } else if (result == JOptionPane.NO_OPTION) {
                actionNew();
            }
        }
    }

    private void actionNew() {
        NewDialog newDialog = new NewDialog(mainFrame, true, mainFrame.getPnWidth(), mainFrame.getPnHeight());
        newDialog.setLocationRelativeTo(mainFrame);
        newDialog.setVisible(true);
        if (newDialog.isSubmit) {
            BufferedImage newImage = new BufferedImage(mainFrame.pnImage.getImageWidth(), mainFrame.pnImage.getImageHeight(), BufferedImage.TYPE_INT_ARGB);
            if (mainFrame.pnImage.isImageTransparent()) {
                mainFrame.pnTool.setColor(new Color(1.0f, 1.0f, 1.0f, 0.5f));
            } else {
                mainFrame.pnTool.setColor(Color.WHITE);
            }
            mainFrame.pnImage.clear(newImage);
            mainFrame.pnImage.setImage(newImage);
            setLoad(true);
            mainFrame.pnImage.setFilePath("");
            mainFrame.pnImage.setFileName("");

            mainFrame.pnMsg.displayName("");
            mainFrame.pnMsg.displaySize("");
            mainFrame.pnMsg.displayResolution(mainFrame.pnImage.getImageWidth() + " x " + mainFrame.pnImage.getImageHeight());

            mainFrame.pnTool.setColor(Color.RED);
        }
    }

    private void mnSaveActionPerformed(java.awt.event.ActionEvent evt) {
        if ("".equals(mainFrame.pnImage.getFilePath())) {
            JFileChooser ch = new JFileChooser();
            int result = ch.showSaveDialog(this);
            ch.setDialogTitle("Save File");
            if (result == JFileChooser.APPROVE_OPTION) {
                try {
                    String fileNameLocal = ch.getSelectedFile().toString();
                    if (!fileNameLocal.endsWith(".png") && !fileNameLocal.endsWith(".jpg") && !fileNameLocal.endsWith(".gif") && !fileNameLocal.endsWith(".jpeg")) {
                        fileNameLocal += ".png";
                    }
                    ImageIO.write(mainFrame.pnImage.playImage, "png", new File(fileNameLocal));
                    mainFrame.pnImage.setFilePath(fileNameLocal);
                    mainFrame.pnImage.setFileName(ch.getSelectedFile().getName());
                    mainFrame.pnMsg.displayName(mainFrame.pnImage.getFileName());
                    mainFrame.pnMsg.displaySize(readByteCount(ch.getSelectedFile().length()));

                    mainFrame.pnMsg.displayMessage("Save Successful !!!");
                } catch (IOException ex) {
                    mainFrame.showError(ex);
                }
            }
        } else {
            try {
                ImageIO.write(mainFrame.pnImage.playImage, "png", new File(mainFrame.pnImage.getFilePath()));
                mainFrame.pnMsg.displayMessage("Save Successful !!!");
            } catch (IOException ex) {
                mainFrame.showError(ex);
            }
        }
        mainFrame.pnMsg.displayResolution(mainFrame.pnImage.getImageWidth() + " x " + mainFrame.pnImage.getImageHeight());
    }

    private void mnPrintActionPerformed(java.awt.event.ActionEvent evt) {
        PrinterJob printJob = PrinterJob.getPrinterJob();
        printJob.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if (pageIndex != 0) {
                    return NO_SUCH_PAGE;
                }
                graphics.drawImage(mainFrame.pnImage.playImage, 0, 0, mainFrame.pnImage.getImageWidth(), mainFrame.pnImage.getImageHeight(), null);
                return PAGE_EXISTS;
            }
        });
        try {
            printJob.print();
        } catch (PrinterException e1) {
        }
    }

    private void mnPropertiesActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void mnPNGActionPerformed(java.awt.event.ActionEvent evt) {
        saveFileExtension("png");
    }

    private void mnJPEGActionPerformed(java.awt.event.ActionEvent evt) {
        saveFileExtension("jpg");
    }

    private void mnBMPActionPerformed(java.awt.event.ActionEvent evt) {
        saveFileExtension("bmp");
    }

    private void mnGIFActionPerformed(java.awt.event.ActionEvent evt) {
        saveFileExtension("gif");
    }

    private void mnOtherActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser ch = new JFileChooser();
        int result = ch.showSaveDialog(mainFrame);
        ch.setDialogTitle("Save File");
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                String fileNameLocal = ch.getSelectedFile().toString();
                if (!fileNameLocal.endsWith(".png") && !fileNameLocal.endsWith(".jpg") && !fileNameLocal.endsWith(".gif") && !fileNameLocal.endsWith(".jpeg")) {
                    fileNameLocal += ".png";
                }
                ImageIO.write(mainFrame.pnImage.playImage, "png", new File(fileNameLocal));
                mainFrame.pnImage.setFilePath(fileNameLocal);
                mainFrame.pnImage.setFileName(ch.getSelectedFile().getName());
                mainFrame.pnMsg.displayMessage("Save Successful !!!");
            } catch (IOException ex) {
                mainFrame.showError(ex);
            }
        }
    }

    private void saveFileExtension(String extension) {
        JFileChooser ch = new JFileChooser();
        int result = ch.showSaveDialog(mainFrame);
        ch.setDialogTitle("Save File");
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                String fileNameLocal = ch.getSelectedFile().toString();
                if (!fileNameLocal.endsWith("." + extension)) {
                    fileNameLocal += "." + extension;
                }
                ImageIO.write(mainFrame.pnImage.playImage, extension, new File(fileNameLocal));
                mainFrame.pnImage.setFilePath(fileNameLocal);
                mainFrame.pnImage.setFileName(ch.getSelectedFile().getName());
                mainFrame.pnMsg.displayMessage("Save Successful !!!");
            } catch (IOException ex) {
                mainFrame.showError(ex);
            }
        }
    }

    private void mnAboutActionPerformed(java.awt.event.ActionEvent evt) {

    }

    BufferedImage a, b;

    private void mnZoomInActionPerformed(java.awt.event.ActionEvent evt) {
        scaleValue += 0.1f;
        int w = mainFrame.pnImage.getImageWidth();
        int h = mainFrame.pnImage.getImageHeight();
        int imageWidth = mainFrame.pnImage.getImageWidth();
        int imageHeight = mainFrame.pnImage.getImageHeight();
        double x = (w - scaleValue * imageWidth) / 2;
        double y = (h - scaleValue * imageHeight) / 2;
        a = new BufferedImage(mainFrame.pnImage.getImageWidth(), mainFrame.pnImage.getImageHeight(), BufferedImage.TYPE_INT_ARGB);
        a.setData(b.getData());
        AffineTransform at = AffineTransform.getTranslateInstance(0, 0);
        at.scale(scaleValue, scaleValue);
        Graphics2D g2d = (Graphics2D) a.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2d.drawRenderedImage(b, at);
//        mainFrame.pnImage.playImage.setData(a.getData());
        mainFrame.pnImage.lbImage.setIcon(new ImageIcon(a));
    }

    private void mnZoomOutActionPerformed(java.awt.event.ActionEvent evt) {
        scaleValue -= 0.1f;
        int w = mainFrame.pnImage.getImageWidth();
        int h = mainFrame.pnImage.getImageHeight();
        int imageWidth = mainFrame.pnImage.getImageWidth();
        int imageHeight = mainFrame.pnImage.getImageHeight();
        double x = (w - scaleValue * imageWidth) / 2;
        double y = (h - scaleValue * imageHeight) / 2;
        a = new BufferedImage(mainFrame.pnImage.getImageWidth(), mainFrame.pnImage.getImageHeight(), BufferedImage.TYPE_INT_ARGB);
        a.setData(b.getData());
        AffineTransform at = AffineTransform.getTranslateInstance(x, y);
        at.scale(scaleValue, scaleValue);
        Graphics2D g2d = (Graphics2D) a.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2d.drawRenderedImage(b, at);
//        mainFrame.pnImage.playImage.setData(a.getData());
        mainFrame.pnImage.lbImage.setIcon(new ImageIcon(a));
    }

    private void mnFullPreviewActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void mnDefaultActionPerformed(java.awt.event.ActionEvent evt) {

        b = new BufferedImage(mainFrame.pnImage.getImageWidth(), mainFrame.pnImage.getImageHeight(), BufferedImage.TYPE_INT_ARGB);
        b.setData(mainFrame.pnImage.playImage.getData());
    }

    private void mnCameraActionPerformed(java.awt.event.ActionEvent evt) {
        if (mainFrame.pnImage.playImage == null) {
            actionCamera();
        } else {
            int result;
            if (!"".equals(mainFrame.pnImage.getFilePath())) {
                result = JOptionPane.showConfirmDialog(null, "Do you want to save changes to " + mainFrame.pnImage.getFileName() + " ?", "Paint", JOptionPane.YES_NO_CANCEL_OPTION);
            } else {
                result = JOptionPane.showConfirmDialog(null, "Do you want to save changes to Untitled ?", "Paint", JOptionPane.YES_NO_CANCEL_OPTION);
            }

            if (result == JOptionPane.OK_OPTION) {
                mnSaveActionPerformed(evt);
                actionCamera();
            } else if (result == JOptionPane.NO_OPTION) {
                actionCamera();
            }
        }
    }

    private void mnUndoActionPerformed(java.awt.event.ActionEvent evt) {
        if (mainFrame.pnImage.canUndo()) {
            mainFrame.pnImage.imageUndo();
            mnRedo.setEnabled(true);
        }
    }

    private void mnRedoActionPerformed(java.awt.event.ActionEvent evt) {
        if (mainFrame.pnImage.canRedo()) {
            mainFrame.pnImage.imageRedo();
        }
    }

    private void actionCamera() {
        try {
            NativeUtils.loadLibraryFromJar("/Library/opencv_java249.dll");
        } catch (IOException ex) {
        }
        CameraDialog camDialog = new CameraDialog(mainFrame, true);
        camDialog.setLocationRelativeTo(mainFrame);
        camDialog.setVisible(true);
        if (camDialog.isVisible() == false && camDialog.isCapture == true) {
            mainFrame.pnImage.setFilePath("");
            mainFrame.pnImage.setFileName("");
            BufferedImage bi = null;

            try {
                bi = ImageIO.read(new File(camDialog.path));
                mainFrame.pnImage.setImageWidth(bi.getWidth());
                mainFrame.pnImage.setImageHeight(bi.getHeight());
                mainFrame.pnImage.setImage(bi);
            } catch (IOException ex) {
            }

            setLoad(true);

            mainFrame.pnMsg.displayName("");
            mainFrame.pnMsg.displaySize("");
            mainFrame.pnMsg.displayResolution(mainFrame.pnImage.getImageWidth() + " x " + mainFrame.pnImage.getImageHeight());
        }
    }

    private void mnOpacityActionPerformed(ActionEvent evt) {
        mainFrame.pnImage.tempImage.setData(mainFrame.pnImage.playImage.getData());
        OpacityDialog opacity = new OpacityDialog(mainFrame, true, mainFrame);
        opacity.setLocationRelativeTo(mainFrame);
        opacity.setVisible(true);
    }

    private void mnRotateActionPerformed(ActionEvent e, String type) {
        switch (type) {
            case "right45":
                mainFrame.pnImage.rotateImage(0);
                break;
            case "left45":
                mainFrame.pnImage.rotateImage(1);
                break;
            case "180":
                mainFrame.pnImage.rotateImage(2);
                break;
            default:
                break;
        }
    }

    private void mnFlipActionPerformed(ActionEvent e, boolean b) {
        mainFrame.pnImage.flipImage(b);
    }

    private void mnResizeActionPerformed(ActionEvent e) {
        ResizeDialog resize = new ResizeDialog(mainFrame, true, mainFrame.pnImage.getImageWidth(), mainFrame.pnImage.getImageHeight());
        resize.setLocationRelativeTo(mainFrame);
        resize.setVisible(true);
        if (resize.isVisible() == false && resize.width != 0 && resize.height != 0) {
            mainFrame.pnImage.resizeImage(resize.width, resize.height);
        }
    }

    private void mnBorderActionPerformed(ActionEvent e) {
        BorderDialog dialog = new BorderDialog(mainFrame, true);
        dialog.setLocationRelativeTo(mainFrame);
        dialog.setVisible(true);
        if(dialog.isVisible() == false && !dialog.selectedFileName.equals("0")){
            mainFrame.pnImage.setBorder(dialog.selectedFileName);
        }
    }

    private void setStatus(boolean isLoad) {
        mnSave.setEnabled(isLoad);
        mnSaveAs.setEnabled(isLoad);
        mnSetBackround.setEnabled(isLoad);
        mnPrint.setEnabled(isLoad);
        mnProperties.setEnabled(isLoad);
        mnZoomIn.setEnabled(isLoad);
        mnZoomOut.setEnabled(isLoad);
        mnFullPreview.setEnabled(isLoad);
        mnDefault.setEnabled(isLoad);
        mnOpacity.setEnabled(isLoad);
        mnRotate.setEnabled(isLoad);
        mnRotateRight.setEnabled(isLoad);
        mnRotateLeft.setEnabled(isLoad);
        mnRotate180.setEnabled(isLoad);
        mnRedo.setEnabled(false);
        mnUndo.setEnabled(false);
        mnResize.setEnabled(isLoad);
        mnBorder.setEnabled(isLoad);
    }

    private String readByteCount(long bytes) {
        int unit = 1024;
        if (bytes < unit) {
            return bytes + " B";
        }
        int exp = (int) (Math.log(bytes) / Math.log(unit));
        String pre = ("KMGTPE").charAt(exp - 1) + ("");
        return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
    }

    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator1;

    private javax.swing.JMenuItem mnAbout;
    private javax.swing.JMenuItem mnBMP;
    private javax.swing.JMenuItem mnCamera;
    private javax.swing.JMenuItem mnDefault;
    private javax.swing.JMenuItem mnExit;
    private javax.swing.JMenu mnFile;
    private javax.swing.JMenu mnEdit;
    public javax.swing.JMenuItem mnUndo;
    public javax.swing.JMenuItem mnRedo;
    public javax.swing.JMenuItem mnOpacity;
    private javax.swing.JMenuItem mnFullPreview;
    private javax.swing.JMenuItem mnGIF;
    private javax.swing.JMenuItem mnJPEG;
    private javax.swing.JMenuItem mnNew;
    private javax.swing.JMenuItem mnOpen;
    private javax.swing.JMenuItem mnOther;
    private javax.swing.JMenuItem mnPNG;
    private javax.swing.JMenuItem mnPrint;
    private javax.swing.JMenuItem mnProperties;
    private javax.swing.JMenuItem mnSave;
    private javax.swing.JMenu mnSaveAs;
    private javax.swing.JMenuItem mnSetBackround;
    private javax.swing.JMenu mnView;
    private javax.swing.JMenuItem mnZoomIn;
    private javax.swing.JMenuItem mnZoomOut;
    private javax.swing.JMenu mnRotate;
    private javax.swing.JMenuItem mnRotateRight;
    private javax.swing.JMenuItem mnRotateLeft;
    private javax.swing.JMenuItem mnRotate180;
    private javax.swing.JMenuItem mnFlipHori;
    private javax.swing.JMenuItem mnFlipVerti;
    private javax.swing.JMenuItem mnResize;
    private javax.swing.JMenuItem mnBorder;
}
