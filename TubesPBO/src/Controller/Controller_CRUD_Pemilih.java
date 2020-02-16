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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Controller_CRUD_Pemilih extends MouseAdapter implements ActionListener {
    CRUD_Pemilih view;
    Pemilih_Edit viewUpdate;
    Application model;
    Database db;
    Pemilih pemilih;
    
    public Controller_CRUD_Pemilih(){
        view = new CRUD_Pemilih();
        viewUpdate = new Pemilih_Edit();
        model = new Application();
        db = new Database();
        pemilih = new Pemilih("","","","");
        
        view.Listener(this);
        view.Adapter(this);
        view.setVisible(true);
        model.loadPemilih();
        view.ResetView();
        view.setListPemilih(model.getPemilihListNik());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object src = ae.getSource();
          
        if (src.equals(view.getAddPemilih())){
            try{
                String Nama = view.getTFNama();
                String NIK = view.getTFNik();
                String Alamat = view.getTFAlamat();
                Pemilih pemilih = new Pemilih(Nama,NIK,Alamat);
                model.addPemilih(pemilih);
            }catch (Exception e){
                System.out.println(e);
            }
            view.ResetView();
            model.loadPemilih();
            view.setListPemilih(model.getPemilihListNik());
        }else if (src.equals(view.getBtnMenu())){
            new ControllerAdmin_Menu();
            view.dispose();
        }else if (src.equals(view.getEditPemilih())){
            try{
                Pemilih p = model.getPemilih(view.getSelectedPemilih());   
                new ControllerPemilih_Edit(p);
            }catch(Exception x){
                JOptionPane.showMessageDialog(null, "Pilih data terlebih dahulu !");
                view.setVisible(true);
            }
        }else if (src.equals(view.getDeletePemilih())){
            int ok = JOptionPane.showConfirmDialog(null,"Apakah Yakin Mendelete record ini???", "Confirmation",JOptionPane.YES_NO_CANCEL_OPTION);
            if (ok==0){
                String NIK = view.getSelectedPemilih();   
                model.DeletePemilih(model.getPemilih(NIK));                
                view.ResetView();
                view.setListPemilih(model.getPemilihListNik());
                JOptionPane.showMessageDialog(null, "Delete Data Sukses");
            }
        }
    }
    
    public void mousePressed(MouseEvent me){
        Object source = me.getSource();
        if(source.equals(view.getListPemilih())){
            String NIK = view.getSelectedPemilih();
            view.setTextPemilih(model.searchPemilih(NIK));
        }
    }
}
