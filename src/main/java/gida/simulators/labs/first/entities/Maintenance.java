package gida.simulators.labs.first.entities;

import gida.simulators.labs.first.resources.Airstrip;

public class Maintenance extends Entity {

    public Maintenance(int id) {
        super(id);
    }
    

    public void repair(Airstrip airstrip){
        double rep = airstrip.getWear() * 0.15;
        airstrip.setWear(airstrip.getWear()+rep);
    }

    
}
