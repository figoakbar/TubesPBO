/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Aldy
 */

import java.util.*;
import Database.*;

public class Application {
    List<Petugas> listPetugas;
    List<Pemilih> listPemilih;
    List<Kandidat> listKandidat;
    List<Pemilihan> listPemilihan;
    List<Pemilihan> listPemilihanTerverifikasi;
    List<TPS> listTPS;
    Database db;
    
//login Admin......................................................................
    private String username_admin = "admin"; 
    private String password_admin = "admin";

    public String getUsername_admin() {
        return username_admin;
    }

    public String getPassword_admin() {
        return password_admin;
    }
//.................................................................................
    
    public Application(){
        listPetugas = new ArrayList();
        listPemilih = new ArrayList();
        listKandidat = new ArrayList();
        listPemilihan = new ArrayList();
        listPemilihanTerverifikasi = new ArrayList();
        listTPS = new ArrayList();
        
        db = new Database();
        db.connect();
    }

// Method Petugas..................................................................
    public void addPetugas(Petugas p){
        listPetugas.add(p);
        db.savePetugas(p);
    }
    
    public void DeletePetugas(Petugas p){
        listPetugas.remove(p);
        db.delPetugas(p);
    }
    
    public Petugas getPetugas(String id){
        Petugas petugas = null;
        for (int i = 0; i < listPetugas.size(); i++) {
            if(listPetugas.get(i).getId_petugas().equals(id) ){
                petugas = listPetugas.get(i);
            }
        }
        return petugas;    
    }
    
    public String searchPetugas(String id){
        return db.loadOnePetugasById(id).toString(); 
    }

    public String[] getPetugasListId(){
        String[] listId = new String[listPetugas.size()];
        for (int i=0; i < listPetugas.size(); i++){
            listId[i]=listPetugas.get(i).getId_petugas();
        }
        return listId;
    }
    
    public void loadPetugas(){     
        listPetugas = db.loadAllPetugas();
    } 
//.................................................................................
    
//Method Pemilih...................................................................
    public void addPemilih(Pemilih p){
        listPemilih.add(p);
        db.savePemilih(p);
    }
    
    public void DeletePemilih(Pemilih p){
        listPemilih.remove(p);
        db.delPemilih(p);
        db.delPemilihanByPemilih(p);
        db.delPemilihanVerifikasiByPemilih(p);
    }
    
    public Pemilih getPemilih(String NIK){
        Pemilih pemilih = null;
        for (int i = 0; i < listPemilih.size(); i++) {
            if(listPemilih.get(i).getNIK().equals(NIK)){
                pemilih = listPemilih.get(i);
            }
        }
        return pemilih;    
    }
    
    public Pemilih getPemilihbyNama(String Nama){
        Pemilih pemilih = null;
        for (int i = 0; i < listPemilih.size(); i++) {
            if(listPemilih.get(i).getNama().equals(Nama)){
                pemilih = listPemilih.get(i);
            }
        }
        return pemilih;    
    }
    
    public String searchPemilih(String NIK){
        return db.loadOnePemilihByNIK(NIK).toString();
    }
    
    public String[] getPemilihListNik(){
        String[] listNIK = new String[listPemilih.size()];
        for (int i = 0; i < listPemilih.size(); i++) {
            listNIK[i]=listPemilih.get(i).getNIK();
        }
        return listNIK;
    }
    
    public void loadPemilih(){
        listPemilih = db.loadAllPemilih();    
    }
    
//.................................................................................
//Method Kandidat...................................................................
    public void addKandidat (Kandidat k){
        listKandidat.add(k);
        db.saveKandidat(k);
    }
    
    public void DeleteKandidat(Kandidat k){
        listKandidat.remove(k);
        db.delKandidat(k);
        db.delPemilihanByPilihan(k);
        db.delPemilihanVerifikasiByPilihan(k);
    }
    
    public Kandidat getKandidat(String Nik){
        Kandidat kandidat = null;
        for (int i = 0; i < listKandidat.size(); i++) {
            if(listKandidat.get(i).getNIK().equals(Nik) ){
                kandidat = listKandidat.get(i);
            }
        }
        return kandidat;    
    }
    
