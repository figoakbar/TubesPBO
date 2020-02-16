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
public class ControllerPemilih_Edit extends MouseAdapter implements ActionListener {

    private Pemilih pemilih = null;
    private Database db = new Database();
    private Pemilih_Edit gui = new Pemilih_Edit();
    CRUD_Pemilih view;
    
    Application model;

    public ControllerPemilih_Edit(Pemilih p) {
        this.pemilih = p;
        gui.resetView(p.getNIK(),p.getNama(),p.getAlamat());
        model = new Application();
        gui.Listener(this);
        gui.setVisible(true);
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if(src.equals(gui.getDoneBtn()))
        {
            String Nama = gui.getTfNama();
            String NIK = gui.getLabelNIK();
            String Alamat = gui.getTfAlamat();
            Pemilih p = new Pemilih(Nama,NIK,Alamat);
            
            db.connect();
            db.updatePemilih(p);
            model.loadPemilih();
            gui.setVisible(false);
            new Controller_CRUD_Pemilih();
           
        }
        else
        {
            gui.dispose();
        }
        
    }
    
}
