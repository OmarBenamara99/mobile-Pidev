
package com.mycompany.myapp.entities;


    public class Services {
    private int service_id ,nb_sous_services;
    private String service_nom,service_description,service_image;

    public Services() {
    }
public Services( int service_id) {
    this.service_id = service_id;
}
    public Services(String service_nom, String service_description, String service_image, int nb_sous_services) {
       
        this.nb_sous_services = nb_sous_services;
        this.service_nom = service_nom;
        this.service_description = service_description;
        this.service_image = service_image;
    }

    public Services(int service_id, String service_nom, String service_description, String service_image, int nb_sous_services) {
        this.service_id = service_id;
        this.nb_sous_services = nb_sous_services;
        this.service_nom = service_nom;
        this.service_description = service_description;
        this.service_image = service_image;
    }

    public int getService_id() {
        return service_id;
    }

   public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public int getNb_sous_services() {
        return nb_sous_services;
    }

    public void setNb_sous_services(int nb_sous_services) {
        this.nb_sous_services = nb_sous_services;
    }

    public String getService_nom() {
        return service_nom;
    }

    public void setService_nom(String service_nom) {
        this.service_nom = service_nom;
    }

    public String getService_description() {
        return service_description;
    }

    public void setService_description(String service_description) {
        this.service_description = service_description;
    }

    public String getService_image() {
        return service_image;
    }

    public void setService_image(String service_image) {
        this.service_image = service_image;
    }

    @Override
    public String toString() {
        return "Services{" + "service_id=" + service_id + ", nb_sous_services=" + nb_sous_services + ", service_nom=" + service_nom + ", service_description=" + service_description + ", service_image=" + service_image + '}';
    }

    

   
   
    
  

    
}
