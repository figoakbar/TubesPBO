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
public class Controller_Input_Petugas extends MouseAdapter implements ActionListener {
    Input_Petugas view;
    Application model;
    Database db;
    Petugas petugas;
    Admin_Menu viewMenu;

    public Controller_Input_Petugas() {
        db      = new Database();
        view    = new Input_Petugas();
        viewMenu= new Admin_Menu();
        petugas = new Petugas("","","","");
        model   = new Application();        
        view.Listener(this);
        view.Adapter(this);
        view.setVisible(true);
        model.loadPetugas();
        view.TampilTabel();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src.equals(view.inputBtn())){
            try{
            Petugas p = model.getPetugas(view.getSelectedPetugas());
            view.setVisible(false);
            new Controller_Input_PetugasTps(p);
            } catch (Exception se) {
                JOptionPane.showMessageDialog(null, "Klik tabel terlebih dahulu");
                new Controller_Input_Petugas();
                view.dispose();
            }
        } else if (src.equals(view.MenuBtn())) {
            new ControllerAdmin_Menu();
            view.dispose();
        }
    }
}
