package gida.simulators.labs.first.policies;

import java.util.List;
import gida.simulators.labs.first.entities.Entity;
import gida.simulators.labs.first.resources.Queue;

public class OneToOneQueuePolicy implements ServerQueuePolicy {

    @Override
    public boolean queuesEmpty(List<Queue> queues,int id) {
        return queues.get(id).isEmpty();
    }

    @Override
    public void enqueue(List<Queue> queues, Entity entity, int id) {
        queues.get(id).enqueue(entity);
        queues.get(id).getMaxSize();
    }

    @Override
    public Entity dequeue(List<Queue> queues, int id) {
        return queues.get(id).next();
    }
}
