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
public class Pemilih extends Person {
    private String Alamat,TPS;

    public Pemilih(String Nama, String NIK,String Alamat) {
        super(Nama,NIK);
        this.Alamat = Alamat;
    }
    
    public Pemilih(String Nama,String NIK,String Alamat,String TPS){
        super(Nama,NIK);
        this.Alamat = Alamat;
        this.TPS = TPS;
    }

    public String getTPS() {
        return TPS;
    }

    public void setTPS(String TPS) {
        this.TPS = TPS;
    }
    
    
    public String getAlamat() {
        return Alamat;
    }
    
    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
    }
    
    public String toString(){
        return "Nama : "+getNama()+"\nNIK : "+getNIK()+"\nAlamat :"+Alamat;
    }
    
    public String toStringAll(){
        return "Nama : "+getNama()+"\nNIK : "+getNIK()+"\nAlamat :"+Alamat+"\nTPS :"+getTPS();
    }
}
