package gida.simulators.labs.first.utils;

public interface Randomizer {

    double nextRandom();
    double nextGaussiano(int mean, double stddev);
    double nextExponencial(int mean);
    double nextUniforme(int a, int b);
}