    public Kandidat getKandidatbyNoUrut(String NoUrut){
        Kandidat kandidat = null;
        for (int i = 0; i < listKandidat.size(); i++) {
            if(listKandidat.get(i).getNo_urut().equals(NoUrut) ){
                kandidat = listKandidat.get(i);
            }
        }
        return kandidat;    
    }
    
    public String searchKandidat(String nik) {
        return db.loadOneKandidatbyNik(nik).toString();
    }
    
    public String searchKandidatProgram(String nik) {
        return db.loadOneKandidatbyNik(nik).toStringProgram();
    }
    
    public String[] getKandidatListNIK(){
        String[] listNIKkandidat = new String[listKandidat.size()];
        for (int i = 0; i < listKandidat.size(); i++) {
            listNIKkandidat[i]=listKandidat.get(i).getNIK();
        }
        return listNIKkandidat;
    }
    
    public void loadKandidat(){
        listKandidat = db.loadAllKandidat();    
    }
    
//Method TPS...................................................................
    public void addTPS (TPS t){
        listTPS.add(t);
        db.saveTPS(t);
    }
    
    public void DeleteTPS(TPS t){
        listTPS.remove(t);
        db.delTPS(t);
        db.delPemilihanByTPS(t);
        db.delPemilihanVerifikasiByTPS(t);
    }
    
    public TPS getTPS(String NoTPS){
        TPS tps = null;
        for (int i = 0; i < listTPS.size(); i++) {
            if(listTPS.get(i).getTPS().equals(NoTPS) ){
                tps = listTPS.get(i);
            }
        }
        return tps;    
    }
    
    public String searchTPS(String no_tps) {
        return db.loadOneTPSbyNoTPS(no_tps).toString();
    }
    
    public String[] getTPSListNoTPS(){
        String[] listNoTPS = new String[listTPS.size()];
        for (int i = 0; i < listTPS.size(); i++) {
            listNoTPS[i]=listTPS.get(i).getTPS();
        }
        return listNoTPS;
    }
    
    public void loadTPS(){
        listTPS = db.loadAllTPS();
        listPemilih = db.loadAllPemilih();
        listPetugas = db.loadAllPetugas();
    }
//.................................................................................
//Method Pemilihan.................................................................    
    
    public void addPemilihan(Pemilihan p){
        listPemilihan.add(p);
        db.savePemilihan(p);
    }
    
    public Pemilihan getPemilihan(String nikPemilih,String noUrutPilihan){
        Pemilihan pemilihan = null;
        for (int i = 0; i < listPemilihan.size(); i++) {
            if(listPemilihan.get(i).getPemilih().getNIK().equals(nikPemilih) && listPemilihan.get(i).getPilihan().getNo_urut().equals(noUrutPilihan)){
                pemilihan = listPemilihan.get(i);
            }
        }
        return pemilihan;    
    }
    
    public void loadPemilihan(){     
        listPemilihan = db.loadAllPemilihan();
    }
//.................................................................................
//Method PemilihanTerverifikasi....................................................    
    
    public void addPemilihanTerverifikasi(Pemilihan p){
        listPemilihanTerverifikasi.add(p);
        db.savePemilihanTerverifikasi(p);
    }
    
    public Pemilihan getPemilihanTerverifikasi(String nikPemilih,String noUrutPilihan){
        Pemilihan pemilihan = null;
        for (int i = 0; i < listPemilihanTerverifikasi.size(); i++) {
            if(listPemilihanTerverifikasi.get(i).getPemilih().getNIK().equals(nikPemilih) && 
               listPemilihanTerverifikasi.get(i).getPilihan().getNo_urut().equals(noUrutPilihan)){
                pemilihan = listPemilihanTerverifikasi.get(i);
            }
        }
        return pemilihan;    
    }
    
    public void loadPemilihanTerverifikasi(){     
        listPemilihanTerverifikasi = db.loadAllPemilihanTerverifikasi();
    }    
}
