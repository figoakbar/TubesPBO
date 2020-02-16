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

public class ControllerPetugas_Login extends MouseAdapter implements ActionListener{
    Petugas_Login view;
    Application model;
    Petugas petugas;
    
    public ControllerPetugas_Login(){
        view = new Petugas_Login();
        model = new Application();
        petugas = new Petugas("","","","");
        model.loadPetugas();
        view.Listener(this);
        view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object src = ae.getSource();
        
        if (src.equals(view.getLoginPetugas())){
            String id = view.getuPetugas();
            petugas = model.getPetugas(id);
            if(petugas != null){
                new Controller_Petugas_Menu(petugas);
                view.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "ID salah");
            }
        }else if (src.equals(view.getHomeBtn())){
            new Controller_Home();
            view.dispose();
        }
    }
}
