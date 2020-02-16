/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

/**
 *
 * @author Aldy
 */
import Model.*;
import view.*;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class Database {
    private Connection con;
    private Statement stmt = null;
    private ResultSet rs = null;
    private Application model = null;

    public void connect(){
        try{
            String url = "jdbc:mysql://localhost:3306/db_pemilu";//Database kita
            String username = "root";
            String password = "";
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connect succes");
        }catch (SQLException se){
            System.out.println("Connect Error");
        }
    }

// Method Petugas..................................................................
  
    public void savePetugas(Petugas p){
        try{
            String query  ="insert into petugas values ('";
                   query += p.getNama()+"','";
                   query += p.getNIK()+"','";
                   query += p.getId_petugas()+"','";
                   query += "-"+"')";
            Statement s =con.createStatement();
            s.execute(query);
            System.out.println("Saving Succes");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ID tidak boleh sama");
        }
    }
    
    public void updatePetugas(Petugas p){
        try{
            String query = "UPDATE Petugas SET";
            query += " Nama ='" + p.getNama() + "',";
            query += " NIK = '"+ p.getNIK() + "'";
            query += " WHERE id ='" + p.getId_petugas() + "'";
            System.out.println(query);
            Statement s = con.createStatement();
            s.execute(query);
        } catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    public void updatePetugasWithTPS(Petugas p){
        try{
            String query = "UPDATE Petugas SET";
            query += " Nama ='" + p.getNama() + "',";
            query += " NIK = '"+ p.getNIK() + "',";
            query += " Tps = '"+ p.getTPS() + "'";
            query += " WHERE id ='" + p.getId_petugas() + "'";
            System.out.println(query);
            Statement s = con.createStatement();
            s.execute(query);
        } catch(SQLException ex){
            System.out.println(ex);
        }
    }

    public void delPetugas(Petugas p) {
        try {
            String query = "DELETE FROM petugas WHERE id ='" + p.getId_petugas() + "'";
            PreparedStatement st=con.prepareStatement(query);
            st.executeUpdate();
        }catch (SQLException ex){
            System.out.println("Error Delete");
        }
    }
    
    public Petugas loadOnePetugasById(String id){         
        try{             
            String query="select * from petugas where id = '"+id+"'" ;             
            Statement s=con.createStatement();             
            ResultSet rs=s.executeQuery(query);             
            Petugas p =null;             
            while (rs.next()){                 
                String Nama=rs.getString(1); 
                String NIK=rs.getString(2);
    
                p = new Petugas(Nama,NIK,id);             
            }             
            return p;         
        }catch(SQLException se){             
            return null;         
        }     
    }
    
    public ArrayList<Petugas> loadAllPetugas(){         
        try{             
            ArrayList<Petugas> petugasAll=new ArrayList();             
            String query="select * from petugas" ;             
            Statement s=con.createStatement();             
            ResultSet rs=s.executeQuery(query);             
            Petugas p;             
            while (rs.next()){                 
                String Nama=rs.getString(1);                 
                String NIK =rs.getString(2);                 
                String id_petugas  =rs.getString(3);
                String TPS = rs.getString(4);

                p = new Petugas(Nama,NIK,id_petugas);                
                petugasAll.add(p);             
            }             
            return petugasAll;         
        }catch(SQLException se){             
            return null;         
        }     
    } 
//.................................................................................

// Method Pemilih..................................................................
    public void savePemilih(Pemilih p){
        try{
            String query  ="insert into pemilih values ('";
                   query += p.getNama()+"','";
                   query += p.getNIK()+"','";
                   query += p.getAlamat()+"','";
                   query += "-"+"')";
            Statement s =con.createStatement();
            s.execute(query);
            System.out.println("Saving Succes");
        }catch(SQLException ex){
            System.out.println("Saving Error");
            JOptionPane.showMessageDialog(null, "NIK tidak boleh sama");
        }
    }
  
    public void updatePemilih(Pemilih p){
        try{
            String query = "UPDATE Pemilih SET";
            query += " Nama ='" + p.getNama() + "',";
            query += " Alamat = '"+ p.getAlamat() + "'";
            query += " WHERE NIK ='" + p.getNIK() + "'";
            System.out.println(query);
            Statement s = con.createStatement();
            s.execute(query);
        } catch(SQLException ex){
                    System.out.println(ex);
        }
    }
    
    public void updatePemilihWithTPS(Pemilih p){
        try{
            String query = "UPDATE Pemilih SET";
            query += " Nama ='" + p.getNama() + "',";
            query += " Alamat = '"+ p.getAlamat() + "',";
            query += " tps = '"+ p.getTPS() + "'";
            query += " WHERE NIK ='" + p.getNIK() + "'";
            System.out.println(query);
            Statement s = con.createStatement();
            s.execute(query);
        } catch(SQLException ex){
                    System.out.println(ex);
        }
    }

    public void delPemilih(Pemilih p) {
        try {
            String query = "DELETE FROM `pemilih` WHERE `NIK`='" + p.getNIK() + "'";
            PreparedStatement st=con.prepareStatement(query);
            st.executeUpdate();
        }catch (SQLException ex){
            System.out.println("Error Delete");
        }
    }
    
    public Pemilih loadOnePemilihByNIK(String NIK){         
        try{             
            String query="select * from pemilih where NIK ='"+NIK+"'" ;             
            Statement s=con.createStatement();             
            ResultSet rs=s.executeQuery(query);             
            Pemilih p =null;             
            while (rs.next()){                 
                String Nama=rs.getString(1); 
                String Alamat=rs.getString(3);
                p=new Pemilih(Nama,NIK,Alamat);             
            }             
            return p;         
        }catch(SQLException se){             
            return null;         
        }     
    }
    
    public ArrayList<Pemilih> loadAllPemilih(){         
        try{             
            ArrayList<Pemilih> pemilihAll =new ArrayList();             
            String query="select * from pemilih" ;             
            Statement s=con.createStatement();             
            ResultSet rs=s.executeQuery(query);             
            Pemilih p;             
            while (rs.next()){                 
                String Nama=rs.getString(1);                 
                String NIK=rs.getString(2);                 
                String Alamat=rs.getString(3);
                String Tps = rs.getString(4);
                p = new Pemilih(Nama,NIK,Alamat,Tps);                
                pemilihAll.add(p);             
            }             
            return pemilihAll;         
        }catch(SQLException se){             
            return null;         
        }     
    } 
    
//.................................................................................
    
    public void saveKandidat(Kandidat k){
        try{
            String query  = "insert into kandidat values ('";
                   query += k.getNama()+"','";
                   query += k.getNo_urut()+"','";
                   query += k.getNIK()+"','";
                   query += "-"+"','";
                   query += "-"+"')";
            Statement s = con.createStatement();
            s.execute(query);
            System.out.println("Saving Succes");
        }catch (SQLException ex) {
            System.out.println("Saving Error");
            JOptionPane.showMessageDialog(null, "NIK tidak boleh sama");
        }
    }
    
    public void updateKandidat(Kandidat k){
        try{
            String query = "UPDATE Kandidat SET";
            query += " Nama ='" + k.getNama() + "',";
            query += " No_Urut = '"+ k.getNo_urut() + "'";
            query += " WHERE NIK ='" + k.getNIK()+ "'";
            Statement s = con.createStatement();
            s.execute(query);
        } catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    public void updateKandidatWithProgram(Kandidat k){
        try{
            String query = "UPDATE Kandidat SET";
            query += " Nama      ='" + k.getNama() + "',";
            query += " No_Urut   ='" + k.getNo_urut() + "',";
            query += " Visi      ='" + k.getVisi() + "',";
            query += " Misi      ='" + k.getMisi() + "'";
            query += " WHERE NIK ='" + k.getNIK()+ "'";
            Statement s = con.createStatement();
            s.execute(query);
        } catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    public void delKandidat(Kandidat k) {
        try {
            String query = "DELETE FROM kandidat WHERE NIK ='" + k.getNIK() + "'";
            PreparedStatement st=con.prepareStatement(query);
            st.executeUpdate();
        }catch (SQLException ex){
            System.out.println("Error Delete");
        }
    }
    
    public Kandidat loadOneKandidatbyNik(String nik){         
        try{             
            String query="select * from kandidat where NIK ='"+nik+"'" ;             
            Statement s=con.createStatement();             
            ResultSet rs=s.executeQuery(query);             
            Kandidat p =null;             
            while (rs.next()){                 
                String Nama=rs.getString(1); 
                String no_urut=rs.getString(2);
                p=new Kandidat(Nama,no_urut,nik);             
            }             
            return p;         
        }catch(SQLException se){             
            return null;         
        }     
    }
    
    public Kandidat loadOneKandidatbyNoUrut(String NoUrut){         
        try{             
            String query="select * from kandidat where no_urut ='"+NoUrut+"'" ;             
            Statement s=con.createStatement();             
            ResultSet rs=s.executeQuery(query);             
            Kandidat p =null;             
            while (rs.next()){                 
                String Nama=rs.getString(1); 
                String nik=rs.getString(3);
                p=new Kandidat(Nama,NoUrut,nik);             
            }             
            return p;         
        }catch(SQLException se){             
            return null;         
        }     
    }
    
    public ArrayList<Kandidat> loadAllKandidat(){         
        try{             
            ArrayList<Kandidat> kandidatAll =new ArrayList();             
            String query="select * from kandidat" ;             
            Statement s=con.createStatement();             
            ResultSet rs=s.executeQuery(query);             
            Kandidat k;             
            while (rs.next()){                 
                String Nama=rs.getString(1);                 
                String no_urut=rs.getString(2);                 
                String NIK=rs.getString(3);
                String Visi = rs.getString(4);
                String Misi = rs.getString(5);
                k = new Kandidat(Nama,no_urut,NIK,Visi,Misi);                
                kandidatAll.add(k);             
            }             
            return kandidatAll;         
        }catch(SQLException se){             
            return null;         
        }     
    } 
 
//....................................................................................
    
//TPS.................................................................................
    
    public void saveTPS(TPS t){
        try{
            String query  = "insert into tps values ('";
                   query += t.getTPS()+"','";
                   query += t.getAlamat()+"')";
            Statement s = con.createStatement();
            s.execute(query);
            System.out.println("Saving Succes");
        }catch (SQLException ex) {
            System.out.println("Saving Error");
            JOptionPane.showMessageDialog(null, "No TPS tidak boleh sama");
        }
    }
    
    public void updateTPS(TPS t){
        try{
            String query = "UPDATE tps SET";
            query += " no_tps ='" + t.getTPS() + "',";
            query += " Alamat = '"+ t.getAlamat() + "'";
            query += " WHERE no_tps = '" + t.getTPS()+ "'";
            Statement s = con.createStatement();
            s.execute(query);
        } catch(SQLException ex){
            System.out.println(ex);
        }

    }

    public void delTPS(TPS t) {
        try {
            String query = "DELETE FROM tps WHERE no_tps ='" + t.getTPS() + "'";
            PreparedStatement st=con.prepareStatement(query);
            st.executeUpdate();
        }catch (SQLException ex){
            System.out.println("Error Delete");
        }
    }
    
    public TPS loadOneTPSbyNoTPS(String no_tps){         
        try{             
            String query="select * from tps where no_tps ='"+no_tps+"'" ;             
            Statement s=con.createStatement();             
            ResultSet rs=s.executeQuery(query);             
            TPS p =null;             
            while (rs.next()){                  
                String Alamat=rs.getString(2);
                p=new TPS(no_tps,Alamat);             
            }             
            return p;         
        }catch(SQLException se){             
            return null;         
        }     
    }
    
    public ArrayList<TPS> loadAllTPS(){         
        try{             
            ArrayList<TPS> tpsAll =new ArrayList();             
            String query="select * from tps" ;             
            Statement s=con.createStatement();             
            ResultSet rs=s.executeQuery(query);             
            TPS t;             
            while (rs.next()){                 
                String no_tps =rs.getString(1);                 
                String Alamat =rs.getString(2);                 
                t = new TPS(no_tps,Alamat);                
                tpsAll.add(t);             
            }             
            return tpsAll;         
        }catch(SQLException se){             
            return null;         
        }     
    } 
    
//....................................................................................
    
//Pemilihan...........................................................................
     public void savePemilihan(Pemilihan p){
        try{
            String query  = "insert into pemilihan values ('";
                   query += p.getPemilih().getNIK()+"','";
                   query += p.getPilihan().getNo_urut()+"','";
                   query += p.getPemilih().getTPS() +"')";
            Statement s = con.createStatement();
            s.execute(query);
            System.out.println("Saving Succes");
            JOptionPane.showMessageDialog(null, "Terimakasih Telah Memilih");
        }catch (SQLException ex) {
            System.out.println("Saving Error");
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "anda sudah memilih");
        }
    }
     
    public void delPemilihanByPemilih(Pemilih p) {
        try {
            String query = "DELETE FROM pemilihan WHERE Pemilih ='" + p.getNIK() + "'";
            PreparedStatement st=con.prepareStatement(query);
            st.executeUpdate();
        }catch (SQLException ex){
            System.out.println("Error Delete");
        }
    }
    
    public void delPemilihanByPilihan(Kandidat k) {
        try {
            String query = "DELETE FROM pemilihan WHERE Kandidat ='" + k.getNo_urut() + "'";
            PreparedStatement st=con.prepareStatement(query);
            st.executeUpdate();
        }catch (SQLException ex){
            System.out.println("Error Delete");
        }
    }
    
    public void delPemilihanByTPS(TPS t) {
        try {
            String query = "DELETE FROM pemilihan WHERE TPS ='" + t.getTPS() + "'";
            PreparedStatement st=con.prepareStatement(query);
            st.executeUpdate();
        }catch (SQLException ex){
            System.out.println("Error Delete");
        }
    }

    public ArrayList<Pemilihan> loadAllPemilihan(){         
        try{             
            ArrayList<Pemilihan> pemilihanAll =new ArrayList();             
            String query="select * from pemilihan" ;             
            Statement s=con.createStatement();             
            ResultSet rs=s.executeQuery(query);             
            Pemilih p = new Pemilih("","","","");
            Kandidat k = new Kandidat("","","","","");
            Pemilihan pm;             
            while (rs.next()){                 
                String nikPemilih =rs.getString(1);                 
                String noUrutPilihan =rs.getString(2);
                p = loadOnePemilihByNIK(nikPemilih);
                k = loadOneKandidatbyNoUrut(noUrutPilihan);
                pm = new Pemilihan(p,k);                
                pemilihanAll.add(pm);             
            }             
            return pemilihanAll;         
        }catch(SQLException se){             
            return null;         
        }     
    }
    
//....................................................................................
    
//PemilihanTerverifikasi..............................................................
     public void savePemilihanTerverifikasi(Pemilihan p){
        try{
            String query  = "insert into PemilihanTerverifikasi values ('";
                   query += p.getPemilih().getNIK()+"','";
                   query += p.getPilihan().getNo_urut()+"','";
                   query += p.getPemilih().getTPS() +"')";
            Statement s = con.createStatement();
            s.execute(query);
            System.out.println("Saving Succes");
            JOptionPane.showMessageDialog(null, "Verifikasi Berhasil");
        }catch (SQLException ex) {
            System.out.println("Saving Error");
            JOptionPane.showMessageDialog(null, "Data sudah Terverifikasi");
        }
    }

    public ArrayList<Pemilihan> loadAllPemilihanTerverifikasi(){         
        try{             
            ArrayList<Pemilihan> pemilihanTerverifikasiAll =new ArrayList();             
            String query="select * from PemilihanTerverifikasi" ;             
            Statement s=con.createStatement();             
            ResultSet rs=s.executeQuery(query);             
            Pemilih p = new Pemilih("","","","");
            Kandidat k = new Kandidat("","","","","");
            Pemilihan pm;             
            while (rs.next()){                 
                String nikPemilih =rs.getString(1);                 
                String noUrutPilihan =rs.getString(2);
                p = loadOnePemilihByNIK(nikPemilih);
                k = loadOneKandidatbyNoUrut(noUrutPilihan);
                pm = new Pemilihan(p,k);                
                pemilihanTerverifikasiAll.add(pm);             
            }             
            return pemilihanTerverifikasiAll;         
        }catch(SQLException se){             
            return null;         
        }     
    }
    
    public void delPemilihanVerifikasiByPemilih(Pemilih p) {
        try {
            String query = "DELETE FROM PemilihanTerverifikasi WHERE Pemilih ='" + p.getNIK() + "'";
            PreparedStatement st=con.prepareStatement(query);
            st.executeUpdate();
        }catch (SQLException ex){
            System.out.println("Error Delete");
        }
    }
    
    public void delPemilihanVerifikasiByPilihan(Kandidat k) {
        try {
            String query = "DELETE FROM PemilihanTerverifikasi WHERE Kandidat ='" + k.getNo_urut() + "'";
            PreparedStatement st=con.prepareStatement(query);
            st.executeUpdate();
        }catch (SQLException ex){
            System.out.println("Error Delete");
        }
    }
    
    public void delPemilihanVerifikasiByTPS(TPS t) {
        try {
            String query = "DELETE FROM PemilihanTerverifikasi WHERE TPS ='" + t.getTPS() + "'";
            PreparedStatement st=con.prepareStatement(query);
            st.executeUpdate();
        }catch (SQLException ex){
            System.out.println("Error Delete");
        }
    }

} 


