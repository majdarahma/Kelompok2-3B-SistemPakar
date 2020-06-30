package subform;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import koneksi.koneksi;
import mainform.utama;

public class diagnosa extends JInternalFrame {
  /**
	 * 
	 */
	private static final long serialVersionUID = -2588429819018292273L;

Statement stt;
  
  ResultSet rss;
  
  String tampungid;
  
  int tamp = 1;
  
  String tampung;
  
  utama utm = new utama();
  
  int id;
  
  String type;
  
  private JComboBox<String> cmb_type;
  private JComboBox<String> cnma;
  private JButton jButton1;
  private JButton jButton2;
  private JLabel jLabel1;
  private JLabel jLabel2;
  private JTextField txtpertanyaan;
  
  public diagnosa(utama utm) {
    initComponents();
    this.utm = utm;
    loaddata2();
    this.cnma.setEnabled(false);
  }
  
  public void delete_tabel() {
    Connection con = (new koneksi()).getCn();
    String sql = "DELETE FROM tblsmntara";
    try {
      this.stt = con.createStatement();
      this.stt.executeUpdate(sql);
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  private void initComponents() {
    this.cnma = new JComboBox<String>();
    this.txtpertanyaan = new JTextField();
    this.jButton1 = new JButton();
    this.jButton2 = new JButton();
    this.jLabel1 = new JLabel();
    this.cmb_type = new JComboBox<String>();
    this.jLabel2 = new JLabel();
    setClosable(true);
    setTitle("Proses Diagnosa");
    setPreferredSize(new Dimension(650, 265));
    addInternalFrameListener(new InternalFrameListener() {
          public void internalFrameClosed(InternalFrameEvent evt) {}
          
          public void internalFrameClosing(InternalFrameEvent evt) {}
          
          public void internalFrameOpened(InternalFrameEvent evt) {
            diagnosa.this.formInternalFrameOpened(evt);
          }
          
          public void internalFrameActivated(InternalFrameEvent evt) {
            diagnosa.this.formInternalFrameActivated(evt);
          }
          
          public void internalFrameDeactivated(InternalFrameEvent evt) {}
          
          public void internalFrameDeiconified(InternalFrameEvent evt) {}
          
          public void internalFrameIconified(InternalFrameEvent evt) {}
        });
    this.cnma.setFont(new Font("Tahoma", 0, 18));
    this.cnma.setModel(new DefaultComboBoxModel<String>(new String[] { "Pilih" }));
    this.cnma.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent evt) {
            diagnosa.this.cnmaMouseClicked(evt);
          }
          
          public void mouseEntered(MouseEvent evt) {
            diagnosa.this.cnmaMouseEntered(evt);
          }
          
          public void mouseExited(MouseEvent evt) {
            diagnosa.this.cnmaMouseExited(evt);
          }
          
          public void mousePressed(MouseEvent evt) {
            diagnosa.this.cnmaMousePressed(evt);
          }
          
          public void mouseReleased(MouseEvent evt) {
            diagnosa.this.cnmaMouseReleased(evt);
          }
        });
    this.cnma.addItemListener(new ItemListener() {
          public void itemStateChanged(ItemEvent evt) {
            diagnosa.this.cnmaItemStateChanged(evt);
          }
        });
    this.cnma.addKeyListener(new KeyAdapter() {
          public void keyPressed(KeyEvent evt) {
            diagnosa.this.cnmaKeyPressed(evt);
          }
        });
    this.txtpertanyaan.setEditable(false);
    this.jButton1.setText("Ya");
    this.jButton1.setCursor(new Cursor(12));
    this.jButton1.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            diagnosa.this.jButton1ActionPerformed(evt);
          }
        });
    this.jButton2.setText("Tidak");
    this.jButton2.setCursor(new Cursor(12));
    this.jButton2.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            diagnosa.this.jButton2ActionPerformed(evt);
          }
        });
    this.jLabel1.setFont(new Font("Tahoma", 1, 15));
    this.jLabel1.setForeground(new Color(0, 51, 204));
    this.jLabel1.setText("Perkiraan kerusakan terjadi pada komponen ?");
    this.cmb_type.setFont(new Font("Tahoma", 0, 18));
    this.cmb_type.setModel(new DefaultComboBoxModel<String>(new String[] { "Pilih" }));
    this.cmb_type.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent evt) {
            diagnosa.this.cmb_typeMouseClicked(evt);
          }
          
          public void mouseExited(MouseEvent evt) {
            diagnosa.this.cmb_typeMouseExited(evt);
          }
          
          public void mousePressed(MouseEvent evt) {
            diagnosa.this.cmb_typeMousePressed(evt);
          }
          
          public void mouseReleased(MouseEvent evt) {
            diagnosa.this.cmb_typeMouseReleased(evt);
          }
        });
    this.cmb_type.addItemListener(new ItemListener() {
          public void itemStateChanged(ItemEvent evt) {
            diagnosa.this.cmb_typeItemStateChanged(evt);
          }
        });
    this.jLabel2.setFont(new Font("Tahoma", 1, 15));
    this.jLabel2.setForeground(new Color(0, 51, 204));
    this.jLabel2.setText("Merk dan Type");
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(242, 32767).addComponent(this.jButton1).addGap(18, 18, 18).addComponent(this.jButton2).addGap(232, 232, 232)).addGroup(layout.createSequentialGroup().addGap(25, 25, 25).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 34, 32767).addComponent(this.cmb_type, -2, 362, -2)).addComponent(this.jLabel1).addComponent(this.cnma, 0, 581, 32767).addComponent(this.txtpertanyaan, -1, 581, 32767)).addContainerGap(28, 32767)));
    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.cmb_type, -1, 36, 32767).addComponent(this.jLabel2)).addGap(22, 22, 22).addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.cnma, -2, 39, -2).addGap(18, 18, 18).addComponent(this.txtpertanyaan, -2, 35, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton1).addComponent(this.jButton2)).addContainerGap()));
    pack();
  }
  
  private void jButton1ActionPerformed(ActionEvent evt) {
    Connection con = (new koneksi()).getCn();
    try {
      String sql2 = "SELECT solusi.solusi FROM pertanyaan,solusi WHERE solusi.id_solusi = pertanyaan.id_solusi and pertanyaan = '" + this.txtpertanyaan.getText() + "'";
      this.stt = con.createStatement();
      this.rss = this.stt.executeQuery(sql2);
      if (this.rss.next())
        this.tampung = this.rss.getString("solusi"); 
      String sql = "insert into tblsmntara values(?,?,?)";
      PreparedStatement p = con.prepareStatement(sql);
      p.setString(1, this.txtpertanyaan.getText());
      p.setString(2, this.cnma.getSelectedItem().toString());
      p.setString(3, this.tampung);
      p.executeUpdate();
      this.tamp++;
      loadcombo();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Pilih Salah Satu Jenis Kerusakan");
      e.printStackTrace();
    } 
  }
  
  private void cnmaItemStateChanged(ItemEvent evt) {
    loadcombo();
  }
  
  public void loadcombo() {
    Connection con = (new koneksi()).getCn();
    String sql = "SELECT pertanyaan FROM permasalahan, pertanyaan WHERE pertanyaan.idpermasalahan = permasalahan.idpermasalah and permasalahan.permasalahan = '" + this.cnma.getSelectedItem().toString() + "'";
    try {
      this.stt = con.createStatement();
      this.rss = this.stt.executeQuery(sql);
      if (this.cnma.getSelectedItem().equals("Pilih")) {
        this.jButton1.setEnabled(false);
        this.jButton2.setEnabled(false);
      } else {
        if (this.rss.relative(this.tamp)) {
          this.txtpertanyaan.setText(this.rss.getString("pertanyaan"));
        } else {
          hasil pl = new hasil(this);
          this.utm.getdesktoppane().add(pl);
          this.utm.setCenterLocation(pl);
          pl.setVisible(true);
          pl.masalah().setText(this.cnma.getSelectedItem().toString());
          dispose();
        } 
        this.rss.close();
        this.jButton1.setEnabled(true);
        this.jButton2.setEnabled(true);
      } 
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  private void cnmaKeyPressed(KeyEvent evt) {}
  
  private void cnmaMouseClicked(MouseEvent evt) {}
  
  private void cnmaMousePressed(MouseEvent evt) {}
  
  private void cnmaMouseReleased(MouseEvent evt) {}
  
  private void cnmaMouseEntered(MouseEvent evt) {}
  
  private void cnmaMouseExited(MouseEvent evt) {}
  
  private void formInternalFrameActivated(InternalFrameEvent evt) {}
  
  private void formInternalFrameOpened(InternalFrameEvent evt) {
    delete_tabel();
  }
  
  private void jButton2ActionPerformed(ActionEvent evt) {
    try {
      this.tamp++;
      loadcombo();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Pilih Salah Satu Jenis Kerusakan");
    } 
  }
  
  private void cmb_typeItemStateChanged(ItemEvent evt) {
    Connection con = (new koneksi()).getCn();
    this.type = this.cmb_type.getSelectedItem().toString();
    String sql2 = "SELECT distinct permasalahan FROM permasalahan, pertanyaan, notebook WHERE permasalahan.idpermasalah = pertanyaan.idpermasalahan and notebook.id_notebook = pertanyaan.id_notebook and notebook.type = '" + this.type + "'";
    try {
      if (this.stt.isClosed()) {
        this.stt = con.createStatement();
      } else {
        ResultSet rss2 = this.stt.executeQuery(sql2);
        while (rss2.next())
          this.cnma.addItem(rss2.getString("permasalahan")); 
        rss2.close();
        this.stt.close();
      } 
      this.cnma.setEnabled(true);
      this.cmb_type.setEnabled(false);
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  private void cmb_typeMouseClicked(MouseEvent evt) {}
  
  private void cmb_typeMouseReleased(MouseEvent evt) {}
  
  private void cmb_typeMouseExited(MouseEvent evt) {}
  
  private void cmb_typeMousePressed(MouseEvent evt) {}
  
  public void loaddata2() {
    Connection con = (new koneksi()).getCn();
    String sql = "SELECT * FROM notebook";
    try {
      this.stt = con.createStatement();
      this.rss = this.stt.executeQuery(sql);
      while (this.rss.next())
        this.cmb_type.addItem(this.rss.getString("type")); 
      this.rss.close();
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
}
