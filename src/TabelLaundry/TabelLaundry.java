/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TabelLaundry;

/**
 *
 * @author Vivalvia
 */
import MySQL.MySQL;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;

class TabelLaundry extends JFrame implements ActionListener {
    private JPanel jpLaundryBuns = new JPanel();
    private JLabel lblNamaPelanggan = new JLabel("Nama Pelanggan:"),lblTglMasukLaundry = new JLabel("Tgl Masuk Laundry:"),
            lblJenisLaundry = new JLabel("Jenis Laundry: "),lblBerat = new JLabel("Berat: "),
            lblJenisParfum = new JLabel("Jenis Parfum:"),lblTglPengembalian = new JLabel("Tgl Pengembalian:");
    private JTextField txtNamaPelanggan = new JTextField(),txtTglMasukLaundry = new JTextField(),
            txtBerat = new JTextField(),txtTglPengembalian = new JTextField();
    private JComboBox cboJenisLaundry = new JComboBox(), cboJenisParfum  = new JComboBox();
    private JButton btnTambah = new JButton("Tambah"),btnUbah = new JButton("Ubah"),
            btnHapus = new JButton("Hapus"),btnBersih = new JButton("Bersih");
    
     String[] strJdl={"Nama Pelanggan","Tgl Masuk Laundry","Jenis Laundry","Berat","Jenis Parfum","Tgl Pengembalian"};
    
//Deklarasi untuk Tabel
    JTable tabel = new JTable();
    JScrollPane skrTabel = new JScrollPane();
    
