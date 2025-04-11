/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

import java.util.Date;

/**
 *
 * @author USER
 */
public class Reponse {
    private int id ;
    private String subject ;
    private Date date ;
    private int iduser ;
    private int idFreelancer;
    private Utilisateur user ;
    private Reclamation reclam ;

    public Reponse(int id, String subject, Date date, int iduser, int idFreelancer, Utilisateur user, Reclamation reclam) {
        this.id = id;
        this.subject = subject;
        this.date = date;
        this.iduser = iduser;
        this.idFreelancer = idFreelancer;
        this.user = user;
        this.reclam = reclam;
    }

    public Reponse(String subject, Date date, int iduser, int idFreelancer) {
        this.subject = subject;
        this.date = date;
        this.iduser = iduser;
        this.idFreelancer = idFreelancer;
    }

    public Reponse(int id, String subject) {
        this.id = id;
        this.subject = subject;
    }

    public Reponse(String subject) {
        this.subject = subject;
    }

    public Reponse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getIdFreelancer() {
        return idFreelancer;
    }

    public void setIdFreelancer(int idFreelancer) {
        this.idFreelancer = idFreelancer;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public Reclamation getReclam() {
        return reclam;
    }

    public void setReclam(Reclamation reclam) {
        this.reclam = reclam;
    }
    
    
}
