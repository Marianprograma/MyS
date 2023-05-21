package gida.simulators.labs.first.behaviors;

import gida.simulators.labs.first.utils.Randomizer;
//import gida.simulators.labs.first.utils.distributions.Distribution;

public class ArrivalBehavior implements Behavior {

    private Randomizer randomizer;
    //private Distribution<Double> distribution;

    public ArrivalBehavior(Randomizer randomizer) {
        this.randomizer = randomizer;
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public double nextTime() {
        double ret = 0.0;
        double r = this.randomizer.nextRandom();
        double z = 0.0,zprima= 0.0,muz=12,varianzaz=Math.sqrt(2),muy=60,varianzay=2;
            //if
            ret = -(Math.log(1-r))*40;
                //if
                ret = -(Math.log(1-r))*20;
            //if
            ret = -(Math.log(1-r))*30;
                //if
                ret = -(Math.log(1-r))*15;
            //if
            for(int i=0;i<24;i++){
                //UNIFORME(0,1)
                 z += r;
            }
            zprima = (z-muz)/varianzaz;
                //if
                muy=30;
                ret = (zprima *varianzay)+muy;
                //else
                ret = (zprima * varianzay) + muy;
            
        /*if(r<0.3){
            ret=10;
        }else if(r<0.7){
            ret=15;
        }else if (r<1){
            ret=20;
        }*/
        return ret;
    }
}
