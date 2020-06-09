/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MySQL;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Vivalvia
 */
public class MySQL {
    com.mysql.jdbc.Connection getConnection;
    public MySQL(){        
    }
    public static Connection bukaKoneksi() throws SQLException{
        Connection con = null;
        try {
            String url = "jdbc:mysql://localhost/laundry";
            String user = "root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            JOptionPane.showMessageDialog(null, "Selamat Anda Terhubung Dengan Database");
            System.out.println("Connection Success");
            return con;
        }
        catch(SQLException se){
            JOptionPane.showMessageDialog(null, "Coba Lagi");
            System.out.println("No Connection open");
            return null;
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Could't open connection");
            return null;
        }
    }
    public static void main(String[]args)throws SQLException{
        bukaKoneksi();
    }
}
   

