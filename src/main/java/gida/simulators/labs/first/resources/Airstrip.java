package gida.simulators.labs.first.resources;

import java.util.List;
import gida.simulators.labs.first.policies.ServerQueuePolicy;

public abstract class Airstrip extends Server {
    private double wear;

    public double getWear() {
        return wear;
    }

    public void setWear(double wear) {
        this.wear = wear;
    }

    public Airstrip(int id, List<Queue> queues, ServerQueuePolicy serverQueuePolicy,double wear) {
        super(id,queues,serverQueuePolicy);
        this.wear = wear;
    }

    @Override
    public String toString() {
        String ret = super.toString();

        ret += "type: airstrip";

        return ret;
    }
}
