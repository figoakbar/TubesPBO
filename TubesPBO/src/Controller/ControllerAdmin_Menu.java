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

import View.*;
import Model.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class ControllerAdmin_Menu extends MouseAdapter implements ActionListener{
    private Admin_Menu view;
    
    public ControllerAdmin_Menu(){
        view = new Admin_Menu();
        view.Listener(this);
        view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object src = ae.getSource();
        
        if (src.equals(view.getBtnHome())){
            new Controller_Home();
            view.dispose();
        }else if (src.equals(view.getCrudPemilih())){
            new Controller_CRUD_Pemilih();
            view.dispose();
        }else if (src.equals(view.getCrudPetugas())){
            new Controller_CRUD_Petugas();
            view.dispose();
        }else if (src.equals(view.getCrudKandidat())){
            new Controller_CRUD_Kandidat();
            view.dispose();
        }else if (src.equals(view.getCrudTps())){
            new Controller_CRUD_TPS();
        }else if(src.equals(view.getPemilihTps())){
            new Controller_Input_Pemilih();
            view.dispose();
        }else if(src.equals(view.getPetugasTPS())){
            new Controller_Input_Petugas();
            view.dispose();
        }
    }
}
