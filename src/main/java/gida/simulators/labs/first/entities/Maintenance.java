package gida.simulators.labs.first.entities;

import gida.simulators.labs.first.resources.Airstrip;
import gida.simulators.labs.first.utils.Randomizer;

public class Maintenance extends Entity {

    public Maintenance(int id) {
        super(id);
    }

    @Override
    public Entity getNextEntity() {
        Maintenance l = new Maintenance(getId());
        return l;
    }

    @Override
    public void applyEffectOnServer(Randomizer randomizer) {
        this.effect((Airstrip)this.getServer(), randomizer);
    }
    
    public void effect(Airstrip airstrip, Randomizer randomizer){
        double rep = airstrip.getWear() * 0.15;
        airstrip.setWear(airstrip.getWear()+rep);
    }  
}
