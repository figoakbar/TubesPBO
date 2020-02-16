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

public class Controller_USER extends MouseAdapter implements ActionListener {
    User view;
    Application model;
    
    public Controller_USER(){
        view = new User();
        model = new Application();
        model.loadTPS();
        view.Listener(this);
        view.setVisible(true);
        view.setCbTPS(model.getTPSListNoTPS());
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object src = ae.getSource();
        
        if (src.equals(view.getBack())){
            new Controller_Home();
            view.dispose();
        }else if (src.equals(view.getTampil())){
            String Tps = view.getSelectedCB();
            view.TampilTabel(Tps);
        }
        
    }
    
}
