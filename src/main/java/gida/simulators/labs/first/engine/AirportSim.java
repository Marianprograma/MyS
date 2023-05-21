package gida.simulators.labs.first.engine;

import java.util.List;

import gida.simulators.labs.first.behaviors.ArrivalBehavior;
import gida.simulators.labs.first.behaviors.EndOfServiceBehavior;
import gida.simulators.labs.first.entities.Aircraft;
import gida.simulators.labs.first.entities.Heavy;
import gida.simulators.labs.first.entities.LightWeight;
import gida.simulators.labs.first.entities.Medium;
import gida.simulators.labs.first.events.Arrival;
import gida.simulators.labs.first.events.StopSimulation;
import gida.simulators.labs.first.events.Event;
import gida.simulators.labs.first.policies.ServerSelectionPolicy;
import gida.simulators.labs.first.resources.Server;
import gida.simulators.labs.first.utils.Randomizer;

public class AirportSim extends Engine {

    private FutureEventList fel;
    private List<Server> servers;


    public AirportSim(double endClock, List<Server> servers, ServerSelectionPolicy policy,
            Randomizer randomizer, Reportable report) {
                super(report);
                this.servers = servers;
                this.fel = new FutureEventList();
                Aircraft a1 = new LightWeight(0);
                Aircraft a2 = new Medium(1);
                Aircraft a3 = new Heavy(2);
                EndOfServiceBehavior eosbL = new EndOfServiceBehavior(randomizer,a1);
                EndOfServiceBehavior eosbM = new EndOfServiceBehavior(randomizer,a2);
                EndOfServiceBehavior eosbH = new EndOfServiceBehavior(randomizer,a3);
                ArrivalBehavior arrbL = new ArrivalBehavior(randomizer,a1);
                ArrivalBehavior arrbM = new ArrivalBehavior(randomizer,a2);
                ArrivalBehavior arrbH = new ArrivalBehavior(randomizer,a3);
                Arrival e1 = new Arrival(0, a1, arrbL, eosbL, policy);//POLICY MODIFICAR
                Arrival e2 = new Arrival(0, a2, arrbM, eosbM, policy);
                Arrival e3 = new Arrival(0, a3, arrbH, eosbH, policy);
                e1.getEntity().setArrival(e1);
                e2.getEntity().setArrival(e2);
                e3.getEntity().setArrival(e3);
                fel.insert(new StopSimulation(endClock, this));
                fel.insert(e1);
                fel.insert(e2);
                fel.insert(e3);
            }

    @Override
    public void run() {
        while(!this.isStop()){
            Event e =  fel.getImminent();
            e.planificate(fel,this.servers,this.getReportable());
        }
        getReportable().generateReport();
    }
}
