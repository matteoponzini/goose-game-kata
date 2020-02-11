package it.matteoponzini.boost;

import it.matteoponzini.game.PositionPlayer;
import it.matteoponzini.utils.BoostStrategy;
import it.matteoponzini.utils.Position;

//TODO:java doc
@Position(name = "The Bridge", positon = {6}, action = "jumps")
public class Bridge implements BoostStrategy {

    @Override
    public void execute(PositionPlayer positionPlayer) {
        positionPlayer.setPosition(6,6);
        positionPlayer.setLastPosition(0);
    }
}
