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
public class Pemilihan {
    private Pemilih pemilih;
    private Kandidat pilihan;
    
    public Pemilihan(Pemilih pemilih, Kandidat pilihan){
        setPemilih(pemilih);
        setPilihan(pilihan);
    }

    public Pemilih getPemilih() {
        return pemilih;
    }

    public void setPemilih(Pemilih pemilih) {
        this.pemilih = pemilih;
    }

    public Kandidat getPilihan() {
        return pilihan;
    }

    public void setPilihan(Kandidat pilihan) {
        this.pilihan = pilihan;
    }
    
}
