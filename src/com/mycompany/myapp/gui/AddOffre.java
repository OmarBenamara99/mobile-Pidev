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
import com.codename1.ui.ComboBox;
import com.codename1.ui.Display;
import com.codename1.ui.list.DefaultListModel;
import com.mycompany.myapp.entities.Offre;
import com.mycompany.myapp.entities.Services;
import com.mycompany.myapp.entities.Sous_services;
import com.mycompany.myapp.entities.Utilisateur;
import com.mycompany.myapp.services.ServicesService;
import com.mycompany.myapp.services.SousServicesService;
import com.mycompany.myapp.services.serviceOffre;
import com.mycompany.myapp.services.serviceReclamation;
import java.util.ArrayList;
import java.util.Date;
import com.opencsv.CSVReader;
import com.codename1.maps.Coord;
import com.codename1.ui.Display;



public class AddOffre extends Form {
    
    private ComboBox<String> sousServicesCombo;
    private static final String[] BAD_WORDS = {"bad1", "bad2", "bad3"};
    //private static String[] badWords;
    
    public AddOffre(Form previous)  {
        setTitle("Ajouter Offre");
        setLayout(BoxLayout.y());
        ArrayList<Services> servicesList = ServicesService.getInstance().affichageServices();
        String[] servicesNames = new String[servicesList.size()];
        for (int i = 0; i < servicesList.size(); i++) {
            servicesNames[i] = servicesList.get(i).getService_nom();
        }
        
        ComboBox<String> servicesCombo = new ComboBox<>(servicesNames);
        
        servicesCombo.addActionListener(e -> {
            String selectedServiceName = (String) servicesCombo.getSelectedItem();
            Services selectedService = null;
            
            // Find the selected service object based on its name
            for (Services service : servicesList) {
                if (service.getService_nom().equals(selectedServiceName)) {
                    selectedService = service;
                    break;
                }
            }
            
            ArrayList<Sous_services> sservicesList = SousServicesService.getInstance().affichageServices(selectedService.getService_id());
            String[] sservicesNames = new String[sservicesList.size()];
            for (int i = 0; i < sservicesList.size(); i++) {
                sservicesNames[i] = sservicesList.get(i).getSous_service_nom();
            }
            
            // Check if sousServicesCombo already exists
            if (sousServicesCombo == null) {
                sousServicesCombo = new ComboBox<>(new String[]{});
                //add(sousServicesCombo);
                addComponent(1, sousServicesCombo);
            }
            
            sousServicesCombo.setModel(new DefaultListModel<>(sservicesNames));
            revalidate();
        });
        
        TextField adressee = new TextField("", "Adresse");
        

        TextField descriptionn = new TextField("", "Description");
        TextField imagess = new TextField("", "Image");
        
        CheckBox cbStatus = new CheckBox("Status");
        Button btnValider = new Button("Ajouter");
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();
        String formattedDate = dateFormat.format(currentDate);
        System.out.println(formattedDate);
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((adressee.getText().length() == 0) || (descriptionn.getText().length() == 0) || (imagess.getText().length() == 0)) {
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                } else {
                    // Check for bad words in the address and description fields
                    boolean containsBadWords = false;
                    String address = adressee.getText().toLowerCase();
                    String desc = descriptionn.getText().toLowerCase();
                    for (String badWord : BAD_WORDS) {
                        if (address.contains(badWord) || desc.contains(badWord)) {
                            containsBadWords = true;
                            break;
                        }
                    }
                    if (containsBadWords) {
                        Dialog.show("Error", "Please remove any bad words from the address or description fields", new Command("OK"));
                    } else {

                    try {
                        String servicee = servicesCombo.getSelectedItem();
                        String sservicee = sousServicesCombo.getSelectedItem();
                        
                        
                        
                        Offre t = new Offre(adressee.getText().toString(), descriptionn.getText().toString(), imagess.getText().toString(), servicee, sservicee);
                        
                        if (serviceOffre.getInstance().addOffre(t)) {
                            Dialog.show("Success", "Offre Ajouter", new Command("OK"));
                            System.out.println(t.toString());
                        } else {
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                        }
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    }}
                }
            //}
        });
        
        addAll(servicesCombo,adressee,descriptionn,imagess,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
        
    }
}



