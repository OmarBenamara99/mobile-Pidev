package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BoxLayout;

public class HomeForm extends Form {
    public HomeForm() {
        setTitle("Home");
        setLayout(BoxLayout.y());

        // Add side menu bar
        Toolbar tb = new Toolbar();
        setToolbar(tb);
        Command sideMenuCmd = new Command("Menu") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // Handle side menu bar command here
            }
        };
        tb.addCommandToSideMenu(sideMenuCmd);
         // add the label to the toolbar
    Button lblBack = new Button("Back");
    //lblBack.setUIID("Title");
    tb.addComponentToSideMenu(lblBack);
    lblBack.addActionListener(e -> new ListReclamBack(this).show());
    
    setToolbar(tb);

        // Add content to form
        add(new Label("Choose an option"));
        Button btnAddTask = new Button("Add Reclamation");
        Button btnListTasks = new Button("List Reclamation");
        Button btnListTaskss = new Button("Back");

        Button btnAddTaskoffre = new Button("Ajouter Offre");
        Button btnListTasksoffre  = new Button("Afficher Offre");
        
        btnAddTaskoffre .addActionListener(e-> new AddOffre(this).show());
        btnListTasksoffre .addActionListener(e-> new ListOffr(this).show());
        addAll(btnAddTaskoffre ,btnListTasksoffre );
        
        btnAddTask.addActionListener(e -> new AddReclam(this).show());
        btnListTasks.addActionListener(e -> new ListReclam(this).show());
        btnListTaskss.addActionListener(e -> new ListReclamBack(this).show());
        addAll(btnAddTask, btnListTasks);
    }
}
