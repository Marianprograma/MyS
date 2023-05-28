package gida.simulators.labs.first.resources;

import java.util.List;

import gida.simulators.labs.first.policies.ServerQueuePolicy;

public class AirstripL extends Airstrip{

    public AirstripL(int id, List<Queue> queues, ServerQueuePolicy serverQueuePolicy) {
        super(id, queues, serverQueuePolicy,1000);
    }

    public double porcentajeWear(){
        return (this.getWear() * 100)/1000;
    }
    
    
}
