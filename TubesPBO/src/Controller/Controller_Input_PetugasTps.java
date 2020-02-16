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
public class Controller_Input_PetugasTps extends MouseAdapter implements ActionListener {
    private Petugas petugas = null;
    private Database db = new Database();
    private Input_Petugas_Tps view = new Input_Petugas_Tps();
    private Input_Petugas viewInput = new Input_Petugas();
    Application model;

    public Controller_Input_PetugasTps(Petugas p) {
        this.petugas = p;
        view.resetView(p.getId_petugas(),p.getNama(),p.getNIK(),p.getTPS());
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
            String NIK = view.getLabelNIK();
            String id = view.getLabelID();
            String TPS = view.getSelectedTPS();
            Petugas p = new Petugas(id,Nama,NIK,TPS);
            
            db.connect();
            db.updatePetugasWithTPS(p);
            model.loadPetugas();
            model.loadTPS();
            view.setVisible(false);
            new Controller_Input_Petugas();    
            }
        }
        else
        {
            view.dispose();
            new Controller_Input_Petugas();
        }
        
    }
    
}
