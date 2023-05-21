package gida.simulators.labs.first.entities;

import gida.simulators.labs.first.resources.Server;

//import gida.simulators.labs.first.behaviors.Behavior;

public class Medium extends Aircraft {

    //Behavior arrivalBehavior,Behavior endOfServiceBehavior
    public Medium(int id) {
        //arrivalBehavior,endOfServiceBehavior
        super(id);
    }

    @Override
    public Aircraft getNextAircraft() {
        Medium l = new  Medium(getId());
        return l;
    }

    @Override
    public void wearAway(Server server, double random) {
        double uniform;
        uniform=1+(4-1)*random;
        server.setWear(server.getWear() - uniform);
    }
    
}
