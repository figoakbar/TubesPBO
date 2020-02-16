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

public class Controller_CRUD_TPS extends MouseAdapter implements ActionListener {
    CRUD_TPS view;
    TPS_Edit viewUpdate;
    Application model;
    Database db;
    TPS tps;
    
    public Controller_CRUD_TPS(){
        view = new CRUD_TPS();
        viewUpdate = new TPS_Edit();
        model = new Application();
        db = new Database();
        tps = new TPS("","");
        
        view.Listener(this);
        view.Adapter(this);
        view.setVisible(true);
        model.loadTPS();
        view.ResetView();
        view.setListTPS(model.getTPSListNoTPS());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object src = ae.getSource();
          
        if (src.equals(view.getAddTPS())){
            try{
                String Nama = view.getTFNama();
                String Alamat = view.getTFAlamat();
                TPS tps = new TPS(Nama,Alamat);
                model.addTPS(tps);
            }catch (Exception e){
                System.out.println(e);
            }
            view.ResetView();
            model.loadTPS();
            view.setListTPS(model.getTPSListNoTPS());
        }else if (src.equals(view.getBtnMenu())){
            new ControllerAdmin_Menu();
            view.dispose();
        }else if (src.equals(view.getEditTPS())){
            try{
                TPS tps = model.getTPS(view.getSelectedTPS()); 
                new ControllerTPS_Edit(tps);
            }catch(Exception x){
                JOptionPane.showMessageDialog(null, "Pilih data terlebih dahulu !");
                view.setVisible(true);
            }
        }else if (src.equals(view.getDeleteTPS())){
            int ok = JOptionPane.showConfirmDialog(null,"Apakah Yakin Mendelete record ini???", "Confirmation",JOptionPane.YES_NO_CANCEL_OPTION);
            if (ok==0){
                String NoTps = view.getSelectedTPS();   
                model.DeleteTPS(model.getTPS(NoTps));                
                view.ResetView();
                view.setListTPS(model.getTPSListNoTPS());
                JOptionPane.showMessageDialog(null, "Delete Data Sukses");
            }
        }
    }
    
    public void mousePressed(MouseEvent me){
        Object source = me.getSource();
        if(source.equals(view.getListTPS())){
            String NIK = view.getSelectedTPS();
            view.setTextTPS(model.searchTPS(NIK));
        }
    }
}
