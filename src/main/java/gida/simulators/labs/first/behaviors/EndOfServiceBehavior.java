package gida.simulators.labs.first.behaviors;

import gida.simulators.labs.first.entities.Aircraft;
import gida.simulators.labs.first.utils.Randomizer;
//import gida.simulators.labs.first.utils.distributions.Distribution;

public class EndOfServiceBehavior implements Behavior {

    private Randomizer randomizer;
    private Aircraft aircraft;
    //private Distribution<Double> distribution;

    public EndOfServiceBehavior(Randomizer randomizer, Aircraft aircraft) {
        this.randomizer = randomizer;
        this.aircraft = aircraft;
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public double nextTime() {
        double ret=0.0;
        double r = this.randomizer.nextRandom();
        if(aircraft.getId()==0){
            if(r<0.363){
                ret=5.0;
            }else if(r<0.475){
                ret=10.0;
            }else if(r<0.162){
                ret=15.0;
            }
        }
        if(aircraft.getId()==0){
            int a = 10;
            int b = 20;
            ret=this.randomizer.nextUniforme(a, b);
        }
        if(aircraft.getId()==0){
            if(r<0.65){
                ret=40.0;
            }else if(r<0.35){
                ret=50.0;
            }
        }         
        return ret;
    }
}
