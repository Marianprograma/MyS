package gida.simulators.labs.first.utils;

import java.util.ArrayList;
import java.util.List;

import gida.simulators.labs.first.policies.OneToOneQueuePolicy;
//import gida.simulators.labs.first.resources.Airstrip;
import gida.simulators.labs.first.resources.AirstripAux;
import gida.simulators.labs.first.resources.AirstripH;
import gida.simulators.labs.first.resources.AirstripL;
import gida.simulators.labs.first.resources.AirstripM;
import gida.simulators.labs.first.resources.CustomQueue;
import gida.simulators.labs.first.resources.Queue;
import gida.simulators.labs.first.resources.Server;

public class ScenarioBuilder {

    /*public static List<Server> OneServerOneQueue() {
        List<Server> servers = new ArrayList<>();
        List<Queue> queues = new ArrayList<>();
        Queue queue = new CustomQueue(0);
        queues.add(queue);
        Server s=new Airstrip(0, queues, new OneToOneQueuePolicy());
        servers.add(s);
        return servers;
    }*/

    //public static List<Server> OneServerMultipleQueues(int queuesQuantity) {

    //}

    public static List<Server> multipleServersOneQueue(int queuesQuantity) {
        List<Server> servers = new ArrayList<>();
        List<Queue> queues = new ArrayList<>();
        Queue queue = new CustomQueue(queuesQuantity);
        queues.add(queuesQuantity, queue);
        Server s0=new AirstripAux(0, queues, new OneToOneQueuePolicy());
        Server s1=new AirstripL(1, queues, new OneToOneQueuePolicy());
        Server s2=new AirstripM(2, queues, new OneToOneQueuePolicy());
        Server s3=new AirstripH(3,queues,new OneToOneQueuePolicy());
        servers.add(s0);
        servers.add(s1);
        servers.add(s2);
        servers.add(s3);
        return servers;
    }
}
