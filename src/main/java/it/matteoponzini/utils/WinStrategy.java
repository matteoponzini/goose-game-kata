package it.matteoponzini.utils;

import it.matteoponzini.game.PositionPlayer;
import it.matteoponzini.game.WinType;


public interface WinStrategy {
    WinType execute(PositionPlayer positionPlayer);
}
