package gida.simulators.labs.first.policies;

import java.util.List;
import gida.simulators.labs.first.entities.Entity;
import gida.simulators.labs.first.resources.Queue;

public class OneToOneQueuePolicy implements ServerQueuePolicy {

    @Override
    public boolean queuesEmpty(List<Queue> queues) {
        return queues.get(0).isEmpty();
    }

    @Override
    public void enqueue(List<Queue> queues, Entity entity) {
        queues.get(0).enqueue(entity);
        queues.get(0).getMaxSize();
    }

    @Override
    public Entity dequeue(List<Queue> queues) {
        return queues.get(0).next();
    }
}
