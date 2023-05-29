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
        //Queue queue = new CustomQueue(queuesQuantity);
        //queues.add(queuesQuantity,queues);
        for(int i=0;i < queuesQuantity;i++){
            Queue queue = new CustomQueue(i);
            queues.add(queue);
        }
        Server s0=new AirstripAux(0, queues, new OneToOneQueuePolicy());

        Server s1L=new AirstripL(1, queues, new OneToOneQueuePolicy());
        Server s2L=new AirstripL(2, queues, new OneToOneQueuePolicy());
        Server s3L=new AirstripL(3, queues, new OneToOneQueuePolicy());

        Server s1M=new AirstripM(4, queues, new OneToOneQueuePolicy());
        Server s2M=new AirstripM(5, queues, new OneToOneQueuePolicy());
        Server s3M=new AirstripM(6, queues, new OneToOneQueuePolicy());
        Server s4M=new AirstripM(7, queues, new OneToOneQueuePolicy());

        Server s1H=new AirstripH(8,queues,new OneToOneQueuePolicy());
        Server s2H=new AirstripH(9,queues,new OneToOneQueuePolicy());

        servers.add(s0);
        servers.add(s1L);
        servers.add(s2L);
        servers.add(s3L);
        servers.add(s1M);
        servers.add(s2M);
        servers.add(s3M);
        servers.add(s4M);
        servers.add(s1H);
        servers.add(s2H);

        return servers;
    }
}
