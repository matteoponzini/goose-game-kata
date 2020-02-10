package it.matteoponzini.utils;

import it.matteoponzini.game.Player;
import it.matteoponzini.game.PositionPlayer;

import java.util.List;
//TODO: javadoc
public class AddPlayer implements PlayerStrategy<PositionPlayer> {

    @Override
    public PositionPlayer execute(Player player, List<PositionPlayer> positionPlayers) {
        PositionPlayer positionPlayer;
        if (positionPlayers.stream().noneMatch(element -> element.getPlayer().equals(player))) {
            positionPlayer = new PositionPlayer(player, 0, 0);
            positionPlayers.add(positionPlayer);
        }else{
            throw new IllegalArgumentException("The player already exists: "+player.getName());
        }
        return positionPlayer;
    }
}
