package gida.simulators.labs.first.events;

import java.util.List;

//import gida.simulators.labs.first.behaviors.ArrivalBehavior;
import gida.simulators.labs.first.behaviors.Behavior;
import gida.simulators.labs.first.behaviors.EndOfServiceBehavior;
import gida.simulators.labs.first.engine.CustomReport;
import gida.simulators.labs.first.engine.FutureEventList;
import gida.simulators.labs.first.engine.Reportable;
import gida.simulators.labs.first.entities.Aircraft;
import gida.simulators.labs.first.entities.Entity;
import gida.simulators.labs.first.policies.ServerSelectionPolicy;
import gida.simulators.labs.first.resources.Server;

public class Arrival extends Event {

    private ServerSelectionPolicy policy;
    private EndOfServiceBehavior endOfServiceBehavior;

    public Arrival(double clock, Entity entity, Behavior behavior,
            EndOfServiceBehavior endOfServiceBehavior, ServerSelectionPolicy policy) {
                super(clock, entity, behavior, 2);
                this.policy = policy;
                this.endOfServiceBehavior = endOfServiceBehavior;
    }

    @Override
    public void planificate(FutureEventList fel, List<Server> servers,Reportable report) {
        //Seleccionar el sv
        Server servidor = policy.selectServer(servers);

        if(servidor.isBusy()){
            servidor.enqueue(this.getEntity());
            ((CustomReport)report).setMaxSize(servidor.getMaxSizeQueues());
            //analytical
            servidor.setIdleTimeStartMark(0);
            servidor.setIdleTimeFinishedMark(0);
        }else{
            servidor.setCurrentEntity(this.getEntity());
            this.getEntity().setServer(servidor);
            Event eos = new EndOfService(this.getClock() + this.endOfServiceBehavior.nextTime(), this.getEntity(), this.endOfServiceBehavior);
            fel.insert(eos);
            //analytical
            servidor.setIdleTimeFinishedMark(this.getClock());
            servidor.setIdleTime(servidor.getIdleTimeFinishedMark()-servidor.getIdleTimeStartMark());
            if(servidor.getIdleTime()>((CustomReport)report).getMaxIdleTime()){
                ((CustomReport)report).setMaxIdleTime(servidor.getIdleTime());
            }
            ((CustomReport)report).setTotalIdleTime(((CustomReport)report).getTotalIdleTime() + servidor.getIdleTime());
        }
        ((CustomReport)report).setContPlane(((CustomReport)report).getContPlane() + 1);
        Entity e = new Aircraft(this.getEntity().getId() + 1);
        Arrival a = new Arrival(this.getClock() + this.getBehavior().nextTime(), e, this.getBehavior(), this.endOfServiceBehavior, this.policy);
        e.setArrival(a);
        fel.insert(a);
        
    }

    @Override
    public String toString() {
        String ret = "";
        ret += "arrival - entity id: " + this.getEntity().getId() + " - clock: " + this.getClock();
        return ret;
    }
}
