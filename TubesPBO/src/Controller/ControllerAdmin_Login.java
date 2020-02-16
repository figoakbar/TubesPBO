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

public class ControllerAdmin_Login extends MouseAdapter implements ActionListener{
    Admin_Login view;
    Application model;
    
    public ControllerAdmin_Login(){
        view = new  Admin_Login();
        model = new Application();
        view.Listener(this);
        view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object src = ae.getSource();
        
        if (src.equals(view.getHomeBtn())){
            new Controller_Home();
            view.dispose();
        }else if (src.equals(view.getBtnLoginAdmin())){
            String user = view.getTf_uAdmin();
            String pass = view.getTf_pAdmin();
            if (user.equals(model.getUsername_admin()) && pass.equals(model.getPassword_admin())) {
                new ControllerAdmin_Menu();
                view.dispose();   
            }
            else 
            {
                JOptionPane.showMessageDialog(null, "Wrong Username / Password");
            }
        }
    }
}
