package com.mycompany.myapp.entities;


public class Sous_services {

    private Services s = new Services();
    private int Sous_service_id, idFreelancer;
    private String Sous_service_nom, Sous_service_description, Sous_service_image;
    private Services services;
    private int Service_id ;

    public Sous_services() {
    }

    public Sous_services(int Sous_service_id, String Sous_service_nom, String Sous_service_description, String Sous_service_image, Services services, int idFreelancer) {
        this.Sous_service_id = Sous_service_id;
        this.services = services;
        this.Sous_service_nom = Sous_service_nom;
        this.Sous_service_description = Sous_service_description;
        this.Sous_service_image = Sous_service_image;
        this.idFreelancer = idFreelancer;

    }

    public Sous_services(int Sous_service_id, String Sous_service_nom, String Sous_service_description, String Sous_service_image) {
        this.Sous_service_id = Sous_service_id;
        this.Sous_service_nom = Sous_service_nom;
        this.Sous_service_description = Sous_service_description;
        this.Sous_service_image = Sous_service_image;
    }

    public Sous_services(String Sous_service_nom, String Sous_service_description, String Sous_service_image, Services services, int idFreelancer) {
        this.Sous_service_nom = Sous_service_nom;
        this.Sous_service_description = Sous_service_description;
        this.Sous_service_image = Sous_service_image;
        this.services = services;
        this.idFreelancer = idFreelancer;

    }
   

    public Sous_services(int id) {
        this.Sous_service_id = id;
    }


  
    public Services getS() {
        return s;
    }

    public void setS(Services s) {
        this.s = s;
    }

    public int getSous_service_id() {
        return Sous_service_id;
    }

    public void setSous_service_id(int Sous_service_id) {
        this.Sous_service_id = Sous_service_id;
    }

    public String getSous_service_nom() {
        return Sous_service_nom;
    }

    public void setSous_service_nom(String Sous_service_nom) {
        this.Sous_service_nom = Sous_service_nom;
    }

    public String getSous_service_description() {
        return Sous_service_description;
    }

    public void setSous_service_description(String Sous_service_description) {
        this.Sous_service_description = Sous_service_description;
    }

    public String getSous_service_image() {
        return Sous_service_image;
    }

    public void setSous_service_image(String Sous_service_image) {
        this.Sous_service_image = Sous_service_image;
    }

    public Services getService() {
        return services;
    }

    public void setService_id(Services services) {
        this.services = services;
    }

    public int getIdFreelancer() {
        return idFreelancer;
    }

    public void setIdFreelancer(int idFreelancer) {
        this.idFreelancer = idFreelancer;
    }

    @Override
    public String toString() {
        return "Sous_services{" + "s=" + s + ", Sous_service_id=" + Sous_service_id + ", idFreelancer=" + idFreelancer + ", Sous_service_nom=" + Sous_service_nom + ", Sous_service_description=" + Sous_service_description + ", Sous_service_image=" + Sous_service_image + ", services=" + services + '}';
    }

    

}
