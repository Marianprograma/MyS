package gida.simulators.labs.first.behaviors;

import gida.simulators.labs.first.entities.Entity;
import gida.simulators.labs.first.utils.Randomizer;

public interface Behavior {

    /**
     * calculates a time span
     * 
     * @return the value for that time span
     */
    double nextTime(Entity entity );

    /**
     * gets the randomizer
     * @return randomizer
     */
    Randomizer getRandomizer();
}
