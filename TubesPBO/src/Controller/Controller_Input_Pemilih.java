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
public class Controller_Input_Pemilih extends MouseAdapter implements ActionListener {
    Input_Pemilih view;
    Application model;
    Database db;
    Pemilih pemilih;

    public Controller_Input_Pemilih() {
        db      = new Database();
        view    = new Input_Pemilih();
        pemilih = new Pemilih("","","","");
        model   = new Application();        
        view.Listener(this);
        view.Adapter(this);
        view.setVisible(true);
        model.loadPemilih();
        view.TampilTabel();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src.equals(view.inputBtn())){
            try {
            Pemilih p = model.getPemilih(view.getSelectedPemilih());
            view.setVisible(false);
            new Controller_Input_PemilihTps(p);
            } catch (Exception se) {
                JOptionPane.showMessageDialog(null, "Klik tabel terlebih dahulu");
                new Controller_Input_Pemilih();
                view.dispose();
            }
        } else if (src.equals(view.MenuBtnn())) {
            new ControllerAdmin_Menu();
            view.dispose();
        }
    }
}
