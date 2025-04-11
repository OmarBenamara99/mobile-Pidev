/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Reclamation;


import com.codename1.l10n.DateFormat;
import com.codename1.l10n.SimpleDateFormat;
import com.mycompany.myapp.entities.Utilisateur;
import com.mycompany.myapp.services.serviceReclamation;
import java.util.Date;

/**
 *
 * @author USER
 */
public class AddReclam extends Form{
    
    public AddReclam(Form previous) {
        setTitle("Add a new Reclamation");
        setLayout(BoxLayout.y());
        
        TextField tfTitre = new TextField("","Titre");
        TextField tfSubject = new TextField("","Subject");
        CheckBox cbStatus = new CheckBox("Status");
        Button btnValider = new Button("Add Reclam");
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();
        String formattedDate = dateFormat.format(currentDate);
        System.out.println(formattedDate);

        
        Utilisateur freelancer =new Utilisateur(81);
        Utilisateur user =new Utilisateur(126);
        
        btnValider.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent evt) {
        if ((tfTitre.getText().length()==0) || (tfSubject.getText().length()==0))
            Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
        else
        {
            try {
                Reclamation t = new Reclamation(tfTitre.getText().toString(),tfSubject.getText().toString());
                
                if( serviceReclamation.getInstance().addReclamtion(t)) {
                    Dialog.show("Success","Reclamation added",new Command("OK"));
                    System.out.println(t.toString());
                } else {
                    Dialog.show("ERROR", "Server error", new Command("OK"));
                }
            } catch (NumberFormatException e) {
                Dialog.show("ERROR", "Status must be a number", new Command("OK"));
            }

        }
    }
});

        
        addAll(tfTitre,tfSubject,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
                
    }
}
