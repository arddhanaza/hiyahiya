/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbsensiMahasiswa;

/**
 *
 * @author Arddhana Zhafran
 */
//import com.mysql.jdbc.Connection;
import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 
import java.util.logging.Level;
import java.util.logging.Logger; 
import javax.swing.JOptionPane;

public class DbCon {
    public static Connection getConnection(){
        
        String conString = "jdbc:mysql://localhost/db_sisfoabsen";
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection)DriverManager.getConnection(conString,"root","");
            System.out.println("Koneksi Berhasil");
        }catch(ClassNotFoundException e){
            Logger.getLogger(DbCon.class.getName()).log(Level.SEVERE,null,e);
            System.out.println("Koneksi Gagal");
        }catch(SQLException e){
            Logger.getLogger(DbCon.class.getName()).log(Level.SEVERE,null,e);
            System.out.println("Koneksi Gagal");
        }
        return con;
    }
    
    public static int execute(String SQL){
        int status = 0;
        Connection con = getConnection();
        try{
            Statement st = con.createStatement();
            status = st.executeUpdate(SQL);
        }catch(SQLException e){
            Logger.getLogger(DbCon.class.getName()).log(Level.SEVERE,null,e);
        }
        return status;
    }
    
    public static ResultSet executeQuery(String SQL){
        ResultSet rs = null;
        Connection con = getConnection();
        try{
            Statement st = con.createStatement();
            rs = st.executeQuery(SQL);
        }catch(SQLException e){
            Logger.getLogger(DbCon.class.getName()).log(Level.SEVERE,null,e);
        }
        return rs;
    }
    
    static Object GetConnection(){
        throw new UnsupportedOperationException("Not Supported Yet");
    }
}
