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
import gida.simulators.labs.first.resources.Queue;
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
        int j,minQ=0;
        int i=0;
        
        for(i=0;i<sservers.size();i++){
            if(!sservers.get(i).isBusy()){
                return sservers.get(i);
            }
        }

        List<Server> servers3 = obtenerPistasSinMantenimiento(sservers);
        if (servers3.size() == 0)
            return servers.get(0); // this one is the aux airstrip


        for (j = 0; j < (servers3.size())-1; j++) {
            if (servers3.get(minQ).getMaxSizeQueues() <= servers3.get(j+1).getMaxSizeQueues()){
                minQ = j;
            }else{
                minQ = j+1;
            }
        }
        return servers3.get(minQ);

        } else {
                Airstrip a1 =  (Airstrip) servers.get(1);
                double porcentajeMin=a1.porcentajeWear();
                int localice=1;
                for (int i = 2; i < servers.size()-1; i++) {
                    Airstrip a2 = (Airstrip) servers.get(i);
                    if(porcentajeMin > a2.porcentajeWear()){
                        localice=i;
                        porcentajeMin = a2.porcentajeWear();
                    }
                }
                return servers.get(localice);
        }
        //en caso de no tener sv selecciona el -1 del arreglo serverTipo, el cual devuelve el server aux, 
        //en muy pocos casos sucedera esto ya que nuestra politica y forma de programar las entidades no deja que se utilice.
    }

    private List<Server> obtenerPistasSinMantenimiento(List<Server> servers) {
        List<Server> ret = new ArrayList<>();

        for (Server s : servers) 
            if(!s.getCurrentEntity().getClass().getSimpleName().equals("Maintenance") && !estaMantenimientoEnCola(s))
                ret.add(s);
                
        return ret;
    }

    private boolean estaMantenimientoEnCola(Server s) {
        List<Queue> queues = s.getQueues();

        for (Queue q: queues) {
            if(!q.isUsable())
                return true;
        }

        return false;
    }
}

