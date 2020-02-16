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

public class Controller_Home extends MouseAdapter implements ActionListener{
    HOME view;
    
    public Controller_Home(){
        view = new HOME();
        view.Listener(this);
        view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object src = ae.getSource();
        
        if (src.equals(view.getAsPetugas())){
            new ControllerPetugas_Login();
            view.dispose();
        }
        else if (src.equals(view.getAsPemilih())){        
            new ControllerPemilih_Login();
            view.dispose();
        }
        else if (src.equals(view.getAsKandidat())){
            new ControllerKandidat_Login();
            view.dispose();
        }else if (src.equals(view.getAsAdmin())){
            new ControllerAdmin_Login();
            view.dispose();
        }else{
            new Controller_USER();
            view.dispose();
        } 
              
    }
}

    
    

