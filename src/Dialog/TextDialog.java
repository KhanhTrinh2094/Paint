package Dialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GraphicsEnvironment;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.font.TextAttribute;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class TextDialog extends javax.swing.JDialog {

    public String strFont, strText;
    public int size;
    public boolean isBold, isItalic, isUnderline, isStrike, isSubmit;
    private Border lbBorder = new LineBorder(Color.BLACK);
    public int textWidth = 0, textHeight = 0;
    private DefaultComboBoxModel modelFont = new DefaultComboBoxModel();
    private DefaultComboBoxModel modelSize = new DefaultComboBoxModel();

    public TextDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        String font[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (String item : font) {
            modelFont.addElement(item);
        }
        cbFont.setModel(modelFont);
        cbFont.setSelectedItem("Cambria");
        strFont = "Cambria";
        for (int i = 1; i <= 72; i++) {
            modelSize.addElement(i);
        }
        cbSize.setModel(modelSize);
        cbSize.setSelectedItem(14);
        size = 14;
        txtText.setFont(new Font(strFont, 0, size));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtText = new javax.swing.JTextField();
        actBold = new javax.swing.JLabel();
        actItalic = new javax.swing.JLabel();
        actUnderLine = new javax.swing.JLabel();
        actStrike = new javax.swing.JLabel();
        cbFont = new javax.swing.JComboBox();
        cbSize = new javax.swing.JComboBox();
        btnEnter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Your Text");
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Add Your Text"));
        jPanel2.setLayout(null);

        jLabel1.setText("Text : ");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(40, 60, 38, 16);

        txtText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTextKeyPressed(evt);
            }
        });
        jPanel2.add(txtText);
        txtText.setBounds(90, 60, 200, 22);

        actBold.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Bold.png"))); // NOI18N
        actBold.setToolTipText("Bold");
        actBold.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                actBoldMousePressed(evt);
            }
        });
        jPanel2.add(actBold);
        actBold.setBounds(120, 30, 20, 20);

        actItalic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Italic.png"))); // NOI18N
        actItalic.setToolTipText("Italic");
        actItalic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                actItalicMousePressed(evt);
            }
        });
        jPanel2.add(actItalic);
        actItalic.setBounds(150, 30, 20, 20);

        actUnderLine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Underline.png"))); // NOI18N
        actUnderLine.setToolTipText("Underline");
        actUnderLine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                actUnderLineMousePressed(evt);
            }
        });
        jPanel2.add(actUnderLine);
        actUnderLine.setBounds(180, 30, 20, 20);

        actStrike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Strikethrough.png"))); // NOI18N
        actStrike.setToolTipText("Strike Through");
        actStrike.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                actStrikeMousePressed(evt);
            }
        });
        jPanel2.add(actStrike);
        actStrike.setBounds(210, 30, 20, 20);

        cbFont.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbFontItemStateChanged(evt);
            }
        });
        jPanel2.add(cbFont);
        cbFont.setBounds(30, 90, 200, 22);

        cbSize.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbSizeItemStateChanged(evt);
            }
        });
        jPanel2.add(cbSize);
        cbSize.setBounds(250, 90, 50, 22);

        btnEnter.setText("Enter");
        btnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterActionPerformed(evt);
            }
        });
        jPanel2.add(btnEnter);
        btnEnter.setBounds(120, 120, 110, 25);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTextKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnEnterActionPerformed(null);
        }
    }//GEN-LAST:event_txtTextKeyPressed

    private void cbFontItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbFontItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            strFont = cbFont.getSelectedItem().toString();
            evtChange();
        }
    }//GEN-LAST:event_cbFontItemStateChanged

    private void cbSizeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSizeItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            size = Integer.parseInt(cbSize.getSelectedItem().toString());
            evtChange();
        }
    }//GEN-LAST:event_cbSizeItemStateChanged

    private void actBoldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actBoldMousePressed
        if (isBold == false) {
            isBold = true;
            actBold.setBorder(lbBorder);
            evtChange();
        } else {
            actBold.setBorder(null);
            isBold = false;
            evtChange();

        }
    }//GEN-LAST:event_actBoldMousePressed

    private void actItalicMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actItalicMousePressed
        if (isItalic == false) {
            isItalic = true;
            actItalic.setBorder(lbBorder);
            evtChange();
        } else {
            actItalic.setBorder(null);
            isItalic = false;
            evtChange();
        }
    }//GEN-LAST:event_actItalicMousePressed

    private void actUnderLineMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actUnderLineMousePressed
        if (isUnderline == false) {
            isUnderline = true;
            actUnderLine.setBorder(lbBorder);
            evtChange();
        } else {
            actUnderLine.setBorder(null);
            isUnderline = false;
            evtChange();
        }
    }//GEN-LAST:event_actUnderLineMousePressed

    private void actStrikeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actStrikeMousePressed
        if (isStrike == false) {
            isStrike = true;
            actStrike.setBorder(lbBorder);
            evtChange();
        } else {
            actStrike.setBorder(null);
            isStrike = false;
            evtChange();
        }
    }//GEN-LAST:event_actStrikeMousePressed

    private void btnEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterActionPerformed
        if (!txtText.getText().trim().isEmpty()) {
            strText = txtText.getText();
            FontMetrics fontMetrics = getFontMetrics(txtText.getFont());
            textWidth = fontMetrics.stringWidth(strText);
            textHeight = fontMetrics.getHeight();
            isSubmit = true;
            this.dispose();
        }
    }//GEN-LAST:event_btnEnterActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnEnterActionPerformed(null);
        }
    }//GEN-LAST:event_formKeyPressed

    private void evtChange() {
        int style = 0;
        style = (isBold) ? style | Font.BOLD : style;
        style = (isItalic) ? style | Font.ITALIC : style;
        txtText.setFont(new Font(strFont, style, size));

        Font font = txtText.getFont();
        Map attributes = font.getAttributes();
        if (isStrike) {
            attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
            txtText.setFont(font.deriveFont(attributes));
        }

        if (isUnderline) {
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            txtText.setFont(font.deriveFont(attributes));
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel actBold;
    private javax.swing.JLabel actItalic;
    private javax.swing.JLabel actStrike;
    private javax.swing.JLabel actUnderLine;
    private javax.swing.JButton btnEnter;
    private javax.swing.JComboBox cbFont;
    private javax.swing.JComboBox cbSize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JTextField txtText;
    // End of variables declaration//GEN-END:variables
}
