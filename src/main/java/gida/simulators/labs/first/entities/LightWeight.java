package gida.simulators.labs.first.entities;

import gida.simulators.labs.first.resources.Server;

//import gida.simulators.labs.first.behaviors.Behavior;

public class LightWeight extends Aircraft {

    //Fran agrego esto Behavior arrivalBehavior,Behavior endOfServiceBehavior como parametros
    public LightWeight(int id) {
        //arrivalBehavior,endOfServiceBehavior
        super(id);
    }

    @Override
    public Aircraft getNextAircraft() {
        LightWeight l = new LightWeight(getId());
        return l;
    }

    @Override
    public void wearAway(Server server, double random) {
        double uniform;
        uniform=random;
        server.setWear(server.getWear() - uniform);
    }
    
}
