package gida.simulators.labs.first.entities;

import gida.simulators.labs.first.resources.Server;
import gida.simulators.labs.first.utils.Randomizer;

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
    public void wearAway(Server server, Randomizer randomizer) {
        double uniform;
        uniform= randomizer.nextUniforme(3,6);
        server.setWear(server.getWear() - uniform);

    }
    
}
