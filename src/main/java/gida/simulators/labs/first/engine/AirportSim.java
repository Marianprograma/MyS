package gida.simulators.labs.first.engine;

import java.util.List;

import gida.simulators.labs.first.behaviors.ArrivalBehavior;
import gida.simulators.labs.first.behaviors.EndOfServiceBehavior;
import gida.simulators.labs.first.entities.Aircraft;
import gida.simulators.labs.first.entities.Heavy;
import gida.simulators.labs.first.entities.LightWeight;
import gida.simulators.labs.first.entities.Maintenance;
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
    private CustomReport report;

    public AirportSim(double endClock, List<Server> servers, ServerSelectionPolicy policy,
            Randomizer randomizer, CustomReport report, Reportable reportTotal) {
                super(reportTotal);
                this.servers = servers;
                this.report = report;
                this.fel = new FutureEventList();
                fel.insert(new StopSimulation(endClock, this));

                Aircraft a1 = new LightWeight(0);
                Aircraft a2 = new Medium(1);
                Aircraft a3 = new Heavy(2);
                Maintenance maintenance = new Maintenance(3);
                
                Arrival e1 = new Arrival(0, a1, new ArrivalBehavior(randomizer), new EndOfServiceBehavior(randomizer), policy);//POLICY MODIFICAR
                a1.setArrival(e1);
                fel.insert(e1);

                Arrival e2 = new Arrival(0, a2, new ArrivalBehavior(randomizer), new EndOfServiceBehavior(randomizer), policy);
                a2.setArrival(e2);
                fel.insert(e2);

                Arrival e3 = new Arrival(0, a3, new ArrivalBehavior(randomizer), new EndOfServiceBehavior(randomizer), policy);
                a3.setArrival(e3);
                fel.insert(e3);

                Arrival e4 = new Arrival(0, maintenance, new ArrivalBehavior(randomizer), new EndOfServiceBehavior(randomizer), policy);
                maintenance.setArrival(e4);
                fel.insert(e4);

            }

    @Override
    public void run() {
        while(!this.isStop()){
            Event e =  fel.getImminent();
            e.planificate(fel,this.servers,this.report);
        }
        report.generateReport(this.servers);
        ((CustomReportTotal)getReportable()).saveValue(this.report);
    }
}
