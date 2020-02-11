package it.matteoponzini.utils;

import it.matteoponzini.exception.PlayerAlredyExistExeptionException;
import it.matteoponzini.exception.PlayerNotExistException;
import it.matteoponzini.game.Player;

import java.util.List;

//TODO: javadoc
public interface PlayerStrategy<T> {
    T execute(Player player, List<T> positionPlayers) throws PlayerAlredyExistExeptionException, PlayerNotExistException;
}
