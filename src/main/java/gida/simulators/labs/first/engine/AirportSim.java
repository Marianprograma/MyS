package gida.simulators.labs.first.engine;

import java.util.List;

import gida.simulators.labs.first.behaviors.ArrivalBehavior;
import gida.simulators.labs.first.behaviors.EndOfServiceBehavior;
import gida.simulators.labs.first.entities.Aircraft;
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
                EndOfServiceBehavior eosb = new EndOfServiceBehavior(randomizer);
                Aircraft a1 = new Aircraft(0);
                ArrivalBehavior arrb = new ArrivalBehavior(randomizer);
                Arrival e1 = new Arrival(0, a1, arrb, eosb, policy);
                e1.getEntity().setArrival(e1);
                fel.insert(new StopSimulation(endClock, this));
                fel.insert(e1);
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
