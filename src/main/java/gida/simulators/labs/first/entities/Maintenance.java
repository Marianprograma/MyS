package gida.simulators.labs.first.entities;

import gida.simulators.labs.first.resources.Airstrip;

public class Maintenance extends Entity {

    public Maintenance(int id) {
        super(id);
    }

    @Override
    public Entity getNextEntity() {
        Maintenance l = new Maintenance(getId());
        return l;
    }
    

    public void repair(Airstrip airstrip){
        double rep = airstrip.getWear() * 0.15;
        airstrip.setWear(airstrip.getWear()+rep);
    }

    
}
