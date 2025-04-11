/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Reclamation;
import com.mycompany.myapp.services.serviceReclamation;

/**
 *
 * @author USER
 */
public class ViewReclam extends Form {
    Reclamation r=new Reclamation() ;
     public ViewReclam(Form previous ,int id) {
        //System.out.println("alo");
          
                 r = serviceReclamation.getInstance().getReclam(id);
                // int type = r.getTitle()  ;
                System.out.println(r);
setTitle("Reclamation"); //+r.getUser().getId()
        setLayout(BoxLayout.y());

         
        TextField tftt = new TextField(r.getTitle(),"Title");
          TextField tfsub = new TextField(r.getSubject(),"Subject");
          
          Label right = new Label("titre :"+r.getTitle());
           Label right2 = new Label("subject :"+r.getSubject());
           Label right3 = new Label("subject :"+r.getDate());
           System.out.println(r.getDate()+"wwwwwwwwwwwwwwwwwwwwwwww");
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
                           Dialog.show("Success","Connection accepted",new Command("OK"));
                        }else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });

        
        //
        
        
        
        addAll(right,right2)   ; 
        
                getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());

        
        
        
    }
}
