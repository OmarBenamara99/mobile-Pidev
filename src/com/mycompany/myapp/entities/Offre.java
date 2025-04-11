package com.mycompany.myapp.entities;

import java.util.Date;

public class Offre {
    private int Offre_id;
    private String Offre_adresse,Offre_description,Offre_image,ServiceN,Sous_serviceN;
    private Date Offre_date;
    private Services Service;
    private Sous_services Sous_service;
    private Utilisateur user;
    
    public Offre(String Offre_adresse, String Offre_description, String Offre_image, Date Offre_date, Services Service, Sous_services Sous_service, Utilisateur user) {
        this.Offre_adresse = Offre_adresse;
        this.Offre_description = Offre_description;
        this.Offre_image = Offre_image;
        this.Offre_date = Offre_date;
        this.Service = Service;
        this.Sous_service = Sous_service;
        this.user = user;
    }

    public Offre(int Offre_id, String Offre_adresse, String Offre_description, String Offre_image, Date Offre_date, Services Service, Sous_services Sous_service, Utilisateur user) {
        this.Offre_id = Offre_id;
        this.Offre_adresse = Offre_adresse;
        this.Offre_description = Offre_description;
        this.Offre_image = Offre_image;
        this.Offre_date = Offre_date;
        this.Service = Service;
        this.Sous_service = Sous_service;
        this.user = user;
    }

    public Offre(String Offre_adresse, String Offre_description, String Offre_image, String ServiceN, String Sous_serviceN) {
        this.Offre_adresse = Offre_adresse;
        this.Offre_description = Offre_description;
        this.Offre_image = Offre_image;
        this.ServiceN = ServiceN;
        this.Sous_serviceN = Sous_serviceN;
    }

    public Offre(String Offre_adresse, String Offre_description, String Offre_image, String ServiceN, String Sous_serviceN, Services Service, Sous_services Sous_service) {
        this.Offre_adresse = Offre_adresse;
        this.Offre_description = Offre_description;
        this.Offre_image = Offre_image;
        this.ServiceN = ServiceN;
        this.Sous_serviceN = Sous_serviceN;
        this.Service = Service;
        this.Sous_service = Sous_service;
    }

    public String getServiceN() {
        return ServiceN;
    }

    public void setServiceN(String ServiceN) {
        this.ServiceN = ServiceN;
    }

    public String getSous_serviceN() {
        return Sous_serviceN;
    }

    public void setSous_serviceN(String Sous_serviceN) {
        this.Sous_serviceN = Sous_serviceN;
    }

    public Offre(String Offre_adresse, String Offre_description, String Offre_image, String ServiceN, String Sous_serviceN, Date Offre_date, Utilisateur user) {
        this.Offre_adresse = Offre_adresse;
        this.Offre_description = Offre_description;
        this.Offre_image = Offre_image;
        this.ServiceN = ServiceN;
        this.Sous_serviceN = Sous_serviceN;
        this.Offre_date = Offre_date;
        this.user = user;
    }

    public Offre(int Offre_id, String Offre_adresse, String Offre_description, String Offre_image, String ServiceN, String Sous_serviceN, Date Offre_date, Utilisateur user) {
        this.Offre_id = Offre_id;
        this.Offre_adresse = Offre_adresse;
        this.Offre_description = Offre_description;
        this.Offre_image = Offre_image;
        this.ServiceN = ServiceN;
        this.Sous_serviceN = Sous_serviceN;
        this.Offre_date = Offre_date;
        this.user = user;
    }

    public Offre() {
    }

    @Override
    public String toString() {
        return "Offres{" + "Offre_id=" + Offre_id + ", Offre_adresse=" + Offre_adresse + ", Offre_description=" + Offre_description + ", Offre_image=" + Offre_image + ", ServiceN=" + ServiceN + ", Sous_serviceN=" + Sous_serviceN + ", Offre_date=" + Offre_date + ", Service=" + Service + ", Sous_service=" + Sous_service + ", user=" + user + '}';
    }


    public int getOffre_id() {
        return Offre_id;
    }

    public void setOffre_id(int Offre_id) {
        this.Offre_id = Offre_id;
    }

    public String getOffre_adresse() {
        return Offre_adresse;
    }

    public void setOffre_adresse(String Offre_adresse) {
        this.Offre_adresse = Offre_adresse;
    }

    public String getOffre_description() {
        return Offre_description;
    }

    public void setOffre_description(String Offre_description) {
        this.Offre_description = Offre_description;
    }

    public String getOffre_image() {
        return Offre_image;
    }

    public Offre(int Offre_id, String Offre_adresse, String Offre_description, String Offre_image, String ServiceN, String Sous_serviceN) {
        this.Offre_id = Offre_id;
        this.Offre_adresse = Offre_adresse;
        this.Offre_description = Offre_description;
        this.Offre_image = Offre_image;
        this.ServiceN = ServiceN;
        this.Sous_serviceN = Sous_serviceN;
    }

    public void setOffre_image(String Offre_image) {
        this.Offre_image = Offre_image;
    }

    public Date getOffre_date() {
        return Offre_date;
    }

    public void setOffre_date(Date Offre_date) {
        this.Offre_date = Offre_date;
    }

    public Services getService() {
        return Service;
    }

    public void setService(Services Service) {
        this.Service = Service;
    }

    public Sous_services getSous_service() {
        return Sous_service;
    }

    public void setSous_service(Sous_services Sous_service) {
        this.Sous_service = Sous_service;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }
    
}
