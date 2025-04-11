
package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Sous_services;
//import com.mycompany.utils.MyCnx;
import com.mycompany.myapp.utils.Statics;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class SousServicesService {
 
    public static SousServicesService instance = null;

    public static boolean resultOk = true;

    //initilisation connection request 
    private ConnectionRequest req;

    public static SousServicesService getInstance() {
        if (instance == null) {
            instance = new SousServicesService();
        }
        return instance;
    }

    public SousServicesService() {
        req = new ConnectionRequest();

    }

    
        public ArrayList<Sous_services> affichageServices(int id) {
        ArrayList<Sous_services> result = new ArrayList<>();

        String url = Statics.BASE_URL + "sousservicesJson/"+id;
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

                        Sous_services ser = new Sous_services();

                        float id = Float.parseFloat(obj.get("sousServiceId").toString());
                        String Nom = obj.get("sousServiceNom").toString();
                        String des = obj.get("sousServiceDescription").toString();
                        String img = obj.get("sousServiceImage").toString();
                        float idS = Float.parseFloat(obj.get("serviceId").toString());


                        ser.setSous_service_id((int)id );
                        ser.setSous_service_nom(Nom);
                        ser.setSous_service_description(des);
                        ser.setSous_service_image(img);
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
