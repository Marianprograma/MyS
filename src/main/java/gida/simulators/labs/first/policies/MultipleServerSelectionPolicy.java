package gida.simulators.labs.first.policies;

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

    @Override
    public Server selectServer(List<Server> servers, Entity entity) {
        
        int serverTipo [] = new int[servers.size()];
        serverTipo[0] = -1;
        int j=0,i,minQ=0;

        if (entity.getClass() == LightWeight.class) {
            for (i = 0; i < servers.size(); i++) {
                if (servers.get(i).getClass() == AirstripL.class){
                    if(servers.get(i).getCurrentEntity().getClass() != Maintenance.class && servers.get(i).getQueues().get(i).isUsable()){
                        serverTipo[j] = i;
                        j++;
                    }
                }
            }
            if(serverTipo[0]<= 0){
                for (i = 0; i < (serverTipo.length)-1; i++) {
                    if (servers.get(serverTipo[minQ]).getMaxSizeQueues() <= servers.get(i+1).getMaxSizeQueues()){
                        minQ = i;
                    }else{
                        minQ = i+1;
                    }
                }
            }              
            //en caso de no tener sv selecciona el -1 del arreglo serverTipo, el cual devuelve el server aux, 
            //en muy pocos casos sucedera esto ya que nuestra politica y forma de programar las entidades no deja que se utilice.

        } else if (entity.getClass() == Medium.class) {
            for (i = 0; i < servers.size(); i++) {
                if (servers.get(i).getClass() == AirstripM.class){
                    if(servers.get(i).getCurrentEntity().getClass() != Maintenance.class && servers.get(i).getQueues().get(i).isUsable()){
                        serverTipo[j] = i;
                        j++;
                    }
                }
            }
            if(serverTipo[0]<= 0){
                for (i = 0; i < (serverTipo.length)-1; i++) {
                    if (servers.get(serverTipo[minQ]).getMaxSizeQueues() <= servers.get(i+1).getMaxSizeQueues()){
                        minQ = i;
                    }else{
                        minQ = i+1;
                    }
                }
            }  
            
        }else if (entity.getClass() == Heavy.class) {
            for (i = 0; i < servers.size(); i++) {
                if (servers.get(i).getClass() == AirstripH.class){
                    if(servers.get(i).getCurrentEntity().getClass() != Maintenance.class && servers.get(i).getQueues().get(i).isUsable()){
                        serverTipo[j] = i;
                        j++;
                    }
                }
            }
            if(serverTipo[0]<= 0){
                for (i = 0; i < (serverTipo.length)-1; i++) {
                    if (servers.get(serverTipo[minQ]).getMaxSizeQueues() <= servers.get(i+1).getMaxSizeQueues()){
                        minQ = i;
                    }else{
                        minQ = i+1;
                    }
                }
            }  

        }else {
            //mantenimiento
            int var=0;
            
            for (i = 0; i < serverTipo.length-1; i++) {
                Airstrip a1 =  (Airstrip) servers.get(var);
                Airstrip a2 = (Airstrip) servers.get(i+1);
                if(a1.porcentajeWear() >= a2.porcentajeWear()){
                    var=i;
                }else{
                    var=i+1;
                }
            }
            serverTipo[0] = var;
            
        }

        return servers.get(serverTipo[minQ]+1);
    }

    
}
