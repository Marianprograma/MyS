package gida.simulators.labs.first.behaviors;

import gida.simulators.labs.first.entities.Entity;
import gida.simulators.labs.first.entities.Heavy;
import gida.simulators.labs.first.entities.LightWeight;
import gida.simulators.labs.first.entities.Maintenance;
import gida.simulators.labs.first.entities.Medium;
import gida.simulators.labs.first.utils.Randomizer;
//import gida.simulators.labs.first.utils.distributions.Distribution;

public class ArrivalBehavior implements Behavior {

    private Randomizer randomizer;
    private Entity entity;
    //private Distribution<Double> distribution;

    public ArrivalBehavior(Randomizer randomizer, Entity entity) {
        this.randomizer = randomizer;
        this.entity = entity;
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public double nextTime() {
        double ret = 0.0;
        double resto = entity.getArrival().getClock() % 1440;
        if(entity.getClass()==LightWeight.class){
            if((resto>480 && resto<600) || (resto> 1140 && resto<1320)){
                ret = this.randomizer.nextExponencial(20);
            }else{
                ret = this.randomizer.nextExponencial(40);
            }
        }else if(entity.getClass()==Medium.class){
            if((resto>480 && resto<600) || (resto> 1140 && resto<1320)){
                ret = this.randomizer.nextExponencial(15);
            }else{
                ret = this.randomizer.nextExponencial(30);
            }
        }else if(entity.getClass()==Heavy.class){
            if((resto>480 && resto<600) || (resto> 1140 && resto<1320)){
                ret = this.randomizer.nextGaussiano(30, 2);
            }else{
                ret = this.randomizer.nextGaussiano(60, 2);
            }
        }else if(entity.getClass()==Maintenance.class){
            ret = this.randomizer.nextGaussiano(5, 0.5)*1440;
        }
 
        return ret;
    }
}


    //TABLA TP 1
    /*if(r<0.3){
    ret=10;
    }else if(r<0.7){
    ret=15;
    }else if (r<1){
    ret=20;
    }*/