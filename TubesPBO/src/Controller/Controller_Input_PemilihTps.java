/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Database.Database;
import Model.*;
import View.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
/**
 *
 * @author esber
 */
public class Controller_Input_PemilihTps extends MouseAdapter implements ActionListener {
    private Pemilih pemilih = null;
    private Database db = new Database();
    private Input_Pemilih_Tps view = new Input_Pemilih_Tps(); 
    Application model;

    public Controller_Input_PemilihTps(Pemilih p) {
        this.pemilih = p;
        view.resetView(p.getNama(),p.getNIK(),p.getAlamat(),p.getTPS());
        model = new Application();
        view.Listener(this);
        view.setVisible(true);
        model.loadTPS();
        view.setListTPS(model.getTPSListNoTPS());
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if(src.equals(view.getDoneBtn()))
        {
            int ok = JOptionPane.showConfirmDialog(null,"Apakah Yakin menginputkan ke tps ini???", "Confirmation",JOptionPane.YES_NO_CANCEL_OPTION);
            if (ok == 0){
            String Nama = view.getLabelNama();
            String NIK = view.getLabelNik();
            String Alamat = view.getLabelAlamat();
            String TPS = view.getSelectedTPS();
            Pemilih p = new Pemilih(Nama,NIK,Alamat,TPS);
            
            db.connect();
            db.updatePemilihWithTPS(p);
            model.loadPemilih();
            model.loadTPS();
            view.setVisible(false);
            new ControllerAdmin_Menu();    
            }
        }
        else
        {
            view.dispose();
            new Controller_Input_Pemilih();
        }
        
    }
    
}
