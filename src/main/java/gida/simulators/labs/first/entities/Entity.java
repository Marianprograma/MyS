package gida.simulators.labs.first.entities;

import gida.simulators.labs.first.events.Arrival;
import gida.simulators.labs.first.resources.Server;
import gida.simulators.labs.first.utils.Randomizer;

public abstract class Entity {

    private final int id;
    private Server server;
    private Arrival arrival;
    private int idCount;
    //new
    private double waitingTime;
    private double transitTime;


    public abstract Entity getNextEntity();

    public int getIdCount() {
        return idCount;
    }

    public void setIdCount(int idCount) {
        this.idCount = idCount;
    }

    public double getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(double waitingTime) {
        this.waitingTime = waitingTime;
    }

    public double getTransitTime() {
        return transitTime;
    }

    public void setTransitTime(double transitTime) {
        this.transitTime = transitTime;
    }

    //old
    public Entity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Server getServer() {
        return this.server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public Arrival getArrival() {
        return this.arrival;
    }

    public void setArrival(Arrival arrival) {
        this.arrival = arrival;
    }

    public abstract void applyEffectOnServer(Randomizer randomizer);
}
