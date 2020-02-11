package it.matteoponzini.utils;

import it.matteoponzini.exception.PlayerAlredyExistExeptionException;
import it.matteoponzini.game.Player;
import it.matteoponzini.game.PositionPlayer;

import java.util.List;
//TODO: javadoc
public class AddPlayer implements PlayerStrategy<PositionPlayer> {

    @Override
    public PositionPlayer execute(Player player, List<PositionPlayer> positionPlayers) throws PlayerAlredyExistExeptionException {
        if(player == null || positionPlayers == null){
            throw new IllegalArgumentException("argument cannot be null");
        }
        PositionPlayer positionPlayer;
        if (positionPlayers.stream().noneMatch(element -> element.getPlayer().equals(player))) {
            positionPlayer = new PositionPlayer(player, 0, 0);
            positionPlayers.add(positionPlayer);
        }else{
            throw new PlayerAlredyExistExeptionException("The player already exists: "+player.getName());
        }
        return positionPlayer;
    }
}
