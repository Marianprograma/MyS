package gida.simulators.labs.first;

import gida.simulators.labs.first.engine.AirportSim;
import gida.simulators.labs.first.engine.CustomReport;
import gida.simulators.labs.first.policies.UniqueServerSelectionPolicy;
import gida.simulators.labs.first.utils.CustomRandomizer;
import gida.simulators.labs.first.utils.ScenarioBuilder;

public class App {

    private static final float SIMULATION_LENGHT = 40320f;

    public static void main(String[] args) {
        new AirportSim(SIMULATION_LENGHT, ScenarioBuilder.OneServerOneQueue(), new UniqueServerSelectionPolicy(), new CustomRandomizer(), new CustomReport()).run();
    }
}
