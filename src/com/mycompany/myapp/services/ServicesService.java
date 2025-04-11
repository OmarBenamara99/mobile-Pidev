package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Services;
//import com.mycompany.utils.MyCnx;
import com.mycompany.myapp.utils.Statics;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class ServicesService {
    //singleton 

    public static ServicesService instance = null;

    public static boolean resultOk = true;

    //initilisation connection request 
    private ConnectionRequest req;

    public static ServicesService getInstance() {
        if (instance == null) {
            instance = new ServicesService();
        }
        return instance;
    }

    public ServicesService() {
        req = new ConnectionRequest();

    }

    //ajout 
    public boolean ajoutService(Services services) {
        try {

            String url = Statics.BASE_URL + "/addserviceJson?serN=" + services.getService_nom() + "&serD=" + services.getService_description()
                    + "&serI=" + services.getService_image() + "&serNb=" + services.getNb_sous_services();

            req.setUrl(url);
            req.addResponseListener((e) -> {

                String str = new String(req.getResponseData());
                System.out.println("data == " + str);
            });

            NetworkManager.getInstance().addToQueueAndWait(req);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean modifierService(int id, Services services) {
        try {
            String url = Statics.BASE_URL + "/editJson/" + id + "?&serN=" + services.getService_nom()
                    + "&serD=" + services.getService_description() + "&serNb=" + services.getNb_sous_services()
                    + "&serI=" + services.getService_image();
            req.setUrl(url);

            req.addResponseListener((e) -> {

                String str = new String(req.getResponseData());
                System.out.println("data == " + str);
            });

            NetworkManager.getInstance().addToQueueAndWait(req);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public Services findService(Services services) {
        String url = Statics.BASE_URL + "/findJson/" + services.getService_id();
        req.setHttpMethod("POST");
        req.setUrl(url);
        req.addArgument("serN", services.getService_nom());
        req.addArgument("serD", services.getService_description());
        req.addArgument("serNb", Integer.toString(services.getNb_sous_services()));
        req.addArgument("serI", services.getService_image());
        Services service = new Services(services.getService_id(), services.getService_nom(), services.getService_description(),
                services.getService_image(), services.getNb_sous_services());

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOk = req.getResponseCode() == 200;
                req.removeResponseListener(this);
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        if (resultOk) {
            return service;
        } else {
            return null;
        }
    }

    public boolean deleteService(int id) {
        String url = Statics.BASE_URL + "/deleteJson/" + id;

        req.setUrl(url);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                req.removeResponseCodeListener(this);
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOk;
    }

    public ArrayList<Services> affichageServices() {
        ArrayList<Services> result = new ArrayList<>();

        String url = Statics.BASE_URL + "servicesJson";
        req.setUrl(url);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp;
                jsonp = new JSONParser();

                try {
                    Map<String, Object> mapService = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));

                    List<Map<String, Object>> listOfMaps = (List<Map<String, Object>>) mapService.get("root");


                    for (Map<String, Object> obj : listOfMaps) {

                        Services ser = new Services();

                        float id = Float.parseFloat(obj.get("serviceId").toString());
                        String Nom = obj.get("serviceNom").toString();
                        String des = obj.get("serviceDescription").toString();
                        String img = obj.get("serviceImage").toString();


                        ser.setService_id((int)id );
                        ser.setService_nom(Nom);
                        ser.setService_description(des);
                        ser.setService_image(img);
                        ser.setNb_sous_services(65);
                        result.add(ser);

                    }

                } catch (Exception ex) {

                    ex.printStackTrace();
                }

            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);

        return result;

    }

}
