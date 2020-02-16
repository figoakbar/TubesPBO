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

public class Controller_CRUD_Program extends MouseAdapter implements ActionListener{
    CRUD_Program view;
    Application model;
    Database db;
    Kandidat kandidat = null;
    
    public Controller_CRUD_Program(Kandidat k){
        view = new CRUD_Program();
        model = new Application();
        db = new Database();
        kandidat = k;
        
        view.Listener(this);
        view.setVisible(true);
        model.loadKandidat();
        view.ResetView(k.getNama());
        view.setTextKandidat(k.toStringProgram());
    } 

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object src = ae.getSource();
        if (src.equals(view.getAddKandidat())){
            Kandidat k = new Kandidat("","","","","");
            if (kandidat.getVisi().equals("-") || kandidat.getMisi().equals("-")){
                try{
                    String Nama    = view.getLabelNama();
                    String no_urut = kandidat.getNo_urut();
                    String NIK     = kandidat.getNIK();
                    String Visi    = view.getTFVisi();
                    String Misi    = view.getTFMisi();  
                    k = new Kandidat(Nama,no_urut,NIK,Visi,Misi);
                    db.connect();
                    db.updateKandidatWithProgram(k);
                }catch (Exception e){
                    System.out.println(e);
                }
                model.loadKandidat();
                view.setTextKandidat(k.toStringProgram());
                view.ResetView(k.getNama());
            }else{
                JOptionPane.showMessageDialog(null, "Maaf anda sudah menginput program,Silahkan Edit jika ingin merubah");
                view.dispose();
                view.ResetView(k.getNama());
                view.setVisible(true);
            }
        }else if (src.equals(view.getEditKandidat())){
            Kandidat k = new Kandidat("","","","","");
            try{
                String Nama    = view.getLabelNama();
                String no_urut = kandidat.getNo_urut();
                String NIK     = kandidat.getNIK();
                String Visi    = view.getTFVisi();
                String Misi    = view.getTFMisi();  
                k = new Kandidat(Nama,no_urut,NIK,Visi,Misi);
                db.connect();
                db.updateKandidatWithProgram(k);
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Terjadi Exception !");
                view.setVisible(true);
            }
            model.loadKandidat();
            System.out.println(k);
            view.setTextKandidat(k.toStringProgram());
            view.ResetView(k.getNama());
        }else if (src.equals(view.getDeleteKandidat())){
            int ok = JOptionPane.showConfirmDialog(null,"Apakah Yakin Mendelete Visi dan Misi ini???", "Confirmation",JOptionPane.YES_NO_CANCEL_OPTION);
            if (ok==0){
                Kandidat k = new Kandidat("","","","","");
                try{
                    String Nama    = view.getLabelNama();
                    String no_urut = kandidat.getNo_urut();
                    String NIK     = kandidat.getNIK();
                    String Visi    = "-";
                    String Misi    = "-";  
                    k = new Kandidat(Nama,no_urut,NIK,Visi,Misi);
                    db.connect();
                    db.updateKandidatWithProgram(k);
                }catch (Exception e){
                    System.out.println(e);
                }
                model.loadKandidat();
                System.out.println(k);
                view.setTextKandidat(k.toStringProgram());
                view.ResetView(k.getNama());
                JOptionPane.showMessageDialog(null, "Delete Data Sukses");
            } 
        }else if (src.equals(view.getBtnMenu())){
            new ControllerKandidat_Login();
            view.dispose();
        }
    }
    
    public void mousePressed (MouseEvent me){
        Object source = me.getSource();

    }
    
}