package gida.simulators.labs.first.entities;

import gida.simulators.labs.first.behaviors.Behavior;
import gida.simulators.labs.first.resources.Server;

//import gida.simulators.labs.first.events.Arrival;

public abstract class Aircraft extends Entity {
    Behavior arrivalBehavior;
    Behavior endOfServiceBehavior;
    
    //Fran agrego esto Behavior arrivalBehavior,Behavior endOfServiceBehavior como parametros
    public Aircraft(int id) {
        super(id);
        /*this.arrivalBehavior = arrivalBehavior;
        this.endOfServiceBehavior = endOfServiceBehavior;*/
    }

    public abstract Aircraft getNextAircraft();

    public abstract void wearAway(Server server,double random);

    @Override
    public String toString() {
        return "type: aircraft - id: " + this.getId();
    }
}
