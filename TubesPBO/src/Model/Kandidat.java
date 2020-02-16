/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author user
 */
public class Kandidat extends Person {
    List<Program> DaftarProgram = new ArrayList();
    private String no_urut,Alamat,Visi,Misi;

    public Kandidat(String Nama, String no_urut, String NIK ) {
        super(Nama, NIK);
        this.no_urut = no_urut;
    }

    public Kandidat(String Nama, String no_urut, String NIK,String Visi,String Misi) {       
        super(Nama, NIK);
        this.no_urut = no_urut;
        this.Visi = Visi;
        this.Misi = Misi;
        System.out.println(Visi);
        System.out.println(Misi);
    }

    public String getNo_urut() {
        return no_urut;
    }

    public void setNo_urut(String no_urut) {
        this.no_urut = no_urut;
    }

    public String getVisi() {
        return Visi;
    }

    public String getMisi() {
        return Misi;
    }

    public void setVisi(String Visi) {
        this.Visi = Visi;
    }
    
    public void setMisi(String Misi) {
        this.Misi = Misi;
    }
        
    public String toString(){
        return " Nama : " + getNama() + "\n No Urut : " + no_urut + "\n NIK : " + getNIK();
    }
    
    public String toStringProgram(){
        return " Nama : " + getNama() + "\n No Urut : " + no_urut + "\n NIK : " + getNIK()+"\n Visi : " + getVisi() + "\n Misi : " + getMisi();
    }
}
