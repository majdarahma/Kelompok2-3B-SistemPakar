package subform;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import koneksi.koneksi;


public class solusi extends JInternalFrame {
  /**
	 * 
	 */
	private static final long serialVersionUID = -3964371569842287788L;

Statement stt;
  
  ResultSet rss;
  
  DefaultTableModel model;
  
  private JButton btnbaru;
  private JButton btnbatal;
  private JButton btnhapus;
  private JButton btnsimpan;
  private JButton btnubahn;
  private JLabel jLabel2;
  private JLabel jLabel3;
  private JScrollPane jScrollPane1;
  private JTable tblkerusakan;
  private JTextField txtjenis;
  
  public solusi() {
    initComponents();
    tabelKerusakan();
    loadtabel();
    this.btnbatal.setVisible(false);
  }
  
  private void initComponents() {
    this.btnbaru = new JButton();
    this.btnubahn = new JButton();
    this.txtjenis = new JTextField();
    this.btnsimpan = new JButton();
    this.btnbatal = new JButton();
    this.jScrollPane1 = new JScrollPane();
    this.tblkerusakan = new JTable();
    this.jLabel3 = new JLabel();
    this.jLabel2 = new JLabel();
    this.btnhapus = new JButton();
    setClosable(true);
    this.btnbaru.setIcon(new ImageIcon(getClass().getResource("/gambar/File-New-icon.png")));
    this.btnbaru.setText("Baru");
    this.btnbaru.setCursor(new Cursor(12));
    this.btnbaru.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            solusi.this.btnbaruActionPerformed(evt);
          }
        });
    this.btnubahn.setIcon(new ImageIcon(getClass().getResource("/gambar/Actions-document-edit-icon.png")));
    this.btnubahn.setText("Ubah");
    this.btnubahn.setCursor(new Cursor(12));
    this.btnubahn.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            solusi.this.btnubahnActionPerformed(evt);
          }
        });
    this.txtjenis.setEnabled(false);
    this.btnsimpan.setIcon(new ImageIcon(getClass().getResource("/gambar/save-icon.png")));
    this.btnsimpan.setText("Simpan");
    this.btnsimpan.setCursor(new Cursor(12));
    this.btnsimpan.setEnabled(false);
    this.btnsimpan.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            solusi.this.btnsimpanActionPerformed(evt);
          }
        });
    this.btnbatal.setIcon(new ImageIcon(getClass().getResource("/gambar/no-icon.png")));
    this.btnbatal.setText("Batal");
    this.btnbatal.setCursor(new Cursor(12));
    this.btnbatal.setPreferredSize(new Dimension(83, 25));
    this.btnbatal.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            solusi.this.btnbatalActionPerformed(evt);
          }
        });
    this.tblkerusakan.setModel(new DefaultTableModel(new Object[][] { { null, null },  { null, null }, { null, null }, { null, null },  }, (Object[])new String[] { "ID Solusi", "Solusi" }));
    this.tblkerusakan.setName("tblkerusakan");
    this.tblkerusakan.setRowHeight(20);
    this.tblkerusakan.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent evt) {
            solusi.this.tblkerusakanMouseClicked(evt);
          }
        });
    this.jScrollPane1.setViewportView(this.tblkerusakan);
    this.jLabel3.setFont(new Font("Tahoma", 1, 14));
    this.jLabel3.setForeground(new Color(0, 51, 255));
    this.jLabel3.setText("Solusi");
    this.jLabel2.setText("Solusi Kerusakan Notebook");
    this.btnhapus.setIcon(new ImageIcon(getClass().getResource("/gambar/Trash-can-icon.png")));
    this.btnhapus.setText("Hapus");
    this.btnhapus.setCursor(new Cursor(12));
    this.btnhapus.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            solusi.this.btnhapusActionPerformed(evt);
          }
        });
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.jLabel2).addGap(12, 12, 12).addComponent(this.txtjenis, -1, 408, 32767).addContainerGap()).addGroup(layout.createSequentialGroup().addGap(30, 30, 30).addComponent(this.btnbaru, -2, 83, -2).addGap(7, 7, 7).addComponent(this.btnubahn).addGap(134, 134, 134).addComponent(this.btnsimpan).addGap(3, 3, 3).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.btnhapus, -2, 90, -2).addComponent(this.btnbatal, -2, -1, -2)).addGap(56, 56, 56)).addGroup(layout.createSequentialGroup().addComponent(this.jScrollPane1, -1, 557, 32767).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(270, 32767).addComponent(this.jLabel3).addGap(257, 257, 257)));
    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(49, 49, 49).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(47, 47, 47).addComponent(this.jLabel2)).addGroup(layout.createSequentialGroup().addGap(44, 44, 44).addComponent(this.txtjenis, -2, -1, -2))).addGap(17, 17, 17).addComponent(this.jScrollPane1, -2, 276, -2).addGap(24, 24, 24).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.btnbaru).addComponent(this.btnubahn).addComponent(this.btnsimpan).addComponent(this.btnhapus).addComponent(this.btnbatal, -2, -1, -2))).addGroup(layout.createSequentialGroup().addGap(42, 42, 42).addComponent(this.jLabel3))).addContainerGap(20, 32767)));
    pack();
  }
  
  private void btnbaruActionPerformed(ActionEvent evt) {
    this.btnsimpan.setEnabled(true);
    this.btnhapus.setVisible(false);
    this.btnubahn.setEnabled(false);
    this.btnbatal.setVisible(true);
    this.txtjenis.setEnabled(true);
    clear();
  }
  
  private void btnubahnActionPerformed(ActionEvent evt) {
    Connection con = (new koneksi()).getCn();
    int row = this.tblkerusakan.getSelectedRow();
    try {
      if (row == -1) {
        JOptionPane.showMessageDialog(this, "Pilih salah satu tabel", "Pesan", 2);
      } else {
        String idp = this.tblkerusakan.getModel().getValueAt(row, 0).toString();
        String sql = "UPDATE solusi SET solusi = ? WHERE id_solusi = '" + idp + "'";
        PreparedStatement p = con.prepareStatement(sql);
        p.setString(1, this.txtjenis.getText());
        p.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data berhasil diubah", "Pesan", 1);
        tabelKerusakan();
        loadtabel();
        clear();
        this.txtjenis.setEnabled(false);
      } 
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Gagal Ubah");
      e.printStackTrace();
    } 
  }
  
  private void btnsimpanActionPerformed(ActionEvent evt) {
    Connection con = (new koneksi()).getCn();
    try {
      if (this.txtjenis.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
      } else {
        String sql = "insert into solusi(solusi) values(?)";
        PreparedStatement p = con.prepareStatement(sql);
        p.setString(1, this.txtjenis.getText());
        p.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data berhasil masuk", "Pesan", 1);
        tabelKerusakan();
        loadtabel();
        clear();
        this.btnbatal.setVisible(false);
        this.btnhapus.setVisible(true);
        this.btnubahn.setEnabled(true);
        this.btnsimpan.setEnabled(false);
      } 
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Gagal Simpan");
      e.printStackTrace();
    } 
  }
  
  private void btnbatalActionPerformed(ActionEvent evt) {
    clear();
    this.btnubahn.setEnabled(true);
    this.btnhapus.setVisible(true);
    this.btnbatal.setVisible(false);
    this.btnsimpan.setEnabled(false);
    this.txtjenis.setEnabled(false);
  }
  
  private void tblkerusakanMouseClicked(MouseEvent evt) {
    int row = this.tblkerusakan.getSelectedRow();
    this.txtjenis.setText((String)this.tblkerusakan.getValueAt(row, 1));
    this.txtjenis.setEnabled(true);
    this.btnsimpan.setEnabled(false);
  }
  
  private void btnhapusActionPerformed(ActionEvent evt) {
    Connection con = (new koneksi()).getCn();
    int row = this.tblkerusakan.getSelectedRow();
    try {
      if (row == -1) {
        JOptionPane.showMessageDialog(this, "Pilih salah satu tabel untuk dihapus", "Pesan", 2);
      } else {
        String idp = this.tblkerusakan.getModel().getValueAt(row, 0).toString();
        String sql = "DELETE FROM solusi WHERE id_solusi = '" + idp + "'";
        int kom = JOptionPane.showConfirmDialog(null, "Apa Anda yakin ingin menghapus salah satu data?", "Konfirmasi penghapusan", 0);
        if (kom == 0) {
          this.stt = con.createStatement();
          this.stt.executeUpdate(sql);
          JOptionPane.showMessageDialog(null, "Data berhasil dihapus", "Pesan", 1);
          tabelKerusakan();
          loadtabel();
          clear();
          this.txtjenis.setEnabled(false);
        } 
      } 
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  public void tabelKerusakan() {
    this.model = new DefaultTableModel();
    this.tblkerusakan.setModel(this.model);
    this.model.addColumn("ID Solusi");
    this.model.addColumn("Solusi");
    aturKolom();
  }
  
  public void aturKolom() {
    this.tblkerusakan.setAutoResizeMode(0);
    TableColumn column = this.tblkerusakan.getColumnModel().getColumn(0);
    column.setPreferredWidth(110);
    column = this.tblkerusakan.getColumnModel().getColumn(1);
    column.setPreferredWidth(450);
  }
  
  public void loadtabel() {
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
      } 
      this.rss.close();
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  public void clear() {
    this.txtjenis.setText("");
  }
}
