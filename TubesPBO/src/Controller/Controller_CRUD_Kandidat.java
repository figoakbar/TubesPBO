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
import Database.*;
import Model.*;
import View.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class Controller_CRUD_Kandidat extends MouseAdapter implements ActionListener{
    CRUD_Kandidat view;
    Application model;
    Database db;
    
    public Controller_CRUD_Kandidat(){
        view = new CRUD_Kandidat();
        model = new Application();
        db = new Database();
        
        view.Listener(this);
        view.Adapter(this);
        view.setVisible(true);
        model.loadKandidat();
        view.ResetView();
        view.setListKandidat(model.getKandidatListNIK());
    } 

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object src = ae.getSource();
        
        if (src.equals(view.getAddKandidat())){
            try{
                String Nama    = view.getTFNama();
                String no_urut = view.getTFNoUrut();
                String NIK     = view.getTFNik();
        
                Kandidat kandidat = new Kandidat(Nama,no_urut,NIK,"-","-");
                model.addKandidat(kandidat);
            }catch (Exception e){
                System.out.println(e);
            }
            view.ResetView();
            model.loadKandidat();
            view.setListKandidat(model.getKandidatListNIK());
        }else if (src.equals(view.getBtnMenu())){
            new ControllerAdmin_Menu();
            view.dispose();
        }else if (src.equals(view.getEditKandidat())){
            try{
                Kandidat kandidat = model.getKandidat(view.getSelectedKandidat());  
                new ControllerKandidat_Edit(kandidat);
            }catch(Exception x){
                JOptionPane.showMessageDialog(null, "Pilih data terlebih dahulu !");
                view.setVisible(true);
            }
        }else if (src.equals(view.getDeleteKandidat())){
            int ok = JOptionPane.showConfirmDialog(null,"Apakah Yakin Mendelete record ini???", "Confirmation",JOptionPane.YES_NO_CANCEL_OPTION);
            if (ok==0){
                String Id = view.getSelectedKandidat();   
                model.DeleteKandidat(model.getKandidat(Id));                
                view.ResetView();
                view.setListKandidat(model.getKandidatListNIK());
                JOptionPane.showMessageDialog(null, "Delete Data Sukses");
            }
            
        }
    }
    
    public void mousePressed (MouseEvent me){
        Object source = me.getSource();
        if(source.equals(view.getListKandidat())){
            String nik = view.getSelectedKandidat();
            view.setTextKandidat(model.searchKandidat(nik));
        }
    }
    
}