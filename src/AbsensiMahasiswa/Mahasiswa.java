/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbsensiMahasiswa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Arddhana Zhafran
 */
public class Mahasiswa {
    public int id_mahasiswa;
    public String nama_mahasiswa;
    public String kelas_mahasiswa;
    public String nim_mahasiswa;
    public int id_matakuliah;
    public String nama_matakuliah;
    Ruang rg = new Ruang();
    public boolean cek,tes,status_jam;
    public int id_dosen;
    public Time waktu_sekarang;
    MataKuliah matkul = new MataKuliah();
    public Mahasiswa(){    
    
    }
    
    public boolean cek_data(String nim){
        String SQL="SELECT id_mahasiswa FROM tb_mahasiswa WHERE nim_mahasiswa='"+nim+"'";
        try{
            ResultSet rs = DbCon.executeQuery(SQL);    
            while(rs.next()){
                cek = true;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            cek = false;
        }
        
        return cek;
    }
    
    public boolean cek_matakuliah_mahasiswa(String nim,int id_rg){
        
        String SQL ="SELECT * FROM `tb_mahasiswa` "
                + "JOIN tb_matakuliah ON tb_mahasiswa.id_matakuliah = tb_matakuliah.id_matakuliah "
                + "WHERE nim_mahasiswa = '"+nim+"'";
        int id_ruang;
        try{
            ResultSet rs = DbCon.executeQuery(SQL);    
            while(rs.next()){
                id_dosen = rs.getInt("id_dosen");
                if(Integer.parseInt(rs.getString("id_ruang")) == id_rg){
                    tes = true;    
                }else{
                    nama_matakuliah = rs.getString("nama_matakuliah");
                    JOptionPane.showMessageDialog(null, "Error, Mahasiswa tidak terdaftar di Matakuliah'"+nama_matakuliah+"' Pada Ruang '"+id_rg+"'");
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            tes = false;
        }
        return tes;
    }
    public int get_id_mahasiswa_by_nim(String nim){
        String SQL="SELECT id_mahasiswa FROM tb_mahasiswa WHERE nim_mahasiswa='"+nim+"'";
        try{
            ResultSet rs = DbCon.executeQuery(SQL);    
            while(rs.next()){
                id_mahasiswa = rs.getInt("id_mahasiswa");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return id_mahasiswa;
    }
    
    public void get_data_mahasiswa(String nim){
        String SQL="SELECT * FROM tb_mahasiswa WHERE nim_mahasiswa='"+nim+"'";
        try{
            ResultSet rs = DbCon.executeQuery(SQL);    
            while(rs.next()){
                id_mahasiswa = rs.getInt("id_mahasiswa");
                nama_mahasiswa = rs.getString("nama_mahasiswa");
                kelas_mahasiswa = rs.getString("kelas_mahasiswa");
                nim_mahasiswa = rs.getString("nim_mahasiswa");
                id_matakuliah = rs.getInt("id_matakuliah");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }    
    }
    
    public boolean cek_jam_kuliah(String nim,int id_rg){
        matkul.get_jadwal_kuliah(id_rg);
        waktu_sekarang = Time.valueOf(java.time.LocalTime.now());
         String SQL ="SELECT * FROM `tb_mahasiswa` "
                + "JOIN tb_matakuliah ON tb_mahasiswa.id_matakuliah = tb_matakuliah.id_matakuliah "
                + "WHERE nim_mahasiswa = '"+nim+"'";
        int id_ruang;
        try{
            ResultSet rs = DbCon.executeQuery(SQL);    
            while(rs.next()){
                System.out.println(java.time.LocalTime.now());
                if(waktu_sekarang.compareTo(matkul.jam_kuliah) > 0 && waktu_sekarang.compareTo(matkul.jam_akhir) < 0){
                    status_jam = true;
                }else{
                    nama_matakuliah = rs.getString("nama_matakuliah");
                    JOptionPane.showMessageDialog(null, "Error, Mahasiswa tidak dapat mengabsen di Matakuliah'"+nama_matakuliah+"' karena belum memasuki waktu absensi");
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            status_jam = false;
        }
        return status_jam;
    }
}
