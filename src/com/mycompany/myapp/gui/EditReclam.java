/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;


import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Reclamation;
import com.mycompany.myapp.services.serviceReclamation;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;


/**
 *
 * @author USER
 */
public class EditReclam extends Form {
    Reclamation r=new Reclamation() ;
     public EditReclam(Form previous ,int id) {
        System.out.println("alo");
          setTitle("Edit Reclam");
        setLayout(BoxLayout.y());
                 r = serviceReclamation.getInstance().getReclam(id);
                // int type = r.getTitle()  ;


         
        TextField tftt = new TextField(r.getTitle(),"Title");
          TextField tfsub = new TextField(r.getSubject(),"Subject");
//        ComboBox<String> combotype = new ComboBox<>() ; 
//        combotype.addItem("Choix Multiple")  ; 
//        combotype.addItem("Choix Unique"); 
//        if(type==1)
//        {
//            combotype.setSelectedItem("Choix Unique");
//        }
//        else if(type==2)
//        {
//                        combotype.setSelectedItem("Choix Multiple");
//
//        }
        
        Button btnValider = new Button("Update Reclam");
        
        
        
        //
        
                        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tftt.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        
                        Reclamation t = new Reclamation(id,tftt.getText().toString(),tfsub.getText().toString());
                        if( serviceReclamation.getInstance().uppReclamation(t))
                        {
                           Dialog.show("Success","Reclamation modifier",new Command("OK"));
                        }else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });

        
        //
        
        
        
        addAll(tftt,tfsub,btnValider)   ; 
        
                getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());

        
        
        
    }
    
}
