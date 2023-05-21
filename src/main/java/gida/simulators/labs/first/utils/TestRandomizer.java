package gida.simulators.labs.first.utils;

public class TestRandomizer implements Randomizer {

    private int i=0;
    private double[] ramdoms;

    public TestRandomizer(){
        this.ramdoms=new double[20];
        this.ramdoms[0] = 0.28;
        this.ramdoms[1] = 0.68;
        this.ramdoms[2] = 0.09;
        this.ramdoms[3] = 0.55;
        this.ramdoms[4] = 0.14;
        this.ramdoms[5] = 0.99;
        this.ramdoms[6] = 0.79;
        this.ramdoms[7] = 0.66;
        this.ramdoms[8] = 0.10;
        this.ramdoms[9] = 0.88;
        this.ramdoms[10] = 0.45;
        this.ramdoms[11] = 0.32;
        this.ramdoms[12] = 0.01;
        this.ramdoms[13] = 0.73;
        this.ramdoms[14] = 0.5;
        this.ramdoms[15] = 0.26;
        this.ramdoms[16] = 0.43;
        this.ramdoms[17] = 0.90;
        this.ramdoms[18] = 0.64;
        this.ramdoms[19] = 0.58;
    }

    @Override
    public double nextRandom() {
        return this.ramdoms[this.i++];
    }

    
}
