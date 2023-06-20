package gida.simulators.labs.first.policies;

import java.util.ArrayList;
import java.util.List;

import gida.simulators.labs.first.entities.Entity;
import gida.simulators.labs.first.entities.Heavy;
import gida.simulators.labs.first.entities.LightWeight;
import gida.simulators.labs.first.entities.Maintenance;
import gida.simulators.labs.first.entities.Medium;
import gida.simulators.labs.first.resources.Airstrip;
import gida.simulators.labs.first.resources.AirstripH;
import gida.simulators.labs.first.resources.AirstripL;
import gida.simulators.labs.first.resources.AirstripM;
import gida.simulators.labs.first.resources.Server;

public class MultipleServerSelectionPolicy implements ServerSelectionPolicy {

    public List<Server> filterType(List<Server> servers, Entity entity) {
        List<Server> servers2 = new ArrayList<>();

        if (entity.getClass() == LightWeight.class) {
            for (int i = 0; i < servers.size(); i++) {
                if (servers.get(i).getClass() == AirstripL.class){
                    servers2.add(servers.get(i));
                }
            }
        }else if (entity.getClass() == Medium.class) {
            for (int i = 0; i < servers.size(); i++) {
                if (servers.get(i).getClass() == AirstripM.class){
                    servers2.add(servers.get(i));
                }
            }
        }else if (entity.getClass() == Heavy.class) {
            for (int i = 0; i < servers.size(); i++) {
                if (servers.get(i).getClass() == AirstripH.class){
                    servers2.add(servers.get(i));
                }
            }
        }
        return servers2;
    }

    @Override
    public Server selectServer(List<Server> servers, Entity entity) {
        
        if (entity.getClass() != Maintenance.class){
            List<Server> sservers = filterType(servers, entity);
            int j,minQ=0,m=0;
            int i=0;
        
            for(i=0;i<sservers.size();i++){
                if(!sservers.get(i).isBusy()){
                    return sservers.get(i);
                }
            }
            for (j = 0; j < (sservers.size())-1; j++) {
                if (sservers.get(j).getCurrentEntity().getClass() != Maintenance.class){
                    if (sservers.get(minQ).getMaxSizeQueues() <= sservers.get(j+1).getMaxSizeQueues()){
                        minQ = j;
                    }else{
                        minQ = j+1;
                    }
                }else{
                    m+=1;
                }
            }
            if(m==sservers.size()){
                return servers.get(0);
            }else{
                return sservers.get(minQ);
            }
        }else {
                int var=0;
                for (int i = 0; i < servers.size()-1; i++) {
                    Airstrip a1 =  (Airstrip) servers.get(var);
                    Airstrip a2 = (Airstrip) servers.get(i+1);
                    if(a1.porcentajeWear() <= a2.porcentajeWear()){
                        var=i;
                    }else{
                        var=i+1;
                    }
                }
                return servers.get(var);
        }        
        //en caso de no tener sv selecciona el -1 del arreglo serverTipo, el cual devuelve el server aux, 
        //en muy pocos casos sucedera esto ya que nuestra politica y forma de programar las entidades no deja que se utilice.
    }
}

