package gida.simulators.labs.first;



import gida.simulators.labs.first.engine.AirportSim;
import gida.simulators.labs.first.engine.CustomReport;
import gida.simulators.labs.first.engine.CustomReportTotal;
import gida.simulators.labs.first.policies.MultipleServerSelectionPolicy;
import gida.simulators.labs.first.utils.CustomRandomizer;
import gida.simulators.labs.first.utils.ScenarioBuilder;

public class App {

    private static final float SIMULATION_LENGHT = 40320f;

    public static void main(String[] args) {
        CustomReport report = new CustomReport();
        CustomReportTotal customReportTotal = new CustomReportTotal(report);
        for(int i=0;i<50;i++){
            new AirportSim(SIMULATION_LENGHT, ScenarioBuilder.multipleServersOneQueue(1,2,1), new MultipleServerSelectionPolicy(), new CustomRandomizer(),report,customReportTotal).run();
            report.resetCustom();
        }
        customReportTotal.generateReportTotal(customReportTotal.getReport());
    }
}
