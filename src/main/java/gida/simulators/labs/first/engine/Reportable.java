package gida.simulators.labs.first.engine;

import java.util.List;

import gida.simulators.labs.first.resources.Server;

@FunctionalInterface
public interface Reportable {

    void generateReport(List<Server> servers);
}
