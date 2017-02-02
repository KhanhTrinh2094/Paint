package Frame;

import Panel.DrawPanel;
import Panel.MenuPanel;
import Panel.MessengerPanel;
import Panel.ToolPanel;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.JPanel;

public class MainFrame extends javax.swing.JFrame {

    private int pnWidth, pnHeight;
    public MessengerPanel pnMsg;
    public MenuPanel pnMenu;
    public ToolPanel pnTool;
    public DrawPanel pnImage;
    private JPanel pnMain;

    public MainFrame() {
        initComponents();
        setLocationRelativeTo(this);
    }

    public int getPnWidth() {
        return pnWidth;
    }

    public void setPnWidth(int pnWidth) {
        this.pnWidth = pnWidth;
    }

    public int getPnHeight() {
        return pnHeight;
    }

    public void setPnHeight(int pnHeight) {
        this.pnHeight = pnHeight;
    }

    private void initComponents() {
        this.pnMain = new JPanel();
        this.pnTool = new ToolPanel(this);
        this.pnImage = new DrawPanel(this);
        this.pnMenu = new MenuPanel(this);
        this.pnMsg = new MessengerPanel(this);

        this.pnTool.setBounds(10, 10, 1174, 110);
        this.pnImage.setBounds(10, 130, 1174, 475);
        this.pnMsg.setBounds(0, 615, 1194, 24);

        this.pnMain.add(pnTool);
        this.pnMain.add(pnImage);
        this.pnMain.add(pnMsg);
        this.setJMenuBar(pnMenu);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Nguyễn Cảnh Khánh Trình");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/Logo.png")));
        this.setResizable(false);

        this.pnMain.setBackground(new java.awt.Color(255, 255, 255));
        this.pnMain.setPreferredSize(new java.awt.Dimension(1194, 639));
        this.pnMain.setLayout(null);

        this.pnImage.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        this.pnImage.setPreferredSize(new java.awt.Dimension(1180, 475));

        javax.swing.GroupLayout pnImageLayout = new javax.swing.GroupLayout(pnImage);
        this.pnImage.setLayout(pnImageLayout);
        pnImageLayout.setHorizontalGroup(
                pnImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 1170, Short.MAX_VALUE)
        );
        pnImageLayout.setVerticalGroup(
                pnImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 470, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnMain, javax.swing.GroupLayout.DEFAULT_SIZE, 1174, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnMain, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        this.pack();
        this.setSize(1200, 700);
        this.pnMenu.setLoad(false);
        this.setPnWidth(1170);
        this.setPnHeight(471);
        this.pnTool.setColor(this.pnTool.getBackgroundColorOne());
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    public void showError(IOException e) {
    }

}
