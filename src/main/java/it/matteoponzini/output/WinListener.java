package it.matteoponzini.output;

import it.matteoponzini.game.PositionPlayer;

//TODO: javadoc
public class WinListener extends DiceRollsListener {

    @Override
    public StringBuilder notify(String eventType, Object object) {

        if(!(object instanceof PositionPlayer)){
            //TODO: eccezzione
        }
        PositionPlayer positionPlayer = (PositionPlayer) object;
        return super.notify(eventType, positionPlayer).append(" ").append(positionPlayer.getPlayer().getName()).append(" Wins");
    }
}
