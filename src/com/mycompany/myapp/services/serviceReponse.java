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
import com.mycompany.myapp.entities.Reponse;
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
public class serviceReponse {
    public ArrayList<Reponse> reclam;
    public Reponse rec ;
    
    public static serviceReponse instance = null;
    public boolean resultOK;
    public ConnectionRequest req;
    
    private serviceReponse() {
        req = new ConnectionRequest();
    }
    
            public static serviceReponse getInstance() {
                if (instance == null) {
                    instance = new serviceReponse();
                }
                return instance;
            }
            
            public boolean addReclamtion(Reponse t) {
            try {
                
            String subject =  t.getSubject() ;
                System.out.println(subject);
                            req.setPost(false);


            String url = Statics.BASE_URL + "reponse/ajouterreponseJson/"+t.getId()+"?desc=" + subject;
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
            
            public ArrayList<Reponse> parseReponse(String jsonText) {
    try {
        reclam = new ArrayList<>();
        JSONParser j = new JSONParser();
        Map<String, Object> repListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
        System.out.println(repListJson);
        List<Map<String, Object>> list = (List<Map<String, Object>>) repListJson.get("root");
        System.out.println(list);
        for (Map<String, Object> obj : list) {
            Reponse t = new Reponse();
            System.out.println(obj+"_____________________");
            //t.setId(Integer.parseInt(obj.get("id").toString()));
            float id = Float.parseFloat(obj.get("id").toString());
                t.setId((int) id);
                if(obj.get("Disc")==null){
                t.setSubject("null");
                }else{
            t.setSubject(obj.get("Disc").toString());}
                
                if((Date)obj.get("date")==null){
                t.setDate(null);
                }else{
            t.setDate((Date)obj.get("date"));}
            reclam.add(t);
        }
    } catch (IOException ex) {
        ex.printStackTrace();
    }
    return reclam;
}

    
    
    public ArrayList<Reponse> getAllReponse() {
    String url = Statics.BASE_URL + "reponse/showreponseJSON/";
    //req = new ConnectionRequest();
    req.setUrl(url);
    req.setPost(false);
    req.addResponseListener(new ActionListener<NetworkEvent>() {
        @Override
        public void actionPerformed(NetworkEvent evt) {
            reclam = parseReponse(new String(req.getResponseData()));
            req.removeResponseListener(this);
        }
    });
    NetworkManager.getInstance().addToQueueAndWait(req);
        return reclam;
    }

    
    public boolean suppReponse(Reponse t)
    {
        
         String url = Statics.BASE_URL + "reponse/supprimerreponseJson/"+t.getId() ;
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
}
