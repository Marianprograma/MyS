package gida.simulators.labs.first.utils;

import java.util.Random;

public class CustomRandomizer implements Randomizer {

    private Random random;

    public CustomRandomizer() {
        this.random = new Random(System.currentTimeMillis());
    }

    @Override
    public double nextRandom() {
        return this.random.nextDouble();
    }

    @Override
    public double nextGaussiano(int mean, double stddev){
        int n = 24;
        double varianzaz = Math.sqrt(2);
        double z = 0;
         for(int i = 0; i < n; i++){
             z += nextRandom();
        }
        double zprima = (z - (n/2)) / varianzaz;
        return (zprima * stddev + mean);
    }

    @Override
    public double nextExponencial(int mean){
        double r = nextRandom();
        return (-mean*Math.log(1-r));
    }   

    @Override
    public double nextUniforme(int a, int b){
        return (a + (b-a) * nextRandom());
    }

}
