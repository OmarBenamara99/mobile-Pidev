/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;

import com.mycompany.myapp.entities.Reclamation;
import com.mycompany.myapp.entities.Utilisateur;
import static com.mycompany.myapp.services.serviceReclamation.instance;
import com.mycompany.myapp.utils.Statics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 *
 * @author USER
 */
public class serviceReclamation {
    public ArrayList<Reclamation> reclam;
    public Reclamation rec ;
    
    public static serviceReclamation instance = null;
    public boolean resultOK;
    public ConnectionRequest req;
    
    private serviceReclamation() {
        req = new ConnectionRequest();
    }
    
            public static serviceReclamation getInstance() {
                if (instance == null) {
                    instance = new serviceReclamation();
                }
                return instance;
            }

            public boolean addReclamtion(Reclamation t) {
            try {
                String titre = t.getTitle();
            String subject =  t.getSubject() ;
                System.out.println(titre+" "+subject);
                            req.setPost(false);


            String url = Statics.BASE_URL + "ajouterreclamJsoon/81/94"+"?titre=" + titre + "&desc=" + subject;
            //String urll =  "http://127.0.0.1:8000/ajouterreclamJsoon/81"+"?titre=" + titre + "&desc=" + subject;
            //System.out.println(url);
            req.setUrl(url);
            System.out.println(req.getUrl());

            req.addResponseListener((e) -> {

                String str = new String(req.getResponseData());
                //System.out.println("data == " + str);
            });
            //req.onRedirect(url);
            NetworkManager.getInstance().addToQueueAndWait(req);

            return true;
        } catch (Exception e) {
            return false;
        }
        }

    
    
    public ArrayList<Reclamation> parseReclam(String jsonText) {
    try {
        reclam = new ArrayList<>();
        JSONParser j = new JSONParser();
        Map<String, Object> reclamListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
        System.out.println(reclamListJson);
        List<Map<String, Object>> list = (List<Map<String, Object>>) reclamListJson.get("root");
        System.out.println(list);
        for (Map<String, Object> obj : list) {
            Reclamation t = new Reclamation();
            System.out.println(obj);
            //t.setId(Integer.parseInt(obj.get("id").toString()));
            float id = Float.parseFloat(obj.get("id").toString());
                t.setId((int) id);
                if(obj.get("titre")==null){
                t.setTitle("ff");
                }else{
            t.setTitle(obj.get("titre").toString());
                }
                if(obj.get("sujet")==null){
                t.setSubject("null");
                }else{
            t.setSubject(obj.get("sujet").toString());}
                
                if((Date)obj.get("date")==null){
                t.setDate(null);
                }else{
            t.setDate((Date)obj.get("date"));}
                if(obj.get("consulter")==null){
                t.setConsulter("null");
                }else{
            t.setConsulter(obj.get("consulter").toString());}
            reclam.add(t);
        }
    } catch (IOException ex) {
        ex.printStackTrace();
    }
    return reclam;
}

    
    
    public ArrayList<Reclamation> getAllReclam() {
    String url = Statics.BASE_URL + "showreclamJSOONALLConsulter/";
    //req = new ConnectionRequest();
    req.setUrl(url);
    req.setPost(false);
    req.addResponseListener(new ActionListener<NetworkEvent>() {
        @Override
        public void actionPerformed(NetworkEvent evt) {
            reclam = parseReclam(new String(req.getResponseData()));
            req.removeResponseListener(this);
        }
    });
    NetworkManager.getInstance().addToQueueAndWait(req);
        return reclam;
    }

    
    public boolean suppReclamation(Reclamation t)
    {
        
         String url = Statics.BASE_URL + "supprimerreclamationJsoon/"+t.getId() ;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
             @Override
             public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);             }
         });
          NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
        
        
        
    }
    
    
    public Reclamation getReclam(int id) {
        
        String url = Statics.BASE_URL + "showreclamJSOONById/"+id+"/"   ;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                rec = parseReclambyid(new String(req.getResponseData()));

                req.removeResponseListener(this);
            }
        });
        
        
        NetworkManager.getInstance().addToQueueAndWait(req);
        
        
        return rec;
        
        
    }
    
    
    public Reclamation parseReclambyid(String jsonText) {
        try {
           System.out.println("aloo 2 ");

            rec = new Reclamation();
           System.out.println("aloo 3");

            JSONParser j = new JSONParser();
             System.out.println("aloo 4");

            Map<String, Object> reclamListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            System.out.println(reclamListJson.values()+"cjfkf,kfffffffff");
            List<Map<String, Object>> list = (List<Map<String, Object>>) reclamListJson.get("root");
        System.out.println(list);     

             for (Map<String, Object> obj : list) {
                float id = Float.parseFloat(obj.get("id").toString());
                rec.setId((int) id);
//                if (Float.parseFloat(list.get("id").toString())==0) 
//                {
//                    rec.setId(0); 
//                    System.out.println("yaya aaaaaaaaanooooooooo");
//                } 
//                else 
//                {
//                   float id = Float.parseFloat(reclamListJson.get("id").toString());
//                   System.out.println("yaya aaaaaaaaa");
//                 
//
//                rec.setId((int) id);
//                 }
                
                if (obj.get("titre") == null) 
                {
                    rec.setTitle("null"); 
                } 
                else 
                {
                   rec.setTitle(obj.get("titre").toString())        ;
                 }
              
                    if(obj.get("sujet")==null){
                
                    rec.setSubject("null"); }
                    
                    else {
                        rec.setSubject(obj.get("sujet").toString());}
                    if(obj.get("date_reclamation")==null){
                
                    rec.setSubject("null"); }
                    
                    else {
                        //System.out.println((Date)obj.get("date_reclamation")+"mmmmmmmmmmmmmmmmmmmmmm");
                        //rec.setDate((Date)obj.get("date_reclamation"));
                    }
                    
                    
             }
             
        } catch (IOException ex) {
                 System.out.println("errrrrrrrrr");
        }
        

        
        return rec ;
    } 
    
    public boolean uppReclamation(Reclamation t) {

        String titre = t.getTitle();
        String subject =  t.getSubject() ;
        
        //String url = Statics.BASE_URL + "create?name=" + t.getName() + "&status=" + t.getStatus();
        String url = Statics.BASE_URL + "modifreclamJsoon/"+t.getId()+"?titre=" + titre + "&desc=" + subject ;

        req.setUrl(url);
        req.setPost(false);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    
    
    public ArrayList<Reclamation> getReclamById(int id) {
    String url = Statics.BASE_URL + "showreclamJSOONById/"+id+"/"   ;
    //req = new ConnectionRequest();
    req.setUrl(url);
    req.setPost(false);
    req.addResponseListener(new ActionListener<NetworkEvent>() {
        @Override
        public void actionPerformed(NetworkEvent evt) {
            reclam = parseReclam(new String(req.getResponseData()));
            req.removeResponseListener(this);
        }
    });
    NetworkManager.getInstance().addToQueueAndWait(req);
        return reclam;
    }
}
