package gida.simulators.labs.first.entities;

import gida.simulators.labs.first.behaviors.Behavior;

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
    

    @Override
    public Entity getNextEntity(){
        return getNextAircraft();
    }

    @Override
    public String toString() {
        return "type: aircraft - id: " + this.getId();
    }
}
