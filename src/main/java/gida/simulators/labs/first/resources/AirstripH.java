package gida.simulators.labs.first.resources;

import java.util.List;

import gida.simulators.labs.first.policies.ServerQueuePolicy;

public class AirstripH extends Airstrip {

    public AirstripH(int id, List<Queue> queues, ServerQueuePolicy serverQueuePolicy) {
        super(id, queues, serverQueuePolicy,5000);
    }

    
    
}
