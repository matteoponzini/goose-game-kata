package it.matteoponzini.output;

import it.matteoponzini.game.PositionPlayer;

public class DrawListener extends DiceRollsListener {
    @Override
    public StringBuilder notify(String eventType, Object object) {

        if(!(object instanceof PositionPlayer)){
            //TODO: eccezzione
        }
        PositionPlayer positionPlayer = (PositionPlayer) object;
        return super.notify(eventType, positionPlayer).append(" ").append(positionPlayer.getPlayer().getName()).append(" bounces! returns to ").append(positionPlayer.getPosition()-4);
    }
}
