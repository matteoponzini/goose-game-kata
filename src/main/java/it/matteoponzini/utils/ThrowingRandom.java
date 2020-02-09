package it.matteoponzini.utils;

import java.util.Random;
/**
 * @author Matteo Ponzini
 * @version 1.0-ALPHA
 */
public class ThrowingRandom implements ThrowingStrategy {
    Integer minNumber;
    Integer maxNumber;

    public ThrowingRandom(Integer minNumber, Integer maxNumber) {
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
    }

    /**
     * @since 1.0-ALPHA
     * @return a random number given by the maximum number to the minimum number
     */
    @Override
    public Integer throwing() {
        return new Random(System.currentTimeMillis()).nextInt(maxNumber)+minNumber;
    }
}
