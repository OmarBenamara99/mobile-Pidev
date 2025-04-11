
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Reclamation;
import com.mycompany.myapp.services.serviceReclamation;
import java.util.ArrayList;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Offre;
import com.mycompany.myapp.services.serviceOffre;

/**
 *
 * @author USER
 */
public class ListOffr extends Form {
    public ListOffr(Form previous) {
        setTitle("List Des Offres");
        setLayout(BoxLayout.y());

        
        ArrayList<Offre> quizs = serviceOffre.getInstance().getAllOffre();

        for (Offre t : quizs) {
            addElement(t);
        }

        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());

    }
    
    
    
    public void addElement(Offre offr) {
        Button btn_up =new Button("Modifier")  ;
        btn_up.addActionListener(e-> new EditOffr(this,offr.getOffre_id()).show());
        Button btn_2 = new Button("Supprimer");
        btn_2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            Dialog dlg = new Dialog("Offre Supprimer");
            //dlg.show("Please wait...");
            boolean result = serviceOffre.getInstance().suppOffre(offr);
            if (result) {
                dlg.dispose();
                Dialog.show("Success", "Offre supprimé avec succès", "OK", null);
                refreshList();
            } else {
                dlg.dispose();
                Dialog.show("Error", "Erreur", "OK", null);
            }
        }
    });

    //Button btn = new Button(offr.getTitle());
    Label right = new Label("Service       :"+offr.getServiceN());
    Label right2 = new Label("Sous service :"+offr.getSous_serviceN());
    Label right3 = new Label("Adresse      :"+offr.getOffre_adresse());
    Label right4 = new Label("Description  :"+offr.getOffre_description());
    //Label right5 = new Label("Date         :"+offr.getOffre_date());
    Label right6 = new Label("Image        :"+offr.getOffre_image());
    /*btn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            // TODO: handle displaying Reclamation details
        }
    });*/

    addAll(right,right2,right3,right4,right6, btn_2,btn_up);
}

private void refreshList() {
    removeAll();
    ArrayList<Offre> quizs = serviceOffre.getInstance().getAllOffre();
    for (Offre t : quizs) {
        addElement(t);
    }
    revalidate();
}

}
