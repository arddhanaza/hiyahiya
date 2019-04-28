/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbsensiMahasiswa;

import java.sql.ResultSet;
import java.sql.Time;
import javax.swing.JOptionPane;

/**
 *
 * @author Arddhana Zhafran
 */
public class MataKuliah {
    public int id_matakuliah;
    public int id_dosen;
    public int id_ruang;
    public String nama_matakuliah;
    public String jadwal_kuliah;
    public Time jam_kuliah;
    public Time jam_akhir;
    public int jadwal_int;
    public MataKuliah(){
        
    }
    
    public int get_id_matakuliah_by_id_ruang(int id_ruang){
        String SQL="SELECT id_matakuliah FROM tb_matakuliah WHERE id_ruang='"+id_ruang+"'";
        try{
            ResultSet rs = DbCon.executeQuery(SQL);    
            while(rs.next()){
                id_matakuliah = rs.getInt("id_matakuliah");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return id_matakuliah;
    }
    
    public Time get_jadwal_kuliah(int id_ruang){
        String SQL="SELECT * FROM tb_matakuliah WHERE id_ruang='"+id_ruang+"'";
        try{
            ResultSet rs = DbCon.executeQuery(SQL);    
            while(rs.next()){
                jam_kuliah = rs.getTime("jadwal_matakuliah");
                jam_akhir = rs.getTime("jam_akhir");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return jam_kuliah;
    }
    
    public void rubah_jam_jadwal(){
        jadwal_int = Integer.parseInt(jadwal_kuliah);
    }
}

