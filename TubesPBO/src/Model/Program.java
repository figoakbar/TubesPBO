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
public class Program extends Kandidat{
    private String Visi;
    private String Misi;
    int no_urut;

    public Program(String Visi, String Misi, String Nama,String NIK, String no_urut) {
        super(Nama,no_urut,NIK);
        this.Visi = Visi;
        this.Misi = Misi;
    }

    public String getVisi() {
        return Visi;
    }

    public String getMisi() {
        return Misi;
    }
    
    
}
