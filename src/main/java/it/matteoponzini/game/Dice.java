package it.matteoponzini.game;


import it.matteoponzini.utils.ThrowingRandom;
import it.matteoponzini.utils.ThrowingStrategy;

import java.util.Optional;

/**
 * @author Matteo Ponzini
 * @version 1.0-ALPHA
 */
public class Dice {
    private int face;
    private ThrowingStrategy throwingStrategy;
    public Dice(int face) {
        this.setFace(face);
        throwingStrategy = new ThrowingRandom(1, face);
    }

    /**
     * @since 1.0-ALPHA
     * @return Returns a random number of an N face dice
     */
    public Integer roll(){
        return throwingStrategy.throwing();
    }

    public int getFace() {
        return face;
    }

    /**
     * @since 1.0-ALPHA
     * @param face this sets the size of the die, if value is null passed you come by default the value 6
     */
    public void setFace(int face) {
        this.face = Optional.ofNullable(face)
                            .orElse(6);
    }

    public ThrowingStrategy getThrowingStrategy() {
        return throwingStrategy;
    }

    /**
     * @since 1.0-ALPHA
     * @param throwingStrategy set what strategy you want to generate the number
     */
    public void setThrowingStrategy(ThrowingStrategy throwingStrategy) {
        this.throwingStrategy = Optional.ofNullable(throwingStrategy)
                                        .orElse(new ThrowingRandom(1,
                                                Optional.ofNullable(this.face)
                                                .orElse(6)
                                        ));
    }
}
