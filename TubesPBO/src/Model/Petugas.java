/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author user
 */
public class Petugas extends Person{
    private String id_petugas,tps;
    
    public Petugas(String nama, String NIK, String id_petugas){
        super(nama,NIK);
        this.id_petugas = id_petugas;
    }
     
    public Petugas (String id_petugas,String nama, String NIK,String tps){
        super(nama,NIK);
        this.id_petugas = id_petugas;
        this.tps = tps;
    }
     
    public String getId_petugas() {
        return id_petugas;
    }

    public void setId_petugas(String id_petugas) {
        this.id_petugas = id_petugas;
    }
    
    public String getTPS() {
        return tps;
    }

    public void setTPS(String TPS) {
        this.tps = TPS;
    }
    
    @Override
    public String toString(){
        return "Nama : "+getNama()+"\nNIK:"+getNIK()+"\nID: "+id_petugas;
    }
    
    
    
}