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
import Database.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.JOptionPane;

public class Controller_CRUD_Petugas extends MouseAdapter implements ActionListener{
    CRUD_Petugas view;
    Petugas_Edit viewUpdate;
    
    Application model;
    Database db;
    Petugas petugas;
    
    public Controller_CRUD_Petugas(){
        view = new CRUD_Petugas();
        viewUpdate = new Petugas_Edit();
        model = new Application();
        db = new Database();
        petugas = new Petugas("","","","");
        
        view.Listener(this);
        view.Adapter(this);
        view.setVisible(true);
        model.loadPetugas();
        view.ResetView();
        view.setListPetugas(model.getPetugasListId());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object src = ae.getSource();
          
        if (src.equals(view.getAddPetugas())){
            try{
                String Nama = view.getTFNama();
                String NIK = view.getTFNik();
                String ID = view.getTFID();
                Petugas petugas = new Petugas(Nama,NIK,ID);
                model.addPetugas(petugas);
            }catch(Exception e){
                System.out.println(e);
            }
            view.ResetView();
            model.loadPetugas();
            view.setListPetugas(model.getPetugasListId());
        }else if (src.equals(view.getBtnMenu())){
            new ControllerAdmin_Menu();
            view.dispose();
        }else if (src.equals(view.getEditPetugas())){
            try{
                Petugas p = model.getPetugas(view.getSelectedPetugas()); 
                new ControllerPetugas_Edit(p);
            }catch(Exception x){
                JOptionPane.showMessageDialog(null, "Pilih data terlebih dahulu");
                view.setVisible(true);
            }
        }else if (src.equals(view.getDeletePetugas())){
            int ok = JOptionPane.showConfirmDialog(null,"Apakah Yakin Mendelete record ini???", "Confirmation",JOptionPane.YES_NO_CANCEL_OPTION);
            if (ok==0){
                String Id = view.getSelectedPetugas();   
                model.DeletePetugas(model.getPetugas(Id));                
                view.ResetView();
                view.setListPetugas(model.getPetugasListId());
                JOptionPane.showMessageDialog(null, "Delete Data Sukses");
            }
            
        }
    }
    
    public void mousePressed(MouseEvent me){
        Object source = me.getSource();
        if(source.equals(view.getListPetugas())){
            view.setTextPetugas(model.searchPetugas(view.getSelectedPetugas()));
        }
    }
}
