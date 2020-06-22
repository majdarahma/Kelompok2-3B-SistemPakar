package subform;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.LayoutManager;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import koneksi.koneksi;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class gejala extends JInternalFrame {
  Statement stt;
  
  ResultSet rss;
  
  DefaultTableModel model;
  
  String idpertnyaan;
  
  int id;
  
  private JButton btnbaru;
  
  private JButton btnbatal;
  
  private JButton btnhapus;
  
  private JButton btnsimpan;
  
  private JButton btnubahn;
  
  private JComboBox cid;
  
  private JComboBox cidya;
  
  private JComboBox cmb_merk;
  
  private JLabel jLabel1;
  
  private JLabel jLabel2;
  
  private JLabel jLabel3;
  
  private JLabel jLabel4;
  
  private JLabel jLabel5;
  
  private JLabel jLabel6;
  
  private JScrollPane jScrollPane1;
  
  private JScrollPane jScrollPane2;
  
  private JScrollPane jScrollPane3;
  
  private JTable tbl_solusi;
  
  private JTable tblgejala;
  
  private JTable tblkerusakan;
  
  private JTextField txtpertanyaan;
  
  public gejala() {
    initComponents();
    tabelgejala();
    loadtabel();
    tabelKerusakan();
    loadkerusakan();
    tabelSolusi();
    loadsolusi();
    cmb_notebook();
    this.btnbatal.setVisible(false);
  }
  
  private void initComponents() {
    this.jLabel2 = new JLabel();
    this.txtpertanyaan = new JTextField();
    this.jLabel3 = new JLabel();
    this.jScrollPane1 = new JScrollPane();
    this.tblgejala = new JTable();
    this.btnbaru = new JButton();
    this.btnbatal = new JButton();
    this.btnhapus = new JButton();
    this.btnubahn = new JButton();
    this.btnsimpan = new JButton();
    this.jLabel5 = new JLabel();
    this.cid = new JComboBox();
    this.jScrollPane2 = new JScrollPane();
    this.tblkerusakan = new JTable();
    this.jLabel1 = new JLabel();
    this.cmb_merk = new JComboBox();
    this.jScrollPane3 = new JScrollPane();
    this.tbl_solusi = new JTable();
    this.jLabel4 = new JLabel();
    this.jLabel6 = new JLabel();
    this.cidya = new JComboBox();
    setClosable(true);
    setTitle("Basis Pengetahuan Gejala dan Permasalahan Kerusakan Notebook");
    setPreferredSize(new Dimension(1015, 515));
    getContentPane().setLayout((LayoutManager)new AbsoluteLayout());
    this.jLabel2.setText(" Pertanyaan");
    getContentPane().add(this.jLabel2, new AbsoluteConstraints(250, 70, -1, -1));
    this.txtpertanyaan.setEnabled(false);
    getContentPane().add(this.txtpertanyaan, new AbsoluteConstraints(390, 70, 600, -1));
    this.jLabel3.setText(" Solusi Ya");
    getContentPane().add(this.jLabel3, new AbsoluteConstraints(250, 100, -1, -1));
    this.tblgejala.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null }, , { null, null, null, null, null }, , { null, null, null, null, null }, , { null, null, null, null, null },  }, (Object[])new String[] { "Id Permasalahan", "Id Pertanyaan", "Pertanyaan", "Id Solusi", "Id Pertanyaan" }));
    this.tblgejala.setRowHeight(18);
    this.tblgejala.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent evt) {
            gejala.this.tblgejalaMouseClicked(evt);
          }
        });
    this.jScrollPane1.setViewportView(this.tblgejala);
    getContentPane().add(this.jScrollPane1, new AbsoluteConstraints(0, 300, 1000, 190));
    this.btnbaru.setIcon(new ImageIcon(getClass().getResource("/gambar/File-New-icon.png")));
    this.btnbaru.setText("Baru");
    this.btnbaru.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            gejala.this.btnbaruActionPerformed(evt);
          }
        });
    getContentPane().add(this.btnbaru, new AbsoluteConstraints(10, 20, 80, -1));
    this.btnbatal.setIcon(new ImageIcon(getClass().getResource("/gambar/no-icon.png")));
    this.btnbatal.setText("Batal");
    this.btnbatal.setCursor(new Cursor(12));
    this.btnbatal.setMaximumSize(new Dimension(83, 25));
    this.btnbatal.setMinimumSize(new Dimension(83, 25));
    this.btnbatal.setPreferredSize(new Dimension(83, 25));
    this.btnbatal.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            gejala.this.btnbatalActionPerformed(evt);
          }
        });
    getContentPane().add(this.btnbatal, new AbsoluteConstraints(120, 80, -1, 30));
    this.btnhapus.setIcon(new ImageIcon(getClass().getResource("/gambar/Trash-can-icon.png")));
    this.btnhapus.setText("Hapus");
    this.btnhapus.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            gejala.this.btnhapusActionPerformed(evt);
          }
        });
    getContentPane().add(this.btnhapus, new AbsoluteConstraints(120, 80, 90, -1));
    this.btnubahn.setIcon(new ImageIcon(getClass().getResource("/gambar/Actions-document-edit-icon.png")));
    this.btnubahn.setText("Ubah");
    this.btnubahn.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            gejala.this.btnubahnActionPerformed(evt);
          }
        });
    getContentPane().add(this.btnubahn, new AbsoluteConstraints(120, 20, 90, -1));
    this.btnsimpan.setIcon(new ImageIcon(getClass().getResource("/gambar/save-icon.png")));
    this.btnsimpan.setText("Simpan");
    this.btnsimpan.setEnabled(false);
    this.btnsimpan.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            gejala.this.btnsimpanActionPerformed(evt);
          }
        });
    getContentPane().add(this.btnsimpan, new AbsoluteConstraints(10, 80, -1, -1));
    this.jLabel5.setText(" Id Permasalahan");
    getContentPane().add(this.jLabel5, new AbsoluteConstraints(250, 40, -1, -1));
    this.cid.setEnabled(false);
    this.cid.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent evt) {
            gejala.this.cidMouseClicked(evt);
          }
          
          public void mousePressed(MouseEvent evt) {
            gejala.this.cidMousePressed(evt);
          }
        });
    this.cid.addItemListener(new ItemListener() {
          public void itemStateChanged(ItemEvent evt) {
            gejala.this.cidItemStateChanged(evt);
          }
        });
    this.cid.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            gejala.this.cidActionPerformed(evt);
          }
        });
    this.cid.addKeyListener(new KeyAdapter() {
          public void keyPressed(KeyEvent evt) {
            gejala.this.cidKeyPressed(evt);
          }
        });
    getContentPane().add(this.cid, new AbsoluteConstraints(390, 40, 90, 25));
    this.tblkerusakan.setModel(new DefaultTableModel(new Object[][] { { null, null }, , { null, null }, , { null, null }, , { null, null },  }, (Object[])new String[] { "Id Permasalahan", "Jenis Permasalahan" }));
    this.tblkerusakan.setEnabled(false);
    this.tblkerusakan.setRowHeight(18);
    this.jScrollPane2.setViewportView(this.tblkerusakan);
    getContentPane().add(this.jScrollPane2, new AbsoluteConstraints(600, 140, 400, 160));
    this.jLabel1.setText(" Merk & Type Notebook");
    getContentPane().add(this.jLabel1, new AbsoluteConstraints(250, 10, 140, -1));
    this.cmb_merk.setEnabled(false);
    this.cmb_merk.addItemListener(new ItemListener() {
          public void itemStateChanged(ItemEvent evt) {
            gejala.this.cmb_merkItemStateChanged(evt);
          }
        });
    getContentPane().add(this.cmb_merk, new AbsoluteConstraints(390, 10, 270, 25));
    this.tbl_solusi.setModel(new DefaultTableModel(new Object[][] { { null, null }, , { null, null }, , { null, null }, , { null, null },  }, (Object[])new String[] { "Id Solusi", "Solusi" }));
    this.tbl_solusi.setEnabled(false);
    this.tbl_solusi.setRowHeight(18);
    this.jScrollPane3.setViewportView(this.tbl_solusi);
    getContentPane().add(this.jScrollPane3, new AbsoluteConstraints(0, 140, 580, 160));
    this.jLabel4.setText("Solusi");
    getContentPane().add(this.jLabel4, new AbsoluteConstraints(10, 120, 40, -1));
    this.jLabel6.setText("Permasalahan");
    getContentPane().add(this.jLabel6, new AbsoluteConstraints(600, 120, -1, -1));
    this.cidya.setEnabled(false);
    getContentPane().add(this.cidya, new AbsoluteConstraints(390, 100, 90, -1));
    pack();
  }
  
  private void btnbaruActionPerformed(ActionEvent evt) {
    this.btnsimpan.setEnabled(true);
    this.btnhapus.setVisible(false);
    this.btnubahn.setEnabled(false);
    this.btnbatal.setVisible(true);
    muncul();
    clear();
  }
  
  private void btnbatalActionPerformed(ActionEvent evt) {
    this.btnubahn.setEnabled(true);
    this.btnhapus.setVisible(true);
    this.btnbatal.setVisible(false);
    this.btnsimpan.setEnabled(false);
    this.cidya.setEnabled(false);
    this.txtpertanyaan.setEnabled(false);
    this.cid.setEnabled(false);
    this.cmb_merk.setEnabled(false);
    clear();
  }
  
  private void btnhapusActionPerformed(ActionEvent evt) {
    Connection con = (new koneksi()).getCn();
    int row = this.tblgejala.getSelectedRow();
    try {
      if (row == -1) {
        JOptionPane.showMessageDialog(this, "Pilih salah satu tabel untuk dihapus", "Pesan", 2);
      } else {
        String id = this.tblgejala.getModel().getValueAt(row, 1).toString();
        String sql = "DELETE FROM pertanyaan WHERE idpertanyaan = '" + id + "'";
        int kom = JOptionPane.showConfirmDialog(null, "Apa Anda yakin ingin menghapus salah satu data?", "Konfirmasi penghapusan", 0);
        if (kom == 0) {
          this.stt = con.createStatement();
          this.stt.executeUpdate(sql);
          JOptionPane.showMessageDialog(null, "Data berhasil dihapus", "Pesan", 1);
          tabelgejala();
          loadtabel();
          this.txtpertanyaan.setEnabled(false);
          this.cidya.setEnabled(false);
          clear();
        } 
      } 
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  private void btnubahnActionPerformed(ActionEvent evt) {
    Connection con = (new koneksi()).getCn();
    int row = this.tblgejala.getSelectedRow();
    try {
      if (row == -1) {
        JOptionPane.showMessageDialog(this, "Pilih salah satu tabel", "Pesan", 2);
      } else {
        String id1 = this.tblgejala.getValueAt(row, 1).toString();
        String sql = "UPDATE pertanyaan SET pertanyaan = ?,id_solusi = ?, idpermasalahan = ?, id_notebook=? WHERE idpertanyaan = '" + id1 + "'";
        PreparedStatement p = con.prepareStatement(sql);
        p.setString(1, this.txtpertanyaan.getText());
        p.setString(2, this.cidya.getSelectedItem().toString());
        p.setString(3, this.cid.getSelectedItem().toString());
        p.setInt(4, this.id);
        p.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data berhasil diubah", "Pesan", 1);
        tabelgejala();
        loadtabel();
        this.btnbatal.setVisible(false);
        this.btnhapus.setVisible(true);
        this.btnubahn.setEnabled(true);
        this.btnsimpan.setEnabled(false);
        this.txtpertanyaan.setEnabled(false);
        this.cidya.setEnabled(false);
        clear();
      } 
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Gagal Ubah");
      e.printStackTrace();
    } 
  }
  
  private void btnsimpanActionPerformed(ActionEvent evt) {
    try {
      Connection con = (new koneksi()).getCn();
      String sql = "insert into pertanyaan(pertanyaan, id_solusi, idpermasalahan,id_notebook) values(?,?,?,?)";
      PreparedStatement p = con.prepareStatement(sql);
      p.setString(1, this.txtpertanyaan.getText());
      p.setString(2, this.cidya.getSelectedItem().toString());
      p.setString(3, this.cid.getSelectedItem().toString());
      p.setInt(4, this.id);
      p.executeUpdate();
      JOptionPane.showMessageDialog(null, "Data berhasil masuk", "Pesan", 1);
      tabelgejala();
      loadtabel();
      this.btnbatal.setVisible(false);
      this.btnhapus.setVisible(true);
      this.btnubahn.setEnabled(true);
      this.btnsimpan.setEnabled(false);
      this.txtpertanyaan.setEnabled(false);
      this.cidya.setEnabled(false);
      this.cid.setEnabled(false);
      this.cmb_merk.setEnabled(false);
      clear();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Gagal Simpan");
      e.printStackTrace();
    } 
  }
  
  private void tblgejalaMouseClicked(MouseEvent evt) {
    int row = this.tblgejala.getSelectedRow();
    this.idpertnyaan = (String)this.tblgejala.getValueAt(row, 1);
    this.cmb_merk.setSelectedItem(this.tblgejala.getValueAt(row, 5).toString());
    this.txtpertanyaan.setText((String)this.tblgejala.getValueAt(row, 2));
    this.cidya.setSelectedItem(this.tblgejala.getValueAt(row, 3));
    this.cid.setSelectedItem(this.tblgejala.getValueAt(row, 0));
    muncul();
  }
  
  private void cidItemStateChanged(ItemEvent evt) {}
  
  private void cidKeyPressed(KeyEvent evt) {}
  
  private void cidMouseClicked(MouseEvent evt) {}
  
  private void cidMousePressed(MouseEvent evt) {}
  
  private void cidActionPerformed(ActionEvent evt) {}
  
  private void cmb_merkItemStateChanged(ItemEvent evt) {
    Connection con = (new koneksi()).getCn();
    String sql = "SELECT id_notebook FROM notebook WHERE type = '" + this.cmb_merk.getSelectedItem().toString() + "'";
    try {
      this.stt = con.createStatement();
      ResultSet rss2 = this.stt.executeQuery(sql);
      if (rss2.next())
        this.id = rss2.getInt(1); 
      rss2.close();
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  public void loadtabel() {
    Connection con = (new koneksi()).getCn();
    String sql = "SELECT pertanyaan.idpertanyaan, permasalahan.permasalahan, pertanyaan.pertanyaan, pertanyaan.id_solusi, permasalahan.idpermasalah, notebook.id_notebook, notebook.type FROM pertanyaan,permasalahan, solusi, notebook WHERE permasalahan.idpermasalah = pertanyaan.idpermasalahan and pertanyaan.id_solusi = solusi.id_solusi and notebook.id_notebook = pertanyaan.id_notebook";
    try {
      this.stt = con.createStatement();
      this.rss = this.stt.executeQuery(sql);
      while (this.rss.next()) {
        Object[] o = new Object[6];
        o[0] = this.rss.getString("idpermasalah");
        o[1] = this.rss.getString("idpertanyaan");
        o[2] = this.rss.getString("pertanyaan");
        o[3] = this.rss.getString("id_solusi");
        o[4] = this.rss.getString("id_notebook");
        o[5] = this.rss.getString("type");
        this.model.addRow(o);
      } 
      this.rss.close();
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  public void tabelgejala() {
    this.model = new DefaultTableModel();
    this.tblgejala.setModel(this.model);
    this.model.addColumn("Id Permasalahan");
    this.model.addColumn("Id Pertanyaan");
    this.model.addColumn("Pertanyaan");
    this.model.addColumn("Id Solusi");
    this.model.addColumn("Id Notebook");
    this.model.addColumn("Type");
    aturKolom();
  }
  
  public void aturKolom() {
    this.tblgejala.setAutoResizeMode(0);
    TableColumn column = this.tblgejala.getColumnModel().getColumn(0);
    column.setPreferredWidth(105);
    column = this.tblgejala.getColumnModel().getColumn(1);
    column.setPreferredWidth(105);
    column = this.tblgejala.getColumnModel().getColumn(2);
    column.setPreferredWidth(660);
    column = this.tblgejala.getColumnModel().getColumn(3);
    column.setPreferredWidth(105);
    column = this.tblgejala.getColumnModel().getColumn(4);
    column.setPreferredWidth(105);
  }
  
  public void clear() {
    this.cid.setSelectedIndex(0);
    this.txtpertanyaan.setText("");
    this.cidya.setSelectedIndex(0);
  }
  
  public void loadkerusakan() {
    Connection con = (new koneksi()).getCn();
    String sql = "SELECT * FROM permasalahan";
    try {
      this.stt = con.createStatement();
      this.rss = this.stt.executeQuery(sql);
      while (this.rss.next()) {
        Object[] o = new Object[2];
        o[0] = this.rss.getString("idpermasalah");
        o[1] = this.rss.getString("permasalahan");
        this.model.addRow(o);
        this.cid.addItem(this.rss.getString("idpermasalah"));
      } 
      this.rss.close();
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  public void tabelKerusakan() {
    this.model = new DefaultTableModel();
    this.tblkerusakan.setModel(this.model);
    this.model.addColumn("Id Permasalahan");
    this.model.addColumn("Jenis Permasalahan");
    aturKolom1();
  }
  
  public void loadsolusi() {
    Connection con = (new koneksi()).getCn();
    String sql = "SELECT * FROM solusi";
    try {
      this.stt = con.createStatement();
      this.rss = this.stt.executeQuery(sql);
      while (this.rss.next()) {
        Object[] o = new Object[2];
        o[0] = this.rss.getString("id_solusi");
        o[1] = this.rss.getString("solusi");
        this.model.addRow(o);
        this.cidya.addItem(this.rss.getString("id_solusi"));
      } 
      this.rss.close();
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  public void cmb_notebook() {
    Connection con = (new koneksi()).getCn();
    String sql = "SELECT * FROM notebook";
    try {
      this.stt = con.createStatement();
      this.rss = this.stt.executeQuery(sql);
      while (this.rss.next())
        this.cmb_merk.addItem(this.rss.getString("type")); 
      this.rss.close();
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  public void tabelSolusi() {
    this.model = new DefaultTableModel();
    this.tbl_solusi.setModel(this.model);
    this.model.addColumn("Id Solusi");
    this.model.addColumn("Solusi");
    aturKolom2();
  }
  
  public void aturKolom2() {
    this.tblkerusakan.setAutoResizeMode(0);
    TableColumn column = this.tbl_solusi.getColumnModel().getColumn(0);
    column.setPreferredWidth(20);
    column = this.tbl_solusi.getColumnModel().getColumn(1);
    column.setPreferredWidth(400);
  }
  
  public void aturKolom1() {
    this.tblkerusakan.setAutoResizeMode(0);
    TableColumn column = this.tblkerusakan.getColumnModel().getColumn(0);
    column.setPreferredWidth(105);
    column = this.tblkerusakan.getColumnModel().getColumn(1);
    column.setPreferredWidth(270);
  }
  
  public void muncul() {
    this.cid.setEnabled(true);
    this.txtpertanyaan.setEnabled(true);
    this.cidya.setEnabled(true);
    this.cmb_merk.setEnabled(true);
  }
}
