package gida.simulators.labs.first.engine;

import java.util.List;

import gida.simulators.labs.first.resources.Server;


public interface Reportable {

    void generateReport(List<Server> servers);

    void generateReportTotal(CustomReport report);
}
