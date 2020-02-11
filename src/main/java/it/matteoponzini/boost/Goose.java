package it.matteoponzini.boost;

import it.matteoponzini.game.PositionPlayer;
import it.matteoponzini.utils.BoostStrategy;
import it.matteoponzini.utils.Position;

@Position(name = "The Goose", positon = {5, 9, 14, 18, 23, 27}, action = "goes")
public class Goose implements BoostStrategy {
    @Override
    public void execute(PositionPlayer positionPlayer) {
        positionPlayer.setPosition(positionPlayer.getFirstDice(), positionPlayer.getSecondDice());
    }
}
