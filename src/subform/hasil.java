package subform;

import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.GroupLayout;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import koneksi.koneksi;
import mainform.utama;

public class hasil extends JInternalFrame {
  /**
	 * 
	 */
	private static final long serialVersionUID = 7317174146239630520L;

int i = 0;
  
  utama utm = new utama();
  
  diagnosa dg = new diagnosa(this.utm);
  
  Statement stt;
  
  ResultSet rss;
  
  private JLabel jLabel1;
  private JLabel jLabel2;
  private JScrollPane jScrollPane1;
  private JScrollPane jScrollPane2;
  private JTextField txtmaslah;
  private JTextArea txtpertanyaan;
  private JTextArea txtsolusi;
  
  public hasil(diagnosa dg) {
    initComponents();
    this.dg = dg;
    loadgejala();
  }
  
  public JTextField masalah() {
    return this.txtmaslah;
  }
  
  public void loadgejala() {
    Connection con = (new koneksi()).getCn();
    String sql = "SELECT * FROM tblsmntara";
    try {
      this.stt = con.createStatement();
      this.rss = this.stt.executeQuery(sql);
      while (this.rss.next()) {
        this.i++;
        this.txtpertanyaan.append(this.i + ". " + this.rss.getString("pertanyaan") + "\n");
        this.txtsolusi.append(this.i + ". " + this.rss.getString("solusi") + "\n");
      } 
      this.rss.close();
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  private void initComponents() {
    this.jScrollPane1 = new JScrollPane();
    this.txtsolusi = new JTextArea();
    this.jLabel1 = new JLabel();
    this.jLabel2 = new JLabel();
    this.jScrollPane2 = new JScrollPane();
    this.txtpertanyaan = new JTextArea();
    this.txtmaslah = new JTextField();
    setClosable(true);
    setTitle("Hasil Diagnosa");
    setPreferredSize(new Dimension(450, 510));
    this.txtsolusi.setColumns(20);
    this.txtsolusi.setEditable(false);
    this.txtsolusi.setRows(5);
    this.jScrollPane1.setViewportView(this.txtsolusi);
    this.jLabel1.setFont(new Font("Tahoma", 1, 11));
    this.jLabel1.setText("Gejala Yang Dialami");
    this.jLabel2.setFont(new Font("Tahoma", 1, 11));
    this.jLabel2.setText("Pilihan Solusi");
    this.txtpertanyaan.setColumns(20);
    this.txtpertanyaan.setEditable(false);
    this.txtpertanyaan.setRows(5);
    this.jScrollPane2.setViewportView(this.txtpertanyaan);
    this.txtmaslah.setEditable(false);
    this.txtmaslah.setFont(new Font("Tahoma", 0, 18));
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel2).addComponent(this.jLabel1)).addGap(0, 302, 32767)).addComponent(this.jScrollPane1, -1, 414, 32767).addComponent(this.jScrollPane2, -1, 414, 32767)).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.txtmaslah, -2, 294, -2).addGap(68, 68, 68)))));
    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.txtmaslah, -2, 36, -2).addGap(18, 18, 18).addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -2, 175, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel2).addGap(4, 4, 4).addComponent(this.jScrollPane1, -1, 186, 32767).addContainerGap()));
    pack();
  }
}
