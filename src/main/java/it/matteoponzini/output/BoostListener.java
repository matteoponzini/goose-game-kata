package it.matteoponzini.output;

import it.matteoponzini.utils.EventListener;

public class BoostListener implements EventListener {
    @Override
    public StringBuilder notify(String eventType, Object object) {
        if(eventType == null || object == null){
            throw new IllegalArgumentException("argument cannot be null");
        }
        if(!(object instanceof StringBuilder)){
            throw new ClassCastException("argument cannot be cast");
        }
        return (StringBuilder) object;
    }
}
