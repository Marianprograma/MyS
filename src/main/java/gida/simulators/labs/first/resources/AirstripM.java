package gida.simulators.labs.first.resources;

import java.util.List;

import gida.simulators.labs.first.policies.ServerQueuePolicy;

public class AirstripM extends Airstrip{


    public AirstripM(int id, List<Queue> queues, ServerQueuePolicy serverQueuePolicy) {
        super(id, queues, serverQueuePolicy,3000);
        
    }
    public double porcentajeWear(){
        return (this.getWear() * 100)/3000;
    }
    
}