    TabelLaundry (){
        super("Data Pelanggan Laundry Bun's");
        setSize(500,300);
        jpLaundryBuns.setLayout(null);
        
        //mengatur letak objek pada container
        lblNamaPelanggan.setBounds(15, 20, 100, 25);
        lblTglMasukLaundry.setBounds(15,55, 150, 25);
        lblJenisLaundry.setBounds(15, 90, 100, 25);
        lblBerat.setBounds(15, 125, 100, 25);
        lblJenisParfum.setBounds(15,  160, 100, 25);
        lblTglPengembalian.setBounds(15, 195, 150, 25);
        
        txtNamaPelanggan.setBounds(150, 20, 100, 25);
        txtTglMasukLaundry.setBounds(150, 55, 100, 25);
        cboJenisLaundry.setBounds(150, 90, 100, 25);
        txtBerat.setBounds(150, 125, 50, 25);
        cboJenisParfum.setBounds(150, 160, 100, 25);
        txtTglPengembalian.setBounds(150, 195, 100, 25);
        
        btnTambah.setBounds(340, 20, 85, 25);
        btnUbah.setBounds(340, 55, 85, 25);
        btnHapus.setBounds(340, 90, 85, 25);
        btnBersih.setBounds(340, 125, 85, 25);
        
    skrTabel.getViewport().add(tabel);
    tabel.setEnabled(true);
    skrTabel.setBounds(15, 250, 470, 115);

    //menambahkan tabel pada panel
    jpLaundryBuns.add(skrTabel);
        
        //mengatur/meletakkan objek pada objek panel
        jpLaundryBuns.add(lblNamaPelanggan);
        jpLaundryBuns.add(lblTglMasukLaundry);
        jpLaundryBuns.add(lblJenisLaundry);
        jpLaundryBuns.add(lblBerat);
        jpLaundryBuns.add(lblJenisParfum);
        jpLaundryBuns.add(lblTglPengembalian);
        jpLaundryBuns.add(txtNamaPelanggan);
        jpLaundryBuns.add(txtTglMasukLaundry);
        jpLaundryBuns.add(cboJenisLaundry);
        jpLaundryBuns.add(txtBerat);
        jpLaundryBuns.add(cboJenisParfum);
        jpLaundryBuns.add(txtTglPengembalian);
        
        jpLaundryBuns.add(btnTambah);
        jpLaundryBuns.add(btnUbah);
        jpLaundryBuns.add(btnHapus);
        jpLaundryBuns.add(btnBersih);
        
        //mengisi combo 
        cboJenisLaundry.addItem("Cuci Kering");
        cboJenisLaundry.addItem("Cuci Basah");
        cboJenisLaundry.addItem("Cuci Setrika");
        cboJenisLaundry.addItem("Sprei");
        cboJenisLaundry.addItem("Boneka");
        cboJenisLaundry.addItem("Selimut");
        
        cboJenisParfum.addItem("Cool");
        cboJenisParfum.addItem("Soft");
        cboJenisParfum.addItem("Classic");
        
        //mengatur objek agar dapat berinteraksi dengan user
        btnTambah.addActionListener(this);
        btnUbah.addActionListener(this);
        btnHapus.addActionListener(this);
        btnBersih.addActionListener(this);
        
        //menambahkan objek JPanel pada container frame
        getContentPane().add(jpLaundryBuns);
        //menampilkan tabel siswa ke komponen tabel
        TampilTabel();

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        //pengaturan Tabel
       
        skrTabel.getViewport().add(tabel);
        tabel.setEnabled(true);
        skrTabel.setBounds(15, 250, 470, 115);
       
        //menambahkan tabel pada panel
        jpLaundryBuns.add(skrTabel);
       
        
        //menambahkan objek JPanel pada container frame
        getContentPane().add(jpLaundryBuns);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TampilTabel();
    }
    public void actionPerformed(ActionEvent ae) {
        Object obj = ae.getSource();
        if (obj ==btnTambah){
            Tambah();
        }
        if (obj == btnUbah){
            Ubah();
        }
        if (obj == btnHapus){
            Hapus();
        }
        Bersih();
    }
    void Bersih(){
        txtNamaPelanggan.setText("");
        txtTglMasukLaundry.setText("");
        cboJenisLaundry.setSelectedIndex(0);
        txtBerat.setText("");
        cboJenisParfum.setSelectedIndex(0);
        txtTglPengembalian.setText("");
    }
    void Tambah(){
        try{
            MySQL ObjKoneksi = new MySQL();
            Connection con = ObjKoneksi.bukaKoneksi();
            Statement st = con.createStatement();
            String sql = "INSERT INTO `laundry`(`Nama Pelanggan`, `Tgl Masuk Laundry`, `Jenis Laundry`, `Berat`, `Jenis Parfum`, `Tgl Pengembalian`) VALUES('"
                    +txtNamaPelanggan.getText()+"','"+txtTglMasukLaundry.getText()
                    +"','"+cboJenisLaundry.getSelectedItem()+"','"+txtBerat.getText()
                    +"','"+cboJenisParfum.getSelectedItem()+"','"+txtTglPengembalian.getText()+"')";
            int row = st.executeUpdate(sql);
            if (row ==1){
                JOptionPane.showMessageDialog(null,"Data sudah ditambahkan ke" +
                        " database","infomasi",JOptionPane.INFORMATION_MESSAGE);
                
                con.close();
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Data tidak ditambahkan ke" +
                    " database","infomasi",JOptionPane.INFORMATION_MESSAGE);
        }
        TampilTabel(); 
    }
    void Ubah(){
        try{
            MySQL ObjKoneksi = new MySQL();
            Connection con = ObjKoneksi.bukaKoneksi();
            Statement st = con.createStatement();
           
            String sql = "UPDATE `laundry` SET `Tgl Masuk Laundry` = '"+txtTglMasukLaundry.getText()+"',`Jenis Laundry`='"+cboJenisLaundry.getSelectedItem()+
                    "',`Berat`='"+txtBerat.getText()+"',`Jenis Parfum`='"+cboJenisParfum.getSelectedItem()+
                    "',`Nama Pelanggan`='"+txtNamaPelanggan.getText()+
                    "' WHERE `Tgl Pengembalian` ='"+txtTglPengembalian.getText()+"' ";
           
             int row = st.executeUpdate(sql);
            if (row ==1){
                
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Data tidak diUbah"+
                    e.getMessage() ,"infomasi",JOptionPane.INFORMATION_MESSAGE);
        }
        TampilTabel();
        
    }
    void Hapus(){
         try{
            MySQL ObjKoneksi = new MySQL();
            Connection con = ObjKoneksi.bukaKoneksi();
            Statement st = con.createStatement();
            String sql = "DELETE FROM laundry WHERE `Nama Pelanggan` = '"+txtNamaPelanggan.getText()+"'";
            int row = st.executeUpdate(sql);
            if (row ==1){
                JOptionPane.showMessageDialog(null,"Data sudah dihapus dari " + " database","infomasi",JOptionPane.INFORMATION_MESSAGE);
                con.close();
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Data tidak dihapus","infomasi",JOptionPane.INFORMATION_MESSAGE);
        }
        TampilTabel();
    }
    void TampilTabel(){
       try {
            MySQL ObjKoneksi = new MySQL();
            Connection con = ObjKoneksi.bukaKoneksi();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM laundry";
            ResultSet set = st.executeQuery(sql);
            
            //menampilkan data ke Tabel
            ResultSetTableModel model = new ResultSetTableModel(set);
            tabel.setModel(model);
            while(set.next()){
                txtNamaPelanggan.setText(set.getString("Nama Pelanggan"));
                txtTglMasukLaundry.setText(set.getString("Tgl Masuk Laundry"));
                cboJenisLaundry.addItem(set.getString("Jenis Laundry"));
                txtBerat.setText(set.getString("Berat"));
                cboJenisParfum.addItem(set.getString("Jenis Parfum"));
                txtTglPengembalian.setText(set.getString("Tgl Pengembalian"));
            }
            System.out.print("query tampil");
        }
        catch(SQLException e) {
            System.out.println("gagal query");
        }
   } 
    

    public static void main (String[] args){
        new TabelLaundry();
    }
}


