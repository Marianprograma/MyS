package gida.simulators.labs.first.behaviors;

import gida.simulators.labs.first.entities.Aircraft;
import gida.simulators.labs.first.utils.Randomizer;
//import gida.simulators.labs.first.utils.distributions.Distribution;

public class ArrivalBehavior implements Behavior {

    private Randomizer randomizer;
    private Aircraft aircraft;
    //private Distribution<Double> distribution;

    public ArrivalBehavior(Randomizer randomizer, Aircraft aircraft) {
        this.randomizer = randomizer;
        this.aircraft = aircraft;
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public double nextTime() {
        double ret = 0.0;
        if(aircraft.getId()==0){
            //if tiempo
                ret = this.randomizer.nextExponencial(20);
                //else
                ret = this.randomizer.nextExponencial(40);
        }else if(aircraft.getId()==1){
            //if tiempo
                ret = this.randomizer.nextExponencial(15);
                //else
                ret = this.randomizer.nextExponencial(30);
        }else if(aircraft.getId()==2){
            //if tiempo
                ret = this.randomizer.nextGaussiano(30, 2);
                //else
                ret = this.randomizer.nextGaussiano(60, 2);
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