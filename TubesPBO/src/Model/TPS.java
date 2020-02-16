/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.*;

/**
 *
 * @author user
 */
public class TPS {
    private List<Pemilih> DPT;
    private List<Petugas> DaftarPPS;
    private String TPS;
    private String Alamat;
    
    public TPS(String TPS,String Alamat){
        setTPS(TPS);
        this.Alamat=Alamat;
        DaftarPPS = new ArrayList();
        DPT = new ArrayList();
    }
    
    
    public void addPPS(Petugas petugas){
        DaftarPPS.add(petugas);
    }
    
    public void addDPT(Pemilih pemilih){
        DPT.add(pemilih);
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
    }
    
    public String getTPS() {
        return TPS;
    }

    public void setTPS(String TPS) {
        if (TPS != "0" ){
            this.TPS = TPS;
        }
    }

    public Petugas getPetugas(String id_petugas) {
        for(Petugas p : DaftarPPS){
            if (p.getId_petugas() == id_petugas){
                return p;
            }
        }
        return null;
    }
    
    public Pemilih getPemilih (String NIK){
        for(Pemilih p : DPT){
            if(p.getNIK()==NIK){
                return p;
            }
        }
        return null;
    }
    
    public Pemilih getIndexPemilih(int index){
        return DPT.get(index);
    }
    
    public Petugas getIndexPetugas(int index){
        return DaftarPPS.get(index);
    }
    
    public int getJumlahPemilih(){
        return DPT.size();
    }
    
    public int getJumlahPetugas(){
        return DaftarPPS.size();
    }
    
    public String toString(){
        return "No TPs : "+TPS+"\n Alamat :"+Alamat;
    }
    
    
    
}
