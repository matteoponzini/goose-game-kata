package it.matteoponzini.utils;

import it.matteoponzini.game.Dice;
import it.matteoponzini.game.Player;
import it.matteoponzini.game.PositionPlayer;

import java.util.List;
//TODO: javadoc
public class MovePlayer implements PlayerStrategy<PositionPlayer> {
    @Override
    public PositionPlayer execute(Player player, List<PositionPlayer> positionPlayers) {
        PositionPlayer positionPlayer = positionPlayers.stream().filter(element->element.getPlayer().equals(player)).findFirst().get();
        Integer firstDice = new Dice().roll();
        Integer lastDice = new Dice().roll();
        positionPlayer.setPosition( firstDice,lastDice );
        return positionPlayer;
    }
}
