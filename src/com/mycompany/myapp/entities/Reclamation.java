/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

import com.codename1.l10n.DateFormat;
import java.util.Date;



/**
 *
 * @author USER
 */
public class Reclamation {
    private int id ;
    private String title,subject ;
    private Date date ;
    private String consulter ;
    private Utilisateur user ;
    private Utilisateur Freelancer ;

    public Reclamation(int id, String title, String subject, Date date, String consulter, Utilisateur user, Utilisateur Freelancer) {
        this.id = id;
        this.title = title;
        this.subject = subject;
        this.date = date;
        this.consulter = consulter;
        this.user = user;
        this.Freelancer = Freelancer;
    }

    public Reclamation(String title, String subject, Date date, String consulter, Utilisateur user, Utilisateur Freelancer) {
        this.title = title;
        this.subject = subject;
        this.date = date;
        this.consulter = consulter;
        this.user = user;
        this.Freelancer = Freelancer;
    }

    public Reclamation(String subject) {
        this.subject = subject;
    }

    public Reclamation(int id, String title, String subject, Date date, String consulter) {
        this.id = id;
        this.title = title;
        this.subject = subject;
        this.date = date;
        this.consulter = consulter;
    }

    
    public Reclamation(String title, String subject) {
        this.title = title;
        this.subject = subject;
    }

    public Reclamation(int id, String title, String subject) {
        this.id = id;
        this.title = title;
        this.subject = subject;
    }
    
    
    public Reclamation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getConsulter() {
        return consulter;
    }

    public void setConsulter(String consulter) {
        this.consulter = consulter;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public Utilisateur getFreelancer() {
        return Freelancer;
    }

    public void setFreelancer(Utilisateur Freelancer) {
        this.Freelancer = Freelancer;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + ", title=" + title + ", subject=" + subject + ", date=" + date  + ", consulter=" + consulter + ", user=" + user + ", Freelancer=" + Freelancer + '}';
    }
    
    
    
    
}
