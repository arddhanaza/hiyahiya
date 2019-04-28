/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbsensiMahasiswa;

import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Arddhana Zhafran
 */
public class Ruang {
    public String nama_ruang;
    public int id_ruang;
    
    public Ruang(){
        
    }
    public String get_nama_ruang_by_id(int id_rg){
        String SQL="SELECT * FROM tb_ruang WHERE id_ruang='"+id_rg+"'";
        try{
            ResultSet rs = DbCon.executeQuery(SQL);    
            while(rs.next()){
                id_ruang = id_rg;
                nama_ruang = rs.getString("nama_ruang");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return nama_ruang;
    }
}
