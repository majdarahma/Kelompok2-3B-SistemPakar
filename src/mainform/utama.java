package mainform;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import subform.kerusakan;
import subform.diagnosa;
import subform.gejala;
import subform.solusi;

public class utama extends JFrame {
  /**
	 * 
	 */
	private static final long serialVersionUID = 9090118014193448903L;

String nik;
  
  private JDesktopPane jDesktopPane1;
  private JMenu jMenu1;
  private JMenu jMenu2;
  private JMenu jMenu3;
  private JMenu jMenu4;
  private JMenuBar jMenuBar1;
  private JMenuItem jMenuItem1;
  private JMenuItem jMenuItem2;
  private JMenuItem jMenuItem4;
  private JMenuItem jMenuItem5;
  public utama() {
    initComponents();
    setExtendedState(6);
  }
  
  private void initComponents() {
    this.jDesktopPane1 = new JDesktopPane();
    this.jMenuBar1 = new JMenuBar();
    this.jMenu1 = new JMenu();
    this.jMenu2 = new JMenu();
    this.jMenuItem2 = new JMenuItem();
    this.jMenuItem5 = new JMenuItem();
    this.jMenuItem1 = new JMenuItem();
    this.jMenuItem4 = new JMenuItem();
    this.jMenu3 = new JMenu();
    this.jMenu4 = new JMenu();
    
    setDefaultCloseOperation(3);
    setTitle("Sistem Pakar Diagnosa Kerusakan");
    this.jMenuBar1.setToolTipText("");
    this.jMenuBar1.setPreferredSize(new Dimension(288, 30));
    this.jMenu1.setText("File");
    this.jMenu1.setCursor(new Cursor(12));
    this.jMenu1.setPreferredSize(new Dimension(70, 19));
   
    this.jMenu2.add(this.jMenuItem2);
    this.jMenuItem5.setPreferredSize(new Dimension(240, 29));
    this.jMenuItem5.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            utama.this.jMenuItem5ActionPerformed(evt);
          }
        });
    this.jMenu2.add(this.jMenuItem5);
    this.jMenuItem1.setText("Solusi");
    this.jMenuItem1.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            utama.this.jMenuItem1ActionPerformed(evt);
          }
        });
    this.jMenu2.add(this.jMenuItem1);
    this.jMenuItem4.setText("Basis Pengetahuan");
    this.jMenuItem4.setPreferredSize(new Dimension(225, 29));
    this.jMenuItem4.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            utama.this.jMenuItem4ActionPerformed(evt);
          }
        });
    this.jMenu2.add(this.jMenuItem4);
    this.jMenuBar1.add(this.jMenu2);
    this.jMenu3.setText("Diagnosa");
    this.jMenu3.setCursor(new Cursor(12));
    this.jMenu3.setPreferredSize(new Dimension(100, 19));
    this.jMenu3.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent evt) {
            utama.this.jMenu3MouseClicked(evt);
          }
        });
    this.jMenu3.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            utama.this.jMenu3ActionPerformed(evt);
          }
        });
    
    this.jMenuBar1.add(this.jMenu4);
    setJMenuBar(this.jMenuBar1);
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jDesktopPane1, -1, 966, 32767));
    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jDesktopPane1, -1, 620, 32767));
    getAccessibleContext().setAccessibleName("Sistem Pakar Diagnosa Kerusakan");
    pack();
  }
  
  private void jMenu3ActionPerformed(ActionEvent evt) {}
  
  private void jMenuItem5ActionPerformed(ActionEvent evt) {
    kerusakan kr = new kerusakan();
    kr.setVisible(true);
    this.jDesktopPane1.add((Component)kr);
    setCenterLocation((JInternalFrame)kr);
  }
  
  private void jMenuItem4ActionPerformed(ActionEvent evt) {
    gejala gj = new gejala();
    gj.setVisible(true);
    this.jDesktopPane1.add((Component)gj);
    setCenterLocation((JInternalFrame)gj);
  }
  
  private void jMenu3MouseClicked(MouseEvent evt) {
    diagnosa diag = new diagnosa(this);
    diag.setVisible(true);
    this.jDesktopPane1.add((Component)diag);
    setCenterLocation((JInternalFrame)diag);
  }
  
  private void jMenuItem1ActionPerformed(ActionEvent evt) {
    solusi sls = new solusi();
    sls.setVisible(true);
    this.jDesktopPane1.add((Component)sls);
    setCenterLocation((JInternalFrame)sls);
  }
  
  public JDesktopPane getdesktoppane() {
    return this.jDesktopPane1;
  }
  
  public JMenuItem menudata() {
    return this.jMenu2;
  }
  
  public void setNik(String nik) {
    this.nik = nik;
  }
  
  public void setCenterLocation(JInternalFrame jif) {
    Dimension desktopSize = this.jDesktopPane1.getSize();
    Dimension jifSize = jif.getSize();
    int width = (desktopSize.width - jifSize.width) / 2;
    int height = (desktopSize.height - jifSize.height) / 2;
    jif.setLocation(width, height);
  }
  
  public static void main(String[] args) {
    try {
      for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          UIManager.setLookAndFeel(info.getClassName());
          break;
        } 
      } 
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(utama.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (InstantiationException ex) {
      Logger.getLogger(utama.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (IllegalAccessException ex) {
      Logger.getLogger(utama.class.getName()).log(Level.SEVERE, (String)null, ex);
    } catch (UnsupportedLookAndFeelException ex) {
      Logger.getLogger(utama.class.getName()).log(Level.SEVERE, (String)null, ex);
    } 
    EventQueue.invokeLater(new Runnable() {
          public void run() {
            (new utama()).setVisible(true);
          }
        });
  }
}
