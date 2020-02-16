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

public class ControllerPemilih_Login extends MouseAdapter implements ActionListener{
    Pemilih_Login view;
    Application model;
    Pemilih pemilih;
    
    public ControllerPemilih_Login(){
        view = new Pemilih_Login();
        model = new Application();
        pemilih = new Pemilih("","","","");
        model.loadPemilih();
        view.Listener(this);
        view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object src = ae.getSource();
        
        if (src.equals(view.getHomeBtn())){
            new Controller_Home();
            view.dispose();
        }else if (src.equals(view.getL_Pemilih())){
            String kode = view.getTfNIK();
            pemilih = model.getPemilih(kode);
            if(pemilih != null){
                new Controller_Pemilih_Menu(pemilih);
                view.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Nik salah");
            }
        }
    }
}
