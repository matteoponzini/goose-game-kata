package it.matteoponzini.utils;

import it.matteoponzini.exception.PlayerNotExistException;
import it.matteoponzini.game.Dice;
import it.matteoponzini.game.Player;
import it.matteoponzini.game.PositionPlayer;

import java.util.List;
//TODO: javadoc
public class MovePlayer implements PlayerStrategy<PositionPlayer> {
    @Override
    public PositionPlayer execute(Player player, List<PositionPlayer> positionPlayers) throws PlayerNotExistException {
        if(player == null || positionPlayers == null){
            throw new IllegalArgumentException("argument cannot be null");
        }

        PositionPlayer positionPlayer = positionPlayers.stream().filter(element->element.getPlayer().equals(player)).findFirst().orElse(null);
        if(positionPlayer == null){
            throw new PlayerNotExistException("Selected user does not exist");
        }
        Integer firstDice = new Dice().roll();
        Integer lastDice = new Dice().roll();
        positionPlayer.setPosition( firstDice,lastDice );
        return positionPlayer;
    }
}
