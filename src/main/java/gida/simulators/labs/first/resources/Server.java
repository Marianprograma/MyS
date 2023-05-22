package gida.simulators.labs.first.resources;

import java.util.List;
//import java.util.Properties;

import gida.simulators.labs.first.entities.Entity;
import gida.simulators.labs.first.policies.ServerQueuePolicy;
//import javafx.beans.property.Property;

public abstract class Server {

    private int id;
    private int idCount;
    private Entity currentEntity;
    private List<Queue> queues;
    private double idleTimeStartMark;
    private double idleTimeFinishedMark;
    private ServerQueuePolicy policy;
    private double idleTime;
    private int maxSizeQueues;
    //Tp1

    public int getMaxSizeQueues() {
        return maxSizeQueues;
    }

    public void setMaxSizeQueues(int maxSizeQueues) {
        this.maxSizeQueues = maxSizeQueues;
    }

    public Server(int id, List<Queue> queues, ServerQueuePolicy policy) {
        this.id = id;
        this.queues = queues;
        this.policy = policy;
    }
    
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Entity getCurrentEntity() {
        return this.currentEntity;
    }

    public void setCurrentEntity(Entity currentEntity) {
        this.currentEntity = currentEntity;
    }

    public int getIdCount() {
        return idCount;
    }

    public void setIdCount(int idCount) {
        this.idCount = idCount;
    }

    public double getIdleTimeStartMark() {
        return idleTimeStartMark;
    }

    public void setIdleTimeStartMark(double idleTimeStartMark) {
        this.idleTimeStartMark = idleTimeStartMark;
    }

    public double getIdleTimeFinishedMark() {
        return idleTimeFinishedMark;
    }

    public void setIdleTimeFinishedMark(double idleTimeFinishedMark) {
        this.idleTimeFinishedMark = idleTimeFinishedMark;
    }

    public double getIdleTime() {
        return idleTime;
    }

    public void setIdleTime(double idleTime) {
        this.idleTime = idleTime;
    }

    public boolean isBusy() {
        return this.currentEntity != null;
    }

    public boolean queuesEmpty() {
        return this.policy.queuesEmpty(queues);
    }

    public void enqueue(Entity entity) {
        this.policy.enqueue(this.queues, entity);
        setMaxSizeQueues(this.queues.get(0).getMaxSize());
    }

    public Entity dequeue() {
        return this.policy.dequeue(this.queues);
    }

    @Override
    public String toString() {
        String ret = "id: " + this.id + " -- current entity: " + this.currentEntity.getId() + "\n"
                + "queues:\n";

        for (Queue q : queues)
            ret += "\t" + q.toString() + "\n";

        return ret;
    }
}
