package gida.simulators.labs.first.engine;

/**
 * this interface defines the simulator functionalities
 */
public abstract class Engine implements Runnable {

    private boolean stop = false;
    private final Reportable reportable;

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public Reportable getReportable() {
        return this.reportable;
    }

    public Engine(Reportable reportable) {
        this.reportable = reportable;
    }

    /**
     * stops the engine execution
     */
    public void stopExecute() {
        this.stop = true;
    }
}
