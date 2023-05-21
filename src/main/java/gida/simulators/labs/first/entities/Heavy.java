package gida.simulators.labs.first.entities;

import gida.simulators.labs.first.resources.Server;

//import gida.simulators.labs.first.behaviors.Behavior;

public class Heavy extends Aircraft {

    //Behavior arrivalBehavior, Behavior endOfServiceBehavior
    public Heavy(int id) {
        //, arrivalBehavior, endOfServiceBehavior
        super(id);
    }

    @Override
    public Aircraft getNextAircraft() {
        Heavy l = new Heavy(getId());
        return l;
    }

    @Override
    public void wearAway(Server server, double random) {
        double uniform;
        uniform=3+(6-3)*random;
        server.setWear(server.getWear() - uniform);

    }
    
}
