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
public class ControllerKandidat_Edit extends MouseAdapter implements ActionListener {

    private Kandidat kandidat = null;
    private Database db = new Database();
    private Kandidat_Edit gui = new Kandidat_Edit();
    CRUD_Kandidat view;
    
    Application model;

    public ControllerKandidat_Edit(Kandidat k) {
        this.kandidat = k;
        gui.resetView(k.getNIK(),k.getNama(),k.getNo_urut());
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
            String NoUrut = gui.getTfNoUrut();
            Kandidat kandidat = new Kandidat(Nama,NoUrut,NIK);
            db.connect();
            db.updateKandidat(kandidat);
            model.loadKandidat();
            gui.setVisible(false);
            new Controller_CRUD_Kandidat();
           
        }
        else
        {
            gui.dispose();
        }
        
    }
    
}
