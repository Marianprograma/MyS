package gida.simulators.labs.first.behaviors;

import gida.simulators.labs.first.entities.Entity;
import gida.simulators.labs.first.entities.Heavy;
import gida.simulators.labs.first.entities.LightWeight;
import gida.simulators.labs.first.entities.Maintenance;
import gida.simulators.labs.first.entities.Medium;
import gida.simulators.labs.first.utils.Randomizer;
//import gida.simulators.labs.first.utils.distributions.Distribution;

public class EndOfServiceBehavior implements Behavior {

    private Randomizer randomizer;
    //private Distribution<Double> distribution;

    public EndOfServiceBehavior(Randomizer randomizer) {
        this.randomizer = randomizer;
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public double nextTime(Entity entity) {
        double ret=0.0;
        double r = this.randomizer.nextRandom();
        if(entity.getClass()==LightWeight.class){
            if(r<0.363){
                ret=5.0;
            }else if(r<0.838){
                ret=10.0;
            }else if(r<1){
                ret=15.0;
            }
        }else if(entity.getClass()==Medium.class){
            ret=this.randomizer.nextUniforme(10, 20);
        }else if(entity.getClass()==Heavy.class){
            if(r<0.65){
                ret=40.0;
            }else if(r<1){
                ret=50.0;
            }
        }else if (entity.getClass()==Maintenance.class) {
            ret=this.randomizer.nextUniforme(12, 24)*60;
        }         
        
        return ret;
    }

    @Override
    public Randomizer getRandomizer() {
        return this.randomizer;
    }
}
