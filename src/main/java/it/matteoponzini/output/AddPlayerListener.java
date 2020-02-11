package it.matteoponzini.output;

import it.matteoponzini.game.Player;
import it.matteoponzini.utils.EventListener;

//TODO: javadoc
public class AddPlayerListener implements EventListener {
    StringBuilder stringBuilder = new StringBuilder();
    @Override
    public StringBuilder notify(String eventType, Object object) {
        if(eventType == null || object == null){
            throw new IllegalArgumentException("argument cannot be null");
        }
        if(!(object instanceof Player)){
            throw new ClassCastException("argument cannot be cast");
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
