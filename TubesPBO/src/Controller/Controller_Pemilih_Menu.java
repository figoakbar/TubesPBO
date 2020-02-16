///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
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
public class Controller_Pemilih_Menu extends MouseAdapter implements ActionListener {
    Pemilih_Menu view;
    Application model;
    Database db;
    Pemilih pemilih = null;
    Pemilihan pemilihan = null;
    HOME viewMenu;

    public Controller_Pemilih_Menu(Pemilih p) {
        db        = new Database();
        view      = new Pemilih_Menu();
        viewMenu  = new HOME();
        pemilih = p;
        model   = new Application();        
        view.Listener(this);
        view.Adapter(this);
        view.setVisible(true);
        model.loadPemilih();
        model.loadKandidat();
        view.setTextPemilih(pemilih.toStringAll());
        view.ResetView("....");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src.equals(view.inputBtn())){
            try{
                Kandidat k = model.getKandidat(view.getSelectedKandidat());
                Pemilihan p = new Pemilihan(pemilih,k);
                model.addPemilihan(p);
                view.ResetView(k.getNama());
            } catch (Exception se) {
                JOptionPane.showMessageDialog(null, "Klik tabel terlebih dahulu");
                view.setVisible(true);
                view.ResetView("");
            }
            model.loadPemilihan();
        }
        if (src.equals(view.MenuBtn())) {
            new Controller_Home();
            view.dispose();
        }
    }
}
