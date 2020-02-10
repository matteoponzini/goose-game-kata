package it.matteoponzini.utils;

import it.matteoponzini.game.Player;

import java.util.List;

//TODO: javadoc
public interface PlayerStrategy<T> {
    T execute(Player player, List<T> positionPlayers);
}
