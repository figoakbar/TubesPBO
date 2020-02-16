/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Aldy
 */
import Model.*;
import View.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class ControllerKandidat_Login extends MouseAdapter implements ActionListener{
    Kandidat_Login view;
    Application model;
    Kandidat kandidat;
    
    public ControllerKandidat_Login(){
        view = new Kandidat_Login();
        model = new Application();
        kandidat = new Kandidat("","","","","");
        model.loadKandidat();
        view.Listener(this);
        view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object src = ae.getSource();
        
        if (src.equals(view.getHomeBtn())){
            new Controller_Home();
            view.dispose();
        }else if (src.equals(view.getLoginKandidat())){
            String kode = view.getNikKandidat();
            kandidat = model.getKandidat(kode);
            if(kandidat != null){
                new Controller_CRUD_Program(kandidat);
                view.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Nik salah");
            }
        }
    }
    
    
}
