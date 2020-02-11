package it.matteoponzini.output;

import it.matteoponzini.utils.EventListener;

public class BoostListener implements EventListener {
    @Override
    public StringBuilder notify(String eventType, Object object) {
        return (StringBuilder) object;
    }
}
