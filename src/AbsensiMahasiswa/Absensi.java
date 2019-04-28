/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbsensiMahasiswa;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Arddhana Zhafran
 */
public class Absensi {
    private int id_absensi,id_mahasiswa,id_ruang,id_matakuliah;
    private String waktu;
    Date date = new Date();
    public boolean cek;
    SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    public Absensi(int id_absensi, int id_mahasiswa, int id_ruang, int id_matakuliah, String waktu){
        this.id_absensi = id_absensi;
        this.id_mahasiswa = id_mahasiswa;
        this.id_ruang = id_ruang;
        this.id_matakuliah = id_matakuliah;
        this.waktu = waktu;
    }
    public Absensi(){
        
    }
    
    public boolean add_absensi(int id_mahasiswa, int id_dosen, int id_ruang, int id_matakuliah){
        
        String SQL="INSERT INTO tb_absensi(id_mahasiswa,id_dosen,id_ruang,id_matakuliah,waktu_absensi)"+
            "VALUES('"+id_mahasiswa+"','"+id_dosen+"','"+id_ruang+"','"+id_matakuliah+"','"+formater.format(date)+"')";
        try{
            int status=DbCon.execute(SQL);
            if (status==1) {
                JOptionPane.showMessageDialog(null, "Data berhasil disimpan","Sukses",JOptionPane.INFORMATION_MESSAGE);
                cek = true;
            }else{
                cek = false;
            }
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
            return cek;
    }
    public int get_idabsen(){
        return id_absensi;
    }
    
    public int get_idmahasiswa(){
        return id_mahasiswa;
    }
    
    public int get_idruang(){
        return id_ruang;
    }
    public int id_matakuliah(){
        return id_matakuliah;
    }
    
    public String waktu(){
        return waktu;
    }
}
