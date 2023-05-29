package gida.simulators.labs.first.resources;

import java.util.List;

import gida.simulators.labs.first.policies.ServerQueuePolicy;

public class AirstripAux extends Airstrip {

    public AirstripAux(int id, List<Queue> queues, ServerQueuePolicy serverQueuePolicy) {
        super(id, queues, serverQueuePolicy,250);
    }

    public double porcentajeWear(){
        return (this.getWear() * 100)/250;
    }
    
}
