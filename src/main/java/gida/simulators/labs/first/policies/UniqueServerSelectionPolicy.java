package gida.simulators.labs.first.policies;

import java.util.List;

import gida.simulators.labs.first.entities.Entity;
import gida.simulators.labs.first.entities.Heavy;
import gida.simulators.labs.first.entities.LightWeight;
import gida.simulators.labs.first.entities.Medium;
import gida.simulators.labs.first.resources.AirstripL;
import gida.simulators.labs.first.resources.Server;

public class UniqueServerSelectionPolicy implements ServerSelectionPolicy {

    @Override
    public Server selectServer(List<Server> servers, Entity entity) {

        int serverTipo [] = new int[servers.size()];
        int j=0,i,minQ=0;

        if (entity.getClass() == LightWeight.class) {
            for (i = 0; i < servers.size(); i++) {
                if (servers.get(i).getClass() == AirstripL.class){
                    serverTipo[j] = i;
                    j++;
                }
            }
            for (i = 0; i < (serverTipo.length)-1; i++) {
                if (servers.get(serverTipo[minQ]).getMaxSizeQueues() <= servers.get(i+1).getMaxSizeQueues()){
                    minQ = i;
                }else{
                    minQ = i+1;
                }
            }
            //en que caso debe elegir a la aux

        } else if (entity.getClass() == Medium.class) {
            
        }else if (entity.getClass() == Heavy.class) {

        }else {
            
        }

        return servers.get(serverTipo[minQ]);
    }
    //Crear el algoritmo de la policy
}
