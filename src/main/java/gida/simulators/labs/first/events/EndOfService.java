package gida.simulators.labs.first.events;

import java.util.List;

//import gida.simulators.labs.first.behaviors.Behavior;
import gida.simulators.labs.first.behaviors.EndOfServiceBehavior;
import gida.simulators.labs.first.engine.CustomReport;
import gida.simulators.labs.first.engine.FutureEventList;
import gida.simulators.labs.first.engine.Reportable;
import gida.simulators.labs.first.entities.Entity;
import gida.simulators.labs.first.resources.Server;

public class EndOfService extends Event {

    public EndOfService(double clock, Entity entity, EndOfServiceBehavior behavior) {
        super(clock, entity, behavior, 0);
    }

    @Override
    public void planificate(FutureEventList fel, List<Server> servers,Reportable report) {
        Server servidor = getEntity().getServer();

        //Si hay cola
        if(!(servidor.queuesEmpty())){

            Entity e = servidor.dequeue();

            //Tiempo de espera
            e.setWaitingTime(this.getClock() - e.getArrival().getClock());
            if(((CustomReport)report).getMaxWaitingTime()<e.getWaitingTime()){
                ((CustomReport)report).setMaxWaitingTime(e.getWaitingTime());
            }
            ((CustomReport)report).setTotalWaitingTime(((CustomReport)report).getTotalWaitingTime() + e.getWaitingTime());
            ((CustomReport)report).setContQueue(((CustomReport)report).getContQueue()+1);
            servidor.setCurrentEntity(e);
            e.setServer(servidor);
            Event proxSalida = new EndOfService(this.getClock() + this.getBehavior().nextTime(), e,(EndOfServiceBehavior)this.getBehavior());
            fel.insert(proxSalida);
            
        }else{
            servidor.setCurrentEntity(null);
            servidor.setIdleTimeStartMark(this.getClock());
        }

        //Tiempo de transito
        getEntity().setTransitTime(this.getClock() - getEntity().getArrival().getClock());
        if(((CustomReport)report).getMaxTransitTime()<getEntity().getTransitTime()){
            ((CustomReport)report).setMaxTransitTime(getEntity().getTransitTime());
        }
        ((CustomReport)report).setTotalTransitTime(((CustomReport)report).getTotalTransitTime()+getEntity().getTransitTime());
    }

    @Override
    public String toString() {
        String ret = "";
        ret += "end of service - entity id: " + this.getEntity().getId() + " - clock: "
                + this.getClock();
        return ret;
    }
}
