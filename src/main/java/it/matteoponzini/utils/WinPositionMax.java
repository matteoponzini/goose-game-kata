package it.matteoponzini.utils;

import it.matteoponzini.game.PositionPlayer;
import it.matteoponzini.game.WinType;

public class WinPositionMax implements WinStrategy {
    @Override
    public WinType execute(PositionPlayer positionPlayer) {
        if(positionPlayer.getPosition() > 63){
            return WinType.WIN;
        }else if(positionPlayer.getPosition() == 63){
            return WinType.DRAW;
        }
        return WinType.LOSE;
    }
}
