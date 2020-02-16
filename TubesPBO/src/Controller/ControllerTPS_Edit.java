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
public class ControllerTPS_Edit extends MouseAdapter implements ActionListener {

    private TPS tps = null;
    private Database db = new Database();
    private TPS_Edit gui = new TPS_Edit();
    CRUD_TPS view;
    
    Application model;

    public ControllerTPS_Edit(TPS tps) {
        this.tps = tps;
        gui.resetView(tps.getTPS(),tps.getAlamat());
        model = new Application();
        gui.Listener(this);
        gui.setVisible(true);
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if(src.equals(gui.getDoneBtn()))
        {
            String NoTPS = gui.getLabelNoTPS();
            String Alamat = gui.getTfAlamat();
            TPS t = new TPS(NoTPS,Alamat);
            
            db.connect();
            db.updateTPS(t);
            model.loadTPS();
            gui.setVisible(false);
            new Controller_CRUD_TPS();
           
        }
        else
        {
            gui.dispose();
        }
        
    }
    
}
