package it.matteoponzini.output;

import it.matteoponzini.game.PositionPlayer;

//TODO: javadoc
public class WinListener extends DiceRollsListener {

    @Override
    public StringBuilder notify(String eventType, Object object) {
        if(eventType == null || object == null){
            throw new IllegalArgumentException("argument cannot be null");
        }
        if(!(object instanceof PositionPlayer)){
            throw new ClassCastException("argument cannot be cast");
        }
        PositionPlayer positionPlayer = (PositionPlayer) object;
        return super.notify(eventType, positionPlayer).append(" ").append(positionPlayer.getPlayer().getName()).append(" Wins");
    }
}
