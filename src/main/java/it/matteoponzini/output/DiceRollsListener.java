package it.matteoponzini.output;

import it.matteoponzini.game.PositionPlayer;
import it.matteoponzini.utils.EventListener;
//TODO: javadoc
public class DiceRollsListener implements EventListener {
    @Override
    public StringBuilder notify(String eventType, Object object) {
        if(!(object instanceof PositionPlayer)){
            //TODO: eccezzione
        }
        PositionPlayer positionPlayer = (PositionPlayer)object;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Player: ")
                .append(positionPlayer.getPlayer().getName())
                .append(" rolls ")
                .append(positionPlayer.getFirstDice())
                .append(", ")
                .append(positionPlayer.getSecondDice())
                .append(" ")
                .append(positionPlayer.getPlayer().getName()).append(" moves from ");
        if(positionPlayer.getLastPosition() == 0){
             stringBuilder.append("Start to ");
        }else{
            stringBuilder.append(positionPlayer.getLastPosition())
                    .append(" to ");
        }
        return stringBuilder.append(positionPlayer.getPosition());
    }
}
