package gida.simulators.labs.first.entities;

import gida.simulators.labs.first.resources.Airstrip;
//import gida.simulators.labs.first.resources.Server;
import gida.simulators.labs.first.utils.Randomizer;

//import gida.simulators.labs.first.behaviors.Behavior;

public class LightWeight extends Aircraft {

    //Fran agrego esto Behavior arrivalBehavior,Behavior endOfServiceBehavior como parametros
    public LightWeight(int id) {
        //arrivalBehavior,endOfServiceBehavior
        super(id);
    }

    @Override
    public Aircraft getNextAircraft() {
        LightWeight l = new LightWeight(getId());
        return l;
    }

    @Override
    public void applyEffectOnServer( Randomizer randomizer) {
        double uniform;
        uniform=randomizer.nextUniforme(0,1);
        ((Airstrip) this.getServer()).setWear(((Airstrip) this.getServer()).getWear() - uniform);
    }    
}
