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
public class ControllerPetugas_Edit extends MouseAdapter implements ActionListener {

    private Petugas petugas = null;
    private Database db = new Database();
    private Petugas_Edit gui = new Petugas_Edit();
    CRUD_Petugas view;
    
    Application model;

    public ControllerPetugas_Edit(Petugas p) {
        this.petugas = p;
        gui.resetView(p.getId_petugas(),p.getNama(),p.getNIK());
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
            String Id = gui.getLabelID();
            String NIK = gui.getTfNIK();
            Petugas p = new Petugas(Nama,NIK,Id);
            
            db.connect();
            db.updatePetugas(p);
            model.loadPetugas();
            gui.setVisible(false);
            new Controller_CRUD_Petugas();    
        }
        else
        {
            gui.dispose();
        }
        
    }
    
}
