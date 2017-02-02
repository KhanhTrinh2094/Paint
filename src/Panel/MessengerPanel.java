package Panel;

import Frame.MainFrame;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

public class MessengerPanel extends JPanel {

    private Timer timeMsg;
    private MainFrame mainFrame;

    public MessengerPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
    }

    public void displayMessage(String messenger) {
        txtMsg.setText(messenger);
        timeMsg = new Timer();
        timeMsg.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                txtMsg.setText("");
                timeMsg.cancel();
            }
        }, 4000, 1000);
    }

    public void displayName(String name) {
        if ("".equals(name) || name == null) {
            this.lbName.setIcon(null);
            this.lbName.setText("");
        } else {
            this.lbName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Name.png")));
            this.lbName.setText("   " + name);
        }
    }

    public void displaySize(String size) {
        if (size == null || size.isEmpty()) {
            this.lbSize.setIcon(null);
            this.lbSize.setText("");
        } else {
            this.lbSize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Save.png")));
            this.lbSize.setText("   Size : " + size);
        }
    }

    public void displayResolution(String resolution) {
        if (resolution == null || resolution.isEmpty()) {
            this.lbResolution.setIcon(null);
            this.lbResolution.setText("");
        } else {
            this.lbResolution.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Size.png")));
            this.lbResolution.setText("   " + resolution);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnMsg = new javax.swing.JPanel();
        txtMsg = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbResolution = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lbSize = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        lbName = new javax.swing.JLabel();

        pnMsg.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(102, 102, 102)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, null, new java.awt.Color(0, 0, 0)));
        pnMsg.setPreferredSize(new java.awt.Dimension(1174, 24));
        pnMsg.setLayout(null);

        txtMsg.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        pnMsg.add(txtMsg);
        txtMsg.setBounds(14, 0, 230, 24);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        pnMsg.add(jSeparator1);
        jSeparator1.setBounds(260, 0, 2, 24);

        lbResolution.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        pnMsg.add(lbResolution);
        lbResolution.setBounds(270, 0, 170, 24);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        pnMsg.add(jSeparator2);
        jSeparator2.setBounds(458, 0, 10, 24);

        lbSize.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        pnMsg.add(lbSize);
        lbSize.setBounds(471, 0, 160, 24);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        pnMsg.add(jSeparator3);
        jSeparator3.setBounds(660, 0, 10, 24);

        lbName.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        pnMsg.add(lbName);
        lbName.setBounds(670, 0, 160, 24);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 1194, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMsg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbResolution;
    private javax.swing.JLabel lbSize;
    private javax.swing.JPanel pnMsg;
    private javax.swing.JLabel txtMsg;
    // End of variables declaration//GEN-END:variables
}
