package Dialog;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JColorChooser;

public class GradientDialog extends javax.swing.JDialog {

    public Color from = Color.RED, to = Color.BLUE;
    public int Orizon = 0, Vector = 0;
    public boolean isSubmit = false;

    public GradientDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnEnterActionPerformed(null);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbTo = new javax.swing.JLabel();
        lbFrom = new javax.swing.JLabel();
        cbOrizon = new javax.swing.JComboBox();
        cbLeft = new javax.swing.JComboBox();
        btnEnter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Setings Gradient");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Config Gradient"));

        lbTo.setBackground(java.awt.Color.blue);
        lbTo.setForeground(new java.awt.Color(255, 255, 255));
        lbTo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTo.setText("TO");
        lbTo.setOpaque(true);
        lbTo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbToMousePressed(evt);
            }
        });

        lbFrom.setBackground(java.awt.Color.red);
        lbFrom.setForeground(new java.awt.Color(255, 255, 255));
        lbFrom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFrom.setText("FROM");
        lbFrom.setOpaque(true);
        lbFrom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbFromMousePressed(evt);
            }
        });

        cbOrizon.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Horizontal", "Vertical" }));
        cbOrizon.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbOrizonItemStateChanged(evt);
            }
        });

        cbLeft.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Left --> Right", "Right --> Left" }));
        cbLeft.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbLeftItemStateChanged(evt);
            }
        });

        btnEnter.setText("Enter");
        btnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(cbOrizon, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbTo, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbOrizon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnEnter)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbFromMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFromMousePressed
        Color select = JColorChooser.showDialog(this, "Select Color", Color.RED);
        if (select != null) {
            if (select.getRGB() == Color.white.getRGB()) {
                lbFrom.setForeground(Color.BLACK);
            } else {
                lbFrom.setForeground(Color.WHITE);
            }
            lbFrom.setBackground(select);
            from = select;
        }
    }//GEN-LAST:event_lbFromMousePressed

    private void lbToMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbToMousePressed
        Color select = JColorChooser.showDialog(this, "Select Color", Color.RED);
        if (select != null) {
            if (select.getRGB() == Color.white.getRGB()) {
                lbTo.setForeground(Color.BLACK);
            } else {
                lbTo.setForeground(Color.WHITE);
            }
            lbTo.setBackground(select);
            to = select;
        }
    }//GEN-LAST:event_lbToMousePressed

    private void cbOrizonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbOrizonItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (cbOrizon.getSelectedIndex() == 0) {
                DefaultComboBoxModel model = new DefaultComboBoxModel();
                model.addElement("Left --> Right");
                model.addElement("Right --> Left");
                cbLeft.setModel(model);
            } else {
                DefaultComboBoxModel model = new DefaultComboBoxModel();
                model.addElement("Top --> Bot");
                model.addElement("Bot --> Top");
                cbLeft.setModel(model);
            }
        }
    }//GEN-LAST:event_cbOrizonItemStateChanged

    private void cbLeftItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbLeftItemStateChanged

    }//GEN-LAST:event_cbLeftItemStateChanged

    private void btnEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterActionPerformed
        Orizon = cbOrizon.getSelectedIndex();
        Vector = cbLeft.getSelectedIndex();
        isSubmit = true;
        dispose();
    }//GEN-LAST:event_btnEnterActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnter;
    private javax.swing.JComboBox cbLeft;
    private javax.swing.JComboBox cbOrizon;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbFrom;
    private javax.swing.JLabel lbTo;
    // End of variables declaration//GEN-END:variables
}
