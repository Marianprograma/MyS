package gida.simulators.labs.first.utils;

import java.util.ArrayList;
import java.util.List;

//import gida.simulators.labs.first.entities.LightWeight;
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

    public static List<Server> multipleServersOneQueue(int lightQuantity, int mediumQuantity, int heavyQuantity) {
        List<Server> ret =  new ArrayList<>();

        List<Queue> airstripAQueues = new ArrayList<>();
        airstripAQueues.add(new CustomQueue(0));
        ret.add(new AirstripAux(0, airstripAQueues, new OneToOneQueuePolicy()));

        List<Server> lightAirstrips = new ArrayList<>();
        int index = 1;
        for (int i = 0; i < lightQuantity; i++) {
            List<Queue> lightAirstripsQueues = new ArrayList<>();
            lightAirstripsQueues.add(new CustomQueue(index));
            lightAirstrips.add(new AirstripL(index, lightAirstripsQueues, new OneToOneQueuePolicy()));
            index++;
        }

        List<Server> mediumAirstrips = new ArrayList<>();
        for (int i = 0; i < mediumQuantity; i++) {
            List<Queue> mediumAirstripsQueues = new ArrayList<>();
            mediumAirstripsQueues.add(new CustomQueue(index));
            mediumAirstrips.add(new AirstripM(index, mediumAirstripsQueues, new OneToOneQueuePolicy()));
            index++;
        }

        List<Server> heavyAirstrips = new ArrayList<>();
        for (int i = 0; i < heavyQuantity; i++) {
            List<Queue> heavyAirstripsQueues = new ArrayList<>();
            heavyAirstripsQueues.add(new CustomQueue(index));
            heavyAirstrips.add(new AirstripH(index, heavyAirstripsQueues, new OneToOneQueuePolicy()));
            index++;
        }

        ret.addAll(lightAirstrips);
        ret.addAll(mediumAirstrips);
        ret.addAll(heavyAirstrips);

        return ret;
    }
}
