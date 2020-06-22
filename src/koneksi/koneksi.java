package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class koneksi {
  Connection Connect = null;
  
  public Connection getCn() {
    try {
      this.Connect = DriverManager.getConnection("jdbc:mysql://localhost/pakar", "root", "");
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Gagal Koneksi");
    } 
    return this.Connect;
  }
}
