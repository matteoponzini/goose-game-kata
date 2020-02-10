package it.matteoponzini.output;

import it.matteoponzini.game.Player;
import it.matteoponzini.game.PositionPlayer;
import it.matteoponzini.utils.EventListener;
//TODO: javadoc
public class AddPlayerListener implements EventListener {
    StringBuilder stringBuilder = new StringBuilder();
    @Override
    public StringBuilder notify(String eventType, Object object) {
        if(!(object instanceof Player)){
            //TODO: eccezzione
        }
        Player player = (Player) object;
        if(stringBuilder.length()<=0){
            stringBuilder.append("Players: ")
                    .append(player.getName());
        }else {
            stringBuilder.append(", ").append(player.getName());
        }
        return stringBuilder;
    }
}
